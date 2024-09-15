import model.Endereco;
import services.ConsumoApi;
import services.GeradorDeArquivo;
import services.SerializaParaJson;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) {

        ConsumoApi consulta = new ConsumoApi();
        String cep = JOptionPane.showInputDialog("Informe o número do Cep: ");

        cep = cep
                .replace("-", "")
                .replace(" ", "")
                .replace(".", "")
                .trim();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            Endereco novoEndereco = consulta.buscaEndereco(endereco);
            SerializaParaJson serializa = new SerializaParaJson();
            JOptionPane.showMessageDialog(null, serializa.serializarParaJson(novoEndereco));

            GeradorDeArquivo gerarArquivo = new GeradorDeArquivo();
            gerarArquivo.salvarJson(novoEndereco);

        } catch (RuntimeException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Finalizando a aplicação");
        }
    }
}