-- crawldb.laword_attc definition

DROP TABLE `law_laword_attc`;
CREATE TABLE `law_laword_attc` (
  `laword_key` varchar(100) NOT NULL COMMENT '법령KEY',
  `attc_key` varchar(100) NOT NULL COMMENT '별표KEY',
  `attc_no` varchar(100) NOT NULL COMMENT '별표번호',
  `attc_brnc_no` varchar(100) DEFAULT NULL COMMENT '별표가지번호',
  `attc_typ` varchar(100) DEFAULT NULL COMMENT '별표구분',
  `attc_nm` text DEFAULT NULL COMMENT '별표제목',
  `attc_cnfdcr_Dt` varchar(100) DEFAULT NULL COMMENT '별표시행일자',
  `attc_file_lnk` varchar(100) DEFAULT NULL COMMENT '별표서식파일링크',
  `attc_hwp_nm` varchar(100) DEFAULT NULL COMMENT '별표HWP파일명',
  `attc_pdf_lnk` varchar(100) DEFAULT NULL COMMENT '별표서식PDF파일링크',
  `attc_pdf_nm` varchar(100) DEFAULT NULL COMMENT '별표PDF파일명',
  `attc_img_nm` varchar(100) DEFAULT NULL COMMENT '별표이미지파일명',
  `attc_cnt` longtext DEFAULT NULL COMMENT '별표내용',
  PRIMARY KEY (`laword_key`,`attc_key`,`attc_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='법령_별표';