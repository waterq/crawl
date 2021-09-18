-- crawldb.laword_comp_hang definition

DROP TABLE `law_laword_comp_hang`;
CREATE TABLE `law_laword_comp_hang` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `comp_key` int(11) NOT NULL COMMENT '조문KEY',
  `hang_key` int(11) NOT NULL COMMENT '항KEY',
  `hang_no` varchar(100) DEFAULT NULL COMMENT '항번호',
  `hang_revi_typ` varchar(100) DEFAULT NULL COMMENT '항제개정유형',
  `hang_revi_dt` text DEFAULT NULL COMMENT '항제개정일자문자열',
  `hang_cnt` longtext DEFAULT NULL COMMENT '항내용',
  PRIMARY KEY (`laword_key`,`comp_key`,`hang_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_조문_항';