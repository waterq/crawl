/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 조약_첨부파일
 */
public class TrtyAttc extends LawVO {

	/**
	 * 조약일련번호 trty_sn
	 */
	private String trtySn;

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
	 * @return the trtySn
	 */
	public String getTrtySn() {
		return trtySn;
	}

	/**
	 * @param trtySn the trtySn to set
	 */
	public void setTrtySn(String trtySn) {
		this.trtySn = trtySn;
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
