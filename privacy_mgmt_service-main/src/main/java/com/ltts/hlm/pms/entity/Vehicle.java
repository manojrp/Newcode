package com.ltts.hlm.pms.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_tbl")

public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "vehicle_id")
	private String vehicle_id;

	@Column(name = "cust_id")
	private String cust_id;

	@Column(name = "country_id")
	private String country_id;
	
	@Column(name = "vehicle_name")
	private String vehicle_name;
	
	@Column(name = "vehicle_model_id")
	private String vehicle_model_id;
	
	@Column(name = "manufacture_date")
	private LocalDateTime manufacture_date;
	
	@Column(name = "vehicle_vin_no")
	private String vehicle_vin_no;
	
	@Column(name = "vehicle_hull_no")
	private String vehicle_hull_no;
	
	@Column(name = "create_timestamp")
	private LocalDateTime create_timestamp;
	

	@Column(name = "update_timestamp")
	private LocalDateTime update_timestamp;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}


	public String getCust_id() {
		return cust_id;
	}


	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}


	public String getCountry_id() {
		return country_id;
	}


	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}


	public String getVehicle_name() {
		return vehicle_name;
	}


	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}


	public String getVehicle_model_id() {
		return vehicle_model_id;
	}


	public void setVehicle_model_id(String vehicle_model_id) {
		this.vehicle_model_id = vehicle_model_id;
	}


	public LocalDateTime getManufacture_date() {
		return manufacture_date;
	}


	public void setManufacture_date(LocalDateTime manufacture_date) {
		this.manufacture_date = manufacture_date;
	}


	public String getVehicle_vin_no() {
		return vehicle_vin_no;
	}


	public void setVehicle_vin_no(String vehicle_vin_no) {
		this.vehicle_vin_no = vehicle_vin_no;
	}


	public String getVehicle_hull_no() {
		return vehicle_hull_no;
	}


	public void setVehicle_hull_no(String vehicle_hull_no) {
		this.vehicle_hull_no = vehicle_hull_no;
	}


	public LocalDateTime getCreate_timestamp() {
		return create_timestamp;
	}


	public void setCreate_timestamp(LocalDateTime create_timestamp) {
		this.create_timestamp = create_timestamp;
	}


	public LocalDateTime getUpdate_timestamp() {
		return update_timestamp;
	}


	public void setUpdate_timestamp(LocalDateTime update_timestamp) {
		this.update_timestamp = update_timestamp;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	

}
