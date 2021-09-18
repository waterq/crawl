-- crawldb.trty_attc definition

DROP TABLE `law_trty_attc`;
CREATE TABLE `law_trty_attc` (
  `trty_sn` varchar(100) NOT NULL COMMENT '조약일련번호',
  `attc_key` int(11) NOT NULL COMMENT '첨부파일번호',
  `attc_nm` text DEFAULT NULL COMMENT '첨부파일명',
  `attc_lnk` text DEFAULT NULL COMMENT '첨부파일링크',
  PRIMARY KEY (`trty_sn`,`attc_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='조약_첨부파일';