package GooglePlaceAPIMock;

import com.google.gson.annotations.SerializedName;

public class GeometryMock {
	@SerializedName("location")
	private LocationMock location;
	
	public GeometryMock(LocationMock location)
	{
	    this.location = location;
	}
}
