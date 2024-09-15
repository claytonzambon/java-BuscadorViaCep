package model;

public record Endereco(String cep, String logradouro, String complemento,
                       String unidade, String bairro, String localidade,
                       String uf, String estado, String regiao,
                       String ibge, String ddd, String siafi) {

}
