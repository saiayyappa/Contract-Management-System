package com.cms.bean;

public class ContractBean {

	private int contractId;
	private String contractDesc;
	private String contractSubDate;
	private String contractProDate;
	private String contractStatus;
	private int supplierId;
	private String term1;
	private String term2;
	private String term3;
	private String condition1;
	private String condition2;
	private String condition3;
	private String amenity1;

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractDesc() {
		return contractDesc;
	}

	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}

	public String getContractSubDate() {
		return contractSubDate;
	}

	public void setContractSubDate(String contractSubDate) {
		this.contractSubDate = contractSubDate;
	}

	public String getContractProDate() {
		return contractProDate;
	}

	public void setContractProDate(String contractProDate) {
		this.contractProDate = contractProDate;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getTerm1() {
		return term1;
	}

	public void setTerm1(String term1) {
		this.term1 = term1;
	}

	public String getTerm2() {
		return term2;
	}

	public void setTerm2(String term2) {
		this.term2 = term2;
	}

	public String getTerm3() {
		return term3;
	}

	public void setTerm3(String term3) {
		this.term3 = term3;
	}

	public String getCondition1() {
		return condition1;
	}

	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}

	public String getCondition2() {
		return condition2;
	}

	public void setCondition2(String condition2) {
		this.condition2 = condition2;
	}

	public String getCondition3() {
		return condition3;
	}

	public void setCondition3(String condition3) {
		this.condition3 = condition3;
	}

	public String getAmenity1() {
		return amenity1;
	}

	public void setAmenity1(String amenity) {
		this.amenity1 = amenity;
	}

	@Override
	public String toString() {
		return "ContractBean [contractId=" + contractId + ", contractDesc=" + contractDesc + ", contractSubDate="
				+ contractSubDate + ", contractProDate=" + contractProDate + ", contractStatus=" + contractStatus
				+ ", supplierId=" + supplierId + ", term1=" + term1 + ", term2=" + term2 + ", term3=" + term3
				+ ", condition1=" + condition1 + ", condition2=" + condition2 + ", condition3=" + condition3
				+ ", amenity1=" + amenity1 + "]";
	}
	
}
