package GooglePlaceAPIMock;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class GoogleMapperMock {
    @SerializedName("debug_info")
    private List<String> debug_info;

    @SerializedName("html_attributions")
    private List<String> html_attributions;

    @SerializedName("next_page_token")
    private String next_page_token;

    @SerializedName("results")
    private List<ResultsMock> results;

    @SerializedName("status")
    private String status;
    
    public GoogleMapperMock(List<String> debug_info, List<String> html_attributions,
            String next_page_token, List<ResultsMock> results, String status)
    {
        this.debug_info = debug_info;
        this.html_attributions = html_attributions;
        this.next_page_token = next_page_token;
        this.results = results;
        this.status = status;
    }
}
