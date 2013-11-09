package GooglePlaceAPI;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Results {
	@SerializedName("geometry")
	public Geometry geometry;

	@SerializedName("icon")
	public String icon;

	@SerializedName("id")
	public String id;

	@SerializedName("name")
<<<<<<< HEAD
	public String name;

	@SerializedName("photos")
	public Photos photos;

	@SerializedName("rating")
	public Double rating;

	@SerializedName("reference")
	public String reference;
=======
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
>>>>>>> 6f2dcddc62bf2d2b9e904dfb2b40c674a91dfe6c

	@SerializedName("types")
	public List<String> types;

	@SerializedName("vicinity")
	public String vicinity;
}
