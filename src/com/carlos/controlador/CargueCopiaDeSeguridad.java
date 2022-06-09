/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.Conexion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class CargueCopiaDeSeguridad {

    private static ArrayList<Object> consulta_tablas, consulta_funciones, consulta_paquetes, consulta_procedimientos, consulta_triggers, consulta_vistas, consulta_indices = new ArrayList<Object>();
    private static String Error = null;

    public static String Error() {
        return Error;
    }

    private static void deteccion_motor() throws SQLException {
        switch (DatosConexion.motor) {
            case "Oracle" -> {
                consulta_tablas = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('TABLE',U.TABLE_NAME) FROM USER_TABLES U ORDER BY U.LAST_ANALYZED ASC");
                consulta_funciones = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('FUNCTION',U.OBJECT_NAME) FROM USER_PROCEDURES U WHERE OBJECT_TYPE = 'FUNCTION'");
                consulta_paquetes = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('PACKAGE',U.OBJECT_NAME) FROM USER_PROCEDURES U  WHERE OBJECT_TYPE = 'PACKAGE'");
                consulta_procedimientos = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('PROCEDURE',U.OBJECT_NAME) FROM USER_PROCEDURES U   WHERE OBJECT_TYPE = 'PROCEDURE'");
                consulta_triggers = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('TRIGGER',U.TRIGGER_NAME) FROM USER_TRIGGERS U");
                consulta_vistas = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('VIEW',U.VIEW_NAME) FROM USER_VIEWS U ");
                consulta_indices = ConsultaClob("SELECT DBMS_METADATA.GET_DDL('INDEX',U.INDEX_NAME) FROM USER_INDEXES U");
            }
            case "SQL Server" -> {
                consulta_tablas = ConsultaClob("SELECT NAME FROM SYS.TABLES ");
                consulta_funciones = ConsultaClob("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='FN' ");
                consulta_procedimientos = ConsultaClob("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='P' ");
                consulta_triggers = ConsultaClob("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='TR' ");
                consulta_vistas = ConsultaClob("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='V'");
            }
        }
    }

    private static ArrayList<Object> ConsultaClob(String consulta) {
        ArrayList<Object> data = new ArrayList<>();
        ResultSet rs = null;

        try {
            Connection con = Conexion.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(consulta);
            ResultSetMetaData resultt = rs.getMetaData();
            while (rs.next()) {
                for (int i = 0; i < resultt.getColumnCount(); i++) {
                    data.add(rs.getObject(i + 1));
                }
            }
            Error = "";
        } catch (SQLException ex) {
            Error = String.valueOf(ex.getMessage());
        }
        return data;
    }

    private static String Clob_String(ArrayList<Object> data) {
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            Clob clobValue = (Clob) data.get(i);
            try {
                final long clobLength = clobValue.length();
                if (clobLength < Integer.MIN_VALUE || clobLength > Integer.MAX_VALUE) {
                    System.out.println("CLOB size too big for String!");
                } else {
                    result += (clobValue.getSubString(1, (int) clobValue.length())) + "\n \n";
                }
            } catch (SQLException e) {
                System.out.println("tryClob2String ERROR: {}" + e);
            } finally {
                if (clobValue != null) {
                    try {
                        clobValue.free();
                    } catch (SQLException e) {
                        System.out.println("CLOB FREE ERROR: {}" + e);
                    }
                }
            }
        }
        return result;
    }

    private static String tablesServer() {
        try {
            deteccion_motor();
        } catch (SQLException ex) {
            Logger.getLogger(CargueCopiaDeSeguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement st = null;
        ResultSet rs = null;
        String all = "";
        try {
            Connection con = Conexion.getConnection();
            st = con.createStatement();
            for (int i = 0; i < consulta_tablas.size(); i++) {
                rs = st.executeQuery("DECLARE @table_name SYSNAME\n"
                        + "                        SELECT @table_name = 'dbo." + consulta_tablas.get(i) + "'\n"
                        + "                      \n"
                        + "                        DECLARE @object_name SYSNAME, @object_id INT\n"
                        + "                        \n"
                        + "                        SELECT  @object_name = '[' + s.name + '].[' + o.name + ']', @object_id = o.[object_id] FROM sys.objects o WITH (NOWAIT)\n"
                        + "                        JOIN sys.schemas s WITH (NOWAIT) ON o.[schema_id] = s.[schema_id] WHERE s.name + '.' + o.name = @table_name\n"
                        + "                        AND o.[type] = 'U' AND o.is_ms_shipped = 0\n"
                        + "                        \n"
                        + "                        DECLARE @SQL NVARCHAR(MAX) = ''\n"
                        + "                        ;WITH index_column \n"
                        + "						AS  (\n"
                        + "                            SELECT \n"
                        + "                                  ic.[object_id]\n"
                        + "                                , ic.index_id\n"
                        + "                                , ic.is_descending_key\n"
                        + "                                , ic.is_included_column\n"
                        + "                                , c.name\n"
                        + "                            FROM sys.index_columns ic WITH (NOWAIT)\n"
                        + "                            JOIN sys.columns c WITH (NOWAIT) ON ic.[object_id] = c.[object_id] AND ic.column_id = c.column_id\n"
                        + "                            WHERE ic.[object_id] = @object_id\n"
                        + "                        ),\n"
                        + "                        fk_columns AS \n"
                        + "                        (SELECT  k.constraint_object_id , cname = c.name, rcname = rc.name\n"
                        + "                            FROM sys.foreign_key_columns k WITH (NOWAIT)\n"
                        + "                            JOIN sys.columns rc WITH (NOWAIT) ON rc.[object_id] = k.referenced_object_id AND rc.column_id = k.referenced_column_id \n"
                        + "                            JOIN sys.columns c WITH (NOWAIT) ON c.[object_id] = k.parent_object_id AND c.column_id = k.parent_column_id\n"
                        + "                            WHERE k.parent_object_id = @object_id)\n"
                        + "\n"
                        + "                        SELECT @SQL = 'CREATE TABLE ' + @object_name + CHAR(13) + '(' + CHAR(13) + STUFF((\n"
                        + "                            SELECT CHAR(9) + ', [' + c.name + '] ' + CASE WHEN c.is_computed = 1 THEN 'AS ' + cc.[definition] ELSE UPPER(tp.name) + \n"
                        + "                                        CASE WHEN tp.name IN ('varchar', 'char', 'varbinary', 'binary', 'text')\n"
                        + "                                               THEN '(' + CASE WHEN c.max_length = -1 THEN 'MAX' ELSE CAST(c.max_length AS VARCHAR(5)) END + ')'\n"
                        + "                                             WHEN tp.name IN ('nvarchar', 'nchar', 'ntext')\n"
                        + "                                               THEN '(' + CASE WHEN c.max_length = -1 THEN 'MAX' ELSE CAST(c.max_length / 2 AS VARCHAR(5)) END + ')'\n"
                        + "                                             WHEN tp.name IN ('datetime2', 'time2', 'datetimeoffset') \n"
                        + "                                               THEN '(' + CAST(c.scale AS VARCHAR(5)) + ')'\n"
                        + "                                             WHEN tp.name = 'decimal' \n"
                        + "                                               THEN '(' + CAST(c.[precision] AS VARCHAR(5)) + ',' + CAST(c.scale AS VARCHAR(5)) + ')'\n"
                        + "                                            ELSE ''\n"
                        + "                                        END +\n"
                        + "                                        CASE WHEN c.collation_name IS NOT NULL THEN ' COLLATE ' + c.collation_name ELSE '' END +\n"
                        + "                                        CASE WHEN c.is_nullable = 1 THEN ' NULL' ELSE ' NOT NULL' END +\n"
                        + "                                        CASE WHEN dc.[definition] IS NOT NULL THEN ' DEFAULT' + dc.[definition] ELSE '' END + \n"
                        + "                                        CASE WHEN ic.is_identity = 1 THEN ' IDENTITY(' + CAST(ISNULL(ic.seed_value, '0') AS CHAR(1)) + ',' + CAST(ISNULL(ic.increment_value, '1') AS CHAR(1)) + ')' ELSE '' END \n"
                        + "                                END + CHAR(13)\n"
                        + "                            FROM sys.columns c WITH (NOWAIT)\n"
                        + "                            JOIN sys.types tp WITH (NOWAIT) ON c.user_type_id = tp.user_type_id\n"
                        + "                            LEFT JOIN sys.computed_columns cc WITH (NOWAIT) ON c.[object_id] = cc.[object_id] AND c.column_id = cc.column_id\n"
                        + "                            LEFT JOIN sys.default_constraints dc WITH (NOWAIT) ON c.default_object_id != 0 AND c.[object_id] = dc.parent_object_id AND c.column_id = dc.parent_column_id\n"
                        + "                            LEFT JOIN sys.identity_columns ic WITH (NOWAIT) ON c.is_identity = 1 AND c.[object_id] = ic.[object_id] AND c.column_id = ic.column_id\n"
                        + "                            WHERE c.[object_id] = @object_id\n"
                        + "                            ORDER BY c.column_id\n"
                        + "                            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, CHAR(9) + ' ')\n"
                        + "                            + ISNULL((SELECT CHAR(9) + ', CONSTRAINT [' + k.name + '] PRIMARY KEY (' + \n"
                        + "                                            (SELECT STUFF((\n"
                        + "                                                 SELECT ', [' + c.name + '] ' + CASE WHEN ic.is_descending_key = 1 THEN 'DESC' ELSE 'ASC' END\n"
                        + "                                                 FROM sys.index_columns ic WITH (NOWAIT)\n"
                        + "                                                 JOIN sys.columns c WITH (NOWAIT) ON c.[object_id] = ic.[object_id] AND c.column_id = ic.column_id\n"
                        + "                                                 WHERE ic.is_included_column = 0\n"
                        + "                                                     AND ic.[object_id] = k.parent_object_id \n"
                        + "                                                     AND ic.index_id = k.unique_index_id     \n"
                        + "                                                 FOR XML PATH(N''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, ''))\n"
                        + "                                    + ')' + CHAR(13)\n"
                        + "                                    FROM sys.key_constraints k WITH (NOWAIT)\n"
                        + "                                    WHERE k.parent_object_id = @object_id \n"
                        + "                                        AND k.[type] = 'PK'), '') + ')'  + CHAR(13)\n"
                        + "                            + ISNULL((SELECT (\n"
                        + "                                SELECT CHAR(13) +\n"
                        + "                                     'ALTER TABLE ' + @object_name + ' WITH' \n"
                        + "                                    + CASE WHEN fk.is_not_trusted = 1 \n"
                        + "                                        THEN ' NOCHECK' \n"
                        + "                                        ELSE ' CHECK' \n"
                        + "                                      END + \n"
                        + "                                      ' ADD CONSTRAINT [' + fk.name  + '] FOREIGN KEY(' \n"
                        + "                                      + STUFF((\n"
                        + "                                        SELECT ', [' + k.cname + ']'\n"
                        + "                                        FROM fk_columns k\n"
                        + "                                        WHERE k.constraint_object_id = fk.[object_id]\n"
                        + "                                        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '')\n"
                        + "                                       + ')' +\n"
                        + "                                      ' REFERENCES [' + SCHEMA_NAME(ro.[schema_id]) + '].[' + ro.name + '] ('\n"
                        + "                                      + STUFF((\n"
                        + "                                        SELECT ', [' + k.rcname + ']'\n"
                        + "                                        FROM fk_columns k\n"
                        + "                                        WHERE k.constraint_object_id = fk.[object_id]\n"
                        + "                                        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '')\n"
                        + "                                       + ')'\n"
                        + "                                    + CASE \n"
                        + "                                        WHEN fk.delete_referential_action = 1 THEN ' ON DELETE CASCADE' \n"
                        + "                                        WHEN fk.delete_referential_action = 2 THEN ' ON DELETE SET NULL'\n"
                        + "                                        WHEN fk.delete_referential_action = 3 THEN ' ON DELETE SET DEFAULT' \n"
                        + "                                        ELSE '' \n"
                        + "                                      END\n"
                        + "                                    + CASE \n"
                        + "                                        WHEN fk.update_referential_action = 1 THEN ' ON UPDATE CASCADE'\n"
                        + "                                        WHEN fk.update_referential_action = 2 THEN ' ON UPDATE SET NULL'\n"
                        + "                                        WHEN fk.update_referential_action = 3 THEN ' ON UPDATE SET DEFAULT'  \n"
                        + "                                        ELSE '' \n"
                        + "                                      END \n"
                        + "                                    + CHAR(13) + 'ALTER TABLE ' + @object_name + ' CHECK CONSTRAINT [' + fk.name  + ']' + CHAR(13)\n"
                        + "                                FROM sys.foreign_keys fk WITH (NOWAIT)\n"
                        + "                                JOIN sys.objects ro WITH (NOWAIT) ON ro.[object_id] = fk.referenced_object_id\n"
                        + "                                WHERE fk.parent_object_id = @object_id\n"
                        + "                                FOR XML PATH(N''), TYPE).value('.', 'NVARCHAR(MAX)')), '')\n"
                        + "                            + ISNULL(((SELECT\n"
                        + "                                 CHAR(13) + 'CREATE' + CASE WHEN i.is_unique = 1 THEN ' UNIQUE' ELSE '' END \n"
                        + "                                        + ' NONCLUSTERED INDEX [' + i.name + '] ON ' + @object_name + ' (' +\n"
                        + "                                        STUFF((\n"
                        + "                                        SELECT ', [' + c.name + ']' + CASE WHEN c.is_descending_key = 1 THEN ' DESC' ELSE ' ASC' END\n"
                        + "                                        FROM index_column c\n"
                        + "                                        WHERE c.is_included_column = 0\n"
                        + "                                            AND c.index_id = i.index_id\n"
                        + "                                        FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') + ')'  \n"
                        + "                                        + ISNULL(CHAR(13) + 'INCLUDE (' + \n"
                        + "                                            STUFF((\n"
                        + "                                            SELECT ', [' + c.name + ']'\n"
                        + "                                            FROM index_column c\n"
                        + "                                            WHERE c.is_included_column = 1\n"
                        + "                                                AND c.index_id = i.index_id\n"
                        + "                                            FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)'), 1, 2, '') + ')', '')  + CHAR(13)\n"
                        + "                                FROM sys.indexes i WITH (NOWAIT)\n"
                        + "                                WHERE i.[object_id] = @object_id\n"
                        + "                                    AND i.is_primary_key = 0\n"
                        + "                                    AND i.[type] = 2\n"
                        + "                                FOR XML PATH(''), TYPE).value('.', 'NVARCHAR(MAX)')\n"
                        + "                            ), '')\n"
                        + "                        \n"
                        + "                        select @SQL as tablas");

                while (rs.next()) {
                    all += stream_string(rs.getAsciiStream(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(CargueCopiaDeSeguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

    private static String stream_string(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

    private static String consultaP(ArrayList<Object> data) {
        String all = "";
        ResultSet rs = null;

        try {
            Connection con = Conexion.getConnection();
            Statement st = con.createStatement();
            for (int i = 0; i < data.size(); i++) {
                rs = st.executeQuery("sp_helptext " + data.get(i));
                while (rs.next()) {
                    all += (rs.getObject(1));
                }
            }
        } catch (SQLException ex) {
            Error = String.valueOf(ex.getMessage());

        }
        return all;
    }

    public static String ScriptOracle() {
        try {
            deteccion_motor();
        } catch (SQLException ex) {
            Logger.getLogger(CargueCopiaDeSeguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        String all = "";
        all += "*******TABLES********\n\n"
                + Clob_String(consulta_tablas) + "\n\n\n\n";
        all += "*******FUNCTIONS********\n\n"
                + Clob_String(consulta_funciones) + "\n\n\n\n";
        all += "*******PACKAGES********\n\n"
                + Clob_String(consulta_paquetes) + "\n\n\n\n";
        all += "*******PROCEDURES********\n\n"
                + Clob_String(consulta_procedimientos) + "\n\n\n\n";
        all += "*******TRIGGERS********\n\n"
                + Clob_String(consulta_triggers) + "\n\n\n\n";
        all += "*******VIEWS********\n\n"
                + Clob_String(consulta_vistas) + "\n\n\n\n";
        all += "*******INDEXES********\n\n"
                + Clob_String(consulta_indices) + "\n\n\n\n";

        return all;
    }

    public static String ScriptServer() {
        String all = "";

        try {
            deteccion_motor();
        } catch (SQLException ex) {
            Logger.getLogger(CargueCopiaDeSeguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        all += "*******TABLES********\n\n"
                + tablesServer() + "\n\n\n\n";
        all += "*******FUNCTIONS********\n\n"
                + consultaP(consulta_funciones) + "\n\n\n\n";
        all += "*******PROCEDURES********\n\n"
                + consultaP(consulta_procedimientos) + "\n\n\n\n";
        all += "*******TRIGGERS********\n\n"
                + consultaP(consulta_triggers) + "\n\n\n\n";
        all += "*******VIEWS********\n\n"
                + consultaP(consulta_vistas) + "\n\n\n\n";

        return all;

    }
}
