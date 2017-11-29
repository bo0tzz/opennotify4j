package me.bo0tzz.opennotify4j.requests;

import lombok.Builder;
import me.bo0tzz.opennotify4j.api.ISSPeople;
import me.bo0tzz.opennotify4j.requests.framework.AbstractISSRequest;

import java.util.function.Consumer;

public class ISSPeopleRequest extends AbstractISSRequest<ISSPeople> {

    @Builder
    protected ISSPeopleRequest(Consumer<ISSPeople> callback) {
        super("astros.json", callback, ISSPeople.class);
    }

}
