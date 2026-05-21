import javax.swing.*;
import java.awt.*;

public class ControlaTarefa {
    Gerencia g;
    public  ControlaTarefa (Gerencia gerenciaCompartilhada) {
        this.g = gerenciaCompartilhada;
    }

    public JButton criarBotao(String texto, JPanel painelDestino) {
        JButton botao = new JButton(texto);

        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 18));

        painelDestino.add(botao);
        return botao;
    }

    public JLabel criarLabel(String texto, int tamanhoFonte, JPanel painelDestino) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        painelDestino.add(label);
        return label;
    }

    public JTextField criarCampo(JPanel painelDestino) {
        JTextField campo = new JTextField(20);
        campo.setFont(new Font("Arial", Font.BOLD, 18));
        painelDestino.add(campo);
        return campo;
    }

    public JTextArea criarCampoArea(JPanel painelDestino) {
        String texto = "";
        texto = g.mostraTarefa(texto);

        JTextArea tArea = new JTextArea();
        tArea.setEditable(false);
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true);
        tArea.setFont(new Font("Arial", Font.BOLD, 12));
        tArea.setEditable(false);

        if (g.temTarefa()) {
            tArea.setText("\n -- Suas Tarefas -- \n\n");
            tArea.setText(texto);
        } else {
            tArea.setText("\n\n\n NÃO HÁ NENHUMA TAREFA!!! ");
        }
        painelDestino.add(tArea);
        tArea.setVisible(true);

        return tArea;
    }

    public void botaoAdiciona(JTextField campo, JLabel titulo, JPanel painelDestino, JPanel painelMensagem) {
        String texto = campo.getText().trim();

        if (!texto.isEmpty()) {
            g.adiciona(texto);
            campo.setText("");
            titulo.setText("Tarefa Adicionada com sucesso!");
            titulo.setForeground(Color.GREEN);
        } else {
            campo.setText("");
            titulo.setText("Erro!! Campo vazio!");
            titulo.setForeground(Color.RED);
        }
        painelMensagem.setVisible(true);
        painelDestino.repaint();
        painelDestino.revalidate();
    }

    public void botaoEditar (JTextField campoVelha, JTextField campoNova, JLabel titulo, JPanel painelDestino, JTextArea campoArea) {
        String textoVelha = campoVelha.getText().trim();
        String textoNova = campoNova.getText().trim();

        int intVelha;

        if (!textoNova.isEmpty() && !textoVelha.isEmpty()) {
            try {
                intVelha = Integer.parseInt(textoVelha);

                    if (intVelha > 0 && intVelha <= g.tarefa.size()) {
                        g.editarTarefa(intVelha, textoNova);

                        titulo.setText("Tarefa Editada com sucesso!");
                        titulo.setForeground(Color.GREEN);
                        campoVelha.setText("");
                        campoNova.setText("");
                        campoArea.setText(g.mostraTarefa(""));
                    }else{
                        titulo.setText("Tarefa inexistente!!");
                        titulo.setForeground(Color.RED);
                        campoVelha.setText("");
                        campoNova.setText("");
                    }
                painelDestino.repaint();
                painelDestino.revalidate();
            } catch (Exception e){
                titulo.setText("Digite apenas numeros!!!");
                campoVelha.setText("");
                campoNova.setText("");
                titulo.setForeground(Color.RED);
                painelDestino.repaint();
                painelDestino.revalidate();
            }
        }else {
            titulo.setText("Campos vazios!");
            titulo.setForeground(Color.RED);
        }
    }

    public void botaoConcluir(JTextArea tArea, JLabel titulo, JTextField campo, JPanel painelDestino) {
        String  texto = campo.getText().trim();

        int intTextoConcluido;
        if (!texto.isEmpty()) {
            try{
                intTextoConcluido = Integer.parseInt(texto);

                if (intTextoConcluido > 0 && intTextoConcluido <= g.tarefa.size()) {

                    //passando o valor Objeto para booleano
                    boolean statusTarefa = g.alternaStatusTarefa(intTextoConcluido);

                    if (statusTarefa) {
                        titulo.setText("Tarefa Concluida com sucesso!");
                        titulo.setForeground(Color.GREEN);
                    } else {
                        titulo.setText("Tarefa reaberta com sucesso!");
                        titulo.setForeground(Color.BLUE);
                    }
                    campo.setText("");
                    tArea.setText(g.mostraTarefa(""));
                } else {
                    campo.setText("");
                    tArea.setText(g.mostraTarefa(""));
                    titulo.setText("Tarefa inexistente!");
                    titulo.setForeground(Color.RED);
                }

                painelDestino.repaint();
                painelDestino.revalidate();

            }catch (Exception e){
                titulo.setText("Digite apenas numeros!!!");
                titulo.setForeground(Color.RED);
                campo.setText("");

            }
        } else{
            campo.setText("");
            tArea.setText(g.mostraTarefa(""));
            titulo.setText("Campos vazios!");
            titulo.setForeground(Color.RED);
        }
    }
    public void botaoDeletar(JTextArea areaTexto, JTextField campo, JLabel titulo, JPanel painelDestino) {
        String texto = campo.getText().trim();
        int  intTextoDeleta;

        if(!texto.isEmpty()) {
            try{
                intTextoDeleta = Integer.parseInt(texto);
                if (intTextoDeleta > 0 && intTextoDeleta <= g.tarefa.size()) {
                    campo.setText("");
                    int resposta = JOptionPane.showConfirmDialog(painelDestino,"Deseja realmente excluir está Tarefa?",
                            "ATENÇÃO!!!",JOptionPane.YES_NO_OPTION);
                    if  (resposta == JOptionPane.YES_OPTION) {

                        g.deletar(intTextoDeleta);

                        areaTexto.setText(g.mostraTarefa(""));
                        titulo.setText("Tarefa excluida com sucesso!");
                        titulo.setForeground(Color.GREEN);
                    }else{
                        titulo.setText("Exclusão Cancelada!");
                        titulo.setForeground(Color.BLUE);
                    }
                }else{
                    titulo.setText("Tarefa inexistente!");
                    titulo.setForeground(Color.RED);
                    campo.setText("");
                }

            }catch (Exception e){
                titulo.setText("digite apenas numeros!!");
                titulo.setForeground(Color.RED);
                campo.setText("");
            }
        }else{
            titulo.setText("Campos vazios!");
            titulo.setForeground(Color.RED);
        }
    }
}
