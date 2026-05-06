import javax.swing.*;
import java.awt.*;

public class ControlaTarefa {
    Gerencia g = new Gerencia();

    public JButton criarBotao(String texto, JPanel painelDestino) {
        JButton botao = new JButton(texto);

        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 18));

        // em ves de criar na janela ele cria no painel e manda pra la
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
        System.out.println("\n\nbotao adicionar - controlatarefa - acionado com sucesso");

        if (!texto.isEmpty()) {
            g.adiciona(texto);
            campo.setText("");
            titulo.setText("Tarefa Adicionada com sucesso!");
            titulo.setForeground(Color.GREEN);
            painelMensagem.setVisible(true);


            painelDestino.repaint();
            painelDestino.revalidate();
            System.out.println("\n\ntem algo no campo");
        } else {
            campo.setText("");
            titulo.setText("Erro ao adicionar Tarefa!");
            titulo.setForeground(Color.RED);

            painelMensagem.setVisible(true);
            System.out.println("\n\nnao tem nada no campo");
            painelDestino.repaint();
            painelDestino.revalidate();
        }
    }

    public void botaoEditar (JTextField campoVelha, JTextField campoNova, JLabel titulo, JPanel painelDestino) {
        String textoVelha = campoVelha.getText().trim();
        String textoNova = campoNova.getText().trim();

        int intVelha;
        intVelha = Integer.parseInt(textoVelha);
        try {

            System.out.println("try funcionando ");
            if (intVelha > 0 && intVelha <g.tarefa.size()){
                System.out.println(" if botao editar funcionado ");
            }else {
                titulo.setText("Erro ao adicionar Tarefa!");
            }
        } catch (Exception e){
            titulo.setText("Digite apenas números no primeiro campo!!!");
            campoVelha.setText("");
            campoNova.setText("");
            titulo.setForeground(Color.RED);
            painelDestino.repaint();
            painelDestino.revalidate();
            System.out.println(" catch funcionando");
        }

    }

    public void Botaoeditar() {

    }
}
