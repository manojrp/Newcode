package com.ltts.hlm.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "electrical_tbl")

public class Electrical implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "engine_id")
	private String engine_id;

	@Column(name = "vehicle_id")
	private String vehicle_id;

	@Column(name = "model_id")
	private String model_id;

	@Column(name = "battery_status_1")
	private String battery_status_1;
	
	@Column(name = "battery_status_2")
	private String battery_status_2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEngine_id() {
		return engine_id;
	}

	public void setEngine_id(String engine_id) {
		this.engine_id = engine_id;
	}

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getBattery_status_1() {
		return battery_status_1;
	}

	public void setBattery_status_1(String battery_status_1) {
		this.battery_status_1 = battery_status_1;
	}

	public String getBattery_status_2() {
		return battery_status_2;
	}

	public void setBattery_status_2(String battery_status_2) {
		this.battery_status_2 = battery_status_2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
