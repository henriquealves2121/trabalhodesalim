
package Discoteca;


public class Musica {
    private String nome;
    private int nota;
    private int duracao;

    public Musica(String nome,int nota, int duracao) {
        this.nome = nome;
        this.nota = nota;
        this.duracao = duracao;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getNota(){
        return nota;
    }
     public void setNota(int nota) {
        this.nota = nota;
    }
    public int getDuracao(){
        return duracao;
    }
     public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}

