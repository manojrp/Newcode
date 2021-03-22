package com.ltts.hlm.pms.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltts.hlm.pms.Application;
import com.ltts.hlm.pms.entity.Electrical;
import com.ltts.hlm.pms.entity.Engine;
import com.ltts.hlm.pms.entity.Location;
import com.ltts.hlm.pms.entity.NetworkMonitoring;
import com.ltts.hlm.pms.entity.Vehicle;
import com.ltts.hlm.pms.entity.Vessel;
import com.ltts.hlm.pms.service.PrivacyManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PrivacyManagementControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PrivacyManagementService pmsService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void myBoatTestWithValidData() throws Exception {

		MockHttpServletResponse response = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/hlmc/v1/myBoat")
						.header("messageId", "550e8400-e29b-41d4-a716-446655440000")
						.header("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ")
						.header("systemId", "com.honda.hondalink.ig_ios").header("country_code", "US")
						.header("language_code", "EN").param("customer_id", "USR1001").param("vehicle_id", "veh1001"))
				.andReturn().getResponse();

	}

	@Test
	public void myBoatTestWithInvalidData() throws Exception {

		MockHttpServletResponse response = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/hlmc/v1/myBoat")
						.header("messageId", "550e8400-e29b-41d4-a716-446655440000")
						.header("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ")
						.header("systemId", "com.honda.hondalink.ig_ios").header("country_code", "US")
						.header("language_code", "EN").param("customer_id", "USA00132ab85d3e9804b33913966b52f29e09d"))
				.andReturn().getResponse();

	}

	@Test
	public void myBoatTestWithNoBlankId() throws Exception {

		MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/hlmc/v1/myBoat")
				.header("messageId", "550e8400-e29b-41d4-a716-446655440000")
				.header("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ")
				.header("systemId", "com.honda.hondalink.ig_ios").header("country_code", "US")
				.header("language_code", "EN").param("customer_id", "")).andReturn().getResponse();

	}

	@Test
	public void myBoatTestWithNoCustId() throws Exception {

		MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/hlmc/v1/myBoat")
				.header("messageId", "550e8400-e29b-41d4-a716-446655440000")
				.header("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ")
				.header("systemId", "com.honda.hondalink.ig_ios").header("country_code", "US")
				.header("language_code", "EN")).andReturn().getResponse();

	}

	@Test
	public void myBoatTestWithNoHeader() throws Exception {

		MockHttpServletResponse response = this.mockMvc.perform(MockMvcRequestBuilders.get("/hlmc/v1/myBoat"))
				.andReturn().getResponse();

	}

	@Test
	public void main() {
		Application.main(new String[] {});
	}

	@Test
	public void applicationContextLoaded() {
	}

	@Test
	public void testSetter_setsProperly() throws Exception {
		// given
		final Electrical pojo = new Electrical();

		// when
		pojo.setBattery_status_1("97%");

		// then
		final Field field = pojo.getClass().getDeclaredField("battery_status_1");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "97%");
	}

	@Test
	public void testSetter_setsProperly2() throws Exception {
		// given
		final Engine pojo = new Engine();

		// when
		pojo.setAlternator_potential("1.5KW");

		// then
		final Field field = pojo.getClass().getDeclaredField("alternator_potential");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "1.5KW");
	}

	@Test
	public void testSetter_setsProperly3() throws Exception {
		// given
		final Vehicle pojo = new Vehicle();

		// when
		pojo.setVehicle_vin_no("11115555789");

		// then
		final Field field = pojo.getClass().getDeclaredField("vehicle_vin_no");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "11115555789");
	}

	@Test
	public void testSetter_setsProperly4() throws Exception {
		// given
		final Location pojo = new Location();

		// when
		pojo.setWater_depth("10Ft");

		// then
		final Field field = pojo.getClass().getDeclaredField("water_depth");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "10Ft");
	}

	@Test
	public void testSetter_setsProperly5() throws Exception {
		// given
		final Vessel pojo = new Vessel();

		// when
		pojo.setFluid_level("1Ft");

		// then
		Field field = pojo.getClass().getDeclaredField("fluid_level");
		field.setAccessible(true);

		// when
		pojo.setEngine_id("eng1001");

		// then
		field = pojo.getClass().getDeclaredField("engine_id");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "eng1001");

		// when

		pojo.setId(Long.parseLong("1001"));

		// then
		field = pojo.getClass().getDeclaredField("id");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), Long.parseLong("1001"));

		// when

		pojo.setModel_id("mod1001");

		// then
		field = pojo.getClass().getDeclaredField("model_id");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "mod1001");

		// when

		pojo.setVehicle_id("veh1001");

		// then
		field = pojo.getClass().getDeclaredField("vehicle_id");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "veh1001");

		// when

		pojo.setWind_data("299F");

		// then
		field = pojo.getClass().getDeclaredField("wind_data");
		field.setAccessible(true);
		assertEquals("Fields didn't match", field.get(pojo), "299F");
	}

	@Test
	public void testVessel() {
		Vessel vessel = new Vessel();
		vessel.setEngine_id("eng1001");
		assertTrue(vessel.getEngine_id() == "eng1001");
		vessel.setFluid_level("133F");
		assertTrue(vessel.getFluid_level() == "133F");
		vessel.setId(Long.parseLong("1234"));
		assertTrue(vessel.getId() == Long.parseLong("1234"));
		vessel.setModel_id("mod1001");
		assertTrue(vessel.getModel_id() == "mod1001");
		vessel.setVehicle_id("veh1001");
		assertTrue(vessel.getVehicle_id() == "veh1001");
		vessel.setWind_data("156F");
		assertTrue(vessel.getWind_data() == "156F");

	}

	@Test
	public void testNetwork() {
		NetworkMonitoring network = new NetworkMonitoring();
		network.setEngine_id("eng1001");
		assertTrue(network.getEngine_id() == "eng1001");
		network.setId(Long.parseLong("1234"));
		assertTrue(network.getId() == Long.parseLong("1234"));
		network.setModel_id("mod1001");
		assertTrue(network.getModel_id() == "mod1001");
		network.setProduct_info("XX");
		assertTrue(network.getProduct_info() == "XX");
		network.setVehicle_id("veh1002");
		assertTrue(network.getVehicle_id() == "veh1002");

	}

	@Test
	public void testElectrical() {
		Electrical electrical = new Electrical();
		electrical.setBattery_status_1("98%");
		assertTrue(electrical.getBattery_status_1() == "98%");
		electrical.setBattery_status_2("95%");
		assertTrue(electrical.getBattery_status_2() == "95%");
		electrical.setEngine_id("eng1001");
		assertTrue(electrical.getEngine_id() == "eng1001");
		electrical.setId(Long.parseLong("1234"));
		assertTrue(electrical.getId() == Long.parseLong("1234"));
		electrical.setModel_id("mod1001");
		assertTrue(electrical.getModel_id() == "mod1001");
		electrical.setVehicle_id("veh1001");
		assertTrue(electrical.getVehicle_id() == "veh1001");
	}

	@Test
	public void testLocation() {
		Location loc = new Location();
		loc.setAltitude("22N");
		assertTrue(loc.getAltitude() == "22N");
		loc.setDirection("588East");
		assertTrue(loc.getDirection() == "588East");
		loc.setEngine_id("eng1001");
		assertTrue(loc.getEngine_id() == "eng1001");
		loc.setGnss_position("XX");
		assertTrue(loc.getGnss_position() == "XX");
		loc.setId(Long.parseLong("1234"));
		assertTrue(loc.getId() == Long.parseLong("1234"));
		loc.setModel_id("mod1001");
		assertTrue(loc.getModel_id() == "mod1001");
		loc.setVehicle_id("veh1001");
		assertTrue(loc.getVehicle_id() == "veh1001");
		loc.setWater_depth("5ft");
		assertTrue(loc.getWater_depth() == "5ft");
	}

	@Test
	public void testVehicle() {
		Vehicle veh = new Vehicle();
		veh.setCountry_id("US");
		assertTrue(veh.getCountry_id() == "US");
		LocalDateTime date = LocalDateTime.now();
		veh.setCreate_timestamp(date);
		assertTrue(veh.getCreate_timestamp() == date);
		veh.setCust_id("USA1001");
		assertTrue(veh.getCust_id() == "USA1001");
		veh.setId(Long.parseLong("1234"));
		assertTrue(veh.getId() == Long.parseLong("1234"));
		veh.setManufacture_date(date);
		assertTrue(veh.getManufacture_date() == date);
		veh.setUpdate_timestamp(date);
		assertTrue(veh.getUpdate_timestamp() == date);
		veh.setVehicle_hull_no("hul1001");
		assertTrue(veh.getVehicle_hull_no() == "hul1001");
		veh.setVehicle_id("veh1001");
		assertTrue(veh.getVehicle_id() == "veh1001");
		veh.setVehicle_model_id("mod1001");
		assertTrue(veh.getVehicle_model_id() == "mod1001");
		veh.setVehicle_name("seashore");
		assertTrue(veh.getVehicle_name() == "seashore");
		veh.setVehicle_vin_no("vin1001");
		assertTrue(veh.getVehicle_vin_no() == "vin1001");
	}

	@Test
	public void testEngine() {
		Engine eng = new Engine();
		eng.setAlternator_potential("15KW");
		assertTrue(eng.getAlternator_potential() == "15KW");
		eng.setCharge_indicator("OK");
		assertTrue(eng.getCharge_indicator() == "OK");
		eng.setCheck_engine("OK");
		assertTrue(eng.getCheck_engine() == "OK");
		eng.setEmergency_stop_mode("On");
		assertTrue(eng.getEmergency_stop_mode() == "On");
		eng.setEngine_boost_pressure("159PSI");
		assertTrue(eng.getEngine_boost_pressure() == "159PSI");
		eng.setEngine_id("eng1001");
		assertTrue(eng.getEngine_id() == "eng1001");
		eng.setEngine_speed("26MPH");
		assertTrue(eng.getEngine_speed() == "26MPH");
		eng.setEngine_temp("46F");
		assertTrue(eng.getEngine_temp() == "46F");
		eng.setEngine_tilt_trim("3");
		assertTrue(eng.getEngine_tilt_trim() == "3");
		eng.setFuel_rate("25");
		assertTrue(eng.getFuel_rate() == "25");
		eng.setId(Long.parseLong("1234"));
		assertTrue(eng.getId() == Long.parseLong("1234"));
		eng.setLow_oil_pressure("N/A");
		assertTrue(eng.getLow_oil_pressure() == "N/A");
		eng.setModel_id("mod1001");
		assertTrue(eng.getModel_id() == "mod1001");
		eng.setOver_temperature("N/A");
		assertTrue(eng.getOver_temperature() == "N/A");
		eng.setRated_engine_speed("55");
		assertTrue(eng.getRated_engine_speed() == "55");
		eng.setRev_limit_exceeded("No");
		assertTrue(eng.getRev_limit_exceeded() == "No");
		eng.setTotal_engine_hours("6");
		assertTrue(eng.getTotal_engine_hours() == "6");
		eng.setTransmission_gear("N");
		assertTrue(eng.getTransmission_gear() == "N");
		eng.setVehicle_id("veh1001");
		assertTrue(eng.getVehicle_id() == "veh1001");
		eng.setWater_in_fuel("No");
		assertTrue(eng.getWater_in_fuel() == "No");
	}
	
	@Test
	public void preferredDealerTestWithValidData() throws Exception {

		MockHttpServletResponse response = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/hlmc/v1/preferred/dealer")
						.header("messageId", "550e8400-e29b-41d4-a716-446655440000")
						.header("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ")
						.header("systemId", "com.honda.hondalink.ig_ios").header("country_code", "US")
						.header("language_code", "EN").param("customer_id", "USR1001"))
				.andReturn().getResponse();

	}

}