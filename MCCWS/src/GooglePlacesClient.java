

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import GooglePlaceAPI.GoogleMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GooglePlacesClient {
	private static final String GOOGLE_API_KEY = "AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic";

	private final HttpClient client = new DefaultHttpClient();

	public HttpResponse performSearch(final String types, final double lon,
			final double lat) throws ParseException, IOException,
			URISyntaxException {
		final URIBuilder builder = new URIBuilder().setScheme("https")
				.setHost("maps.googleapis.com")
				.setPath("/maps/api/place/search/json");

		builder.addParameter("location", lat + "," + lon);
		builder.addParameter("radius", "5000");
		builder.addParameter("types", types);
		builder.addParameter("sensor", "true");
		builder.addParameter("key", GooglePlacesClient.GOOGLE_API_KEY);

		final HttpUriRequest request = new HttpGet(builder.build());

		final HttpResponse response = this.client.execute(request);

		Gson gson = new GsonBuilder().serializeNulls().create();
	    String json = gson.toJson(response.getEntity());

	    gson.fromJson(json, GoogleMapper.class);
		return response;
	}

}
