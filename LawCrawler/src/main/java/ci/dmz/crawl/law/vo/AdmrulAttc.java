/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 행정규칙_별표
 */
public class AdmrulAttc extends LawVO {

	/**
	 * 행정규칙일련번호 admrul_sn
	 */
	private String admrulSn;

	/**
	 * 별표Key attc_key attcKey
	 */
	private int attcKey;

	/**
	 * 별표Key attc_key2 attcKey2
	 */
	private String attcKey2;

	/**
	 * 별표번호 attc_no attcNo
	 */
	private String attcNo;

	/**
	 * 별표가지번호 attc_brnc_no attcBrncNo
	 */
	private String attcBrncNo;

	/**
	 * 별표구분 attc_typ attcTyp
	 */
	private String attcTyp;

	/**
	 * 별표제목 attc_nm attcNm
	 */
	private String attcNm;

	/**
	 * 별표서식파일링크 attc_file_lnk attcFileLnk
	 */
	private String attcFileLnk;

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
	 * @return the attcKey2
	 */
	public String getAttcKey2() {
		return attcKey2;
	}

	/**
	 * @param attcKey2 the attcKey2 to set
	 */
	public void setAttcKey2(String attcKey2) {
		this.attcKey2 = attcKey2;
	}

	/**
	 * @return the attcNo
	 */
	public String getAttcNo() {
		return attcNo;
	}

	/**
	 * @param attcNo the attcNo to set
	 */
	public void setAttcNo(String attcNo) {
		this.attcNo = attcNo;
	}

	/**
	 * @return the attcBrncNo
	 */
	public String getAttcBrncNo() {
		return attcBrncNo;
	}

	/**
	 * @param attcBrncNo the attcBrncNo to set
	 */
	public void setAttcBrncNo(String attcBrncNo) {
		this.attcBrncNo = attcBrncNo;
	}

	/**
	 * @return the attcTyp
	 */
	public String getAttcTyp() {
		return attcTyp;
	}

	/**
	 * @param attcTyp the attcTyp to set
	 */
	public void setAttcTyp(String attcTyp) {
		this.attcTyp = attcTyp;
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
	 * @return the attcFileLnk
	 */
	public String getAttcFileLnk() {
		return attcFileLnk;
	}

	/**
	 * @param attcFileLnk the attcFileLnk to set
	 */
	public void setAttcFileLnk(String attcFileLnk) {
		this.attcFileLnk = attcFileLnk;
	}

}
