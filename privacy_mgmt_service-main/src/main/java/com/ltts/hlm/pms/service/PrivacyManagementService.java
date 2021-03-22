package com.ltts.hlm.pms.service;

import java.util.List;

import org.json.JSONObject;

import com.ltts.hlm.pms.entity.Dealer;

public interface PrivacyManagementService {

	JSONObject getBoatList(String customer_id);

	List<Dealer> getPreferredDealers(String customer_id);

}
