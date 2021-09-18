/**
 * 
 */
package ci.dmz.crawl.law.vo;

import java.util.ArrayList;

/**
 * @author 이동훈 법령_조문_항
 */
public class LawordCompHang extends LawVO {

	/**
	 * 법령Key laword_key lawordKey
	 */
	private String lawordKey;

	/**
	 * 조문Key comp_key compKey
	 */
	private int compKey;

	/**
	 * 항Key hang_key hangKey
	 */
	private int hangKey;

	/**
	 * 항번호 hang_no hangNo
	 */
	private String hangNo;

	/**
	 * 항제개정유형 hang_revi_typ hangReviTyp
	 */
	private String hangReviTyp;

	/**
	 * 항제개정일자문자열 hang_revi_dt hangReviDt
	 */
	private String hangReviDt;

	/**
	 * 항내용 hang_cnt hangCnt
	 */
	private String hangCnt;

	/**
	 * 법령_조문_항_호
	 */
	private ArrayList<LawordCompHangHo> lawordCompHangHos;

	public LawordCompHang() {
		this.lawordCompHangHos = new ArrayList<LawordCompHangHo>();
	}

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
	 * @return the compKey
	 */
	public int getCompKey() {
		return compKey;
	}

	/**
	 * @param compKey the compKey to set
	 */
	public void setCompKey(int compKey) {
		this.compKey = compKey;
	}

	/**
	 * @return the hangKey
	 */
	public int getHangKey() {
		return hangKey;
	}

	/**
	 * @param hangKey the hangKey to set
	 */
	public void setHangKey(int hangKey) {
		this.hangKey = hangKey;
	}

	/**
	 * @return the hangNo
	 */
	public String getHangNo() {
		return hangNo;
	}

	/**
	 * @param hangNo the hangNo to set
	 */
	public void setHangNo(String hangNo) {
		this.hangNo = hangNo;
	}

	/**
	 * @return the hangReviTyp
	 */
	public String getHangReviTyp() {
		return hangReviTyp;
	}

	/**
	 * @param hangReviTyp the hangReviTyp to set
	 */
	public void setHangReviTyp(String hangReviTyp) {
		this.hangReviTyp = hangReviTyp;
	}

	/**
	 * @return the hangReviDt
	 */
	public String getHangReviDt() {
		return hangReviDt;
	}

	/**
	 * @param hangReviDt the hangReviDt to set
	 */
	public void setHangReviDt(String hangReviDt) {
		this.hangReviDt = hangReviDt;
	}

	/**
	 * @return the hangCnt
	 */
	public String getHangCnt() {
		return hangCnt;
	}

	/**
	 * @param hangCnt the hangCnt to set
	 */
	public void setHangCnt(String hangCnt) {
		this.hangCnt = hangCnt;
	}

	/**
	 * @return the lawordCompHangHos
	 */
	public ArrayList<LawordCompHangHo> getLawordCompHangHos() {
		return lawordCompHangHos;
	}

	/**
	 * @param lawordCompHangHos the lawordCompHangHos to set
	 */
	public void setLawordCompHangHos(ArrayList<LawordCompHangHo> lawordCompHangHos) {
		this.lawordCompHangHos = lawordCompHangHos;
	}

}
