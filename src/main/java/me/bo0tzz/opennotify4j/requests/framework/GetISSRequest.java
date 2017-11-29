package me.bo0tzz.opennotify4j.requests.framework;

import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.Map;
import java.util.function.Consumer;

public abstract class GetISSRequest<T> extends AbstractISSRequest<T> {

    private final Map<String, String> queryParams;

    protected GetISSRequest(String endpoint, Consumer callback, Class callbackType, Map<String, String> queryParams) {
        super(endpoint, callback, callbackType);
        this.queryParams = queryParams;
    }

    @Override
    public Request getRequest() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL + endpoint).newBuilder();
        queryParams.forEach((k, v) -> urlBuilder.addQueryParameter(k, v));
        return new Request.Builder().url(urlBuilder.build()).build();
    }
}
