
//creacion de base de datos
CREATE DATABASE db_proyecto;

USE db_proyecto;

//creacion de tabla empleados

 CREATE TABLE usuarios(
   usuario VARCHAR(25) NOT NULL PRIMARY KEY,
   nombres VARCHAR(35) NOT NULL,
   rol VARCHAR(25) NOT NULL,
   correo VARCHAR(25),
   clave VARCHAR (20)NOT NULL,
   fechaalta DATE NOT NULL
);

CREATE TABLE tipousuario(
   rol VARCHAR(25) NOT NULL PRIMARY KEY
);

CREATE TABLE puesto(
   puesto VARCHAR(25) NOT NULL PRIMARY KEY
);

CREATE TABLE cuadrilla(
   nombrecuadrilla VARCHAR(25) NOT NULL PRIMARY KEY
);

CREATE TABLE renglon(
   id_renglon VARCHAR(25) NOT NULL PRIMARY KEY
);

SELECT * FROM usuarios;
SELECT * FROM tipousuario;
SELECT * FROM empleado;
SHOW TABLES;

INSERT INTO tipousuario(rol)VALUES
('Administrador'),
('Usuario'),
('Contador'),
('secretaria');



CREATE TABLE empleado(
ficha_empleado INT NOT NULL PRIMARY KEY,
estatus VARCHAR(25) NOT NULL,
sexo VARCHAR(20)NOT NULL,
primer_nombre VARCHAR(45) NOT NULL,
segundo_nombre  VARCHAR(45),
primer_apellido VARCHAR(45) NOT NULL,
segundo_apellido VARCHAR(45),
puesto VARCHAR(45) NOT NULL,
nit INT(9) NOT NULL,
salario INT(12)NOT NULL,
anios_antiguedad INT NOT NULL,
renglon INT NOT NULL,
cuadrilla VARCHAR(25) NOT NULL,
sede VARCHAR(45) NOT NULL,
categoria VARCHAR(45) NOT NULL,
no_afiliacion_igss INT(15) NOT NULL
   );
   
//creacion de tabla cuadrillas

CREATE TABLE tbl_cuadrillas(
id_cuadrilla INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(45)
); 

//creacion de tabla trabajo

CREATE TABLE tbl_control_trabajo(
id_control_trabajo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_cuadrilla INT NOT NULL,
ficha_empleado INT NOT NULL,
fecha_inicio DATE,
fecha_final DATE,
hora_inicio TIME,
hora_final TIME,
departamento VARCHAR(45),
municipio VARCHAR(45),
voltaje VARCHAR(45),
linea VARCHAR(45),
identificacion_estrucura VARCHAR(45),
trabajo VARCHAR(45),
nombramiento VARCHAR(45) NOT NULL,
id_usuario INT
);

SELECT * FROM tbl_control_trabajo;

//relacion entre tablas

ALTER TABLE tbl_empleados ADD FOREIGN KEY (id_cuadrilla)
REFERENCES tbl_cuadrillas(id_cuadrilla);

ALTER TABLE tbl_control_trabajo ADD FOREIGN KEY (id_cuadrilla)
REFERENCES tbl_cuadrillas(id_cuadrilla);

ALTER TABLE tbl_control_trabajo ADD FOREIGN KEY (ficha_empleado)
REFERENCES tbl_empleados(ficha_empleado);

ALTER TABLE empleado ADD FOREIGN KEY ()


   
  