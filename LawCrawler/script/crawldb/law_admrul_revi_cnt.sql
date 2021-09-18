-- crawldb.admrul_revi_cnt definition

DROP TABLE `law_admrul_revi_cnt`;
CREATE TABLE `law_admrul_revi_cnt` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `revi_typ_cnt` longtext DEFAULT NULL COMMENT '개정문내용',
  PRIMARY KEY (`admrul_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_개정문';