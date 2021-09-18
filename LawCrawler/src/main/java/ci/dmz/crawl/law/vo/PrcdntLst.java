/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 판례목록
 */
public class PrcdntLst extends LawVO {

	/**
	 * 판례일련번호(prcdnt_sn)
	 */
	private String prcdntSn;

	/**
	 * 사건명(incdnt_nm)
	 */
	private String incdntNm;

	/**
	 * 사건번호(incdnt_no)
	 */
	private String incdntNo;

	/**
	 * 선고일자
	 */
	private String adjuDt;

	/**
	 * 법원명
	 */
	private String courtNm;

	/**
	 * 법원종류코드
	 */
	private String courtCndCd;

	/**
	 * 사건종류코드
	 */
	private String incdntCndCd;

	/**
	 * 사건종류명
	 */
	private String incdntCndNm;

	/**
	 * 판결유형
	 */
	private String judmnTyp;

	/**
	 * 선고
	 */
	private String adju;

	/**
	 * 판례상세링크
	 */
	private String prcdntLnk;

	/**
	 * @return 판례일련번호
	 */
	public String getPrcdntSn() {
		return prcdntSn;
	}

	/**
	 * @param prcdntSn 판례일련번호 to set
	 */
	public void setPrcdntSn(String prcdntSn) {
		this.prcdntSn = prcdntSn;
	}

	/**
	 * @return 사건명
	 */
	public String getIncdntNm() {
		return incdntNm;
	}

	/**
	 * @param incdntNm 사건명 to set
	 */
	public void setIncdntNm(String incdntNm) {
		this.incdntNm = incdntNm;
	}

	/**
	 * @return 사건번호
	 */
	public String getIncdntNo() {
		return incdntNo;
	}

	/**
	 * @param incdntNo 사건번호 to set
	 */
	public void setIncdntNo(String incdntNo) {
		this.incdntNo = incdntNo;
	}

	/**
	 * @return 선고일자
	 */
	public String getAdjuDt() {
		return adjuDt;
	}

	/**
	 * @param adjuDt 선고일자 to set
	 */
	public void setAdjuDt(String adjuDt) {
		this.adjuDt = adjuDt;
	}

	/**
	 * @return 법원명
	 */
	public String getCourtNm() {
		return courtNm;
	}

	/**
	 * @param courtNm 법원명 to set
	 */
	public void setCourtNm(String courtNm) {
		this.courtNm = courtNm;
	}

	/**
	 * @return 법원종류코드
	 */
	public String getCourtCndCd() {
		return courtCndCd;
	}

	/**
	 * @param courtCndCd 법원종류코드 to set
	 */
	public void setCourtCndCd(String courtCndCd) {
		this.courtCndCd = courtCndCd;
	}

	/**
	 * @return 사건종류코드
	 */
	public String getIncdntCndCd() {
		return incdntCndCd;
	}

	/**
	 * @param incdntCndCd 사건종류코드 to set
	 */
	public void setIncdntCndCd(String incdntCndCd) {
		this.incdntCndCd = incdntCndCd;
	}

	/**
	 * @return 사건종류명
	 */
	public String getIncdntCndNm() {
		return incdntCndNm;
	}

	/**
	 * @param incdntCndNm 사건종류명 to set
	 */
	public void setIncdntCndNm(String incdntCndNm) {
		this.incdntCndNm = incdntCndNm;
	}

	/**
	 * @return 판결유형
	 */
	public String getJudmnTyp() {
		return judmnTyp;
	}

	/**
	 * @param judmnTyp 판결유형 to set
	 */
	public void setJudmnTyp(String judmnTyp) {
		this.judmnTyp = judmnTyp;
	}

	/**
	 * @return 선고
	 */
	public String getAdju() {
		return adju;
	}

	/**
	 * @param adju 선고 to set
	 */
	public void setAdju(String adju) {
		this.adju = adju;
	}

	/**
	 * @return 판례상세링크
	 */
	public String getPrcdntLnk() {
		return prcdntLnk;
	}

	/**
	 * @param prcdntLnk 판례상세링크 to set
	 */
	public void setPrcdntLnk(String prcdntLnk) {
		this.prcdntLnk = prcdntLnk;
	}

}
