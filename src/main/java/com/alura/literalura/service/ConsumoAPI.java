package com.alura.literalura.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

   public String obtenerDatos(String url){
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
      HttpResponse<String> response = null;
      try {
         response = client
               .send(request, HttpResponse.BodyHandlers.ofString());
      } catch (IOException | InterruptedException e) {
         throw new RuntimeException(e);
      }
      String json = response.body();
      return json;
   }

   public JsonArray getDataResultsAsJson(String json) {
      return JsonParser.parseString(json).getAsJsonObject().get("results").getAsJsonArray();
   }
   }
}
