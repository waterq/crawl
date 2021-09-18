/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 법령_제개정이유
 */
public class LawordReviRsn extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 제개정이유내용 revi_rsn_cnt reviRsnCnt
	 */
	private String reviRsnCnt;

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
