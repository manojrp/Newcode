package com.ltts.hlm.pms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
public class TermsAndConditions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="sequence_gen")
	private Long Id;
	
	private String filename;
	
	private String filepath;
	
	private Date timestamp;
	
	private String customer_id;
	
	private boolean accept;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		customer_id = customer_id;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}

	@Override
	public String toString() {
		return "TermsAndConditions [Id=" + Id + ", filename=" + filename + ", filepath=" + filepath + ", timestamp="
				+ timestamp + ", Customer_id=" + customer_id + ", accept=" + accept + "]";
	}

	public TermsAndConditions(Long id, String filename, String filepath, Date timestamp, String customer_id,
			boolean accept) {
		super();
		Id = id;
		this.filename = filename;
		this.filepath = filepath;
		this.timestamp = timestamp;
		this.customer_id=customer_id;
		this.accept = accept;
	}
	
	
	
	
	
	

}
