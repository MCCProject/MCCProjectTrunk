import static java.lang.Math.sqrt;


public class Distance {
	
	public static double getDistanceBetween2Locs(double lat1, double lat2, double lng1, double lng2)
	{
		//calculate between lat1, lng1 to lat2 lng2
		double theDistance = 0;
		
		double latDiff = lat1 - lat2;
    	double lngDiff = lng1 - lng2;
    	
    	double latDiffSquare = latDiff * latDiff;
    	double lngDiffSquare = lngDiff * lngDiff;
    	
    	theDistance = sqrt(latDiffSquare + lngDiffSquare);
    	
		
		return theDistance;
	}

}
