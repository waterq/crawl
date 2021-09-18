-- crawldb.admrul_file definition

DROP TABLE `law_admrul_file`;
CREATE TABLE `law_admrul_file` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `attc_key` int(11) NOT NULL COMMENT '첨부파일번호',
  `attc_nm` text DEFAULT NULL COMMENT '첨부파일명',
  `attc_lnk` varchar(100) DEFAULT NULL COMMENT '첨부파일링크',
  PRIMARY KEY (`admrul_sn`,`attc_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_첨부파일';