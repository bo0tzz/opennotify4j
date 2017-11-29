package me.bo0tzz.opennotify4j.requests.framework;

import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractISSRequest<T> implements ISSRequest<T> {

    public static String API_URL = "http://api.open-notify.org/";
    protected static final Gson GSON = new Gson();
    private static final OkHttpClient client = new OkHttpClient();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    protected final String endpoint;
    protected final Consumer<T> callback;
    protected final Class<T> callbackType;

    @Override
    public Request getRequest() {
        return new Request.Builder()
                .url(API_URL + endpoint)
                .build();
    }

    protected String getBody(Response response) throws IOException {
        return response == null ? null : response.body().string();
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public void handleResponse(Response response) throws IOException {
        String body = getBody(response);

        if (body != null && callback != null) {
            callback.accept(GSON.fromJson(body, callbackType));
        }
    }

    public void perform() {
        executorService.submit(() -> {
            try {
                Response response = client.newCall(getRequest()).execute();

                handleResponse(response);
            } catch (IOException e) {
                //handle it maybe?
            }
        });
    }
}
