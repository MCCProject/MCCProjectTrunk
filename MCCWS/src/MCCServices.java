
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.apache.http.ParseException;
import org.json.JSONObject;
import org.apache.http.HttpResponse;
import com.sun.jersey.api.json.JSONWithPadding;

@Path("mccservices")
public class MCCServices {
	@SuppressWarnings("unused")
	@Context
	private UriInfo context;

	/**
	 * Default constructor.
	 */
	public MCCServices() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retrieves representation of an instance of MCCServices
	 * 
	 * @return an instance of String
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	// @GET
	// @Produces("application/json")
	// public String getJson() {
	// // TODO return proper representation object
	// throw new UnsupportedOperationException();
	// }
	// {20.333, 44.55}
	@GET
	@Produces("application/x-javascript")
	@Path("currentPath/{gpsLocation}")
	public JSONWithPadding GetLocationInfo(
			@QueryParam("callback") String callback,
			@PathParam("gpsLocation") String gpsLocation) throws IOException,
			ParseException, URISyntaxException {

//		String current = "";
//		try {
//			current = new java.io.File(".").getCanonicalPath();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String currentDir = System.getProperty("user.home");
//
//		// The name of the file to open.
//		String fileName = "/home/idcuser/HadoopOutput/testfile.txt";
//
//		// This will reference one line at a time
//		String line = null;
//		String text = "";
//
//		try {
//			// FileReader reads text files in the default encoding.
//			FileReader fileReader = new FileReader(fileName);
//
//			// Always wrap FileReader in BufferedReader.
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//			while ((line = bufferedReader.readLine()) != null) {
//				text = text + line;
//			}
//
//			// Always close files.
//			bufferedReader.close();
//		} catch (FileNotFoundException ex) {
//			text = "file reading has failed";
//		}
		String[] lngLat = gpsLocation.split(",");
		JSONObject json = new JSONObject();
		try {
			json.put("Longitute:", lngLat[0]);
			json.put("Latitute:", lngLat[1]);

			if (lngLat[0] != null && lngLat[1] != null) {
				
				 HttpResponse response = new GooglePlacesClient().performSearch(
						"establishment", Double.parseDouble(lngLat[0]),
						Double.parseDouble(lngLat[1]));
				//json.put("places", places);
				
				 List<LocationCount> locations = new ArrayList<LocationCount>();
				 List<Place> places = new ArrayList<Place>();
//				 for(Place p : places)
//				 {
//					 
//				 }
//				 //put into file, kick off jar
//				 for(LocationCount lc : locations)
//				 {
//					 
//				 }
//				 //put in json and send back
			}
		} catch (Exception ex) {
			json.put("exception", ex.toString());
		}
		return new JSONWithPadding(json.toString(), callback);
	}

	/**
	 * PUT method for updating or creating an instance of MCCServices
	 * 
	 * @param content
	 *            representation for the resource
	 * @return an HTTP response with content of the updated or created resource.
	 */
	@PUT
	@Consumes("application/json")
	public void putJson(String content) {
	}

}