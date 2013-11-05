package GooglePlaceAPI;

import com.google.gson.annotations.SerializedName;

public class Location {
	@SerializedName("lat")
	private Double lat;

	@SerializedName("lng")
	private Double lng;
}
