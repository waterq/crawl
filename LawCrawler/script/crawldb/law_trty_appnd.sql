-- crawldb.trty_appnd definition

DROP TABLE `law_trty_appnd`;
CREATE TABLE `law_trty_appnd` (
  `trty_sn` varchar(100) NOT NULL COMMENT '조약일련번호',
  `appnd_key` int(11) NOT NULL COMMENT '조약_Key',
  `cncls_natn` text DEFAULT NULL COMMENT '체결대상국가',
  `cncls_natn_kr` varchar(100) DEFAULT NULL COMMENT '체결대상국가한글',
  `compt_dspth_in_dt` varchar(100) DEFAULT NULL COMMENT '우리측국내절차완료통보',
  `compt_dspth_out_dt` varchar(100) DEFAULT NULL COMMENT '상대국측국내절차완료통보',
  `trty_cd` varchar(100) DEFAULT NULL COMMENT '양자조약분야코드',
  `trty_nm` varchar(100) DEFAULT NULL COMMENT '양자조약분야명',
  `lang_typ` varchar(100) DEFAULT NULL COMMENT '제2외국어종류',
  `natn_cd` varchar(100) DEFAULT NULL COMMENT '국가코드',
  PRIMARY KEY (`trty_sn`,`appnd_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;