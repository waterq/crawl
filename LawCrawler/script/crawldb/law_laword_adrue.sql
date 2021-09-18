-- crawldb.laword_adrue definition

DROP TABLE `law_laword_adrue`;
CREATE TABLE `law_laword_adrue` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `adrue_key` varchar(100) NOT NULL COMMENT '부칙KEY',
  `adrue_prmg_dt` varchar(100) DEFAULT NULL COMMENT '부칙공포일자',
  `adrue_prmg_no` varchar(100) DEFAULT NULL COMMENT '부칙공포번호',
  `adrue_cnt` longtext DEFAULT NULL COMMENT '부칙내용',
  PRIMARY KEY (`laword_key`,`adrue_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_부칙';