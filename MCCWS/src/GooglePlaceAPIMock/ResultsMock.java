package GooglePlaceAPIMock;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsMock {
	@SerializedName("geometry")
	private GeometryMock geometryMock;

	@SerializedName("icon")
	private String icon;

	@SerializedName("id")
	private String id;

	@SerializedName("name")
	private String name;
	
	@SerializedName("opening_hours")
	private OpeningHoursMock opening_hours;

	@SerializedName("photos")
	private PhotosMock photos;
	
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
	
	public ResultsMock(GeometryMock geometryMock, String icon, String id,
	        String name, OpeningHoursMock opening_hours, PhotosMock photosMock,
	        int price_level, String reference, Double rating, String vicinity)
	{
	    this.geometryMock = geometryMock;
	    this.icon = icon;
	    this.id = id;
	    this.name = name;
	    this.opening_hours = opening_hours;
	    this.photos = photosMock;
	    this.price_level = price_level;
	    this.reference = reference;
	    this.rating = rating;
	    this.vicinity = vicinity;
	}
}
