
public class Tarefa {
    private String nome;
    private Boolean concluido;

    public Tarefa(String nome){
        this.nome = nome;
        this.concluido = false;
    }

    public String getNome(){
        return this.nome;
    }
    public boolean getConcluido(){
        return this.concluido;
    }
    public void setConcluido(boolean status){
        this.concluido = status;
    }

}
