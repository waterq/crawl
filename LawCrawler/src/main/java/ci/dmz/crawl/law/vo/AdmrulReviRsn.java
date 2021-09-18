/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_제개정이유
 */
public class AdmrulReviRsn extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 제개정이유내용 revi_rsn_cnt reviRsnCnt
	 */
	private String reviRsnCnt;

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
	 * @return the reviRsnCnt
	 */
	public String getReviRsnCnt() {
		return reviRsnCnt;
	}

	/**
	 * @param reviRsnCnt the reviRsnCnt to set
	 */
	public void setReviRsnCnt(String reviRsnCnt) {
		this.reviRsnCnt = reviRsnCnt;
	}

}
