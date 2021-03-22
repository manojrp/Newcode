package com.ltts.hlm.pms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ltts.hlm.pms.entity.Dealer;
import com.ltts.hlm.pms.service.PrivacyManagementService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("hlmc/v1")
public class PrivacyManagementController {

	@Autowired
	private PrivacyManagementService pmsService;

	private static final Logger LOG = LoggerFactory.getLogger(PrivacyManagementController.class);

	/**
	 * 
	 * @param messageId
	 * @param Authorization
	 * @param systemId
	 * @param country_code
	 * @param language_code
	 * @param customer_id
	 * @return this api is used to fetch boat data based on customer id for my boat
	 *         page
	 */
	@ApiOperation(tags = "My Boat", value = "API to get data for my boat page")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 500, message = "Internal Server Error (System Issues)"),
			@ApiResponse(code = 204, message = "Empty Response Content"),
			@ApiResponse(code = 412, message = "HondaHeaderType is missing in the HTTP Header"),
			@ApiResponse(code = 415, message = "Invalid File Name in header"),
			@ApiResponse(code = 504, message = "Failed to establish Backside connection"),
			@ApiResponse(code = 503, message = "Service Unavailable") })
	@GetMapping(value = "myBoat")
	public ResponseEntity<String> myBoat(
			@ApiParam(value = "hondaHeaderType.messageId", required = true) @RequestHeader String messageId,
			@ApiParam(value = "Authorization", required = true) @RequestHeader String Authorization,
			@ApiParam(value = "hondaHeaderType.systemId", required = true) @RequestHeader String systemId,
			@ApiParam(value = "hondaHeaderType.country_code", required = true) @RequestHeader String country_code,
			@ApiParam(value = "hondaHeaderType.language_code", required = true) @RequestHeader String language_code,
			@RequestParam("customer_id") String customer_id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("hondaHeaderType.messageId", "550e8400-e29b-41d4-a716-446655440000");
		responseHeaders.set("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ");
		responseHeaders.set("hondaHeaderType.systemId", "com.honda.hondalink.ig_ios");
		responseHeaders.set("hondaHeaderType.country_code", "US");
		responseHeaders.set("hondaHeaderType.language_code", "EN");

		try {
			JSONObject boat = pmsService.getBoatList(customer_id);
			LOG.info("Boat object - " + boat);
			
			return new ResponseEntity<String>(boat.toString(), responseHeaders, HttpStatus.OK);
			

		} catch (Exception e) {
			LOG.error("Exception in VehicleHealthManagementController myBoat ::: " + e);
			return new ResponseEntity<String>(responseHeaders, HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	/**
	 * 
	 * @param messageId
	 * @param Authorization
	 * @param systemId
	 * @param country_code
	 * @param language_code
	 * @param customer_id
	 * @return
	 * this api is used to fetch the list of preferred dealers
	 */ 
	
	@ApiOperation(tags = "Terms and cond", value = "tnc file download")
    /*@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "bad request"),
            @ApiResponse(code = 500, message = "Internal Server Error (System Issues)"),
            @ApiResponse(code = 204, message = "Empty Response Content"),
            @ApiResponse(code = 412, message = "HondaHeaderType is missing in the HTTP Header"),
            @ApiResponse(code = 415, message = "Invalid File Name in header"),
            @ApiResponse(code = 504, message = "Failed to establish Backside connection"),
            @ApiResponse(code = 503, message = "Service Unavailable") })*/
    @GetMapping("/preferences/tnc/{customer_id}")
    public ResponseEntity<?> picdownload(/*@ApiParam(value = "hondaHeaderType.messageId", required = true) @RequestHeader String messageId,
            @ApiParam(value = "Authorization", required = true) @RequestHeader String Authorization,
            @ApiParam(value = "hondaHeaderType.systemId", required = true) @RequestHeader String systemId,
            @ApiParam(value = "hondaHeaderType.country_code", required = true) @RequestHeader String country_code,
            @ApiParam(value = "hondaHeaderType.language_code", required = true) @RequestHeader String language_code,*/
            @PathVariable("customer_id") String custId) {
        HttpHeaders responseHeaders = new HttpHeaders();
        /*responseHeaders.set("hondaHeaderType.messageId", "550e8400-e29b-41d4-a716-446655440000");
        responseHeaders.set("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ");
        responseHeaders.set("hondaHeaderType.systemId", "com.honda.hondalink.ig_ios");
        responseHeaders.set("hondaHeaderType.country_code", "US");
        responseHeaders.set("hondaHeaderType.language_code", "EN");*/
        ResponseEntity<Object> responseEntity;
        try {
            
                String filename = "C:\\HLM_LOGS\\terms&conditions.pdf";
                LOG.info("File path : " + filename);
                File file = new File(filename);

 

                InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
                responseHeaders.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
                //responseHeaders.add("Content-Type", "image/png");
                responseHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");
                responseHeaders.add("Pragma", "no-cache");
                responseHeaders.add("Expires", "0");
                responseEntity = ResponseEntity.ok().headers(responseHeaders).contentLength(file.length())
                        .contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
            
            return responseEntity;
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Exception in  tnc download :: " + e);
            return new ResponseEntity<>("Error", responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

 

    }
	
	
	
	
	
	
	
	
	
	@ApiOperation(tags = "Preferred Dealer", value = "Fetches the list of preferred dealers set by the user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "bad request"),
			@ApiResponse(code = 500, message = "Internal Server Error (System Issues)"),
			@ApiResponse(code = 204, message = "Empty Response Content"),
			@ApiResponse(code = 412, message = "HondaHeaderType is missing in the HTTP Header"),
			@ApiResponse(code = 415, message = "Invalid File Name in header"),
			@ApiResponse(code = 504, message = "Failed to establish Backside connection"),
			@ApiResponse(code = 503, message = "Service Unavailable") })
	@GetMapping(value = "/preferred/dealer")
	public ResponseEntity<?> preferredDealer(
			@ApiParam(value = "hondaHeaderType.messageId", required = true) @RequestHeader String messageId,
			@ApiParam(value = "Authorization", required = true) @RequestHeader String Authorization,
			@ApiParam(value = "hondaHeaderType.systemId", required = true) @RequestHeader String systemId,
			@ApiParam(value = "hondaHeaderType.country_code", required = true) @RequestHeader String country_code,
			@ApiParam(value = "hondaHeaderType.language_code", required = true) @RequestHeader String language_code,
			@RequestParam("customer_id") String customer_id) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("hondaHeaderType.messageId", "550e8400-e29b-41d4-a716-446655440000");
		responseHeaders.set("Authorization", "Bearer<4654d6asda54s6-er85475-8877654> ");
		responseHeaders.set("hondaHeaderType.systemId", "com.honda.hondalink.ig_ios");
		responseHeaders.set("hondaHeaderType.country_code", "US");
		responseHeaders.set("hondaHeaderType.language_code", "EN");

		try {
			
			List<Dealer> preferredDealer = new ArrayList<Dealer>();
			preferredDealer = pmsService.getPreferredDealers(customer_id);
			return new ResponseEntity<>(preferredDealer, responseHeaders, HttpStatus.OK);
			

		} catch (Exception e) {
			LOG.error("Exception in VehicleHealthManagementController preferredDealer ::: " + e);
			return new ResponseEntity<>(responseHeaders, HttpStatus.EXPECTATION_FAILED);
		}

	}
}
