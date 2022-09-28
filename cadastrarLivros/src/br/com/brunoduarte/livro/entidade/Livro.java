
package br.com.brunoduarte.livro.entidade;


public class Livro {
    
    private int id;
    private String editora;
    private String titulo;
    private String isbn;

    public Livro(int id, String editora, String titulo, String isbn) {
        this.id = id;
        this.editora = editora;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Livro() {
            }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + id + ", editora=" + editora + ", titulo=" + titulo + ", isbn=" + isbn + '}';
    }
    
    
    
    
}
