package mr.web.model;

import java.util.HashMap;
import java.util.Map;

public class MedicineVO {

	private String entpName; // 업체명
	private String itemName; // 제품명
	private String itemSeq; // 품목기준코드
	private String efcyQesitm; // 효능
	private String useMethodQesitm; // 사용법
	private Object atpnWarnQesitm; // 주의사항경고
	private String atpnQesitm; // 주의사항
	private Object intrcQesitm; // 상호작용
	private Object seQesitm; // 부작용
	private String depositMethodQesitm; // 보관법
	private String openDe; // 공개일자
	private String updateDe; // 수정일자
	private Object itemImage; // 낱알이미지
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	private String searchType;
	private String keyWord;

	
	
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

	public Object getAtpnWarnQesitm() {
		return atpnWarnQesitm;
	}

	public void setAtpnWarnQesitm(Object atpnWarnQesitm) {
		this.atpnWarnQesitm = atpnWarnQesitm;
	}

	public String getAtpnQesitm() {
		return atpnQesitm;
	}

	public void setAtpnQesitm(String atpnQesitm) {
		this.atpnQesitm = atpnQesitm;
	}

	public Object getIntrcQesitm() {
		return intrcQesitm;
	}

	public void setIntrcQesitm(Object intrcQesitm) {
		this.intrcQesitm = intrcQesitm;
	}

	public Object getSeQesitm() {
		return seQesitm;
	}

	public void setSeQesitm(Object seQesitm) {
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

	public Object getItemImage() {
		return itemImage;
	}

	public void setItemImage(Object itemImage) {
		this.itemImage = itemImage;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
