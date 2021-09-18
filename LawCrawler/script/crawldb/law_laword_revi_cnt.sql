-- crawldb.laword_revi_cnt definition

DROP TABLE `law_laword_revi_cnt`;
CREATE TABLE `law_laword_revi_cnt` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `revi_typ_cnt` longtext DEFAULT NULL COMMENT '개정문내용',
  PRIMARY KEY (`laword_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_개정문';