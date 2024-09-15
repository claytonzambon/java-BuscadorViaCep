package services;

import com.google.gson.Gson;
import model.Endereco;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public Endereco buscaEndereco(String cep) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(cep))
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter uma resposta.");
        }
    }
}
