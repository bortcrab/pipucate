-- ASIGNACIÓN 2
create database ecoActivistas;
use ecoActivistas;

create table clientes (
id int primary key auto_increment,
nombre varchar(100) not null,
apellidoPaterno varchar(100) not null,
apellidoMaterno varchar(100),
codigoPostal varchar(5) not null,
colonia varchar(100) not null,
calle varchar(100) not null,
numExterior varchar(5) not null
);

create table telefonosClientes (
id int primary key auto_increment,
numero varchar(15) not null unique,
idCliente int not null,
foreign key (idCliente) references clientes(id)
);

create table problemas (
id int primary key auto_increment,
fechaInicio date not null,
fechaFin date not null,
estado enum('Pendiente', 'Concluido', 'Cancelado') not null,
idCliente int not null,
foreign key (idCliente) references clientes(id)
);

create table activistas (
id int primary key auto_increment,
nombre varchar(100) not null,
apellidoPaterno varchar(100) not null,
apellidoMaterno varchar(100),
telefono varchar(15) not null unique,
fechaComienzo date not null
);

create table activistasAtiendenProblemas (
id int primary key auto_increment,
idActivista int not null,
idProblema int not null,
foreign key (idActivista) references activistas(id),
foreign key (idProblema) references problemas(id)
);

-- ASIGNACIÓN 3
-- 1. Inserta 3 clientes, 2 activistas y 3 problemas con los datos que tu consideres apropiados.
insert into clientes (nombre, apellidoPaterno, apellidoMaterno, codigoPostal, colonia, calle, numExterior)
values ("Saúl", "Pérez", "Ibarra", "84513", "Libertad", "Flores", "987"),
("Roberto", "Ponce", "Araujo", "88932", "Nueva Palmira", "El Paso", "3126"),
("Luis", "Encinas", "Ruiz", "85130", "Bellavista", "Londres", "1595");

-- No sabía si debía agregarle los teléfonos a los clientes, pero lo hice por si acaso.
insert into telefonosClientes (numero, idCliente)
values ("6441562374", 1), ("6441987565", 2), ("6442654821", 3);

insert into activistas (nombre, apellidoPaterno, apellidoMaterno, telefono, fechaComienzo)
values ("Juan", "Román", "Vega", "6441857139", "2022-05-28"),
("Manuel", "Benítez", "Arellanos", "6441326990", "2017-12-14");

insert into problemas(fechaInicio, fechaFin, estado, idCliente)
values ("2023-02-15", "2023-03-10", "Concluido", "1"),
("2023-06-02", "2023-06-22", "Concluido", "2"),
("2023-07-30", "2023-09-04", "Cancelado", "3");

-- No sabía si debía asignar problemas a activistas, pero lo hice por si acaso.
insert into activistasAtiendenProblemas (idActivista, idProblema)
values (1, 1), (1, 2), (1, 3);

-- 2. Actualiza los clientes para que uno se llame John Wick y otro Tony Stark.
update clientes set nombre = "John", apellidoPaterno = "Wick", apellidoMaterno = null where id = 1;
update clientes set nombre = "Tony", apellidoPaterno = "Stark", apellidoMaterno = null where id = 2;

-- 3. Actualiza los activistas para que uno se llame Bruce Wayne y su teléfono sea 55412355.
update activistas set nombre = "Bruce", apellidoPaterno = "Wayne", apellidoMaterno = null, telefono = "55412355" where id = 1;

-- 4. Actualiza los problemas para que todos tengan fecha de este año.
update problemas set fechaInicio = concat("2024", right(fechaInicio, 6)), fechaFin = concat("2024", right(fechaFin, 6));

-- 5. Inserta 1 problema para el cliente Bruce Wayne, fecha inicio el primer día del año en curso, estado pendiente.
insert into problemas(fechaInicio, fechaFin, estado, idCliente)
values ("2024-01-01", "2024-08-01", "Pendiente", "1");

insert into activistasAtiendenProblemas (idActivista, idProblema)
values (1, 4);

-- 6. Inserta 1 problema para el cliente Bruce Wayne, periodo: la primera quincena de enero, estado concluido.
insert into problemas(fechaInicio, fechaFin, estado, idCliente)
values ("2024-01-01", "2024-01-15", "Concluido", "1");

insert into activistasAtiendenProblemas (idActivista, idProblema)
values (1, 5);

-- 7. Consulta el nombre y teléfonos de los clientes que tengan al menos un problema registrado.
select concat(c.nombre, " ", c.apellidoPaterno, " ", ifnull(c.apellidoMaterno, '')) as "Cliente", tc.numero
from clientes c
left join telefonosClientes tc on c.id = tc.idCliente
inner join problemas p on c.id = p.idCliente
group by c.id, tc.numero;

-- 8. Consulta a los activistas que están trabajando actualmente en un problema. Incluye los datos del activista
-- y el nombre del problema.
-- En ningún momento de las actividades anteriores viene algo referente a que los problemas llevan nombre.
select concat(a.nombre, " ", a.apellidoPaterno, " ", ifnull(a.apellidoMaterno, '')) as "Activista", a.telefono,
a.fechaComienzo, aap.idProblema from activistas a
inner join activistasAtiendenProblemas aap on a.id = aap.idActivista
inner join problemas p on p.id = aap.idProblema
where p.estado = "Pendiente"
group by a.id, aap.idProblema;

-- 9. Consulta los problemas pendientes registrados en el mes de diciembre del 2022. Muestra los datos del problema
-- y el nombre cliente. Además, muestra el número de días transcurridos desde la fecha de inicio.
-- No sale nada porque no hay problemas con la fecha en diciembre de 2022.
select p.id as "ID Problema", p.fechaInicio, p.fechaFin, p.estado,
concat(c.nombre, " ", c.apellidoPaterno, " ", ifnull(c.apellidoMaterno, '')) as "Cliente",
datediff(curdate(), fechaInicio) as "Días transcurridos"
from problemas p inner join clientes c on p.idCliente = c.id
where p.estado = "Pendiente" and month(fechaInicio) = 12 and year(fechaInicio) = 2022;