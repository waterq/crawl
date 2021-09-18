-- crawldb.admrul_lst definition

DROP TABLE `law_admrul_lst`;
CREATE TABLE `law_admrul_lst` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `admrul_nm` text DEFAULT NULL COMMENT '행정규칙명',
  `admrul_typ` varchar(100) DEFAULT NULL COMMENT '행정규칙종류',
  `gnfd_dt` varchar(100) DEFAULT NULL COMMENT '발령일자',
  `gnfd_no` varchar(100) DEFAULT NULL COMMENT '발령번호',
  `jrsd_mof_Nm` varchar(100) DEFAULT NULL COMMENT '소관부처명',
  `cur_hist_typ` varchar(100) DEFAULT NULL COMMENT '현행연혁구분',
  `revi_typ_cd` varchar(100) DEFAULT NULL COMMENT '제개정구분코드',
  `revi_typ_nm` varchar(100) DEFAULT NULL COMMENT '제개정구분명',
  `admrul_id` varchar(100) DEFAULT NULL COMMENT '행정규칙ID',
  `admrul_lnk` varchar(100) DEFAULT NULL COMMENT '행정규칙상세링크',
  `cnfdcr_dt` varchar(100) DEFAULT NULL COMMENT '시행일자',
  `creat_dt` varchar(100) DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`admrul_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙_목록';