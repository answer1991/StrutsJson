package com.answer1991.struts.json.action;

import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.answer1991.struts.json.helper.CrossDomainJsonHelper;
import com.answer1991.struts.json.helper.DefaultCrossDomainJsonHelper;
import com.opensymphony.xwork2.ActionSupport;

public abstract class JsonAction extends ActionSupport {
	private static final long serialVersionUID = 5692938860861413971L;

	public static final String RETURN_TYPE_JSON = "json";
	public static final String RETURN_TYPE_JS = "js";
	public static final String RETURN_TYPE_JSONP = "jsonp";

	public static final String CONTENT_TYPE_JSON = "application/json";
	public static final String CONTENT_TYPE_JS = "text/javascript";
	public static final String CONTENT_TYPE_JSONP = "text/javascript";

	private String returnType;
	private String returnName;
	private CrossDomainJsonHelper crossDomainJsonHelper;

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getReturnName() {
		return returnName;
	}

	public void setReturnName(String returnName) {
		this.returnName = returnName;
	}

	public CrossDomainJsonHelper getCrossDomainJsonHelper() {
		return crossDomainJsonHelper;
	}

	public void setCrossDomainJsonHelper(
			CrossDomainJsonHelper crossDomainJsonHelper) {
		this.crossDomainJsonHelper = crossDomainJsonHelper;
	}

	public abstract String getJsonString();

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		Writer responseWriter = response.getWriter();

		if (RETURN_TYPE_JS.equals(this.returnType)) {
			if (null == crossDomainJsonHelper) {
				crossDomainJsonHelper = new DefaultCrossDomainJsonHelper();
			}
			response.setContentType(CONTENT_TYPE_JS);
			responseWriter.append(crossDomainJsonHelper.toJs(
					this.getJsonString(), this.returnName));
		} else if (RETURN_TYPE_JSONP.equals(this.returnType)) {
			if (null == crossDomainJsonHelper) {
				crossDomainJsonHelper = new DefaultCrossDomainJsonHelper();
			}
			response.setContentType(CONTENT_TYPE_JSONP);
			responseWriter.append(crossDomainJsonHelper.toJsonp(
					this.getJsonString(), this.returnName));
		} else {
			response.setContentType(CONTENT_TYPE_JSON);
			responseWriter.append(this.getJsonString());
		}
		
		responseWriter.flush();

		return null;
	}
}
