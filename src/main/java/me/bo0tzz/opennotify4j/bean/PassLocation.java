package me.bo0tzz.opennotify4j.bean;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class PassLocation extends Location {

    Float altitude;
    Integer passes;
    Long datetime;

    @Builder
    protected PassLocation(Float latitude, Float longitude, Float altitude, Integer passes, Long datetime) {
        super(latitude, longitude);
        if (altitude < 0.0 || altitude > 10000.0) throw new IllegalArgumentException("Altitude must be between 0.0 and 10,000.0!");
        this.altitude = altitude;
        this.passes = passes;
        this.datetime = datetime;
    }

    static class PassLocationBuilder extends Location.LocationBuilder {

    }

}
