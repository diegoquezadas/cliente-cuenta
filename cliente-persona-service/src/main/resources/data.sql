-- Insertar datos en la tabla persona
INSERT INTO persona (nombre, genero, edad, identificacion, direccion, telefono) 
VALUES ('Diego Quezada', 'M', 30, '1722432885', 'Beaterio sn y principal', '0999638217');

-- Insertar datos en la tabla cliente usando el id de persona
INSERT INTO cliente (id, contrasena, estado) 
VALUES ((SELECT id FROM persona WHERE identificacion = '1722432885'), '1234', true);
