package com.answer1991.struts.json.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class TestCrossDomainJsonHelper {
	private CrossDomainJsonHelper helper;
	private Gson gson;
	
	@Before
	public void init(){
		helper = new DefaultCrossDomainJsonHelper();
		gson = new Gson();
	}
	
	@Test
	public void testJsonp(){
		MockObj obj = new MockObj();
		obj.setName("chenjun");
		obj.setInfo("ibm");
		
		String json = gson.toJson(obj);
		
		String jsonp = helper.toJsonp(json, "test");
		System.out.println(jsonp);
		
		Assert.assertEquals("test(" + json + ");", jsonp);
	}
	
	@Test
	public void testJs(){
		MockObj obj = new MockObj();
		obj.setName("chenjun");
		obj.setInfo("ibm");
		
		String json = gson.toJson(obj);
		
		String js = helper.toJs(json, "test");
		System.out.println(js);
		
		Assert.assertEquals("var test = " + json + ";", js);
	}
}
