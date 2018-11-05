package model.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private int codTransacao, codAnuncio, codUsuario;
    private String data, status,titulo,nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodTransacao() {
        return codTransacao;
    }

    public void setCodTransacao(int codTransacao) {
        this.codTransacao = codTransacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCodAnuncio() {
        return codAnuncio;
    }

    public void setCodAnuncio(int codAnuncio) {
        this.codAnuncio = codAnuncio;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDate() {
        LocalDate date;
        date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = date.format(formatter);
        data = dataFormatada;
    }

}
