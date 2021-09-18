/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_조문
 */
public class AdmrulComp extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 조문번호 comp_key
	 */
	private int compKey;

	/**
	 * 조문내용 comp_cnt
	 */
	private String compCnt;

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

}
