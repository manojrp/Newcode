package com.ltts.hlm.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location_tbl")

public class Location implements Serializable {

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

	@Column(name = "altitude")
	private String altitude;
	
	@Column(name = "water_depth")
	private String water_depth;
	
	@Column(name = "gnss_position")
	private String gnss_position;
	
	@Column(name = "direction")
	private String direction;

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

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getWater_depth() {
		return water_depth;
	}

	public void setWater_depth(String water_depth) {
		this.water_depth = water_depth;
	}

	public String getGnss_position() {
		return gnss_position;
	}

	public void setGnss_position(String gnss_position) {
		this.gnss_position = gnss_position;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
