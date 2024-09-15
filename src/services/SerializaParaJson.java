package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Endereco;

public class SerializaParaJson {
    public String serializarParaJson(Endereco endereco) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(endereco);
    }
}
