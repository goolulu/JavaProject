package com.example.demo;

import okhttp3.*;
import okhttp3.Request.Builder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void foreachInsert(){
        try {
            URL url = new URL("http://localhost:9092/e");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            InputStream in;
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8");
            char[] a = new char[1000];
            int k;
            String b = "";
            while ((k = inputStreamReader.read(a, 0, 1000)) != -1) {
                b += String.valueOf(a, 0, k);
            }
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void batchInsert(){
        try {
            URL url = new URL("http://localhost:9092/f");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            InputStream in;
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8");
            char[] a = new char[1000];
            int k;
            String b = "";
            while ((k = inputStreamReader.read(a, 0, 1000)) != -1) {
                b += String.valueOf(a, 0, k);
            }
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCursor() {
        try {
            URL url = new URL("http://localhost:9092/Cursor");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(),"UTF-8");
            char[] a = new char[1000];
            int k;
            String b = "";
            while ((k = inputStreamReader.read(a, 0, 1000)) != -1) {
                b += String.valueOf(a, 0, k);
            }
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void yuio() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Builder().url("http://localhost:9092/b").build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response.body().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
