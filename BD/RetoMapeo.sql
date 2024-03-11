create database retomapeo;
use retomapeo;

-- Inserciones para Hombres
INSERT INTO tblastronautas (apellidoMaterno, apellidoPaterno, edad, nombres, sexo, tipoSangre) VALUES
  ('García', 'Hernández', 35, 'Juan', 'Masculino', 'A+'),
  ('Martínez', 'López', 40, 'Carlos', 'Masculino', 'B+'),
  ('Ramírez', 'Gómez', 45, 'Alejandro', 'Masculino', 'AB-'),
  ('Pérez', 'Rodríguez', 30, 'Roberto', 'Masculino', 'O-'),
  ('López', 'Sánchez', 32, 'Miguel', 'Masculino', 'A+'),
  ('González', 'Torres', 38, 'Javier', 'Masculino', 'O+'),
  ('Díaz', 'Mendoza', 42, 'Luis', 'Masculino', 'B-'),
  ('Herrera', 'Cruz', 48, 'Antonio', 'Masculino', 'AB+'),
  ('Fernández', 'Reyes', 33, 'Jorge', 'Masculino', 'A-'),
  ('Moreno', 'Ramos', 47, 'Fernando', 'Masculino', 'O+'),
  ('Jiménez', 'Ortega', 36, 'Alberto', 'Masculino', 'B-'),
  ('Vargas', 'Castillo', 44, 'Ricardo', 'Masculino', 'AB+'),
  ('Castro', 'Gutiérrez', 31, 'Daniel', 'Masculino', 'O-'),
  ('Rivera', 'Núñez', 39, 'Juan Manuel', 'Masculino', 'A-'),
  ('Torres', 'Romero', 50, 'José', 'Masculino', 'B+');

-- Inserciones para Mujeres
INSERT INTO tblastronautas (apellidoMaterno, apellidoPaterno, edad, nombres, sexo, tipoSangre) VALUES
  ('Gómez', 'Hernández', 34, 'Ana', 'Femenino', 'A-'),
  ('López', 'Martínez', 41, 'Sofía', 'Femenino', 'AB+'),
  ('Martínez', 'Gómez', 46, 'María', 'Femenino', 'O-'),
  ('Rodríguez', 'Pérez', 30, 'Laura', 'Femenino', 'B+'),
  ('Sánchez', 'López', 32, 'Isabel', 'Femenino', 'A+'),
  ('Torres', 'González', 37, 'Cristina', 'Femenino', 'B-'),
  ('Mendoza', 'Díaz', 43, 'Elena', 'Femenino', 'O+'),
  ('Cruz', 'Herrera', 49, 'Silvia', 'Femenino', 'AB-'),
  ('Reyes', 'Fernández', 33, 'Carolina', 'Femenino', 'A-'),
  ('Ramos', 'Moreno', 48, 'Patricia', 'Femenino', 'B+'),
  ('Ortega', 'Jiménez', 35, 'Beatriz', 'Femenino', 'AB+'),
  ('Castillo', 'Vargas', 44, 'Eva', 'Femenino', 'O-'),
  ('Gutiérrez', 'Castro', 31, 'Lorena', 'Femenino', 'A+'),
  ('Núñez', 'Rivera', 38, 'Marta', 'Femenino', 'B-'),
  ('Romero', 'Torres', 50, 'Adriana', 'Femenino', 'O+');