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
	public String name;

	@SerializedName("photos")
	public Photos photos;

	@SerializedName("rating")
	public Double rating;

	@SerializedName("reference")
	public String reference;

	@SerializedName("types")
	public List<String> types;

	@SerializedName("vicinity")
	public String vicinity;
}
