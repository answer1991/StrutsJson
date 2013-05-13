package com.answer1991.struts.json.action.hello;

import com.answer1991.struts.json.action.JsonActionWithGson;

public class Hello extends JsonActionWithGson {
	private static final long serialVersionUID = -5795858449556904770L;

	@Override
	protected Object process() {
		MockObj returnObj = new MockObj();
		returnObj.setInfo("IBM");
		returnObj.setUsername("Chen Jun");
		
		return returnObj;
	}
}
