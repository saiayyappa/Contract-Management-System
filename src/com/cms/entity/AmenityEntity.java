package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="amenity")
public class AmenityEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int contractId;
	@Column(name="amenity1")
	private String amenity1;

	public String getAmenity1() {
		return amenity1;
	}

	public void setAmenity1(String amenity1) {
		this.amenity1 = amenity1;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	
}
