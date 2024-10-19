package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private void validarLivro(Livro livro) {
        if (livro == null ||
                livro.getTitulo() == null || livro.getTitulo().isBlank() ||
                livro.getAutor() == null || livro.getAutor().isBlank() ||
                livro.getDataPublicacao() == null) {
            throw new ArgumentoInvalidoException("Os atributos deste livro estão incorretos!");
        }
    }

    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("O título tem problemas");
        }
    }



    public void adicionarLivro(Livro livro) {
            validarLivro(livro);
            this.livros.add(livro);
    }


    public void removerLivroPorTitulo(String titulo) {

        Boolean livroAchado = false;

        validarTitulo(titulo);

        for(int i = 0; i < this.livros.size(); i++) {
            if(this.livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                livroAchado = true;
                this.livros.remove(i);
                break;

            }
        }

        if(!livroAchado) {
            throw new LivroNaoEncontradoException("Livro não encontrado");
        }
    }

    public Livro buscarLivroPorTitulo(String titulo){
        validarTitulo(titulo);
        for(int i = 0; i < this.livros.size(); i++) {
            if(this.livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return this.livros.get(i);
            }
        }
        throw new LivroNaoEncontradoException();
    }

    public Integer contarLivros(){
        return this.livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosAteAno = new ArrayList<>();
        for(Livro livro : this.livros) {
            if(livro.getDataPublicacao().getYear() <= ano) {
                livrosAteAno.add(livro);
            }
        }
        return livrosAteAno;
    }







}
