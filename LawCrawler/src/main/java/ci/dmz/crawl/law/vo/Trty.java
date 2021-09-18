package ci.dmz.crawl.law.vo;

import java.util.ArrayList;

/**
 * @author 이동훈 조약기본정보
 */
public class Trty extends LawVO {

	/**
	 * 조약일련번호 trty_sn
	 */
	private String trtySn;

	/**
	 * 조약명_한글 trty_nm
	 */
	private String trtyNm;

	/**
	 * 조약명_영문 trty_nm_en
	 */
	private String trtyNmEn;

	/**
	 * 조약구분코드 trty_typ_cd
	 */
	private String trtyTypCd;

	/**
	 * 대통령재가일자 prsdt_appr_dt
	 */
	private String prsdtApprDt;

	/**
	 * 발효일자 efft_dt
	 */
	private String efftDt;

	/**
	 * 조약번호 trty_no
	 */
	private String trtyNo;

	/**
	 * 관보게재일자 ofctt_opn_dt
	 */
	private String ofcttOpnDt;

	/**
	 * 국무회의심의일자 natn_dlbrt_dt
	 */
	private String natnDlbrtDt;

	/**
	 * 국무회의심의회차 natn_dlbrt_no
	 */
	private String natnDlbrtNo;

	/**
	 * 국회비준동의여부 asmb_agr_yn
	 */
	private String asmbAgrYn;

	/**
	 * 국회비준동의일자 asmb_agr_dt
	 */
	private String asmbAgrDt;

	/**
	 * 서명일자 sign_dt
	 */
	private String signDt;

	/**
	 * 서명장소 sign_plc
	 */
	private String signPlc;

	/**
	 * 비고 rmk
	 */
	private String rmk;

	private ArrayList<TrtyAppnd> trtyAppnds;

	private ArrayList<TrtyCnt> trtyCnts;

	private ArrayList<TrtyAttc> trtyAttcs;

	public Trty() {
		this.trtyAppnds = new ArrayList<TrtyAppnd>();
		this.trtyCnts = new ArrayList<TrtyCnt>();
		this.trtyAttcs = new ArrayList<TrtyAttc>();
	}

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
	 * @return the trtyNmEn
	 */
	public String getTrtyNmEn() {
		return trtyNmEn;
	}

	/**
	 * @param trtyNmEn the trtyNmEn to set
	 */
	public void setTrtyNmEn(String trtyNmEn) {
		this.trtyNmEn = trtyNmEn;
	}

	/**
	 * @return the trtyTypCd
	 */
	public String getTrtyTypCd() {
		return trtyTypCd;
	}

	/**
	 * @param trtyTypCd the trtyTypCd to set
	 */
	public void setTrtyTypCd(String trtyTypCd) {
		this.trtyTypCd = trtyTypCd;
	}

	/**
	 * @return the prsdtApprDt
	 */
	public String getPrsdtApprDt() {
		return prsdtApprDt;
	}

	/**
	 * @param prsdtApprDt the prsdtApprDt to set
	 */
	public void setPrsdtApprDt(String prsdtApprDt) {
		this.prsdtApprDt = prsdtApprDt;
	}

	/**
	 * @return the efftDt
	 */
	public String getEfftDt() {
		return efftDt;
	}

	/**
	 * @param efftDt the efftDt to set
	 */
	public void setEfftDt(String efftDt) {
		this.efftDt = efftDt;
	}

	/**
	 * @return the trtyNo
	 */
	public String getTrtyNo() {
		return trtyNo;
	}

	/**
	 * @param trtyNo the trtyNo to set
	 */
	public void setTrtyNo(String trtyNo) {
		this.trtyNo = trtyNo;
	}

	/**
	 * @return the ofcttOpnDt
	 */
	public String getOfcttOpnDt() {
		return ofcttOpnDt;
	}

	/**
	 * @param ofcttOpnDt the ofcttOpnDt to set
	 */
	public void setOfcttOpnDt(String ofcttOpnDt) {
		this.ofcttOpnDt = ofcttOpnDt;
	}

	/**
	 * @return the natnDlbrtDt
	 */
	public String getNatnDlbrtDt() {
		return natnDlbrtDt;
	}

	/**
	 * @param natnDlbrtDt the natnDlbrtDt to set
	 */
	public void setNatnDlbrtDt(String natnDlbrtDt) {
		this.natnDlbrtDt = natnDlbrtDt;
	}

	/**
	 * @return the natnDlbrtNo
	 */
	public String getNatnDlbrtNo() {
		return natnDlbrtNo;
	}

	/**
	 * @param natnDlbrtNo the natnDlbrtNo to set
	 */
	public void setNatnDlbrtNo(String natnDlbrtNo) {
		this.natnDlbrtNo = natnDlbrtNo;
	}

	/**
	 * @return the asmbAgrYn
	 */
	public String getAsmbAgrYn() {
		return asmbAgrYn;
	}

	/**
	 * @param asmbAgrYn the asmbAgrYn to set
	 */
	public void setAsmbAgrYn(String asmbAgrYn) {
		this.asmbAgrYn = asmbAgrYn;
	}

	/**
	 * @return the asmbAgrDt
	 */
	public String getAsmbAgrDt() {
		return asmbAgrDt;
	}

	/**
	 * @param asmbAgrDt the asmbAgrDt to set
	 */
	public void setAsmbAgrDt(String asmbAgrDt) {
		this.asmbAgrDt = asmbAgrDt;
	}

	/**
	 * @return the signDt
	 */
	public String getSignDt() {
		return signDt;
	}

	/**
	 * @param signDt the signDt to set
	 */
	public void setSignDt(String signDt) {
		this.signDt = signDt;
	}

	/**
	 * @return the signPlc
	 */
	public String getSignPlc() {
		return signPlc;
	}

	/**
	 * @param signPlc the signPlc to set
	 */
	public void setSignPlc(String signPlc) {
		this.signPlc = signPlc;
	}

	/**
	 * @return the rmk
	 */
	public String getRmk() {
		return rmk;
	}

	/**
	 * @param rmk the rmk to set
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	/**
	 * @return the trtyAppnds
	 */
	public ArrayList<TrtyAppnd> getTrtyAppnds() {
		return trtyAppnds;
	}

	/**
	 * @param trtyAppnds the trtyAppnds to set
	 */
	public void setTrtyAppnds(ArrayList<TrtyAppnd> trtyAppnds) {
		this.trtyAppnds = trtyAppnds;
	}

	/**
	 * @return the trtyCnts
	 */
	public ArrayList<TrtyCnt> getTrtyCnts() {
		return trtyCnts;
	}

	/**
	 * @param trtyCnts the trtyCnts to set
	 */
	public void setTrtyCnts(ArrayList<TrtyCnt> trtyCnts) {
		this.trtyCnts = trtyCnts;
	}

	/**
	 * @return the trtyAttcs
	 */
	public ArrayList<TrtyAttc> getTrtyAttcs() {
		return trtyAttcs;
	}

	/**
	 * @param trtyAttcs the trtyAttcs to set
	 */
	public void setTrtyAttcs(ArrayList<TrtyAttc> trtyAttcs) {
		this.trtyAttcs = trtyAttcs;
	}

}
