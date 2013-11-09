import java.io.File;
import static java.lang.Math.*; 
import java.io.FileNotFoundException;
import java.util.Scanner;


public class findRest {

	/*public static void main(String[] args) {
	
		double latitude = 0;
		double longitude = 0;
		
		findClosestRests(latitude, longitude);
		

	}*/
	
	

	
	
	public static restaurant [] findClosestRests(double latitude, double longitude){
		
		restaurant[] closestRest = new restaurant[3];
		File file = new File("RestaurantsList.txt");

		int counter = 0;		
		String tempString;
		
		restaurant[] restaurants = new restaurant[200];
		  
		
		
		/// READING THE INPUT FILE AND STORE RESTAURANTS INFO 
		/// AND CALCULATE THE DISTANCE BETWEEN THE POINTS 
		
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
            	tempString = scanner.nextLine();
            	
            	String delims = "[|]";
            	String[] tokens = tempString.split(delims);
            	double distance = 0;
            	
            	restaurants[counter] = new restaurant(Double.parseDouble(tokens[0]), 
            			Double.parseDouble(tokens[1]), 
            			tokens[2], Double.parseDouble(tokens[3]), tokens[4]);
            	
            	
            	// Calculating the distance 
            	
            	double x = latitude - restaurants[counter].getLat();
            	double y = longitude - restaurants[counter].getLng();
            	
            	double xs = x * x;
            	double sy = y * y;
            	
            	distance = sqrt(xs + sy);
            	
            	restaurants[counter].setDistance(distance);
            	
            	counter++;
               
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        ///Create three restaurants to store info of the closest rest
        
        restaurant[] closest3Rest = new restaurant[3];
        
        for (int z = 0; z < 3; z++){
        	
        	closest3Rest[z] = new restaurant();
        	
        	closest3Rest[z].setDistance(999999);
        	
        	//System.out.println(closest3Rest[z]);
        	
        }
        
        
        
        ///Finding the closest restaurants
        
        for (int w = 0; w < counter; w++){
        	
        	//if new is less than first restaurant
        	if (restaurants[w].getDistance() < closest3Rest[0].getDistance()){
        		
        		// second become third
        		closest3Rest[2].setLat(closest3Rest[1].getLat());
        		closest3Rest[2].setLng(closest3Rest[1].getLng());
        		closest3Rest[2].setName(closest3Rest[1].getName());
        		closest3Rest[2].setRating(closest3Rest[1].getRating());
        		closest3Rest[2].setAddr(closest3Rest[1].getAddr());
        		closest3Rest[2].setDistance(closest3Rest[1].getDistance());
        		
        		
        		//first become second
        		closest3Rest[1].setLat(closest3Rest[0].getLat());
        		closest3Rest[1].setLng(closest3Rest[0].getLng());
        		closest3Rest[1].setName(closest3Rest[0].getName());
        		closest3Rest[1].setRating(closest3Rest[0].getRating());
        		closest3Rest[1].setAddr(closest3Rest[0].getAddr());
        		closest3Rest[1].setDistance(closest3Rest[0].getDistance());
        		
        		//new become first
        		closest3Rest[0].setLat(restaurants[w].getLat());
        		closest3Rest[0].setLng(restaurants[w].getLng());
        		closest3Rest[0].setName(restaurants[w].getName());
        		closest3Rest[0].setRating(restaurants[w].getRating());
        		closest3Rest[0].setAddr(restaurants[w].getAddr());
        		closest3Rest[0].setDistance(restaurants[w].getDistance());
        		
        	}
        	
        	
        	//if larger than the first
        	else{
        	
        		
        		////if less than the second
        		if (restaurants[w].getDistance() < closest3Rest[1].getDistance()){
        			
        			// second become third
            		closest3Rest[2].setLat(closest3Rest[1].getLat());
            		closest3Rest[2].setLng(closest3Rest[1].getLng());
            		closest3Rest[2].setName(closest3Rest[1].getName());
            		closest3Rest[2].setRating(closest3Rest[1].getRating());
            		closest3Rest[2].setAddr(closest3Rest[1].getAddr());
            		closest3Rest[2].setDistance(closest3Rest[1].getDistance());
            		
            		//new become second
            		closest3Rest[1].setLat(restaurants[w].getLat());
            		closest3Rest[1].setLng(restaurants[w].getLng());
            		closest3Rest[1].setName(restaurants[w].getName());
            		closest3Rest[1].setRating(restaurants[w].getRating());
            		closest3Rest[1].setAddr(restaurants[w].getAddr());
            		closest3Rest[1].setDistance(restaurants[w].getDistance());
        		}
        		
        		
        		
        		///if larger than the second
        		else{
        			
        			
        			///if less than the third
        			if (restaurants[w].getDistance() < closest3Rest[2].getDistance()){
        		
        				//new become third
                		closest3Rest[2].setLat(restaurants[w].getLat());
                		closest3Rest[2].setLng(restaurants[w].getLng());
                		closest3Rest[2].setName(restaurants[w].getName());
                		closest3Rest[2].setRating(restaurants[w].getRating());
                		closest3Rest[2].setAddr(restaurants[w].getAddr());
                		closest3Rest[2].setDistance(restaurants[w].getDistance());
        
        			}
        		}
        	}
        	
        	
        	
        }
        
        
   
        //print the result
        /*for (int n = 0; n < 3; n++){
        	
        
        	System.out.println(closest3Rest[n].toString());
        
        }*/
		
		return closest3Rest;
	}

}
