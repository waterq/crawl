/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_첨부파일
 */
public class AdmrulFile extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 첨부파일번호 attc_key
	 */
	private int attcKey;

	/**
	 * 첨부파일명 attc_nm
	 */
	private String attcNm;

	/**
	 * 첨부파일링크 attc_lnk
	 */
	private String attcLnk;

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
	 * @return the attcKey
	 */
	public int getAttcKey() {
		return attcKey;
	}

	/**
	 * @param attcKey the attcKey to set
	 */
	public void setAttcKey(int attcKey) {
		this.attcKey = attcKey;
	}

	/**
	 * @return the attcNm
	 */
	public String getAttcNm() {
		return attcNm;
	}

	/**
	 * @param attcNm the attcNm to set
	 */
	public void setAttcNm(String attcNm) {
		this.attcNm = attcNm;
	}

	/**
	 * @return the attcLnk
	 */
	public String getAttcLnk() {
		return attcLnk;
	}

	/**
	 * @param attcLnk the attcLnk to set
	 */
	public void setAttcLnk(String attcLnk) {
		this.attcLnk = attcLnk;
	}

}
