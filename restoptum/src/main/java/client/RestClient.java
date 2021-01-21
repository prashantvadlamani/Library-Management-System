package client;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




import model.User;



public class RestClient {
	private static final String REST_URI ="http://localhost:8080/restoptum";
	private static Client client=ClientBuilder.newClient();
	
	public static void main(String []args)
	{
		doGet();
	}
	
	public static void doGet()
	{
		WebTarget webTarget = client.target(REST_URI);
		
		WebTarget userWebTarget = webTarget.path("rest/userInfo/1");
		
		Invocation.Builder invocationBuilder = userWebTarget.request(MediaType.APPLICATION_JSON);
		
		Response response=invocationBuilder.get();
		
		User user =response.readEntity(User.class);
		
		System.out.println(user.getName());
		
		System.out.println("-----------");
		
		WebTarget usersWebTarget = webTarget.path("rest/userInfo/");
		
		invocationBuilder =usersWebTarget.request(MediaType.APPLICATION_JSON);
		
		String resp =invocationBuilder.get(String.class);
		System.out.println(resp);
		
		System.out.println("----------------------");
		
		JsonReader reader = Json.createReader(new StringReader(resp));
		JsonArray array = reader.readArray();
		array.forEach(e-> System.out.println(e));
		
		System.out.println("----------------");
		
		for(int i=0;i<array.size();i++)
		{
			JsonObject o=array.getJsonObject(i);
			System.out.println(o.get("name"));
		}
	}
}
