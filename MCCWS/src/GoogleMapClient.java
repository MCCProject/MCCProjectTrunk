

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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




public class GoogleMapClient {

	private static final String GOOGLE_API_KEY = "AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic";

	private final HttpClient client = new DefaultHttpClient();
	
	public void PutDistanceInLocs(List<LocationCount> locs, double latitude, double longitude) {
		for(LocationCount loc : locs)
		{
			for(Place rest : loc.locations)
			{
				rest.Distance = new Distance().getDistanceBetween2Locs(latitude, rest.latitude, longitude, rest.longtide);
			}
		}
	}

	
}
