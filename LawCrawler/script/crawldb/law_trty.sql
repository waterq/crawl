-- crawldb.trty definition

DROP TABLE `law_trty`;
CREATE TABLE `law_trty` (
  `trty_sn` varchar(100) NOT NULL COMMENT '조약일련번호',
  `trty_nm` text DEFAULT NULL COMMENT '조약명_한글',
  `trty_nm_en` text DEFAULT NULL COMMENT '조약명_영문',
  `trty_typ_cd` varchar(100) DEFAULT NULL COMMENT '조약구분코드',
  `prsdt_appr_dt` varchar(100) DEFAULT NULL COMMENT '대통령재가일자',
  `efft_dt` varchar(100) DEFAULT NULL COMMENT '발효일자',
  `trty_no` varchar(100) DEFAULT NULL COMMENT '조약번호',
  `ofctt_opn_dt` varchar(100) DEFAULT NULL COMMENT '관보게재일자',
  `natn_dlbrt_dt` varchar(100) DEFAULT NULL COMMENT '국무회의심의일자',
  `natn_dlbrt_no` varchar(100) DEFAULT NULL COMMENT '국무회의심의회차',
  `asmb_agr_yn` varchar(100) DEFAULT NULL COMMENT '국회비준동의여부',
  `asmb_agr_dt` varchar(100) DEFAULT NULL COMMENT '국회비준동의일자',
  `sign_dt` varchar(100) DEFAULT NULL COMMENT '서명일자',
  `sign_plc` varchar(100) DEFAULT NULL COMMENT '서명장소',
  `rmk` longtext DEFAULT NULL COMMENT '비고',
  PRIMARY KEY (`trty_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='조약기본정보';