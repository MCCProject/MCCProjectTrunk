package GooglePlaceAPI;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class GoogleMapper {
    @SerializedName("debug_info")
    private List<String> debug_info;

    @SerializedName("html_attributions")
    private List<String> html_attributions;

    @SerializedName("next_page_token")
    private String next_page_token;

    @SerializedName("results")
    private List<Results> results;

    @SerializedName("status")
    private String status;

}
