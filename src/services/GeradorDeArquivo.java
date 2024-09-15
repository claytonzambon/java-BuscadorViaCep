package services;

import model.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void salvarJson(Endereco endereco) throws IOException {
        SerializaParaJson serializa = new SerializaParaJson();

        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(serializa.serializarParaJson(endereco));
        escrita.close();
    }
}
