-- crawldb.laword_comp_hang_ho definition

DROP TABLE `law_laword_comp_hang_ho`;
CREATE TABLE `law_laword_comp_hang_ho` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `comp_key` int(11) NOT NULL COMMENT '조문KEY',
  `hang_key` int(11) NOT NULL COMMENT '항KEY',
  `ho_key` int(11) NOT NULL COMMENT '호KEY',
  `ho_no` varchar(100) DEFAULT NULL COMMENT '호번호',
  `ho_cnt` longtext DEFAULT NULL COMMENT '호내용',
  PRIMARY KEY (`laword_key`,`comp_key`,`hang_key`,`ho_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_조문_항_호';