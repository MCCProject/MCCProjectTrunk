package com.map;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

/**
 * Sample JSON Parser
 * @author josephpr
 *
 */
public class MapParser {
    
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
    
    public static void main(String args[]){
        String address = "https://maps.googleapis.com/maps/api/place/search/json?location=8.0%2C39.0997&radius=5000&types=establishment&sensor=true&key=AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic"; 
        MapParser parser = new MapParser();
        try{
            String jsonData = parser.getData(address);
            Gson gson = new Gson();
            
            Response apiResponse = gson.fromJson(jsonData, Response.class);
            if(apiResponse!=null){
                Result[] results = apiResponse.getResults();
                System.out.println(results[0].icon);
            }    
        }catch(Exception exe){
            System.out.println("Exception occured "+exe);
        }
    }

}
