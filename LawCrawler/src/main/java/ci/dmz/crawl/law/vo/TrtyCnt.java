package ci.dmz.crawl.law.vo;

/**
 * @author 이동훈 조약내용
 */
public class TrtyCnt extends LawVO {

	/**
	 * 조약일련번호 trty_sn
	 */
	private String trtySn;

	/**
	 * 내용_Key cnt_key
	 */
	private int cntKey;

	/**
	 * 조약내용 trty_cnt
	 */
	private String trtyCnt;

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
	 * @return the cntKey
	 */
	public int getCntKey() {
		return cntKey;
	}

	/**
	 * @param cntKey the cntKey to set
	 */
	public void setCntKey(int cntKey) {
		this.cntKey = cntKey;
	}

	/**
	 * @return the trtyCnt
	 */
	public String getTrtyCnt() {
		return trtyCnt;
	}

	/**
	 * @param trtyCnt the trtyCnt to set
	 */
	public void setTrtyCnt(String trtyCnt) {
		this.trtyCnt = trtyCnt;
	}

}
