package com.ltts.hlm.pms.service;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.hlm.pms.dao.PrivacyManagementDao;
import com.ltts.hlm.pms.entity.Dealer;

@Service
public class PrivacyManagementServiceImpl implements PrivacyManagementService {
	@Autowired
	private PrivacyManagementDao pmsDao;

	private static final Logger LOG = LoggerFactory.getLogger(PrivacyManagementServiceImpl.class);

	@Override
	public JSONObject getBoatList(String customer_id) {
		return pmsDao.getBoatList(customer_id);
	}

	@Override
	public List<Dealer> getPreferredDealers(String customer_id) {
		return pmsDao.getPreferredDealers(customer_id);
	}

}
