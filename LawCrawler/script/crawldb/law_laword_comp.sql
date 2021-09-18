-- crawldb.laword_comp definition

DROP TABLE `law_laword_comp`;
CREATE TABLE `law_laword_comp` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `comp_key` int(11) NOT NULL COMMENT '조문KEY',
  `comp_key2` varchar(100) DEFAULT NULL COMMENT '조문KEY2',
  `comp_no` varchar(100) DEFAULT NULL COMMENT '조문번호',
  `comp_yn` varchar(100) DEFAULT NULL COMMENT '조문여부',
  `comp_nm` text DEFAULT NULL COMMENT '조문제목',
  `comp_cnf_dt` varchar(100) DEFAULT NULL COMMENT '조문시행일자',
  `comp_rvs_typ` varchar(100) DEFAULT NULL COMMENT '조문제개정유형',
  `comp_mvm_bf` varchar(100) DEFAULT NULL COMMENT '조문이동이전',
  `comp_mvm_af` varchar(100) DEFAULT NULL COMMENT '조문이동이후',
  `comp_chn_yn` varchar(100) DEFAULT NULL COMMENT '조문변경여부',
  `comp_cnt` longtext DEFAULT NULL COMMENT '조문내용',
  PRIMARY KEY (`laword_key`,`comp_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_조문';