package com.javarush.task.task40.task4002;

//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/* 
Опять POST, а не GET
*/
// Исправь ошибки в методе sendPost, чтобы он отправлял POST-запрос с переданными параметрами.
//Примечание: метод main в тестировании не участвует, но чтобы программа корректно работала локально,
// можешь зайти на любой сайт для создания RequestBin (например, https://requestbin.com/),
// создать там свой RequestBin и использовать его в main.
// https://javarush.ru/tasks/com.javarush.task.task40.task4002#discussion
public class Solution {
//    public static void main(String[] args) throws Exception {
//        Solution solution = new Solution();
//        solution.sendPost("http://requestb.in/1h4qhvv1", "name=zapp&mood=good&locale=&id=777");
//    }
//
//
//    public void sendPost(String url, String urlParameters) throws Exception {
//        HttpClient client = getHttpClient();
//        HttpPost request = new HttpPost(url);
//
//        List<NameValuePair> list = new ArrayList<>();
//        String[] s = urlParameters.split("&");
//        for (String v : s) {
//            list.add(new BasicNameValuePair(v.substring(0, v.indexOf("=")), v.substring(v.indexOf("=") + 1)));
//        }
//
//        request.setEntity(new UrlEncodedFormEntity(list));
//        request.addHeader("User-Agent", "Mozilla/5.0");
//
//        HttpResponse response = client.execute(request);
//
//        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//        StringBuffer result = new StringBuffer();
//        String responseLine;
//        while ((responseLine = bufferedReader.readLine()) != null) {
//            result.append(responseLine);
//        }
//
//        System.out.println("Response: " + result.toString());
//    }
//
//    public void sendPostOrigin(String url, String urlParameters) throws Exception {
////        HttpClient client = getHttpClient();
////        HttpGet request = new HttpGet(url);
////        request.addHeader("User-Agent", "Mozilla/5.0");
////        HttpResponse response = client.execute(request);
////        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
////        StringBuffer result = new StringBuffer();
////        String responseLine;
////        while ((responseLine = bufferedReader.readLine()) != null)
////            result.append(responseLine);
////        System.out.println("Response: " + result.toString());
//    }
//
//    protected HttpClient getHttpClient() {
//        return HttpClientBuilder.create().build();
////        return HttpClientBuilder.create().build();
//    }

    // 1. Скачать нужно только одну библиотеку, я выгрузил её в idea через maven: org.apache.httpcomponents:httpclient
    //2. Остальное делал как в ссылкеПример, параметры можно распарсить так
    //List<NameValuePair> params = URLEncodedUtils.parse(urlParameters,Charset.forName("UTF-8"));
    //
    //3. сайт из задачи не работает, я делал на https://requestbin.jumio.com. Заходим, создаём свой requstedBin запускаем код, обновляем страницу с requstedBin.
    //
    //Суть RequestedBin, как я понял, довольно проста,  он просто принимает запросы и хранит информацию о них.
    // Получается просто заглушка, которая хранит информацию о поступающих запроса
}
