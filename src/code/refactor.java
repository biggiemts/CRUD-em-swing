/*
    import javax.swing.*;
    import java.awt.*;

    public void Edita() {
        getContentPane().removeAll();


        JButton voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", Font.BOLD, 14));

        voltar.setFocusPainted(false);
        voltar.addActionListener(e -> Menu());

        if (!g.temTarefa()) {
            //cria
            JLabel titulo = new JLabel("Não há nenhuma Tarefa!!!");

            //edita
            titulo.setFont(new Font("Arial", Font.BOLD, 20));
            titulo.setForeground(Color.RED);

            //localilção
            titulo.setBounds(150, 100, 300, 30);
            voltar.setBounds(150, 140, 150, 30);

            //add
            add(titulo);
            add(voltar);
        } else {
            //cria
            JLabel tituloTarefaModificada = new JLabel("");
            JTextArea texto = new JTextArea();
            JButton botaoConfirmar = new JButton("Confirmar");
            JLabel titulo = new JLabel("Digite sua nova tarefa: ");
            JLabel titulo1 = new JLabel("Qual Tarefa deseja modificar? ");
            JLabel titulo2 = new JLabel("*SÓ NÚMEROS*");
            JTextField campoTarefaVelha = new JTextField();
            JTextField campoTarefaNova = new JTextField();


            //edita
            tituloTarefaModificada.setFont(new Font("Arial", Font.BOLD, 16));

            texto.setEditable(false);
            texto.setLineWrap(true);
            texto.setWrapStyleWord(true);
            texto.setFont(new Font("Arial", Font.BOLD, 12));
            texto.setEditable(false);

            titulo.setFont(new Font("Arial", Font.BOLD, 14));
            titulo1.setFont(new Font("Arial", Font.BOLD, 14));
            titulo2.setFont(new Font("Arial", Font.BOLD, 14));

            botaoConfirmar.setFont(new Font("Arial", Font.BOLD, 14));


            //localização e tamnho
            texto.setBounds(100, 30, 200, 450);
            titulo2.setBounds(310, 50, 300, 30);
            titulo1.setBounds(310, 35, 300, 30);
            titulo.setBounds(310, 115, 300, 30);
            campoTarefaVelha.setBounds(310, 80, 60, 30);
            campoTarefaNova.setBounds(310, 145, 230, 30);
            voltar.setBounds(100, 500, 200, 30);
            botaoConfirmar.setBounds(310, 500, 195, 30);
            tituloTarefaModificada.setBounds(310, 185, 250, 50);


            // manda pro metodo e retorna o dado
            String textoFinal = "--- Suas Tarefas ---\n\n";
            String resultado = g.mostraTarefa(textoFinal);
            texto.setText(resultado);

            botaoConfirmar.addActionListener(e -> {
                try {
                    String velha = campoTarefaVelha.getText();
                    int intVelha = Integer.parseInt(velha);

                    if (intVelha > 0 && intVelha <= g.tarefa.size()) {

                        String novaTarefa = campoTarefaNova.getText();

                        g.Modifica(intVelha, novaTarefa);

                        //limpa buffer
                        campoTarefaVelha.setText("");
                        campoTarefaNova.setText("");

                        //atualiza o textarea e mostra a lista atualiza
                        String textoFinalNovo = "--- Suas Tarefas ---\n\n";
                        String resultadoNovo = g.mostraTarefa(textoFinalNovo);
                        texto.setText(resultadoNovo);

                        tituloTarefaModificada.setText("Tarefa atualizada com sucesso!");
                        tituloTarefaModificada.setForeground(Color.GREEN);
                        add(tituloTarefaModificada);

                        revalidate();
                        repaint();
                    } else {
                        System.out.println("Tarefa incorreta!");

                        campoTarefaVelha.setText("");
                        campoTarefaNova.setText("");

                        //Titulo se nao houver tarefa
                        tituloTarefaModificada.setText("Tarefa inexistente!");
                        tituloTarefaModificada.setForeground(Color.RED);
                        add(tituloTarefaModificada);

                        revalidate();
                        repaint();
                    }
                } catch (Exception erro) {
                    System.out.println("erro editando tarefa!");

                    tituloTarefaModificada.setText("Digite apenas numeros!!");
                    tituloTarefaModificada.setForeground(Color.RED);

                    campoTarefaVelha.setText("");
                    campoTarefaNova.setText("");

                    revalidate();
                    repaint();
                }
            });


            //add
            add(texto);
            add(voltar);
            add(titulo);
            add(campoTarefaNova);
            add(campoTarefaVelha);
            add(titulo1);
            add(titulo2);
            add(botaoConfirmar);


            revalidate();
            repaint();

        }
        revalidate();
        repaint();
        setVisible(true);
    }
    *
 */