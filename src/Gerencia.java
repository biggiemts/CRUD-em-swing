import java.util.ArrayList;

public class Gerencia {

    ArrayList<Tarefa> tarefa = new ArrayList<>();

    // verificador se ha tarefa
    public boolean temTarefa(){
        return !tarefa.isEmpty();
    }

    //adiciona
    public void adiciona(String nome){
        Tarefa t = new Tarefa(nome);
        tarefa.add(t);
    }

    //mostra
    public String mostraTarefa(String textoFinal){
        for (int i = 0; i<tarefa.size(); i++){
            Tarefa t = tarefa.get(i);
            String status = t.getConcluido() ? "[CONCLUIDO]" : "[PENDENTE]";
            textoFinal += (i + 1) + ". " + t.getNome() + " - " + status + "\n";
        }
        return textoFinal;
    }

    //edita
    public void editarTarefa(int tarefaVelha, String tarefaNova){
        Tarefa tarefaAtualizada = new Tarefa(tarefaNova);
        tarefa.set(tarefaVelha - 1, tarefaAtualizada);
    }

    //conclui
    public boolean alternaStatusTarefa(int posicaoUsuario){
        int posicaoComputador = posicaoUsuario - 1;

        Tarefa tarefaConcluida = tarefa.get(posicaoComputador);
        tarefaConcluida.setConcluido(!tarefaConcluida.getConcluido());

        //retornando getConcluido que é booleno
        return tarefaConcluida.getConcluido();
    }

    //deleta
    public void deletar(int posicaoUsuario){
        posicaoUsuario = posicaoUsuario - 1;
        tarefa.remove(posicaoUsuario);
    }
}
