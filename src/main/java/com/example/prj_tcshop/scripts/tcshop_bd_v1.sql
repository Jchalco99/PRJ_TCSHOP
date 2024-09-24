DROP DATABASE tcshop;

CREATE DATABASE tcshop;

USE tcshop;

CREATE TABLE sedes (
    idSede INT PRIMARY KEY AUTO_INCREMENT,
    nombre_sede VARCHAR(255),
    ubicacion_mapa VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE categorias (
    idcategoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria VARCHAR(255),
    descripcion_categoria VARCHAR(255),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuarios (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    email VARCHAR(255),
    contrasena VARCHAR(255),
    rol CHAR(1),
    telefono VARCHAR(45),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    carrera VARCHAR(255),
    departamento VARCHAR(255),
    sedes_idSede INT,
    FOREIGN KEY (sedes_idSede) REFERENCES sedes(idSede)
);

CREATE TABLE productos (
    idproducto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2),
    stock INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    imagen_url VARCHAR(255),
    categorias_idcategoria INT,
    usuarios_idUsuario INT,
    sedes_idSede INT,
    FOREIGN KEY (categorias_idcategoria) REFERENCES categorias(idcategoria),
    FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (sedes_idSede) REFERENCES sedes(idSede)
);

CREATE TABLE rifas (
    idrifas INT PRIMARY KEY AUTO_INCREMENT,
    nombre_rifa VARCHAR(255),
    fecha_rifa DATE,
    precio_boleto DECIMAL(10, 2),
    cantidad_boleto INT,
    sedes_idSede INT,
    FOREIGN KEY (sedes_idSede) REFERENCES sedes(idSede)
);

CREATE TABLE horarios_tienda (
    idhorarios_tienda INT PRIMARY KEY AUTO_INCREMENT,
    hora_apertura TIME,
    hora_cierre TIME,
    dias_operativos VARCHAR(255),
    usuarios_idUsuario INT,
    sedes_idSede INT,
    FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (sedes_idSede) REFERENCES sedes(idSede)
);

CREATE TABLE participantes_rifa (
    idparticipante INT PRIMARY KEY AUTO_INCREMENT,
    numero_boleto VARCHAR(45),
    rifas_idrifa INT,
    usuarios_idUsuario INT,
    FOREIGN KEY (rifas_idrifa) REFERENCES rifas(idrifas) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE promociones (
    idpromocion INT PRIMARY KEY AUTO_INCREMENT,
    descuento DECIMAL(10, 2),
    fecha_inicio DATE,
    fecha_fin DATE,
    descripcion VARCHAR(255),
    productos_idproducto INT,
    FOREIGN KEY (productos_idproducto) REFERENCES productos(idproducto)
);

CREATE TABLE pedidos (
    idpedido INT PRIMARY KEY AUTO_INCREMENT,
    fecha_pedido DATE,
    estado_pedido CHAR(1),
    total_pedido DECIMAL(10, 2),
    usuarios_idUsuario INT,
    FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario)
);

CREATE TABLE detalles_pedido (
    iddetalles_pedido INT PRIMARY KEY AUTO_INCREMENT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    pedidos_idpedido INT,
    productos_idproducto INT,
    FOREIGN KEY (pedidos_idpedido) REFERENCES pedidos(idpedido),
    FOREIGN KEY (productos_idproducto) REFERENCES productos(idproducto)
);

CREATE TABLE resenias_productos (
    idresenias_producto INT PRIMARY KEY AUTO_INCREMENT,
    calificacion INT,
    comentario VARCHAR(255),
    fecha_resena TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuarios_idUsuario INT,
    productos_idproducto INT,
    FOREIGN KEY (usuarios_idUsuario) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (productos_idproducto) REFERENCES productos(idproducto)
);
