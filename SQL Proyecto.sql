use BDProyecto;


CREATE TABLE Usuarios(
	id int primary key identity(1,1),
	Nombre varchar(40),
	edad int,
	sexo char(1),
	fechaRegistro date
);

CREATE TABLE Mediciones(
	id int primary key identity(1,1),
	UserID int foreign key references Usuarios(id),
	peso decimal(5,2),
	talla decimal(4,2)
);

CREATE TABLE IMC(
	id int primary key identity(1,1),
	MedicionID int foreign key references Mediciones(id),
	imc decimal(4,2),
	fechaCalculo date
);

CREATE TABLE Historial(
	id int primary key identity(1,1),
	UsuarioID int foreign key references Usuarios(id),
	tipoCalculo varchar(20),
	resultado decimal(4,2),
	fechaCalculo date
	);


	--Procedimiento para la tabla usuario
CREATE PROCEDURE GestionarUsuario
    @Operacion VARCHAR(20),
    @Id INT = NULL,
    @Nombre VARCHAR(40) = NULL,
    @Edad INT = NULL,
    @Sexo CHAR(1) = NULL,
    @FechaRegistro DATE = NULL
AS
BEGIN
    IF @Operacion = 'Insertar'
    BEGIN
        INSERT INTO Usuarios (Nombre, Edad, Sexo, FechaRegistro)
        VALUES (@Nombre, @Edad, @Sexo, @FechaRegistro);
    END
    ELSE IF @Operacion = 'Actualizar'
    BEGIN
        UPDATE Usuarios
        SET Nombre = @Nombre, Edad = @Edad, Sexo = @Sexo
        WHERE Id = @Id;
    END
    
    ELSE IF @Operacion = 'Obtener'
    BEGIN
        SELECT * FROM Usuarios WHERE Id = @Id;
    END
END;


--Procedimiento para las mediciones
CREATE PROCEDURE GestionarMedicion
    @Operacion VARCHAR(20),
    @Id INT = NULL,
    @UserID INT = NULL,
    @Peso DECIMAL(5,2) = NULL,
    @Talla DECIMAL(4,2) = NULL
AS
BEGIN
    IF @Operacion = 'Insertar'
    BEGIN
        INSERT INTO Mediciones (UserID, peso, talla)
        VALUES (@UserID, @Peso, @Talla);
    END
    ELSE IF @Operacion = 'Actualizar'
    BEGIN
        UPDATE Mediciones
        SET UserID = @UserID, peso = @Peso, talla = @Talla
        WHERE id = @Id;
    END
    ELSE IF @Operacion = 'Obtener'
    BEGIN
        SELECT * FROM Mediciones WHERE id = @Id;
    END
    ELSE IF @Operacion = 'ObtenerPorUsuario'
    BEGIN
        SELECT * FROM Mediciones WHERE UserID = @UserID;
    END
END;


--Procedimiento para el IMC
CREATE PROCEDURE GestionarIMC
    @Operacion VARCHAR(20),
    @Id INT = NULL,
    @MedicionID INT = NULL,
    @Imc DECIMAL(4,2) = NULL,
    @FechaCalculo DATE = NULL
AS
BEGIN
    IF @Operacion = 'Insertar'
    BEGIN
        INSERT INTO IMC (MedicionID, imc, fechaCalculo)
        VALUES (@MedicionID, @Imc, @FechaCalculo);
    END
    ELSE IF @Operacion = 'Actualizar'
    BEGIN
        UPDATE IMC
        SET MedicionID = @MedicionID, imc = @Imc, fechaCalculo = @FechaCalculo
        WHERE id = @Id;
    END
    ELSE IF @Operacion = 'Obtener'
    BEGIN
        SELECT * FROM IMC WHERE id = @Id;
    END
    ELSE IF @Operacion = 'ObtenerTodos'
    BEGIN
        SELECT * FROM IMC;
    END
END;


--Procedimiento para el Historial
CREATE PROCEDURE GestionarHistorial
    @Operacion VARCHAR(20),
    @Id INT = NULL,
    @UsuarioID INT = NULL,
    @TipoCalculo VARCHAR(20) = NULL,
    @Resultado DECIMAL(4,2) = NULL,
    @FechaCalculo DATE = NULL
AS
BEGIN
    IF @Operacion = 'Insertar'
    BEGIN
        INSERT INTO Historial (UsuarioID, tipoCalculo, resultado, fechaCalculo)
        VALUES (@UsuarioID, @TipoCalculo, @Resultado, @FechaCalculo);
    END
    ELSE IF @Operacion = 'Actualizar'
    BEGIN
        UPDATE Historial
        SET UsuarioID = @UsuarioID, tipoCalculo = @TipoCalculo, resultado = @Resultado, fechaCalculo = @FechaCalculo
        WHERE id = @Id;
    END
    ELSE IF @Operacion = 'Obtener'
    BEGIN
        SELECT * FROM Historial WHERE id = @Id;
    END
    ELSE IF @Operacion = 'ObtenerPorUsuario'
    BEGIN
        SELECT * FROM Historial WHERE UsuarioID = @UsuarioID;
    END
END;



use BDProyecto;

select * from Usuarios;
select * from Mediciones;
select * from Historial;

delete from Usuarios;
delete from Mediciones;



DBCC CHECKIDENT ('Usuarios', RESEED, 0);
DBCC CHECKIDENT ('Mediciones', RESEED, 0);
DBCC CHECKIDENT ('IMC', RESEED, 0);
DBCC CHECKIDENT ('Historial', RESEED, 0);




