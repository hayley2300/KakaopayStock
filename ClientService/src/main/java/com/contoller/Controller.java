package com.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Requirement1;
import com.model.Requirement2;
import com.service.Services;


@RestController
@RequestMapping("test")
public class Controller {
	
    @Autowired
    private Services services;
    

    @RequestMapping( value = "/require1",  method = { RequestMethod.GET, RequestMethod.POST })
    public List<Requirement1> getRequirment1() {
        return services.getRequirement1();
    }

    
    @RequestMapping( value = "/require2",  method = { RequestMethod.GET, RequestMethod.POST })
    public List<Requirement2> getRequirment2() {
        return services.getRequirement2();
    }

    @RequestMapping( value = "/require3",  method = { RequestMethod.GET, RequestMethod.POST })
    public List<JSONObject> getRequirment3() {
        return services.getRequirement3();
    }
    
    @RequestMapping( value = "/require4",  method = RequestMethod.POST)
    public Object getRequirment4(@RequestBody Map<String, String> branch) {
    	System.out.println("Get branch : "+branch);
    	if (branch.get("brName").toString().equals("분당점") || branch.get("brName").toString().equals("")) {
    		HashMap<String, String> result = new HashMap<String, String>();
    		result.put("code", "404");
    		result.put("메세지", "br code not found error");
    		return result;
    	}else {
    		return services.getRequirement4(branch.get("brName").toString());
    	}
        
    }
}
