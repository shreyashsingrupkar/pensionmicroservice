package com.claimmicroservice.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.claimmicroservice.entity.PensionDetail;
import com.claimmicroservice.entity.PensionerDetails;
import com.claimmicroservice.service.ClaimService;
import com.claimmicroservice.serviceimpl.ClaimServiceImpl;


@RestController
@RequestMapping("/claims")
public class ClaimMicroserviceController {
	private static final Logger log = LoggerFactory.getLogger(ClaimMicroserviceController.class);
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ClaimServiceImpl claimServiceImpl;
	
	 @GetMapping(value="/ProcessPension/{aadharno}")
	 public PensionDetail processPension(@PathVariable long aadharno) {
		// PensionerDetails p= restTemplate.getForObject("http://172.22.192.1:9002/getpensioner/"+aadharno,PensionerDetails.class);
		 log.info("Calling pensioner details microservice from claim micro service");
		 PensionerDetails p= restTemplate.getForObject("http://localhost:9000/pensionerdetails/PensionerDetailByAadhaar/"+aadharno,PensionerDetails.class);
	   
		 PensionDetail pd=claimServiceImpl.processPension(aadharno, p);
		 return pd;
	 }
	

}
