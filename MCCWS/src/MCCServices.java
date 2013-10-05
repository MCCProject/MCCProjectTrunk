

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;

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
     * @return an instance of String
     * @throws IOException 
     */
//    @GET
//    @Produces("application/json")
//    public String getJson() {
//        // TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
    //{20.333, 44.55}
    @GET
    @Produces("application/x-javascript")
    @Path("currentPath/{username}")
    public JSONWithPadding sayHello (@QueryParam("callback") String callback,
                                 @PathParam("username") String username) throws IOException {
       
    	String current = "";
		try {
			current = new java.io.File( "." ).getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        String currentDir = System.getProperty("user.home");

        
     // The name of the file to open.
        String fileName = "/home/idcuser/HadoopOutput/testfile.txt";

        // This will reference one line at a time
        String line = null;
        String text = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                text = text + line;
            }	

            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
           text = "file reading has failed";
        }
        
    	JSONObject json = new JSONObject();
    	json.put("Current Dir", current);
    	json.put("Current dir using System", currentDir);
    	json.put("text", text);
    	String output = json.toString();
    
        return new JSONWithPadding(output,callback);
    }
    /**
     * PUT method for updating or creating an instance of MCCServices
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

}