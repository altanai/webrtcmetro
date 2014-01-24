package advertisment.com.tcs.webrtc.customizeinterest.REST;


import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import advertisment.com.tcs.webrtc.customizeinterest.bean.Adv;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;*/

public class AdvClient {

	 public static void main(String[] args)  {
		    
		 AdvClient t=new AdvClient();

		//t.getjson();
		 t.putjson();
		 
	}

	  private static URI getBaseURI() {
	   // return UriBuilder.fromUri("http://10.1.5.3:8080/de.vogella.jersey.todo").build();
		  return UriBuilder.fromUri("http://localhost:8080/AdvertismentEngine").build();
	  }
	  
	public void getjson() {
		
		System.out.println(" ------- Advertisment JSON REST client ----------" );
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());

	    String s = service.path("advertisement").path("advertise").accept(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(" s : "+s );

        /*
 	    *Simple Json Object formating
 	  */
        
        try{
        	JSONObject  jsonObject = new JSONObject(s);
        	
        	JSONArray msg = (JSONArray) jsonObject.get("todo");
    	
    		for(int i=0;i<msg.length();i++) {
    			System.out.println("----"+msg.getJSONObject(i));
    			System.out.println(msg.getJSONObject(i).getString("id"));
    			System.out.println(msg.getJSONObject(i).getString("description"));
    			System.out.println(msg.getJSONObject(i).getString("summary"));
    		}
        	
        	
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    

	}
	
	public void putjson(){
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    WebResource service = client.resource(getBaseURI());
	    
	    // create one todo
	    Adv todo = new Adv("macdonel", "http://localhost:8080/TCSWebRTCSolution_Test/advertisment/video/Apple%20-%20iPhone%205c%20-%20Designed%20Together.mp4" ,"apple advertismkent");
	    
	    ClientResponse response = service.path("advertisment").path("advertise")
	        .path(todo.getId()).accept(MediaType.APPLICATION_JSON)
	        .put(ClientResponse.class, todo);
	    
	    // Return code should be 201 == created resource
	    System.out.println("status : "+ response.getStatus());
	}
	

	
}
