/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 법령_개정문
 */
public class LawordReviCnt extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 개정문내용 revi_typ_cnt reviTypCnt
	 */
	private String reviTypCnt;

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
	 * @return the reviTypCnt
	 */
	public String getReviTypCnt() {
		return reviTypCnt;
	}

	/**
	 * @param reviTypCnt the reviTypCnt to set
	 */
	public void setReviTypCnt(String reviTypCnt) {
		this.reviTypCnt = reviTypCnt;
	}

}
