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

	@SerializedName("photos")
	private Photos photos;

	@SerializedName("rating")
	private Double rating;

	@SerializedName("reference")
	private String reference;

	@SerializedName("types")
	private List<String> types;

	@SerializedName("vicinity")
	private String vicinity;
}
