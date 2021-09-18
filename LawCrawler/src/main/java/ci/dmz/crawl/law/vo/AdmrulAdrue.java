/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_부칙
 */
public class AdmrulAdrue extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 부칙키 adrue_key
	 */
	private int adrueKey;

	/**
	 * 부칙공포번호 adrue_prmg_no
	 */
	private String adruePrmgNo;

	/**
	 * 부칙공포일자 adrue_prmg_dt
	 */
	private String adruePrmgDt;

	/**
	 * 부칙내용 adrue_cnt
	 */
	private String adrueCnt;

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
	 * @return the adrueKey
	 */
	public int getAdrueKey() {
		return adrueKey;
	}

	/**
	 * @param adrueKey the adrueKey to set
	 */
	public void setAdrueKey(int adrueKey) {
		this.adrueKey = adrueKey;
	}

	/**
	 * @return the adruePrmgNo
	 */
	public String getAdruePrmgNo() {
		return adruePrmgNo;
	}

	/**
	 * @param adruePrmgNo the adruePrmgNo to set
	 */
	public void setAdruePrmgNo(String adruePrmgNo) {
		this.adruePrmgNo = adruePrmgNo;
	}

	/**
	 * @return the adruePrmgDt
	 */
	public String getAdruePrmgDt() {
		return adruePrmgDt;
	}

	/**
	 * @param adruePrmgDt the adruePrmgDt to set
	 */
	public void setAdruePrmgDt(String adruePrmgDt) {
		this.adruePrmgDt = adruePrmgDt;
	}

	/**
	 * @return the adrueCnt
	 */
	public String getAdrueCnt() {
		return adrueCnt;
	}

	/**
	 * @param adrueCnt the adrueCnt to set
	 */
	public void setAdrueCnt(String adrueCnt) {
		this.adrueCnt = adrueCnt;
	}

}
