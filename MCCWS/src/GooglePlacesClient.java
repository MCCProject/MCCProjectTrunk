

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import GooglePlaceAPI.GoogleMapper;
import GooglePlaceAPI.MyHashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GooglePlacesClient {
	private static final String GOOGLE_API_KEY = "AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic";

	private final HttpClient client = new DefaultHttpClient();

	public MyHashMap[] performSearch(final String types, final double lon,
			final double lat) throws ParseException, IOException,
			URISyntaxException, java.text.ParseException {
		final URIBuilder builder = new URIBuilder().setScheme("https")
				.setHost("maps.googleapis.com")
				.setPath("/maps/api/place/search/json");

		builder.addParameter("location", lat + "," + lon);
		builder.addParameter("radius", "5000");
		builder.addParameter("types", types);
		builder.addParameter("sensor", "true");
		builder.addParameter("key", GooglePlacesClient.GOOGLE_API_KEY);

		MyHashMap[] mapper = null;
		final HttpUriRequest request = new HttpGet(builder.build());

		final HttpResponse response = this.client.execute(request);
		if(response != null){
			HttpEntity entity = response.getEntity();
			if (entity != null) {
	
	            // A Simple JSON Response Read
	            InputStream instream = entity.getContent();
	            JSONObject myObject = new JSONObject(convertStreamToString(instream));
	            Gson gson = new Gson();
	            String json = gson.toJson(myObject);
	            GoogleMapper mapper2 = gson.fromJson(json, GoogleMapper.class);
	    	    mapper[0]  = gson.fromJson(json, MyHashMap.class);
			}
			else
			{
				EntityUtils.consume(entity);
			}
		}
		return mapper;
	}
	private static String convertStreamToString(InputStream is) {

	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}

}
