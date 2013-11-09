package GooglePlaceAPIMock;

import com.google.gson.annotations.SerializedName;

public class LocationMock {
	@SerializedName("lat")
	private Double lat;

	@SerializedName("lng")
	private Double lng;
	
	public LocationMock(Double lat, Double lng)
	{
	    this.lat = lat;
	    this.lng = lng;
	}
}
