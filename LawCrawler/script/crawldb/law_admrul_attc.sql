-- crawldb.admrul_attc definition

DROP TABLE `law_admrul_attc`;
CREATE TABLE `law_admrul_attc` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `attc_key` int(11) NOT NULL COMMENT '별표Key',
  `attc_key2` varchar(100) DEFAULT NULL COMMENT '별표Key2',
  `attc_no` varchar(100) DEFAULT NULL COMMENT '별표번호',
  `attc_brnc_no` varchar(100) DEFAULT NULL COMMENT '별표가지번호',
  `attc_typ` varchar(100) DEFAULT NULL COMMENT '별표구분',
  `attc_nm` text DEFAULT NULL COMMENT '별표제목',
  `attc_file_lnk` varchar(100) DEFAULT NULL COMMENT '별표서식파일링크',
  PRIMARY KEY (`admrul_sn`,`attc_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_별표';