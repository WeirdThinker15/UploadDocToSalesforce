/**
 * 
 */
package com.wt15.sfdc.upload;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author WeirdThinker15
 * Description		: A wrapper Class for Response received from Salesforce 
 *
 */
public class SFDCResponse 
{
	//For Success Scenario 
	public String id;
	public List<Object> error;
	public boolean success;
	//For Error Scenarios
	public List<Object> fields;
	public String message;
	public String errorCode;
	
	public static SFDCResponse convertResponse(String resp)
	{
		GsonBuilder gb = new GsonBuilder();
		Gson gs =gb.create();
		SFDCResponse sr = gs.fromJson(resp,SFDCResponse.class);
		return sr;
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the error
	 */
	public List<Object> getError() {
		return error;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the fields
	 */
	public List<Object> getFields() {
		return fields;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	

}
