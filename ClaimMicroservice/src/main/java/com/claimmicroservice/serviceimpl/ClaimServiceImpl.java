package com.claimmicroservice.serviceimpl;


import org.springframework.stereotype.Service;

import com.claimmicroservice.entity.PensionAmount;
import com.claimmicroservice.entity.PensionDetail;
import com.claimmicroservice.entity.PensionerDetails;
import com.claimmicroservice.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {

	@Override
	public PensionDetail processPension(long aadharno,PensionerDetails p) {
			
		
		PensionDetail pd=new PensionDetail();
		double salaryearned=p.salaryearned;
		double allowances=p.allowances;
		
		
		double selfpension=((salaryearned+allowances)*80)/100;
		double familypension=((salaryearned+allowances)*50)/100;
    
     
     PensionAmount pa=new PensionAmount();
     pa.setFamilypension(familypension);
     pa.setSelfpension(selfpension);
    
     pd.setPensionamount(pa);;
     String banktype1=p.banktype;
     String pub="public";
     if(banktype1.matches(pub)) {
    	 pd.setBankservicecharge(500.0);
     }else {
    	 pd.setBankservicecharge(550.0);
     }
     
		
		return pd ;
	}

}
