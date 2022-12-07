/*
Navicat MySQL Data Transfer

Source Server         : Base de datos I
Source Server Version : 100422
Source Host           : localhost:3306
Source Database       : colegio

Target Server Type    : MYSQL
Target Server Version : 100422
File Encoding         : 65001

Date: 2022-12-07 15:47:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alumnos
-- ----------------------------
DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE `alumnos` (
  `id_alum` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `ci` int(11) DEFAULT NULL,
  `rude` int(11) DEFAULT NULL,
  `curso` int(11) DEFAULT NULL,
  `grado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_alum`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of alumnos
-- ----------------------------
INSERT INTO `alumnos` VALUES ('1', 'Daniel Jhonany', 'Villafan Saca', '1007623', '20003421', '1', 'Secundaria');
INSERT INTO `alumnos` VALUES ('2', 'Edson Ramiro ', 'Calle Mayta', '9963453', '20005312', '2', 'primaria');
INSERT INTO `alumnos` VALUES ('4', 'Felipe Pedro', 'Alarcon', '7452154', '10225485', '2', 'Secundaria');

-- ----------------------------
-- Table structure for curso
-- ----------------------------
DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso` (
  `id_cu` int(11) NOT NULL AUTO_INCREMENT,
  `grado` varchar(5) DEFAULT NULL,
  `num_aula` int(11) DEFAULT NULL,
  `id_inmueble` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cu`),
  KEY `fk_curso` (`id_inmueble`),
  CONSTRAINT `fk_curso` FOREIGN KEY (`id_inmueble`) REFERENCES `inmuebles` (`id_i`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of curso
-- ----------------------------
INSERT INTO `curso` VALUES ('1', '5to', '2', '1');
INSERT INTO `curso` VALUES ('2', '6to', '3', '1');
INSERT INTO `curso` VALUES ('3', '2to', '6', '3');

-- ----------------------------
-- Table structure for inmuebles
-- ----------------------------
DROP TABLE IF EXISTS `inmuebles`;
CREATE TABLE `inmuebles` (
  `id_i` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` varchar(10) DEFAULT '',
  PRIMARY KEY (`id_i`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of inmuebles
-- ----------------------------
INSERT INTO `inmuebles` VALUES ('1', 'sillas', '1000', 'usadas');
INSERT INTO `inmuebles` VALUES ('2', 'mesas', '300', 'nuevas');
INSERT INTO `inmuebles` VALUES ('3', 'estantes', '50', 'usadas');
INSERT INTO `inmuebles` VALUES ('4', 'Pizarra', '12', 'seminuevas');

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `id_p` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT '',
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_p`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('1', 'alberto', 'Zapata Rodrigues', 'Portero', 'Calle Velgica-Zona Entre Rios', '98765922');
INSERT INTO `personal` VALUES ('2', 'Jonathan', 'Mamani Tintaya Mamani', 'Regente', 'Calle Zuisa-Zona 26 de junio', '60785466');
INSERT INTO `personal` VALUES ('3', 'Edson', 'Cusi chirinos', 'Profesor', 'Calle Argentina-Zona 20 de ctubre', '70662343');
INSERT INTO `personal` VALUES ('5', 'Hugo', 'Vazques', 'Profesor', 'Calle Domingo Murillo', '75841258');
INSERT INTO `personal` VALUES ('6', 'Fernanda ', 'Poma Laura', 'Profesora', 'Calle Alfonso Ugarte', '74582140');

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor` (
  `id_t` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT '',
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_t`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES ('1', 'Juan', 'Mamani Parra', 'Calle Brasil-Zona 6 de marzo', '70892343');
INSERT INTO `tutor` VALUES ('3', 'Maria', 'Quispe Fernandes', 'Calle nortica-Zona Villa esper', '67875405');
INSERT INTO `tutor` VALUES ('4', 'Raquel', 'Mendez Silva', 'Calle Pascoe II', '75824125');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_u` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT '',
  PRIMARY KEY (`id_u`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('8', 'hugo', 'kantuta', 'hugo@hogo.com', '202cb962ac59075b964b07152d234b70');
INSERT INTO `usuario` VALUES ('9', 'edson', 'calle', 'edson@edson.com', '827ccb0eea8a706c4c34a16891f84e7b');
INSERT INTO `usuario` VALUES ('10', 'jon', 'mamani', 'parra@parra.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `usuario` VALUES ('11', 'Daniel ', 'Villafan', 'dani@dani.com', '900150983cd24fb0d6963f7d28e17f72');
INSERT INTO `usuario` VALUES ('12', 'Maria', 'Parra', 'maria@maria.com', '263bce650e68ab4e23f28263760b9fa5');
SET FOREIGN_KEY_CHECKS=1;
