package me.bo0tzz.opennotify4j.api;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import me.bo0tzz.opennotify4j.bean.Location;

@Data
public class ISSLocation extends ISSEvent {

    private final long timestamp;
    @SerializedName("iss_position") private final Location location;

    @Builder
    private ISSLocation(String message, long timestamp, Location location) {
        super(message);
        this.timestamp = timestamp;
        this.location = location;
    }

}
