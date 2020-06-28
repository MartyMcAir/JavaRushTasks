package com.javarush.task.task40.task4001;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* 
POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
//        solution.sendPost(new URL("http://requestb.in/1cse9qt1"), "name=zapp&mood=good&locale=&id=777");
        solution.sendPost(new URL("https://entef5b4lpx1.x.pipedream.net"), "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(URL url, String urlParameters) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

//        connection.setRequestMethod("GET");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true); /// added

        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        // этот бок ниже не сработает без setDoOutput(true)
        // Add Parameter like Bite Code _ это самый правильный вариант отправки контента через Post
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            wr.write(postData);
        }    ///  added

        // Еще вариант отправки параметра
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
//        bufferedWriter.write(urlParameters);
//        bufferedWriter.close();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String responseLine;
        StringBuilder response = new StringBuilder();

        while ((responseLine = bufferedReader.readLine()) != null) {
            response.append(responseLine);
        }
        bufferedReader.close();

        System.out.println("Response: " + response.toString());
    }
}
