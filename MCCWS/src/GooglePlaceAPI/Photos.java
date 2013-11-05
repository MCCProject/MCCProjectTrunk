package GooglePlaceAPI;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class Photos {
    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    @SerializedName("html_attributions")
    private List<String> html_attributions;

    @SerializedName("photo_reference")
    private String photo_reference;
}
