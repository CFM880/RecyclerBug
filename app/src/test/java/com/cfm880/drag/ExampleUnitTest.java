package com.cfm880.drag;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends WebSocketListener {
    @Test
    public void addition_isCorrect() throws Exception {
        OkHttpClient client = new  OkHttpClient.Builder().readTimeout(0, TimeUnit.MICROSECONDS).build();
        Request request = new Request.Builder()
                .url("ws://echo.websocket.org")
                .build();
        client.newWebSocket(request,this);
        client.dispatcher().executorService().shutdown();
    }
}