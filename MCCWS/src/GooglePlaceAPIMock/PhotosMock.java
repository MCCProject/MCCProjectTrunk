package GooglePlaceAPIMock;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class PhotosMock {
    @SerializedName("height")
    private int height;
    
    @SerializedName("html_attributions")
    private List<String> html_attributions;

    @SerializedName("photo_reference")
    private String photo_reference;
    
    @SerializedName("width")
    private int width;
    
    public PhotosMock(int height, List<String> html_attributions, 
            String photo_reference, int width)    
    {
        this.height = height;
        this.html_attributions = html_attributions;
        this.photo_reference = photo_reference;
        this.width = width;
    }
}
