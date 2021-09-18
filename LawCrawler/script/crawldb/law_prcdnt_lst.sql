-- crawldb.prcdnt_lst definition

DROP TABLE `law_prcdnt_lst`;
CREATE TABLE `law_prcdnt_lst` (
  `prcdnt_sn` varchar(100) NOT NULL COMMENT '판례일련번호',
  `incdnt_nm` text NOT NULL COMMENT '사건명',
  `incdnt_no` text NOT NULL COMMENT '사건번호',
  `adju_dt` varchar(100) DEFAULT NULL COMMENT '선고일자',
  `court_nm` varchar(100) DEFAULT NULL COMMENT '법원명',
  `court_cnd_cd` varchar(100) DEFAULT NULL COMMENT '법원종류코드',
  `incdnt_cnd_cd` varchar(100) DEFAULT NULL COMMENT '사건종류코드',
  `incdnt_cnd_nm` varchar(100) DEFAULT NULL COMMENT '사건종류명',
  `judmn_typ` varchar(100) DEFAULT NULL COMMENT '판결유형',
  `adju` varchar(100) DEFAULT NULL COMMENT '선고',
  `prcdnt_lnk` varchar(100) DEFAULT NULL COMMENT '판례상세링크',
  PRIMARY KEY (`prcdnt_sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='판례_목록';
