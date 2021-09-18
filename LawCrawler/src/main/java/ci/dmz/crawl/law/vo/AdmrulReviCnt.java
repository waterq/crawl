/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_개정문
 */
public class AdmrulReviCnt extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 개정문내용 revi_typ_cnt reviTypCnt
	 */
	private String reviTypCnt;

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
