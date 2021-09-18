/**
 * 
 */
package ci.dmz.crawl.law.vo;

import java.util.ArrayList;

/**
 * @author 이동훈 행정규칙기본정보
 */
public class Admrul extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 행정규칙명 admrul_nm
	 */
	private String admrulNm;

	/**
	 * 행정규칙종류 admrul_typ
	 */
	private String admrulTyp;

	/**
	 * 행정규칙종류코드 admrul_typ_cd
	 */
	private String admrulTypCd;

	/**
	 * 발령일자 gnfd_dt
	 */
	private String gnfdDt;

	/**
	 * 발령번호 gnfd_no
	 */
	private String gnfdNo;

	/**
	 * 제개정구분명 revi_typ_nm
	 */
	private String reviTypNm;

	/**
	 * 제개정구분코드 revi_typ_cd
	 */
	private String reviTypCd;

	/**
	 * 조문형식여부 comp_typ_yn
	 */
	private String compTypYn;

	/**
	 * 행정규칙ID admrul_id
	 */
	private String admrulId;

	/**
	 * 소관부처명 jrsd_mof_Nm
	 */
	private String jrsdMofNm;

	/**
	 * 소관부처코드 jrsd_mof_Cd
	 */
	private String jrsdMofCd;

	/**
	 * 담당부서기관코드 chrg_mof_Cd
	 */
	private String chrgMofCd;

	/**
	 * 담당부서기관명 chrg_mof_Nm
	 */
	private String chrgMofNm;

	/**
	 * 담당자명 chrger
	 */
	private String chrger;

	/**
	 * 전화번호 telno
	 */
	private String telno;

	/**
	 * 현행여부 cur_yn
	 */
	private String curYn;

	/**
	 * 시행일자 cnfdcr_dt
	 */
	private String cnfdcrDt;

	/**
	 * 생성일자 creat_dt
	 */
	private String creatDt;

	/**
	 * 행정규칙_조문
	 */
	private ArrayList<AdmrulComp> admrulComps;

	/**
	 * 행정규칙_부칙
	 */
	private ArrayList<AdmrulAdrue> admrulAdrues;

	/**
	 * 행정규칙_별표
	 */
	private ArrayList<AdmrulAttc> admrulAttcs;

	/**
	 * 행정규칙_첨부파일
	 */
	private ArrayList<AdmrulFile> admrulFiles;

	/**
	 * 행정규칙_개정문
	 */
	private AdmrulReviCnt admrulReviCnt;

	/**
	 * 행정규칙_제개정이유
	 */
	private AdmrulReviRsn admrulReviRsn;

	public Admrul() {
		this.admrulComps = new ArrayList<AdmrulComp>();
		this.admrulAdrues = new ArrayList<AdmrulAdrue>();
		this.admrulAttcs = new ArrayList<AdmrulAttc>();
		this.admrulFiles = new ArrayList<AdmrulFile>();
//		this.admrulReviCnt = new AdmrulReviCnt();
//		this.admrulReviRsn = new AdmrulReviRsn();
	}

	/**
	 * @return the admrulSn
	 */
	public String getAdmrulSn() {
		return admrulSn;
	}

	/**
	 * @param admrulSn the admrulSn to set
	 */
	public void setAdmrulSn(String admrulSn) {
		this.admrulSn = admrulSn;
	}

	/**
	 * @return the admrulNm
	 */
	public String getAdmrulNm() {
		return admrulNm;
	}

	/**
	 * @param admrulNm the admrulNm to set
	 */
	public void setAdmrulNm(String admrulNm) {
		this.admrulNm = admrulNm;
	}

	/**
	 * @return the admrulTyp
	 */
	public String getAdmrulTyp() {
		return admrulTyp;
	}

	/**
	 * @param admrulTyp the admrulTyp to set
	 */
	public void setAdmrulTyp(String admrulTyp) {
		this.admrulTyp = admrulTyp;
	}

	/**
	 * @return the admrulTypCd
	 */
	public String getAdmrulTypCd() {
		return admrulTypCd;
	}

	/**
	 * @param admrulTypCd the admrulTypCd to set
	 */
	public void setAdmrulTypCd(String admrulTypCd) {
		this.admrulTypCd = admrulTypCd;
	}

	/**
	 * @return the gnfdDt
	 */
	public String getGnfdDt() {
		return gnfdDt;
	}

	/**
	 * @param gnfdDt the gnfdDt to set
	 */
	public void setGnfdDt(String gnfdDt) {
		this.gnfdDt = gnfdDt;
	}

	/**
	 * @return the gnfdNo
	 */
	public String getGnfdNo() {
		return gnfdNo;
	}

	/**
	 * @param gnfdNo the gnfdNo to set
	 */
	public void setGnfdNo(String gnfdNo) {
		this.gnfdNo = gnfdNo;
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
	 * @return the reviTypCd
	 */
	public String getReviTypCd() {
		return reviTypCd;
	}

	/**
	 * @param reviTypCd the reviTypCd to set
	 */
	public void setReviTypCd(String reviTypCd) {
		this.reviTypCd = reviTypCd;
	}

	/**
	 * @return the compTypYn
	 */
	public String getCompTypYn() {
		return compTypYn;
	}

	/**
	 * @param compTypYn the compTypYn to set
	 */
	public void setCompTypYn(String compTypYn) {
		this.compTypYn = compTypYn;
	}

	/**
	 * @return the admrulId
	 */
	public String getAdmrulId() {
		return admrulId;
	}

	/**
	 * @param admrulId the admrulId to set
	 */
	public void setAdmrulId(String admrulId) {
		this.admrulId = admrulId;
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
	 * @return the chrgMofCd
	 */
	public String getChrgMofCd() {
		return chrgMofCd;
	}

	/**
	 * @param chrgMofCd the chrgMofCd to set
	 */
	public void setChrgMofCd(String chrgMofCd) {
		this.chrgMofCd = chrgMofCd;
	}

	/**
	 * @return the chrgMofNm
	 */
	public String getChrgMofNm() {
		return chrgMofNm;
	}

	/**
	 * @param chrgMofNm the chrgMofNm to set
	 */
	public void setChrgMofNm(String chrgMofNm) {
		this.chrgMofNm = chrgMofNm;
	}

	/**
	 * @return the chrger
	 */
	public String getChrger() {
		return chrger;
	}

	/**
	 * @param chrger the chrger to set
	 */
	public void setChrger(String chrger) {
		this.chrger = chrger;
	}

	/**
	 * @return the telno
	 */
	public String getTelno() {
		return telno;
	}

	/**
	 * @param telno the telno to set
	 */
	public void setTelno(String telno) {
		this.telno = telno;
	}

	/**
	 * @return the curYn
	 */
	public String getCurYn() {
		return curYn;
	}

	/**
	 * @param curYn the curYn to set
	 */
	public void setCurYn(String curYn) {
		this.curYn = curYn;
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
	 * @return the creatDt
	 */
	public String getCreatDt() {
		return creatDt;
	}

	/**
	 * @param creatDt the creatDt to set
	 */
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}

	/**
	 * @return the admrulComps
	 */
	public ArrayList<AdmrulComp> getAdmrulComps() {
		return admrulComps;
	}

	/**
	 * @param admrulComps the admrulComps to set
	 */
	public void setAdmrulComps(ArrayList<AdmrulComp> admrulComps) {
		this.admrulComps = admrulComps;
	}

	/**
	 * @return the admrulAdrues
	 */
	public ArrayList<AdmrulAdrue> getAdmrulAdrues() {
		return admrulAdrues;
	}

	/**
	 * @param admrulAdrues the admrulAdrues to set
	 */
	public void setAdmrulAdrues(ArrayList<AdmrulAdrue> admrulAdrues) {
		this.admrulAdrues = admrulAdrues;
	}

	/**
	 * @return the admrulAttcs
	 */
	public ArrayList<AdmrulAttc> getAdmrulAttcs() {
		return admrulAttcs;
	}

	/**
	 * @param admrulAttcs the admrulAttcs to set
	 */
	public void setAdmrulAttcs(ArrayList<AdmrulAttc> admrulAttcs) {
		this.admrulAttcs = admrulAttcs;
	}

	/**
	 * @return the admrulFiles
	 */
	public ArrayList<AdmrulFile> getAdmrulFiles() {
		return admrulFiles;
	}

	/**
	 * @param admrulFiles the admrulFiles to set
	 */
	public void setAdmrulFiles(ArrayList<AdmrulFile> admrulFiles) {
		this.admrulFiles = admrulFiles;
	}

	/**
	 * @return the admrulReviCnt
	 */
	public AdmrulReviCnt getAdmrulReviCnt() {
		return admrulReviCnt;
	}

	/**
	 * @param admrulReviCnt the admrulReviCnt to set
	 */
	public void setAdmrulReviCnt(AdmrulReviCnt admrulReviCnt) {
		this.admrulReviCnt = admrulReviCnt;
	}

	/**
	 * @return the admrulReviRsn
	 */
	public AdmrulReviRsn getAdmrulReviRsn() {
		return admrulReviRsn;
	}

	/**
	 * @param admrulReviRsn the admrulReviRsn to set
	 */
	public void setAdmrulReviRsn(AdmrulReviRsn admrulReviRsn) {
		this.admrulReviRsn = admrulReviRsn;
	}

}
