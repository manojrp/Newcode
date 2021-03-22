package com.ltts.hlm.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.transform.Transformers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ltts.hlm.pms.entity.Dealer;
import com.ltts.hlm.pms.entity.ElectricalModel;
import com.ltts.hlm.pms.entity.EngineModel;
import com.ltts.hlm.pms.entity.LocationModel;
import com.ltts.hlm.pms.entity.NetworkModel;
import com.ltts.hlm.pms.entity.VehResult;
import com.ltts.hlm.pms.entity.VesselModel;
import com.ltts.hlm.pms.util.QueryConstants;

@Transactional
@Repository
public class PrivacyManagementDaoImpl implements PrivacyManagementDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger LOG = LoggerFactory.getLogger(PrivacyManagementDaoImpl.class);

	private List<VehResult> getCountOfBoatsForCustomer(String customer_id) {
		String hql = "";
		List<VehResult> vehicleData = null;
		try {
			hql = QueryConstants.GETBOATCOUNT + "'" + customer_id + "'";
			vehicleData = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
					.setResultTransformer(Transformers.aliasToBean(VehResult.class)).list();

		} catch (Exception e) {
			LOG.error("Exception in VehicleHealthManagementDaoImpl getCountOfBoatsForCustomer : " + e);

		}
		return vehicleData;
	}

	@Override
	public JSONObject getBoatList(String customer_id) {

		String hql = "";
		JSONObject boatObj = new JSONObject();
		List<VehResult> countOfBoats = getCountOfBoatsForCustomer(customer_id);
		List<NetworkModel> network = new ArrayList<NetworkModel>();
		List<VesselModel> vessel = new ArrayList<VesselModel>();
		List<ElectricalModel> electrical = new ArrayList<ElectricalModel>();
		List<LocationModel> location = new ArrayList<LocationModel>();
		List<EngineModel> engine = new ArrayList<EngineModel>();
		JSONArray parentArr = new JSONArray();
		try {
			for (int i = 0; i < countOfBoats.size(); i++) {

				hql = QueryConstants.GETNETWORKDATA + "'" + customer_id + "'" + QueryConstants.PASSVEHICLEID + "'"
						+ countOfBoats.get(i).getVehicle_id().toString() + "'";
				network = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
						.setResultTransformer(Transformers.aliasToBean(NetworkModel.class)).list();

				// 1st object
				JSONObject parentObj = new JSONObject();

				// network object
				JSONObject networkObj = new JSONObject();
				networkObj.put("product_info", network.get(0).getProduct_info());
				parentObj.put("network", networkObj);

				hql = QueryConstants.GETVESSELDATA + "'" + customer_id + "'" + QueryConstants.PASSVEHICLEID + "'"
						+ countOfBoats.get(i).getVehicle_id().toString() + "'";
				vessel = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
						.setResultTransformer(Transformers.aliasToBean(VesselModel.class)).list();

				// vessel object
				JSONObject vesselObj = new JSONObject();
				vesselObj.put("fluid_level", vessel.get(0).getFluid_level());
				vesselObj.put("wind_data", vessel.get(0).getWind_data());
				parentObj.put("vessel", vesselObj);

				hql = QueryConstants.GETELECTRICALDATA + "'" + customer_id + "'" + QueryConstants.PASSVEHICLEID + "'"
						+ countOfBoats.get(i).getVehicle_id().toString() + "'";
				electrical = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
						.setResultTransformer(Transformers.aliasToBean(ElectricalModel.class)).list();

				// electrical object
				JSONObject electricalObj = new JSONObject();
				electricalObj.put("battery_status_1", electrical.get(0).getBattery_status_1());
				electricalObj.put("battery_status_2", electrical.get(0).getBattery_status_2());
				parentObj.put("electrical", electricalObj);

				hql = QueryConstants.GETLOCATIONDATA + "'" + customer_id + "'" + QueryConstants.PASSVEHICLEID + "'"
						+ countOfBoats.get(i).getVehicle_id().toString() + "'";

				location = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
						.setResultTransformer(Transformers.aliasToBean(LocationModel.class)).list();

				// location object
				JSONObject locationObj = new JSONObject();
				locationObj.put("altitude", location.get(0).getAltitude());
				locationObj.put("water_depth", location.get(0).getWater_depth());
				locationObj.put("gnss_position", location.get(0).getGnss_position());
				locationObj.put("direction", location.get(0).getDirection());
				parentObj.put("location", locationObj);

				// boat name object
				parentObj.put("name", countOfBoats.get(i).getVehicle_name().toString());

				hql = QueryConstants.GETENGINEDETAILS + "'" + customer_id + "'" + QueryConstants.PASSVEHICLEID + "'"
						+ countOfBoats.get(i).getVehicle_id().toString() + "'";
				engine = entityManager.createNativeQuery(hql).unwrap(org.hibernate.Query.class)
						.setResultTransformer(Transformers.aliasToBean(EngineModel.class)).list();
				JSONObject tempObj = new JSONObject();
				JSONArray tempArr = new JSONArray();
				JSONObject engineObject = new JSONObject();
				for (int j = 0; j < engine.size(); j++) {

					engineObject.put("engine_speed", engine.get(j).getEngine_speed());
					engineObject.put("engine_boost_pressure", engine.get(j).getEngine_boost_pressure());
					engineObject.put("engine_tilt_trim", engine.get(j).getEngine_tilt_trim());
					engineObject.put("engine_temp", engine.get(j).getEngine_temp());
					engineObject.put("alternator_potential", engine.get(j).getAlternator_potential());
					engineObject.put("fuel_rate", engine.get(j).getFuel_rate());
					engineObject.put("total_engine_hours", engine.get(j).getTotal_engine_hours());
					engineObject.put("transmission_gear", engine.get(j).getTransmission_gear());
					engineObject.put("rated_engine_speed", engine.get(j).getRated_engine_speed());
					engineObject.put("check_engine", engine.get(j).getCheck_engine());
					engineObject.put("over_temperature", engine.get(j).getOver_temperature());
					engineObject.put("low_oil_pressure", engine.get(j).getLow_oil_pressure());
					engineObject.put("water_in_fuel", engine.get(j).getWater_in_fuel());
					engineObject.put("charge_indicator", engine.get(j).getCharge_indicator());
					engineObject.put("rev_limit_exceeded", engine.get(j).getRev_limit_exceeded());
					engineObject.put("emergency_stop_mode", engine.get(j).getEmergency_stop_mode());
					System.out.println("inside eng - " + engineObject);

					tempObj.put(String.valueOf(j), engineObject);
					tempArr.put(engineObject);

				}

				// engine object
				parentObj.put("engine", tempArr);

				// parent array
				parentArr.put(parentObj);

			}

			boatObj.put("boat", parentArr);

		} catch (Exception e) {
			LOG.error("Exception in VehicleHealthManagementDaoImpl getEngineList : " + e);
		}
		LOG.info("Final Object - " + boatObj);
		return boatObj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dealer> getPreferredDealers(String customer_id) {
		List<Dealer> preferredDealerList = null;
		String hql = "";
		try {
			hql = QueryConstants.GETPREFERREDDEALERLIST;
			preferredDealerList = entityManager.createQuery(hql).getResultList();
		} catch (Exception e) {
			LOG.error("Exception in VehicleHealthManagementDaoImpl getPreferredDealers : " + e);
		}
		return preferredDealerList;
	}

}
