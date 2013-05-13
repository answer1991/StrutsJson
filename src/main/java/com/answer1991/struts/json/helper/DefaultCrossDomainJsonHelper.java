package com.answer1991.struts.json.helper;

public class DefaultCrossDomainJsonHelper implements CrossDomainJsonHelper {
	public String toJsonp(String json, String prefix) {
		return prefix + "(" + json + ");";
	}
	
	public String toJs(String json, String prefix) {
		return "var " + prefix + " = " + json + ";";
	}
}
