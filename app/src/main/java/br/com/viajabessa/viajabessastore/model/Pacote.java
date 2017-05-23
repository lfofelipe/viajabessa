package br.com.viajabessa.viajabessastore.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;



public class Pacote implements Serializable {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("valorFormatado")
    @Expose
    private String valor;
    @SerializedName("imagem")
    @Expose
    private String linkImagem;

    private Bitmap bitmap;

    public Pacote() {
    }

    public Pacote(Long id, String titulo, String descricao, String valor, String linkImagem) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.linkImagem = linkImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
