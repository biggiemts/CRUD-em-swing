import java.util.ArrayList;

public class Gerencia {

    ArrayList<Tarefa> tarefa = new ArrayList<>();

    // verificador se a tarefa
    public boolean temTarefa(){return !tarefa.isEmpty();}

    //adiciona
    public void adiciona(String nome){
        Tarefa t = new Tarefa(nome);
        tarefa.add(t);
        System.out.println("Tarefa adicionada com sucesso");
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

    public void editarTarefa(int tarefaVelha, String tarefaNova){
        Tarefa tarefaAtualizada = new Tarefa(tarefaNova);
        tarefa.set(tarefaVelha - 1, tarefaAtualizada);
        System.out.println("Tarefa atualizada com sucesso, metodo ");
    }


    //modifica
    public void Modifica (int indiceTarefa, String tarefaNova){
        Tarefa atualizarTarefa = new Tarefa(tarefaNova);
        tarefa.set(indiceTarefa -1, atualizarTarefa);
        System.out.println("Tarefa atualizada com sucesso");
    }

    //conclui

    //deleta


    //encerra o porgrama


}
