-- crawldb.admrul_comp definition

DROP TABLE `law_admrul_comp`;
CREATE TABLE `law_admrul_comp` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `comp_key` int(11) NOT NULL COMMENT '조문번호',
  `comp_cnt` longtext DEFAULT NULL COMMENT '조문내용',
  PRIMARY KEY (`admrul_sn`,`comp_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_조문';