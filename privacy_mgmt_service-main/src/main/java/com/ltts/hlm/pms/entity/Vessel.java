package com.ltts.hlm.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vessel_tbl")

public class Vessel implements Serializable {

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

	@Column(name = "fluid_level")
	private String fluid_level;
	
	@Column(name = "wind_data")
	private String wind_data;

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

	public String getFluid_level() {
		return fluid_level;
	}

	public void setFluid_level(String fluid_level) {
		this.fluid_level = fluid_level;
	}

	public String getWind_data() {
		return wind_data;
	}

	public void setWind_data(String wind_data) {
		this.wind_data = wind_data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
