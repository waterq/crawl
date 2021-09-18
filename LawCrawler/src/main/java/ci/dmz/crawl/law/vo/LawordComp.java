/**
 * 
 */
package ci.dmz.crawl.law.vo;

import java.util.ArrayList;

/**
 * @author 이동훈 법령_조문
 */
public class LawordComp extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 조문Key comp_key compKey
	 */
	private int compKey;

	/**
	 * 조문Key2 comp_key2 compKey2
	 */
	private String compKey2;

	/**
	 * 조문번호 comp_no compNo
	 */
	private String compNo;

	/**
	 * 조문여부 comp_yn compYn
	 */
	private String compYn;

	/**
	 * 조문제목 comp_nm compNm
	 */
	private String compNm;

	/**
	 * 조문시행일자 comp_cnf_dt compCnfDt
	 */
	private String compCnfDt;

	/**
	 * 조문제개정유형 comp_rvs_typ compRvsTyp
	 */
	private String compRvsTyp;

	/**
	 * 조문이동이전 comp_mvm_bf compMvmBf
	 */
	private String compMvmBf;

	/**
	 * 조문이동이후 comp_mvm_af compMvmAf
	 */
	private String compMvmAf;

	/**
	 * 조문변경여부 comp_chn_yn compChnYn
	 */
	private String compChnYn;

	/**
	 * 조문내용 comp_cnt compCnt
	 */
	private String compCnt;

	/**
	 * 법령_조문_항
	 */
	private ArrayList<LawordCompHang> lawordCompHangs;

	/**
	 * @param lawordId  법령
	 * @param nodeValue 조문키
	 */
	public LawordComp() {
		this.lawordCompHangs = new ArrayList<LawordCompHang>();
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
	 * @return the compKey
	 */
	public int getCompKey() {
		return compKey;
	}

	/**
	 * @param compKey the compKey to set
	 */
	public void setCompKey(int compKey) {
		this.compKey = compKey;
	}

	/**
	 * @return the compKey2
	 */
	public String getCompKey2() {
		return compKey2;
	}

	/**
	 * @param compKey2 the compKey2 to set
	 */
	public void setCompKey2(String compKey2) {
		this.compKey2 = compKey2;
	}

	/**
	 * @return the compNo
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * @param compNo the compNo to set
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}

	/**
	 * @return the compYn
	 */
	public String getCompYn() {
		return compYn;
	}

	/**
	 * @param compYn the compYn to set
	 */
	public void setCompYn(String compYn) {
		this.compYn = compYn;
	}

	/**
	 * @return the compNm
	 */
	public String getCompNm() {
		return compNm;
	}

	/**
	 * @param compNm the compNm to set
	 */
	public void setCompNm(String compNm) {
		this.compNm = compNm;
	}

	/**
	 * @return the compCnfDt
	 */
	public String getCompCnfDt() {
		return compCnfDt;
	}

	/**
	 * @param compCnfDt the compCnfDt to set
	 */
	public void setCompCnfDt(String compCnfDt) {
		this.compCnfDt = compCnfDt;
	}

	/**
	 * @return the compRvsTyp
	 */
	public String getCompRvsTyp() {
		return compRvsTyp;
	}

	/**
	 * @param compRvsTyp the compRvsTyp to set
	 */
	public void setCompRvsTyp(String compRvsTyp) {
		this.compRvsTyp = compRvsTyp;
	}

	/**
	 * @return the compMvmBf
	 */
	public String getCompMvmBf() {
		return compMvmBf;
	}

	/**
	 * @param compMvmBf the compMvmBf to set
	 */
	public void setCompMvmBf(String compMvmBf) {
		this.compMvmBf = compMvmBf;
	}

	/**
	 * @return the compMvmAf
	 */
	public String getCompMvmAf() {
		return compMvmAf;
	}

	/**
	 * @param compMvmAf the compMvmAf to set
	 */
	public void setCompMvmAf(String compMvmAf) {
		this.compMvmAf = compMvmAf;
	}

	/**
	 * @return the compChnYn
	 */
	public String getCompChnYn() {
		return compChnYn;
	}

	/**
	 * @param compChnYn the compChnYn to set
	 */
	public void setCompChnYn(String compChnYn) {
		this.compChnYn = compChnYn;
	}

	/**
	 * @return the compCnt
	 */
	public String getCompCnt() {
		return compCnt;
	}

	/**
	 * @param compCnt the compCnt to set
	 */
	public void setCompCnt(String compCnt) {
		this.compCnt = compCnt;
	}

	/**
	 * @return the lawordCompHangs
	 */
	public ArrayList<LawordCompHang> getLawordCompHangs() {
		return lawordCompHangs;
	}

	/**
	 * @param lawordCompHangs the lawordCompHangs to set
	 */
	public void setLawordCompHangs(ArrayList<LawordCompHang> lawordCompHangs) {
		this.lawordCompHangs = lawordCompHangs;
	}

}
