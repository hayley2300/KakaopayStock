package com.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Requirement1;
import com.model.Requirement2;
import com.model.Requirement3;
import com.model.Requirement4;
import com.repository.AccountRepository;
import com.repository.BranchRepository;
import com.repository.TranRepository;

@Service
@Transactional
public class Services {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TranRepository tranRepository;
    @Autowired
    private BranchRepository branchRepository;


    
    public List<Requirement1> getRequirement1(){
        List<Requirement1> test = tranRepository.getRequirement1();
        return test;
    }
    
    public List<Requirement2> getRequirement2(){
        List<Requirement2> test = accountRepository.getRequirement2();
        return test;
    }
    
    public List<JSONObject> getRequirement3(){
        List<Requirement3> test = tranRepository.getRequirement3();
        
        JSONObject json_dep1 = null;
        JSONObject json_dep2 = null;
        JSONArray req_array = new JSONArray();
        List<JSONObject> lst = new ArrayList<>();
        
        int year=0;
        for(int i =0; i < test.size(); i++) {
        	json_dep2 = new JSONObject();
        	
        	if(i==0) {
        		year = Integer.parseInt(test.get(i).getYear());
        		json_dep2.put("brName", test.get(i).getBrName());
        		json_dep2.put("brCode", test.get(i).getBrCode());
        		json_dep2.put("sumAmt", test.get(i).getSumAmt());
        		req_array.add(json_dep2);
        	}
        	else  if(!test.get(i).getYear().equals(test.get(i-1).getYear())) {
        		json_dep1 = new JSONObject();
        		json_dep1.put("year", year);
        		json_dep1.put("dataList", req_array);
        		req_array = new JSONArray();
        		lst.add(json_dep1);
        		
        		year = Integer.parseInt(test.get(i).getYear());
        		json_dep2.put("brName", test.get(i).getBrName());
        		json_dep2.put("brCode", test.get(i).getBrCode());
        		json_dep2.put("sumAmt", test.get(i).getSumAmt());
                req_array.add(json_dep2);
        	}else {
        		json_dep2.put("brName", test.get(i).getBrName());
        		json_dep2.put("brCode", test.get(i).getBrCode());
        		json_dep2.put("sumAmt", test.get(i).getSumAmt());
        		req_array.add(json_dep2);
        	}
        	
        	if(i+1 == test.size()) {
        		json_dep1 = new JSONObject();
        		json_dep1.put("year", year);
        		json_dep1.put("dataList", req_array);
        		lst.add(json_dep1);
            }
        }
        return lst;
    }
    
    public List<Requirement4> getRequirement4(String branch_nm){
        List<Requirement4> test = branchRepository.getRequirement4(branch_nm);
        return test;
    }
}
