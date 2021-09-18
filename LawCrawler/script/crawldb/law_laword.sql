-- crawldb.laword definition

DROP TABLE `law_laword`;
CREATE TABLE `law_laword` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `laword_id` varchar(100) DEFAULT NULL COMMENT '법령ID',
  `prmg_dt` varchar(100) DEFAULT NULL COMMENT '공포일자',
  `prmg_no` varchar(100) DEFAULT NULL COMMENT '공포번호',
  `lang_typ` varchar(100) DEFAULT NULL COMMENT '언어종류',
  `lawknd_typ` varchar(100) DEFAULT NULL COMMENT '법종류의구분',
  `lawknd_cd` varchar(100) DEFAULT NULL COMMENT '법종구분코드',
  `laword_nm` text DEFAULT NULL COMMENT '한글법령명',
  `laword_nm_ch` text DEFAULT NULL COMMENT '법령명_한자',
  `laword_abrv` varchar(100) DEFAULT NULL COMMENT '법령명약칭',
  `comp_sn` varchar(100) DEFAULT NULL COMMENT '편장절관일련번호',
  `jrsd_mof_cd` varchar(100) DEFAULT NULL COMMENT '소관부처코드',
  `jrsd_mof_nm` varchar(100) DEFAULT NULL COMMENT '소관부처명',
  `tel_no` varchar(100) DEFAULT NULL COMMENT '전화번호',
  `cnfdcr_dt` varchar(100) DEFAULT NULL COMMENT '시행일자',
  `revi_typ_nm` varchar(100) DEFAULT NULL COMMENT '제개정구분',
  `attc_edt_yn` varchar(100) DEFAULT NULL COMMENT '별표편집여부',
  `prmg_edt_yn` varchar(100) DEFAULT NULL COMMENT '공포법령여부',
  `attc_cnfdcr_dt_str` text DEFAULT NULL COMMENT '별표시행일자문자열',
  `ttl_chg_yn` varchar(100) DEFAULT NULL COMMENT '제명변경여부',
  `kor_laword_yn` varchar(100) DEFAULT NULL COMMENT '한글법령여부',
  PRIMARY KEY (`laword_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령';