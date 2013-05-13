package com.answer1991.struts.json.action;

import com.google.gson.Gson;

public abstract class JsonActionWithGson extends JsonAction {
	private static final long serialVersionUID = 9162190412574338624L;

	protected abstract Object process();

	@Override
	public String getJsonString() {
		Gson gson = new Gson();
		return gson.toJson(this.process());
	}
}
