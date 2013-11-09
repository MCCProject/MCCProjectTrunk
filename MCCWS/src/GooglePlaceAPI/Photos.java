package GooglePlaceAPI;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class Photos {
    @SerializedName("height")
<<<<<<< HEAD
    public int height;

    @SerializedName("width")
    public int width;

=======
    private int height;
    
>>>>>>> 6f2dcddc62bf2d2b9e904dfb2b40c674a91dfe6c
    @SerializedName("html_attributions")
    public List<String> html_attributions;

    @SerializedName("photo_reference")
<<<<<<< HEAD
    public String photo_reference;
=======
    private String photo_reference;
    
    @SerializedName("width")
    private int width;
>>>>>>> 6f2dcddc62bf2d2b9e904dfb2b40c674a91dfe6c
}
