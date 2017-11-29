package me.bo0tzz.opennotify4j.bean;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public class Location {

    Float latitude;
    Float longitude;

    @Builder
    protected Location(@NonNull Float latitude, @NonNull Float longitude) {
        if (latitude < -90 || latitude > 90) throw new IllegalArgumentException("Latitude must be between -90.0 and +90.0!");
        if (longitude < -180 || longitude > 180) throw new IllegalArgumentException("Longitude must be between -90.0 and +90.0!");
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
