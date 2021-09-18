-- crawldb.trty_lst definition

DROP TABLE `law_trty_lst`;
CREATE TABLE `law_trty_lst` (
  `trty_sn` varchar(100) NOT NULL COMMENT '조약일련번호',
  `trty_nm` text DEFAULT NULL COMMENT '조약명',
  `trty_typ_cd` varchar(100) DEFAULT NULL COMMENT '조약구분코드',
  `trty_typ_nm` varchar(100) DEFAULT NULL COMMENT '조약구분명',
  `efft_dt` varchar(100) DEFAULT NULL COMMENT '발효일자',
  `sign_dt` varchar(100) DEFAULT NULL COMMENT '서명일자',
  `ofctt_opn_dt` varchar(100) DEFAULT NULL COMMENT '관보게제일자',
  `trty_no` varchar(100) DEFAULT NULL COMMENT '조약번호',
  `natn_no` varchar(100) DEFAULT NULL COMMENT '국가번호',
  `trty_lnk` varchar(100) DEFAULT NULL COMMENT '조약상세링크',
  PRIMARY KEY (`trty_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='조약_목록';