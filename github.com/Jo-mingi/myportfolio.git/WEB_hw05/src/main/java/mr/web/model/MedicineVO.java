package mr.web.model;

public class MedicineVO {

	private int num;
	private String entpName; // 업체명
	private String itemName; // 제품명
	private String itemSeq; // 품목기준코드
	private String efcyQesitm; // 효능
	private String useMethodQesitm; // 사용법
	private String atpnWarnQesitm; // 주의사항경고
	private String atpnQesitm; // 주의사항
	private String intrcQesitm; // 상호작용
	private String seQesitm; // 부작용
	private String depositMethodQesitm; // 보관법
	private String openDe; // 공개일자
	private String updateDe; // 수정일자
	private String itemImage; // 낱알이미지
	
	// paging
	private int viewPage = 1;
	private int startIndex = 0;
	private int cntPerPages = 10;
	private int blockSize = 10;
	
	private String searchType;
	private String keyWord;
	
	// 기본 생성자
	public MedicineVO() {}
	
	// 인자 생성자
	public MedicineVO(int num, String entpName, String itemName, String itemSeq, String efcyQesitm,
			String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm,
			String depositMethodQesitm, String openDe, String updateDe, String itemImage) {
		this.num = num;
		this.entpName = entpName;
		this.itemName = itemName;
		this.itemSeq = itemSeq;
		this.efcyQesitm = efcyQesitm;
		this.useMethodQesitm = useMethodQesitm;
		this.atpnWarnQesitm = atpnWarnQesitm;
		this.atpnQesitm = atpnQesitm;
		this.intrcQesitm = intrcQesitm;
		this.seQesitm = seQesitm;
		this.depositMethodQesitm = depositMethodQesitm;
		this.openDe = openDe;
		this.updateDe = updateDe;
		this.itemImage = itemImage;

	}
	
	public MedicineVO(String entpName, String itemName, String itemSeq, String efcyQesitm,
			String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm,
			String depositMethodQesitm, String openDe, String updateDe, String itemImage) {
		this.entpName = entpName;
		this.itemName = itemName;
		this.itemSeq = itemSeq;
		this.efcyQesitm = efcyQesitm;
		this.useMethodQesitm = useMethodQesitm;
		this.atpnWarnQesitm = atpnWarnQesitm;
		this.atpnQesitm = atpnQesitm;
		this.intrcQesitm = intrcQesitm;
		this.seQesitm = seQesitm;
		this.depositMethodQesitm = depositMethodQesitm;
		this.openDe = openDe;
		this.updateDe = updateDe;
		this.itemImage = itemImage;
		
	}
	
	
	public int getViewPage() {
		return viewPage;
	}

	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getCntPerPages() {
		return cntPerPages;
	}

	public void setCntPerPages(int cntPerPages) {
		this.cntPerPages = cntPerPages;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSeq() {
		return itemSeq;
	}

	public void setItemSeq(String itemSeq) {
		this.itemSeq = itemSeq;
	}

	public String getEfcyQesitm() {
		return efcyQesitm;
	}

	public void setEfcyQesitm(String efcyQesitm) {
		this.efcyQesitm = efcyQesitm;
	}

	public String getUseMethodQesitm() {
		return useMethodQesitm;
	}

	public void setUseMethodQesitm(String useMethodQesitm) {
		this.useMethodQesitm = useMethodQesitm;
	}

	public String getAtpnWarnQesitm() {
		return atpnWarnQesitm;
	}

	public void setAtpnWarnQesitm(String atpnWarnQesitm) {
		this.atpnWarnQesitm = atpnWarnQesitm;
	}

	public String getAtpnQesitm() {
		return atpnQesitm;
	}

	public void setAtpnQesitm(String atpnQesitm) {
		this.atpnQesitm = atpnQesitm;
	}

	public String getIntrcQesitm() {
		return intrcQesitm;
	}

	public void setIntrcQesitm(String intrcQesitm) {
		this.intrcQesitm = intrcQesitm;
	}

	public String getSeQesitm() {
		return seQesitm;
	}

	public void setSeQesitm(String seQesitm) {
		this.seQesitm = seQesitm;
	}

	public String getDepositMethodQesitm() {
		return depositMethodQesitm;
	}

	public void setDepositMethodQesitm(String depositMethodQesitm) {
		this.depositMethodQesitm = depositMethodQesitm;
	}

	public String getOpenDe() {
		return openDe;
	}

	public void setOpenDe(String openDe) {
		this.openDe = openDe;
	}

	public String getUpdateDe() {
		return updateDe;
	}

	public void setUpdateDe(String updateDe) {
		this.updateDe = updateDe;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "MedicineVO [num=" + num + ", entpName=" + entpName + ", itemName=" + itemName + ", itemSeq=" + itemSeq
				+ ", efcyQesitm=" + efcyQesitm + ", useMethodQesitm=" + useMethodQesitm + ", atpnWarnQesitm="
				+ atpnWarnQesitm + ", atpnQesitm=" + atpnQesitm + ", intrcQesitm=" + intrcQesitm + ", seQesitm="
				+ seQesitm + ", depositMethodQesitm=" + depositMethodQesitm + ", openDe=" + openDe + ", updateDe="
				+ updateDe + ", itemImage=" + itemImage + "]";
	}
	
	

}
