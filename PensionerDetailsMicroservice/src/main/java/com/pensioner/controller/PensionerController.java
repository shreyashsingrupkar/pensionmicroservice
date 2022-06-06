package com.pensioner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensioner.entity.Pensioner;
import com.pensioner.service.PensionerService;

@RestController
@RequestMapping("/pensionerdetails")
public class PensionerController {

	@Autowired
	PensionerService pensionerService;
	
	@PostMapping(value="/addpensioner")
	Pensioner addPensionerDetails(@RequestBody Pensioner pensioner) {
		
		Pensioner p=pensionerService.addPensioner(pensioner);
		return p;
	}
	
	
	@GetMapping(value="/PensionerDetailByAadhaar/{aadharno}")
	Optional<Pensioner> getPensionerDetails(@PathVariable Long aadharno){
		Optional<Pensioner> p=pensionerService.getPensioner(aadharno);
		return p;
	}
}
