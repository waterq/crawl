-- crawldb.trty_cnt definition

DROP TABLE `law_trty_cnt`;
CREATE TABLE `law_trty_cnt` (
  `trty_sn` varchar(100) NOT NULL COMMENT '조약일련번호',
  `cnt_key` varchar(100) NOT NULL COMMENT '내용_Key',
  `trty_cnt` longtext DEFAULT NULL COMMENT '조약내용',
  PRIMARY KEY (`trty_sn`,`cnt_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='조약내용';