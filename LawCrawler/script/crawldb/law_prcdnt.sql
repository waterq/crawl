-- crawldb.prcdnt definition

DROP TABLE `law_prcdnt`;
CREATE TABLE `law_prcdnt` (
  `prcdnt_sn` varchar(100) NOT NULL COMMENT '판례일련번호',
  `incdnt_no` text DEFAULT NULL COMMENT '사건번호',
  `incdnt_nm` text DEFAULT NULL COMMENT '사건명',
  `adju_dt` varchar(100) DEFAULT NULL COMMENT '선고일자',
  `adju` varchar(100) DEFAULT NULL COMMENT '선고',
  `court_nm` varchar(100) DEFAULT NULL COMMENT '법원명',
  `court_cnd_cd` varchar(100) DEFAULT NULL COMMENT '법원종류코드',
  `incdnt_cnd_nm` varchar(100) DEFAULT NULL COMMENT '사건종류명',
  `incdnt_cnd_cd` varchar(100) DEFAULT NULL COMMENT '사건종류코드',
  `judmn_typ` varchar(100) DEFAULT NULL COMMENT '판시유형',
  `judmn_pn` text DEFAULT NULL COMMENT '판시사항',
  `judmn_ol` text DEFAULT NULL COMMENT '판결요지',
  `ref_doc` text DEFAULT NULL COMMENT '참조조문',
  `ref_prcdnt` text DEFAULT NULL COMMENT '참조판례',
  `prcdnt_cn` longtext DEFAULT NULL COMMENT '판례내용',
  PRIMARY KEY (`prcdnt_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='판례';