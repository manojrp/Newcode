package com.ltts.hlm.pms.util;

public final class QueryConstants {

	public static final String PASSVEHICLEID = "AND vl.vehicle_id=";
	public static final String GETBOATCOUNT = "SELECT ve.vehicle_name, ve.vehicle_id FROM vehicle_tbl as ve WHERE ve.cust_id=";
	public static final String GETNETWORKDATA = "SELECT ne.product_info FROM network_monitoring_tbl ne INNER JOIN vehicle_tbl vl ON vl.vehicle_id=ne.vehicle_id AND vl.cust_id=";
	public static final String GETVESSELDATA = "SELECT ve.fluid_level,ve.wind_data FROM vessel_tbl ve INNER JOIN vehicle_tbl vl ON vl.vehicle_id=ve.vehicle_id AND vl.cust_id=";
	public static final String GETLOCATIONDATA = "SELECT lo.altitude,lo.direction,lo.gnss_position,lo.water_depth FROM location_tbl lo INNER JOIN vehicle_tbl vl ON vl.vehicle_id=lo.vehicle_id AND vl.cust_id=";
	public static final String GETELECTRICALDATA = "SELECT el.battery_status_1, el.battery_status_2 FROM electrical_tbl el INNER JOIN vehicle_tbl vl ON el.vehicle_id=vl.vehicle_id AND vl.cust_id=";
	public static final String GETENGINEDETAILS = "SELECT en.engine_speed,en.engine_boost_pressure,en.engine_tilt_trim,en.engine_temp,en.alternator_potential,en.fuel_rate,en.total_engine_hours,en.transmission_gear,en.rated_engine_speed,en.check_engine,en.over_temperature,en.low_oil_pressure,en.water_in_fuel,en.charge_indicator,en.rev_limit_exceeded,en.emergency_stop_mode FROM engine_tbl AS en INNER JOIN vehicle_tbl vl ON vl.vehicle_id=en.vehicle_id AND vl.cust_id=";
	public static final String GETPREFERREDDEALERLIST = "FROM Dealer as dl";
}