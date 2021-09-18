-- crawldb.laword_lst definition

DROP TABLE `law_laword_lst`;
CREATE TABLE `law_laword_lst` (
  `laword_sn` varchar(100) NOT NULL COMMENT '법령일련번호',
  `cur_hist_cd` varchar(100) DEFAULT NULL COMMENT '현행연혁코드',
  `laword_nm` text DEFAULT NULL COMMENT '법령명한글',
  `laword_abrv` varchar(100) DEFAULT NULL COMMENT '법령약칭명',
  `laword_id` varchar(100) DEFAULT NULL COMMENT '법령ID',
  `prmg_dt` varchar(100) DEFAULT NULL COMMENT '공포일자',
  `prmg_no` varchar(100) DEFAULT NULL COMMENT '공포번호',
  `revi_typ_nm` varchar(100) DEFAULT NULL COMMENT '제개정구분명',
  `jrsd_mof_nm` varchar(100) DEFAULT NULL COMMENT '소관부처명',
  `jrsd_mof_cd` varchar(100) DEFAULT NULL COMMENT '소관부처코드',
  `laword_typ_nm` varchar(100) DEFAULT NULL COMMENT '법령구분명',
  `cnfdcr_dt` varchar(100) DEFAULT NULL COMMENT '시행일자',
  `self_yn` varchar(100) DEFAULT NULL COMMENT '자법타법여부',
  `laword_lnk` varchar(100) DEFAULT NULL COMMENT '법령상세링크',
  PRIMARY KEY (`laword_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_목록';