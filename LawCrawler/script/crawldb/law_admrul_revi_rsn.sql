-- crawldb.admrul_revi_rsn definition

DROP TABLE `law_admrul_revi_rsn`;
CREATE TABLE `law_admrul_revi_rsn` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `revi_typ_rsn` longtext DEFAULT NULL COMMENT '제개정이유',
  PRIMARY KEY (`admrul_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_제개정이유';