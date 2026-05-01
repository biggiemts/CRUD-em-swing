import javax.swing.*;
import java.awt.*;

public class ControlaTarefa {
    Gerencia g = new Gerencia();
    public JButton criarBotao(String texto, JPanel painelDestino){
        JButton botao = new JButton(texto);

        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 18));

        // em ves de criar na janela ele cria no painel e manda pra la
        painelDestino.add(botao);
        return botao;
    }
    public JLabel criarLabel(String texto, int tamanhoFonte, JPanel painelDestino){
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        painelDestino.add(label);
        return label;
    }
    public JTextField criarCampo(JPanel painelDestino){
        JTextField campo = new JTextField(20);
        campo.setFont(new Font("Arial", Font.BOLD, 18));
        painelDestino.add(campo);
        return campo;
    }
    public void botaoAdiciona(JTextField campo, JLabel titulo, JPanel painelDestino){
        String texto = campo.getText().trim();

        if (!texto.isEmpty()){
            g.adiciona(texto);
            campo.setText("");
            titulo.setText("Tarefa Adicionada com sucesso!");
            titulo.setForeground(Color.GREEN);

            painelDestino.repaint();
            painelDestino.revalidate();
        } else{
            campo.setText("");
            titulo.setText("Erro ao adicionar Tarefa!");
            titulo.setForeground(Color.RED);
            painelDestino.repaint();
            painelDestino.revalidate();
        }


    }
}
