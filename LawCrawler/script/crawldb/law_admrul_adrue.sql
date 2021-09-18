-- crawldb.admrul_adrue definition

DROP TABLE `law_admrul_adrue`;
CREATE TABLE `law_admrul_adrue` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `adrue_key` int(11) NOT NULL COMMENT '부칙_key',
  `adrue_prmg_no` varchar(100) DEFAULT NULL COMMENT '부칙공포번호',
  `adrue_prmg_dt` varchar(100) DEFAULT NULL COMMENT '부칙공포일자',
  `adrue_cnt` longtext DEFAULT NULL COMMENT '부칙내용',
  PRIMARY KEY (`admrul_sn`,`adrue_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_부칙';