import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.ParseException;
import org.apache.http.client.utils.URIBuilder;

import com.google.gson.Gson;
import com.map.Response;
import com.map.Result;


public class GooglePlacesClient {
	private static final String GOOGLE_API_KEY = "AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic";

	//private final HttpClient client = new DefaultHttpClient();

	public Result[] performSearch(final String types, final double lon,
			final double lat) throws ParseException, IOException,
			URISyntaxException, java.text.ParseException {
		final URIBuilder builder = new URIBuilder().setScheme("https")
				.setHost("maps.googleapis.com")
				.setPath("/maps/api/place/search/json");

		builder.addParameter("location", lon + "," + lat);
		builder.addParameter("types", types);
		builder.addParameter("rankby", "distance");
		builder.addParameter("sensor", "true");
		builder.addParameter("key", GooglePlacesClient.GOOGLE_API_KEY);
		 
		Result[] results = null;
	        try{
	            String jsonData = getData(builder.toString());
	            Gson gson = new Gson();
	            
	            Response apiResponse = gson.fromJson(jsonData, Response.class);
	            if(apiResponse!=null){
	                results = apiResponse.getResults();
	            }    
	        }catch(Exception exe){
	            System.out.println("Exception occured "+exe);
	        }
	        return results;
	    }
		
/*
 * Reads and returns the data as string from the url
 */
	public String getData(String address)throws Exception{
	    StringBuffer data = new StringBuffer();
	    if(address != null){
	        URL url = new URL(address);
	        URLConnection connection  = url.openConnection();
	        
	        InputStream inputStream = connection.getInputStream();
	        byte[] readBuffer = new byte[1024];
	        int len = 0;
	        while((len = inputStream.read(readBuffer))!=-1){
	            data.append(new String(readBuffer,0,len));
	        }
	        
	    }
	    
	    return data.toString();
	    
	}

}
