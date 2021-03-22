package com.ltts.hlm.pms.entity;

import java.io.Serializable;

public class VesselModel implements Serializable {

	private String fluid_level;
	private String wind_data;
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

}
