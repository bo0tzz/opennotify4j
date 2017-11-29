package me.bo0tzz.opennotify4j.requests;

import lombok.Builder;
import me.bo0tzz.opennotify4j.api.ISSLocation;
import me.bo0tzz.opennotify4j.requests.framework.AbstractISSRequest;

import java.util.function.Consumer;

public class ISSLocationRequest extends AbstractISSRequest<ISSLocation> {

    @Builder
    protected ISSLocationRequest(Consumer<ISSLocation> callback) {
        super("iss-now.json", callback, ISSLocation.class);
    }

}
