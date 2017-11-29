package me.bo0tzz.opennotify4j.requests.framework;

public interface ISSRequest<T> {

    String getEndpoint();

    void perform();
}
