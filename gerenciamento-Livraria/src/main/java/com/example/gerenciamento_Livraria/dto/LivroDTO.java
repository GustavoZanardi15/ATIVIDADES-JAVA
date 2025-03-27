package com.example.gerenciamento_Livraria.dto;

import com.example.gerenciamento_Livraria.enums.StatusLivro;

public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private StatusLivro statusLivro;

    public LivroDTO() {}

    public LivroDTO(Long id, String titulo, String autor, int anoPublicacao, StatusLivro statusLivro) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.statusLivro = statusLivro;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public StatusLivro getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(StatusLivro statusLivro) {
        this.statusLivro = statusLivro;
    }
}
