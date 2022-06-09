table

CREATE TABLE TAPRES
   (NUMERO NUMBER)

INSERT INTO TPARES (NUMERO) VALUES (15)
UPDATE TPARES SET NUMERO = 400 WHERE NUMERO=4
DELETE FROM PARES



View

 CREATE  VIEW DATOS_EMPLEADO AS 
  SELECT NOMBRE_1,APELLIDO_1,TELEFONO,EMAIL
 FROM EMPLEADOS 
 WHERE IDENTIFICACION = 12;

Function

create or replace function fecha_servidor return varchar2 is
    v_fecha varchar2(5);
begin
    select extract(year from sysdate) into v_fecha from dual;
    return v_fecha;
end fecha_servidor;



procedure

create or replace procedure llenar_pares is
begin 
    for v_contador  in 0 .. 100 loop 
        if mod(v_contador,2) = 0 then
            insert into tpares(numero) values(v_contador);    
        end if;
    end loop;
end;


