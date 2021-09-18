/**
 * 
 */
package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 법령_조문_항_호
 */
public class LawordCompHangHo extends LawVO {

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
	 * 호Key ho_key hoKey
	 */
	private int hoKey;

	/**
	 * 호번호 ho_no hoNo
	 */
	private String hoNo;

	/**
	 * 호내용 ho_cnt hoCnt
	 */
	private String hoCnt;

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
	 * @return the hoKey
	 */
	public int getHoKey() {
		return hoKey;
	}

	/**
	 * @param hoKey the hoKey to set
	 */
	public void setHoKey(int hoKey) {
		this.hoKey = hoKey;
	}

	/**
	 * @return the hoNo
	 */
	public String getHoNo() {
		return hoNo;
	}

	/**
	 * @param hoNo the hoNo to set
	 */
	public void setHoNo(String hoNo) {
		this.hoNo = hoNo;
	}

	/**
	 * @return the hoCnt
	 */
	public String getHoCnt() {
		return hoCnt;
	}

	/**
	 * @param hoCnt the hoCnt to set
	 */
	public void setHoCnt(String hoCnt) {
		this.hoCnt = hoCnt;
	}

}
