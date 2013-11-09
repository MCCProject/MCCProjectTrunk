package GooglePlaceAPIMock;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class GooglePlacesClientMock {
	private static final String GOOGLE_API_KEY = "AIzaSyD8sluaqqEBilKQ6Y5XKn9nbVa75SrFuic";

	private final HttpClient client = new DefaultHttpClient();

	public GoogleMapperMock performSearch()  
	{
	    LocationMock location = new LocationMock(
	            39.0335, 
	            -94.579172);
	    
	    GeometryMock geometry = new GeometryMock(location);
	    
	    OpeningHoursMock openingHours = new OpeningHoursMock(false);
	    
	    PhotosMock photos = new PhotosMock(
	            540, 
	            null, 
	            "CoQBfQAAAFHnspQRiv3AqsN2aqx7y7y3GxF-plAU-T6S52qR2KeIDQxke-EPXImiLNkxl2anaJfL9c-Nbva6AQoF7shxXBrDqJEPYzoc6227Q5bZHXVV1yqTXn4muTWA-sn_cSdc2H5roeR3MFHX7b5W6jvRSEyhyXfUEPvWHeZpIAcDGv_4EhDljz9ex3DJiyXx9WeyoX1sGhSJZ2EzmnidkcCvdGiONe7vTHuKcQ", 
	            720);
	    
	    ResultsMock result = new ResultsMock(
	            geometry, 
	            "http://maps.gstatic.com/mapfiles/place_api/icons/bar-71.png", 
	            "e6651f2a10f96fef41f433fca068310a28df1877", 
	            "Kelly's Westport Inn", 
	            openingHours, 
	            photos, 
	            2, 
	            "CoQBdgAAAJb2KbabkPA0jq9rJxB1m1bspREshkx0jjYvwvSdanc8k3uQKGYBqFZDlaDL85Sza5mpwkwrrai0rExZRN-zZ9xfGx1Qoo89ql_23NGtzEmUFoeU8CxPR0AKmeH1cd5sXc_DqjQUZtvmr2RlQsM5LH-3VTtwi8jKVWSCX88j5Fc-EhAGLGnvTXeWY4EEJNGUgX_KGhTxtcl4enjFitrXEmObuzWJp05XSg", 
	            4.2, 
	            "500 Westport Road, Kansas City");
	    
	    List<ResultsMock> results = new ArrayList<ResultsMock>();
	    results.add(result);
	    
	    GoogleMapperMock mapper = new GoogleMapperMock(
	            null, 
	            null, 
	            "CmRTAAAAPF0OjNCm6CdxuY4AyIemXuuIM4rTkhqtI57sa68FzJlkZXe7xJd1opkqXgzMr_bgk_kV_KOBbZovrDK2jNdKH-lgYo42clyoc6eDjR1mtWd_9iJllBFaI9BbChIa7w-oEhChY69DCZmz97D5CLaRdmCaGhRljl8GxvrvoNIj8CY5xzIwNacJeQ", 
	            results,
	            "OK");
	    	    
		return mapper;
	}
}
