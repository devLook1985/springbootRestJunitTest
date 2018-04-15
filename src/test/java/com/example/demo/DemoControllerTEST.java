package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.controller.DemoController;
import com.example.demo.model.DemoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = {Application.class, DemoController.class})
public class DemoControllerTEST {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void mvcTest() throws Exception {
		DemoEntity entity = new DemoEntity();
		
		entity.setFirName("choi");
		entity.setLastName("duyoung");
		
		ObjectMapper mapper  = new ObjectMapper();
		String json = mapper.writeValueAsString(entity);
		
		System.out.println("arguments json ::: " + json);
		
		MvcResult result = mockMvc.perform(
		        post("/demo/rest/postapi").contentType(
		            MediaType.APPLICATION_JSON).content(json)).andExpect(
		        status().isOk()).andReturn();
		
		String resultString = result.getResponse().getContentAsString();
		
		System.out.println("result json ::: " + resultString);
	}
}
