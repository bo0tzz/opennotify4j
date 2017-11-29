package me.bo0tzz.opennotify4j.requests.framework;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public interface ISSRequest<T> {

    String getEndpoint();

    void handleResponse(Response response) throws IOException;

    Request getRequest();

    void perform();
}
