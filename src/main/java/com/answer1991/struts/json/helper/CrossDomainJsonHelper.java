package com.answer1991.struts.json.helper;

public interface CrossDomainJsonHelper {
	public abstract String toJsonp(String json, String prefix);
	public abstract String toJs(String json, String prefix);
}
