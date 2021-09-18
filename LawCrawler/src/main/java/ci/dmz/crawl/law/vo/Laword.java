/**
 * 
 */
package ci.dmz.crawl.law.vo;

import java.util.ArrayList;

/**
 * @author 이동훈 법령_본문
 */
public class Laword extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 법령ID laword_id lawordId
	 */
	private String lawordId;

	/**
	 * 공포일자 prmg_dt prmgDt
	 */
	private String prmgDt;

	/**
	 * 공포번호 prmg_no prmgNo
	 */
	private String prmgNo;

	/**
	 * 언어종류 lang_typ langTyp
	 */
	private String langTyp;

	/**
	 * 법종류의구분 lawknd_typ lawkndTyp
	 */
	private String lawkndTyp;

	/**
	 * 법종구분코드 lawknd_cd lawkndCd
	 */
	private String lawkndCd;

	/**
	 * 한글법령명 laword_nm lawordNm
	 */
	private String lawordNm;

	/**
	 * 법령명_한자 laword_nm_ch lawordNmCh
	 */
	private String lawordNmCh;

	/**
	 * 법령명약칭 laword_abrv lawordAbrv
	 */
	private String lawordAbrv;

	/**
	 * 제명변경여부 ttl_chg_yn ttlChgYn
	 */
	private String ttlChgYn;

	/**
	 * 한글법령여부 kor_laword_yn korLawordYn
	 */
	private String korLawordYn;

	/**
	 * 편장절관일련번호 comp_sn compSn
	 */
	private String compSn;

	/**
	 * 소관부처코드 jrsd_mof_cd jrsdMofCd
	 */
	private String jrsdMofCd;

	/**
	 * 소관부처명 jrsd_mof_nm jrsdMofNm
	 */
	private String jrsdMofNm;

	/**
	 * 전화번호 tel_no telNo
	 */
	private String telNo;

	/**
	 * 시행일자 cnfdcr_dt cnfdcrDt
	 */
	private String cnfdcrDt;

	/**
	 * 제개정구분 revi_typ_nm reviTypNm
	 */
	private String reviTypNm;

	/**
	 * 별표시행일자문자열 attc_cnfdcr_dt_str
	 */
	private String attcCnfdcrDtStr;

	/**
	 * 별표편집여부 attc_edt_yn attcEdtYn
	 */
	private String attcEdtYn;

	/**
	 * 공포법령여부 prmg_edt_yn prmgEdtYn
	 */
	private String prmgEdtYn;

	/**
	 * 법령_본문_개정문
	 */
	private LawordReviCnt lawordReviCnt;

	/**
	 * 법령_본문_제개정이유
	 */
	private LawordReviRsn lawordReviRsn;

	/**
	 * 법령_본문_조문
	 */
	private ArrayList<LawordComp> lawordComps;

	/**
	 * 법령_본문_부칙
	 */
	private ArrayList<LawordAdrue> lawordAdrues;

	/**
	 * 법령_본문_별표
	 */
	private ArrayList<LawordAttc> lawordAttcs;

	public Laword() {
		this.lawordComps = new ArrayList<LawordComp>();
		this.lawordAdrues = new ArrayList<LawordAdrue>();
		this.lawordAttcs = new ArrayList<LawordAttc>();
	}

	/**
	 * @return the lawordKey
	 */
	public String getLawordKey() {
		return lawordKey;
	}

	/**
	 * @param lawordKey the lawordKey to set
	 */
	public void setLawordKey(String lawordKey) {
		this.lawordKey = lawordKey;
	}

	/**
	 * @return the lawordId
	 */
	public String getLawordId() {
		return lawordId;
	}

	/**
	 * @param lawordId the lawordId to set
	 */
	public void setLawordId(String lawordId) {
		this.lawordId = lawordId;
	}

	/**
	 * @return the prmgDt
	 */
	public String getPrmgDt() {
		return prmgDt;
	}

	/**
	 * @param prmgDt the prmgDt to set
	 */
	public void setPrmgDt(String prmgDt) {
		this.prmgDt = prmgDt;
	}

	/**
	 * @return the prmgNo
	 */
	public String getPrmgNo() {
		return prmgNo;
	}

	/**
	 * @param prmgNo the prmgNo to set
	 */
	public void setPrmgNo(String prmgNo) {
		this.prmgNo = prmgNo;
	}

	/**
	 * @return the langTyp
	 */
	public String getLangTyp() {
		return langTyp;
	}

	/**
	 * @param langTyp the langTyp to set
	 */
	public void setLangTyp(String langTyp) {
		this.langTyp = langTyp;
	}

	/**
	 * @return the lawkndTyp
	 */
	public String getLawkndTyp() {
		return lawkndTyp;
	}

	/**
	 * @param lawkndTyp the lawkndTyp to set
	 */
	public void setLawkndTyp(String lawkndTyp) {
		this.lawkndTyp = lawkndTyp;
	}

	/**
	 * @return the lawkndCd
	 */
	public String getLawkndCd() {
		return lawkndCd;
	}

	/**
	 * @param lawkndCd the lawkndCd to set
	 */
	public void setLawkndCd(String lawkndCd) {
		this.lawkndCd = lawkndCd;
	}

	/**
	 * @return the lawordNm
	 */
	public String getLawordNm() {
		return lawordNm;
	}

	/**
	 * @param lawordNm the lawordNm to set
	 */
	public void setLawordNm(String lawordNm) {
		this.lawordNm = lawordNm;
	}

	/**
	 * @return the lawordNmCh
	 */
	public String getLawordNmCh() {
		return lawordNmCh;
	}

	/**
	 * @param lawordNmCh the lawordNmCh to set
	 */
	public void setLawordNmCh(String lawordNmCh) {
		this.lawordNmCh = lawordNmCh;
	}

	/**
	 * @return the lawordAbrv
	 */
	public String getLawordAbrv() {
		return lawordAbrv;
	}

	/**
	 * @param lawordAbrv the lawordAbrv to set
	 */
	public void setLawordAbrv(String lawordAbrv) {
		this.lawordAbrv = lawordAbrv;
	}

	/**
	 * @return the ttlChgYn
	 */
	public String getTtlChgYn() {
		return ttlChgYn;
	}

	/**
	 * @param ttlChgYn the ttlChgYn to set
	 */
	public void setTtlChgYn(String ttlChgYn) {
		this.ttlChgYn = ttlChgYn;
	}

	/**
	 * @return the korLawordYn
	 */
	public String getKorLawordYn() {
		return korLawordYn;
	}

	/**
	 * @param korLawordYn the korLawordYn to set
	 */
	public void setKorLawordYn(String korLawordYn) {
		this.korLawordYn = korLawordYn;
	}

	/**
	 * @return the compSn
	 */
	public String getCompSn() {
		return compSn;
	}

	/**
	 * @param compSn the compSn to set
	 */
	public void setCompSn(String compSn) {
		this.compSn = compSn;
	}

	/**
	 * @return the jrsdMofCd
	 */
	public String getJrsdMofCd() {
		return jrsdMofCd;
	}

	/**
	 * @param jrsdMofCd the jrsdMofCd to set
	 */
	public void setJrsdMofCd(String jrsdMofCd) {
		this.jrsdMofCd = jrsdMofCd;
	}

	/**
	 * @return the jrsdMofNm
	 */
	public String getJrsdMofNm() {
		return jrsdMofNm;
	}

	/**
	 * @param jrsdMofNm the jrsdMofNm to set
	 */
	public void setJrsdMofNm(String jrsdMofNm) {
		this.jrsdMofNm = jrsdMofNm;
	}

	/**
	 * @return the telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * @param telNo the telNo to set
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * @return the cnfdcrDt
	 */
	public String getCnfdcrDt() {
		return cnfdcrDt;
	}

	/**
	 * @param cnfdcrDt the cnfdcrDt to set
	 */
	public void setCnfdcrDt(String cnfdcrDt) {
		this.cnfdcrDt = cnfdcrDt;
	}

	/**
	 * @return the reviTypNm
	 */
	public String getReviTypNm() {
		return reviTypNm;
	}

	/**
	 * @param reviTypNm the reviTypNm to set
	 */
	public void setReviTypNm(String reviTypNm) {
		this.reviTypNm = reviTypNm;
	}

	/**
	 * @return the attcCnfdcrDtStr
	 */
	public String getAttcCnfdcrDtStr() {
		return attcCnfdcrDtStr;
	}

	/**
	 * @param attcCnfdcrDtStr the attcCnfdcrDtStr to set
	 */
	public void setAttcCnfdcrDtStr(String attcCnfdcrDtStr) {
		this.attcCnfdcrDtStr = attcCnfdcrDtStr;
	}

	/**
	 * @return the attcEdtYn
	 */
	public String getAttcEdtYn() {
		return attcEdtYn;
	}

	/**
	 * @param attcEdtYn the attcEdtYn to set
	 */
	public void setAttcEdtYn(String attcEdtYn) {
		this.attcEdtYn = attcEdtYn;
	}

	/**
	 * @return the prmgEdtYn
	 */
	public String getPrmgEdtYn() {
		return prmgEdtYn;
	}

	/**
	 * @param prmgEdtYn the prmgEdtYn to set
	 */
	public void setPrmgEdtYn(String prmgEdtYn) {
		this.prmgEdtYn = prmgEdtYn;
	}

	/**
	 * @return the lawordReviCnt
	 */
	public LawordReviCnt getLawordReviCnt() {
		return lawordReviCnt;
	}

	/**
	 * @param lawordReviCnt the lawordReviCnt to set
	 */
	public void setLawordReviCnt(LawordReviCnt lawordReviCnt) {
		this.lawordReviCnt = lawordReviCnt;
	}

	/**
	 * @return the lawordReviRsn
	 */
	public LawordReviRsn getLawordReviRsn() {
		return lawordReviRsn;
	}

	/**
	 * @param lawordReviRsn the lawordReviRsn to set
	 */
	public void setLawordReviRsn(LawordReviRsn lawordReviRsn) {
		this.lawordReviRsn = lawordReviRsn;
	}

	/**
	 * @return the lawordComps
	 */
	public ArrayList<LawordComp> getLawordComps() {
		return lawordComps;
	}

	/**
	 * @param lawordComps the lawordComps to set
	 */
	public void setLawordComps(ArrayList<LawordComp> lawordComps) {
		this.lawordComps = lawordComps;
	}

	/**
	 * @return the lawordAdrues
	 */
	public ArrayList<LawordAdrue> getLawordAdrues() {
		return lawordAdrues;
	}

	/**
	 * @param lawordAdrues the lawordAdrues to set
	 */
	public void setLawordAdrues(ArrayList<LawordAdrue> lawordAdrues) {
		this.lawordAdrues = lawordAdrues;
	}

	/**
	 * @return the lawordAttcs
	 */
	public ArrayList<LawordAttc> getLawordAttcs() {
		return lawordAttcs;
	}

	/**
	 * @param lawordAttcs the lawordAttcs to set
	 */
	public void setLawordAttcs(ArrayList<LawordAttc> lawordAttcs) {
		this.lawordAttcs = lawordAttcs;
	}

}
