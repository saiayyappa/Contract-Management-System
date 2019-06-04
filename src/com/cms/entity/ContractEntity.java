package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contract")
public class ContractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contractId;
	@Column(name="contract_desc")
	private String contractDesc;
	@Column(name="contract_sub_date")
	private String contractSubDate;
	@Column(name="contract_pro_date")
	private String contractProDate;
	@Column(name="contract_status")
	private String contractStatus;
	@Column(name="supplier_id")
	private int supplierId;
	
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

}
