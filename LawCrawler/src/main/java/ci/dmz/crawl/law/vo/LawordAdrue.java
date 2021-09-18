/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 법령_본문_부칙
 */
public class LawordAdrue extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 부칙Key adrue_key adrueKey
	 */
	private String adrueKey;

	/**
	 * 부칙공포번호 adrue_prmg_no adruePrmgno
	 */
	private String adruePrmgno;

	/**
	 * 부칙공포일자 adrue_prmg_dt adruePrmgDt
	 */
	private String adruePrmgDt;

	/**
	 * 부칙내용 adrue_cnt adrueCnt
	 */
	private String adrueCnt;

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
	 * @return the adrueKey
	 */
	public String getAdrueKey() {
		return adrueKey;
	}

	/**
	 * @param adrueKey the adrueKey to set
	 */
	public void setAdrueKey(String adrueKey) {
		this.adrueKey = adrueKey;
	}

	/**
	 * @return the adruePrmgno
	 */
	public String getAdruePrmgno() {
		return adruePrmgno;
	}

	/**
	 * @param adruePrmgno the adruePrmgno to set
	 */
	public void setAdruePrmgno(String adruePrmgno) {
		this.adruePrmgno = adruePrmgno;
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
