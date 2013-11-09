package GooglePlaceAPI;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results {
	@SerializedName("geometry")
	private Geometry geometry;

	@SerializedName("icon")
	private String icon;

	@SerializedName("id")
	private String id;

	@SerializedName("name")
	private String name;
	
	@SerializedName("opening_hours")
	private OpeningHours opening_hours;

	@SerializedName("photos")
	private Photos photos;
	
	@SerializedName("price_level")
	private int price_level;

	@SerializedName("reference")
	private String reference;
	   
	@SerializedName("rating")
	private Double rating;

	@SerializedName("types")
	private List<String> types;

	@SerializedName("vicinity")
	private String vicinity;
}
