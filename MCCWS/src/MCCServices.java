import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.StringBuilder;
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

import com.custom.SearchResult;
import com.custom.Business;
import com.google.gson.Gson;
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
			ParseException, URISyntaxException, FileNotFoundException {

		String[] lngLat = gpsLocation.split(",");
		JSONObject json = new JSONObject();
		BufferedWriter bw = null;
		try 
		{
			if (lngLat[0] != null && lngLat[1] != null) 
			{
				SearchResult result = CallYelp(Float.parseFloat(lngLat[0]),Float.parseFloat(lngLat[1]) );
				StringBuilder sb = new StringBuilder(); 
				if(result != null)
				{
					 for(Business b : result.getBusinesses())
					 {
						 for(String[] cats : b.getCategories())
						 { 
							 if(cats != null)
							 {
								 sb.append(b.getName() + ";");
								 sb.append(b.getRating() + ";");
								 sb.append(b.getDistance()/1609 + ";");
								 sb.append(b.getLocation().GetFullAddress() + ";");	
								 sb.append(cats[0] + ";");
								 sb.append(b.getDisplay_phone() +";");
								 sb.append(b.getMobile_url() + "\n");
							 }
						 }
					 }
				 }
			  	String fileName = "/home/idcuser/HadoopOutput/rsinput.txt";
			  
		        File file = new File(fileName);
		        bw = new BufferedWriter(new FileWriter(file));
		        if (!file.exists()) 
		        {
		        	file.createNewFile();
		        }
		        
		        bw.write(sb.toString());
		        
		        //Sort by Cusine in Hadoop/hive
				Process process = Runtime.getRuntime().exec ("sh /home/idcuser/sortRes.sh ");
				Thread.sleep(3000);
				
				// FileReader reads text files in the default encoding.
				//String fileName2 = System.getProperty("user.home") + "\\rsinput2.txt";
				String fileName2 = "/home/idcuser/hive-output1/000000_0";
				FileReader fileReader = new FileReader(fileName2);

				// Always wrap FileReader in BufferedReader.
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line = null;

				List<LocationCount> locations = new ArrayList<LocationCount>();
				
				while ((line = bufferedReader.readLine()) != null) {
					AddToLocationList(locations, line);
				}

				// Always close files.
				bufferedReader.close();
				
				//SortPlacesByDistance(locations);
				
				Gson gson = new Gson();
				//json.put("result:", sb.toString());
				json.put("result:", gson.toJson(locations));
			}

		} catch (Exception ex) {
			json.put("exception", ex.toString());
		}
		finally {
			bw.close();
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
	
	/// CLI
	public static SearchResult CallYelp(float lng, float lat) {
		// Update tokens here from Yelp developers site, Manage API access.
		String consumerKey = "_oqBFA2ewqgim_NY4GMYEg";
		String consumerSecret = "YfsuMQvnDBg6tpwZ8XimRYqKMpg";
		String token = "FTX_s5Fbnx46MOn645MuEtcqEvtkhUad";
		String tokenSecret = "FLt8xE2sK38ivZ-roCUMkrXrRjg";
		
		Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
		String response = yelp.search("food", lng, lat);
		
		System.out.println(response);
		Gson gson = new Gson();
		return gson.fromJson(response, SearchResult.class);
	  }
	  
	public static boolean IsStringSame(String a, String b)
	{
		if(a == null || b == null)
		{
			return false;
		}
		return a.replace(" ", "").equalsIgnoreCase(b.replace(" ", ""));

	}

	public static boolean IsStringsHas(List<String> ls, String str)
	{
		if(ls == null ||str == null)
		{
			return false;
		}
		for(String s : ls)
		{
			if(IsStringSame(s, str))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void SortPlacesByDistance(List<LocationCount> lcs)
	{
		for(LocationCount lc : lcs)
		{
			Collections.sort(lc.Locations, COMPARATOR);
		}
	}
   
	private static Comparator<Place> COMPARATOR = new Comparator<Place>()
    {
    // This is where the sorting happens.
        public int compare(Place p1, Place p2)
        {
        	double d = p1.Distance - p2.Distance;
        	if(d > 0)
        	{
        		return 1;
        	}
        	else
        	{
        		return -1;
        	}
        }
    };
    
    public static void AddToLocationList(List<LocationCount> lcs, String place)
    {
    	if(!place.isEmpty())
    	{
    		String[] p = place.split("\1");
    		if(p.length >= 7)
    		{
    			LocationCount lc = null;
    			boolean addLc = false;
    	    	if(lcs.size() < 1)
    	    	{
    	    		addLc = true;
    	    	}
    	    	else
    	    	{
    	    		if(IsStringSame(lcs.get(lcs.size() - 1).Cusine, p[4]))
    	    		{
    	    			lc = lcs.get(lcs.size() - 1);
    	    		}
    	    		else
    	    		{
    	    			addLc = true;
    	    		}
    	    	}
    	    	if (addLc)
    	    	{
	    			lc = new LocationCount();
	    			lc.Cusine = p[4];
	    			lc.Locations = new ArrayList<Place>();
	    			lcs.add(lc);
    	    	}
    	    	lc.Locations.add(new Place(p[0], p[1], Float.parseFloat(p[2]), p[3], p[4], p[5], p[6]));
    	    	//lc.Locations.add(new Place(p[0], p[1], Float.parseFloat(p[2]), p[3], p[4]));
    	    	lc.NumOfLocations = lc.Locations.size();
    		}
    	}
    	
    }
	public static void AddToLocationList(List<LocationCount> lcs, Place place)
	{
		if( place != null)
		{
			boolean isNew = true;
			if(lcs == null)
			{
				lcs = new ArrayList<LocationCount>();
			}
			for(LocationCount lc : lcs)
			{
				if(IsStringSame(lc.Cusine, place.Cusine))
				{
					lc.Locations.add(place);
					isNew = false;
				}
			}
			if(isNew)
			{
				LocationCount lc = new LocationCount();
				lc.Locations = new ArrayList<Place>();
				lc.Locations.add(place);
				lc.Cusine = place.Cusine;
				lcs.add(lc);
			}
		}
	}	
}