
public class restaurant {

	public double lat;
	double lng;
	String name;
	double rating;
	String addr;
	double distance;
	
	public restaurant(){
		lat = 0;
		lng = 0;
		name = "";
		rating = 0;
		addr = "";
		distance =0;
	}
	
	public restaurant(double t, double g, String n, double r, String d){
		lat = t;
		lng = g;
		name = n;
		rating = r;
		addr = d;
	}
	
	public String toString(){
		return name + "   " + lat + "   " + lng + "   " + rating + "   " + addr;
	}
	
	public void setLat(double lat){
		this.lat = lat;
	}
	
	public double getLat(){
		return lat;
	}
	
	public void setLng(double lng){
		this.lng = lng;
	}
	
	public double getLng(){
		return lng;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setRating(double rating){
		this.rating = rating;
	}
	
	public double getRating(){
		return rating;
	}

	public void setAddr(String addr){
		this.addr = addr;
	}
	
	public String getAddr(){
		return addr;
	}
	
	public void setDistance(double distance){
		this.distance = distance;
	}
	
	public double getDistance(){
		return distance;
	}

}
