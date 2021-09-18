package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 조약추가정보
 */
public class TrtyAppnd extends LawVO {

	/**
	 * 조약일련번호 trty_sn
	 */
	private String trtySn;

	/**
	 * 조약_Key appnd_key
	 */
	private int appndKey;

	/**
	 * 체결대상국가 cncls_natn
	 */
	private String cnclsNatn;

	/**
	 * 체결대상국가한글 cncls_natn_kr
	 */
	private String cnclsNatnKr;

	/**
	 * 우리측국내절차완료통보 compt_dspth_in_dt
	 */
	private String comptDspthInDt;

	/**
	 * 상대국측국내절차완료통보 compt_dspth_out_dt
	 */
	private String comptDspthOutDt;

	/**
	 * 양자조약분야코드 trty_cd
	 */
	private String trtyCd;

	/**
	 * 양자조약분야명 trty_nm
	 */
	private String trtyNm;

	/**
	 * 제2외국어종류 lang_typ
	 */
	private String langTyp;

	/**
	 * 국가코드 natn_cd
	 */
	private String natnCd;

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
	 * @return the appndKey
	 */
	public int getAppndKey() {
		return appndKey;
	}

	/**
	 * @param appndKey the appndKey to set
	 */
	public void setAppndKey(int appndKey) {
		this.appndKey = appndKey;
	}

	/**
	 * @return the cnclsNatn
	 */
	public String getCnclsNatn() {
		return cnclsNatn;
	}

	/**
	 * @param cnclsNatn the cnclsNatn to set
	 */
	public void setCnclsNatn(String cnclsNatn) {
		this.cnclsNatn = cnclsNatn;
	}

	/**
	 * @return the cnclsNatnKr
	 */
	public String getCnclsNatnKr() {
		return cnclsNatnKr;
	}

	/**
	 * @param cnclsNatnKr the cnclsNatnKr to set
	 */
	public void setCnclsNatnKr(String cnclsNatnKr) {
		this.cnclsNatnKr = cnclsNatnKr;
	}

	/**
	 * @return the comptDspthInDt
	 */
	public String getComptDspthInDt() {
		return comptDspthInDt;
	}

	/**
	 * @param comptDspthInDt the comptDspthInDt to set
	 */
	public void setComptDspthInDt(String comptDspthInDt) {
		this.comptDspthInDt = comptDspthInDt;
	}

	/**
	 * @return the comptDspthOutDt
	 */
	public String getComptDspthOutDt() {
		return comptDspthOutDt;
	}

	/**
	 * @param comptDspthOutDt the comptDspthOutDt to set
	 */
	public void setComptDspthOutDt(String comptDspthOutDt) {
		this.comptDspthOutDt = comptDspthOutDt;
	}

	/**
	 * @return the trtyCd
	 */
	public String getTrtyCd() {
		return trtyCd;
	}

	/**
	 * @param trtyCd the trtyCd to set
	 */
	public void setTrtyCd(String trtyCd) {
		this.trtyCd = trtyCd;
	}

	/**
	 * @return the trtyNm
	 */
	public String getTrtyNm() {
		return trtyNm;
	}

	/**
	 * @param trtyNm the trtyNm to set
	 */
	public void setTrtyNm(String trtyNm) {
		this.trtyNm = trtyNm;
	}

	/**
	 * @return the langTyp
	 */
	public String getLangTyp() {
		return langTyp;
	}

	/**
	 * @param langTyp the langTyp to set
	 */
	public void setLangTyp(String langTyp) {
		this.langTyp = langTyp;
	}

	/**
	 * @return the natnCd
	 */
	public String getNatnCd() {
		return natnCd;
	}

	/**
	 * @param natnCd the natnCd to set
	 */
	public void setNatnCd(String natnCd) {
		this.natnCd = natnCd;
	}

}
