package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoEntity;
import com.example.demo.response.ApiConstants;
import com.example.demo.response.ReturnEntity;

@RestController
@RequestMapping("/demo/rest")
public class DemoController {
	
	@RequestMapping(value = "/postapi", 
			method = {RequestMethod.POST }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ReturnEntity postRestApi(@RequestBody DemoEntity resEntity) {
		ReturnEntity result = new ReturnEntity();
		String resultMsg = "";
		
		if(null == resEntity || "".equals(resEntity.getFirName())) {
			result.setCode(ApiConstants.NOT_FIND);
			result.setMsg("page not find");
			
			return result;
		}
		
		resultMsg = "your full name is " + resEntity.getFirName() + " " + resEntity.getLastName();
		result.setMsg(resultMsg);
		
		return result;
	}
	
	@RequestMapping("/hellow")
	public String hellow() {
		return "hellow";
	}
}
