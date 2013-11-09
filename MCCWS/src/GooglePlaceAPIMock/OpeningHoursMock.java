package GooglePlaceAPIMock;

import com.google.gson.annotations.SerializedName;

public class OpeningHoursMock
{
    @SerializedName("open_now")
    private boolean open_now;
    
    public OpeningHoursMock(boolean open_now)
    {
        this.open_now = open_now;
    }
}
