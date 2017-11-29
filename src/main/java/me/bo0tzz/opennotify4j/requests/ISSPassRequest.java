package me.bo0tzz.opennotify4j.requests;

import me.bo0tzz.opennotify4j.api.ISSPass;
import me.bo0tzz.opennotify4j.requests.framework.GetISSRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ISSPassRequest extends GetISSRequest<ISSPass> {

    protected ISSPassRequest(Consumer<ISSPass> callback, Map<String, String> queryParams) {
        super("iss-pass.json", callback, ISSPass.class, queryParams);
    }

    public static ISSPassRequest.Builder builder() {
        return new ISSPassRequest.Builder();
    }

    public static class Builder {

        private Map<String, String> queryParams = new HashMap<>();
        private Consumer<ISSPass> callback;

        private Builder() {

        }

        public Builder callback(Consumer<ISSPass> callback) {
            this.callback = callback;
            return this;
        }

        public Builder latitude(Float latitude) {
            if (latitude < -90 || latitude > 90) throw new IllegalArgumentException("Latitude must be between -90.0 and +90.0!");
            queryParams.put("lat", latitude.toString());
            return this;
        }

        public Builder longitude(Float longitude) {
            if (longitude < -180 || longitude > 180) throw new IllegalArgumentException("Longitude must be between -90.0 and +90.0!");
            queryParams.put("lon", longitude.toString());
            return this;
        }

        public Builder altitude(Float altitude) {
            if (altitude < 0 || altitude > 10000) throw new IllegalArgumentException("Altitude must be between 0.0 and 10000.0!");
            queryParams.put("alt", altitude.toString());
            return this;
        }

        public Builder count(Integer count) {
            queryParams.put("n", count.toString());
            return this;
        }

        public ISSPassRequest build() {
            return new ISSPassRequest(callback, queryParams);
        }

    }

}
