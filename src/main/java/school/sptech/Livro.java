package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacoes) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();

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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrela){
        if( descricao == null || descricao.isBlank() || descricao.isEmpty() || qtdEstrela == null ||( qtdEstrela < 0 || qtdEstrela > 5)){
            throw new ArgumentoInvalidoException("Algum campo está incorreto");
        }else {
            Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrela );
            this.avaliacoes.add(avaliacao);
        }

    }

    public Double calcularMediaAvaliacoes(){
        Double media = 0.0;
        if(this.avaliacoes.isEmpty() || this.avaliacoes.size() == 0){
            return media;
        }else {
            for(Avaliacao avaliacao : this.avaliacoes){
                media += avaliacao.getQtdEstrelas();
            }
        }

        return media / this.avaliacoes.size();
    }

    @Override public String toString() {
        return "Título: " + titulo +"\nAutor: " + autor + "\nData de Publicação: " + dataPublicacao;
    }


}
