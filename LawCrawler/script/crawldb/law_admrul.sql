-- crawldb.admrul definition

DROP TABLE `law_admrul`;
CREATE TABLE `law_admrul` (
  `admrul_sn` varchar(100) NOT NULL COMMENT '행정규칙일련번호',
  `admrul_nm` text DEFAULT NULL COMMENT '행정규칙명',
  `admrul_typ` varchar(100) DEFAULT NULL COMMENT '행정규칙종류',
  `admrul_typ_cd` varchar(100) DEFAULT NULL COMMENT '행정규칙종류코드',
  `gnfd_dt` varchar(100) DEFAULT NULL COMMENT '발령일자',
  `gnfd_no` varchar(100) DEFAULT NULL COMMENT '발령번호',
  `revi_typ_nm` varchar(100) DEFAULT NULL COMMENT '제개정구분명',
  `revi_typ_cd` varchar(100) DEFAULT NULL COMMENT '제개정구분코드',
  `comp_typ_yn` varchar(100) DEFAULT NULL COMMENT '조문형식여부',
  `admrul_id` varchar(100) DEFAULT NULL COMMENT '행정규칙ID',
  `jrsd_mof_Nm` varchar(100) DEFAULT NULL COMMENT '소관부처명',
  `jrsd_mof_Cd` varchar(100) DEFAULT NULL COMMENT '소관부처코드',
  `chrg_mof_Cd` varchar(100) DEFAULT NULL COMMENT '담당부서기관코드',
  `chrg_mof_Nm` varchar(100) DEFAULT NULL COMMENT '담당부서기관명',
  `chrger` varchar(100) DEFAULT NULL COMMENT '담당자명',
  `telno` varchar(100) DEFAULT NULL COMMENT '전화번호',
  `cur_yn` varchar(100) DEFAULT NULL COMMENT '현행여부',
  `cnfdcr_dt` varchar(100) DEFAULT NULL COMMENT '시행일자',
  `creat_dt` varchar(100) DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`admrul_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='행정규칙기본정보';