-- crawldb.laword_revi_rsn definition

DROP TABLE `law_laword_revi_rsn`;
CREATE TABLE `law_laword_revi_rsn` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `revi_rsn_cnt` longtext DEFAULT NULL COMMENT '제개정이유내용',
  PRIMARY KEY (`laword_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_본문_제개정이유';