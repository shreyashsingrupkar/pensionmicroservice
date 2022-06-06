package com.claimmicroservice.service;

import org.springframework.web.client.RestTemplate;


import com.claimmicroservice.entity.PensionDetail;
import com.claimmicroservice.entity.PensionerDetails;


public interface ClaimService {

	public PensionDetail processPension(long aadharno,PensionerDetails p);
}
