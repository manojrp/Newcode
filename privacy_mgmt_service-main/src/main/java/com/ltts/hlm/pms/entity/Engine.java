package com.ltts.hlm.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engine_tbl")

public class Engine implements Serializable {

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

	@Column(name = "engine_speed")
	private String engine_speed;

	@Column(name = "engine_boost_pressure")
	private String engine_boost_pressure;

	@Column(name = "engine_tilt_trim")
	private String engine_tilt_trim;

	@Column(name = "engine_temp")
	private String engine_temp;

	@Column(name = "alternator_potential")
	private String alternator_potential;

	@Column(name = "fuel_rate")
	private String fuel_rate;

	@Column(name = "total_engine_hours")
	private String total_engine_hours;

	@Column(name = "transmission_gear")
	private String transmission_gear;

	@Column(name = "rated_engine_speed")
	private String rated_engine_speed;

	@Column(name = "check_engine")
	private String check_engine;

	@Column(name = "over_temperature")
	private String over_temperature;

	@Column(name = "low_oil_pressure")
	private String low_oil_pressure;

	@Column(name = "water_in_fuel")
	private String water_in_fuel;

	@Column(name = "charge_indicator")
	private String charge_indicator;

	@Column(name = "rev_limit_exceeded")
	private String rev_limit_exceeded;

	@Column(name = "emergency_stop_mode")
	private String emergency_stop_mode;

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

	public String getEngine_speed() {
		return engine_speed;
	}

	public void setEngine_speed(String engine_speed) {
		this.engine_speed = engine_speed;
	}

	public String getEngine_boost_pressure() {
		return engine_boost_pressure;
	}

	public void setEngine_boost_pressure(String engine_boost_pressure) {
		this.engine_boost_pressure = engine_boost_pressure;
	}

	public String getEngine_tilt_trim() {
		return engine_tilt_trim;
	}

	public void setEngine_tilt_trim(String engine_tilt_trim) {
		this.engine_tilt_trim = engine_tilt_trim;
	}

	public String getEngine_temp() {
		return engine_temp;
	}

	public void setEngine_temp(String engine_temp) {
		this.engine_temp = engine_temp;
	}

	public String getAlternator_potential() {
		return alternator_potential;
	}

	public void setAlternator_potential(String alternator_potential) {
		this.alternator_potential = alternator_potential;
	}

	public String getFuel_rate() {
		return fuel_rate;
	}

	public void setFuel_rate(String fuel_rate) {
		this.fuel_rate = fuel_rate;
	}

	public String getTotal_engine_hours() {
		return total_engine_hours;
	}

	public void setTotal_engine_hours(String total_engine_hours) {
		this.total_engine_hours = total_engine_hours;
	}

	public String getTransmission_gear() {
		return transmission_gear;
	}

	public void setTransmission_gear(String transmission_gear) {
		this.transmission_gear = transmission_gear;
	}

	public String getRated_engine_speed() {
		return rated_engine_speed;
	}

	public void setRated_engine_speed(String rated_engine_speed) {
		this.rated_engine_speed = rated_engine_speed;
	}

	public String getCheck_engine() {
		return check_engine;
	}

	public void setCheck_engine(String check_engine) {
		this.check_engine = check_engine;
	}

	public String getOver_temperature() {
		return over_temperature;
	}

	public void setOver_temperature(String over_temperature) {
		this.over_temperature = over_temperature;
	}

	public String getLow_oil_pressure() {
		return low_oil_pressure;
	}

	public void setLow_oil_pressure(String low_oil_pressure) {
		this.low_oil_pressure = low_oil_pressure;
	}

	public String getWater_in_fuel() {
		return water_in_fuel;
	}

	public void setWater_in_fuel(String water_in_fuel) {
		this.water_in_fuel = water_in_fuel;
	}

	public String getCharge_indicator() {
		return charge_indicator;
	}

	public void setCharge_indicator(String charge_indicator) {
		this.charge_indicator = charge_indicator;
	}

	public String getRev_limit_exceeded() {
		return rev_limit_exceeded;
	}

	public void setRev_limit_exceeded(String rev_limit_exceeded) {
		this.rev_limit_exceeded = rev_limit_exceeded;
	}

	public String getEmergency_stop_mode() {
		return emergency_stop_mode;
	}

	public void setEmergency_stop_mode(String emergency_stop_mode) {
		this.emergency_stop_mode = emergency_stop_mode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
