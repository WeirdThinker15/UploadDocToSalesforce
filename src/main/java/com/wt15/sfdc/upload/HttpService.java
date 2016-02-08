/**
 * 
 */
package com.wt15.sfdc.upload;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author WeirdThinker15
 * Description		: This class takes care of making the Http Request to SFDC and also parses the resultant response as required.
 *
 */
public class HttpService 
{
	private static HttpResponse hresp;
	public static void uploadDoc(HttpPost hpost) throws ClientProtocolException, IOException
	{
		HttpClient ht = HttpClients.createDefault();
		//Execute the Post Request 
		hresp = ht.execute(hpost);
	}
	
	public static String readResponse() throws ParseException, IOException
	{
		String res;
		HttpEntity entity = hresp.getEntity();
		res = EntityUtils.toString(entity);
		return res;
	}

}
