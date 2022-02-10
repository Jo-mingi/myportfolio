package mr.web.model;

public class MemoVO {

	private int mnum;
	private String id;
	private String itemName;
	private String Memo;
	
	
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
	}
	@Override
	public String toString() {
		return "MemoVO [mnum=" + mnum + ", id=" + id + ", itemName=" + itemName + ", Memo=" + Memo + "]";
	}
	

}
