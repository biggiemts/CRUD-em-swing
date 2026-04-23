import javax.swing.*;
import java.awt.*;


public class Janela extends JFrame{
    Gerencia g = new Gerencia();


    public Janela()  {
        setTitle("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        Menu();
    }
    private JButton criarBotao(String texto, JPanel painelDestino){
        JButton botao = new JButton(texto);

        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 18));

        // em ves de criar na janela ele cria no painel e manda pra la
        painelDestino.add(botao);
        return botao;
    }
    private JLabel criarLabel(String texto, int tamanhoFonte, JPanel painelDestino){
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, tamanhoFonte));
        painelDestino.add(label);
        return label;
    }
    public void Menu(){
        getContentPane().removeAll();
        JPanel painel = new JPanel();

        //organiza e nao deixa ocupar todo o espaço
        setLayout(new FlowLayout());

        //seta o tanto de linhas colunas e mais umas duas paradas
        painel.setLayout(new GridLayout(7,1,10,10));

        //crio o botao dentro do panel para que o java organize sozinho
        criarLabel("\n-- Sua lista de Tarefas --", 25, painel);
        criarBotao("Adicionar Tarefa", painel).addActionListener(e -> Adicionar());
        criarBotao("mostrar Tarefas", painel).addActionListener( e -> Mostrar());
        criarBotao("Editar Tarefa", painel).addActionListener(e ->Edita());
        criarBotao("Concluir Tarefa", painel).addActionListener( e -> ConcluirTarefa());
        criarBotao("Deletar Tarefa", painel).addActionListener(e -> Deletar());
        criarBotao("sair", painel).addActionListener(e -> Sair());


        // adiciono o painel e coloco aonde ele vai se situar
        add(painel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void Adicionar(){
        getContentPane().removeAll();
        JPanel painel = new JPanel();

        setLayout(new FlowLayout());
        painel.setLayout(new GridLayout(5,2,10,10));

        criarLabel("Adicionar Tarefa: ", 18, painel);

        add(painel, BorderLayout.CENTER);

        revalidate();
        repaint();

    }
    public void Mostrar(){
        getContentPane().removeAll();


        //botao volta e configs
        JButton voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial",Font.BOLD,14));

        voltar.setFocusPainted(false);
        voltar.addActionListener(e ->Menu());

        //if verifica e printa na tela as tarefas
        if(!g.temTarefa()){
            // exibe se nao houver tarefas
            JLabel titulo = new JLabel("Não há nenhuma Tarefa!!!");
            titulo.setFont(new Font("Arial",Font.BOLD,20));
            titulo.setForeground(Color.RED);
            titulo.setBounds(150,100,300,30);
            add(titulo);
            voltar.setBounds(150,140,150,30);
            add(voltar);
        } else{
            //exibe tarefas exitentes
            JTextArea texto = new JTextArea();
            texto.setEditable(false);
            texto.setLineWrap(true);
            texto.setWrapStyleWord(true);
            texto.setBounds(150,50,300,400);
            texto.setFont(new Font("Arial",Font.BOLD,12));
            texto.setEditable(false);

            //chama o for da gerencia
            String textoFinal = "--- Suas Tarefas ---\n\n";
            String resultado = g.mostraTarefa(textoFinal);

            texto.setText(resultado);


            add(texto);
            voltar.setBounds(150,500,150,30);
            add(voltar);

            revalidate();
            repaint();

        }
        revalidate();
        repaint();
        setVisible(true);
    }
    public void Edita(){
        getContentPane().removeAll();


        JButton voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial",Font.BOLD,14));

        voltar.setFocusPainted(false);
        voltar.addActionListener(e ->Menu());

        if(!g.temTarefa()){
            //cria
            JLabel titulo = new JLabel("Não há nenhuma Tarefa!!!");

            //edita
            titulo.setFont(new Font("Arial",Font.BOLD,20));
            titulo.setForeground(Color.RED);

            //localilção
            titulo.setBounds(150,100,300,30);
            voltar.setBounds(150,140,150,30);

            //add
            add(titulo);
            add(voltar);
        } else{
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
            tituloTarefaModificada.setFont(new Font("Arial",Font.BOLD,16));

            texto.setEditable(false);
            texto.setLineWrap(true);
            texto.setWrapStyleWord(true);
            texto.setFont(new Font("Arial",Font.BOLD,12));
            texto.setEditable(false);

            titulo.setFont(new Font("Arial",Font.BOLD,14));
            titulo1.setFont(new Font("Arial",Font.BOLD,14));
            titulo2.setFont(new Font("Arial",Font.BOLD,14));

            botaoConfirmar.setFont(new Font("Arial",Font.BOLD,14));


            //localização e tamnho
            texto.setBounds(100,30,200,450);
            titulo2.setBounds(310,50,300,30);
            titulo1.setBounds(310,35,300,30);
            titulo.setBounds(310,115,300,30);
            campoTarefaVelha.setBounds(310,80,60,30);
            campoTarefaNova.setBounds(310,145,230,30);
            voltar.setBounds(100,500,200,30);
            botaoConfirmar.setBounds(310,500,195,30);
            tituloTarefaModificada.setBounds(310,185,250,50);



            // manda pro metodo e retorna o dado
            String textoFinal = "--- Suas Tarefas ---\n\n";
            String resultado = g.mostraTarefa(textoFinal);
            texto.setText(resultado);

            botaoConfirmar.addActionListener(e ->{
                try{
                    String velha = campoTarefaVelha.getText();
                    int intVelha = Integer.parseInt(velha);

                    if(intVelha > 0 && intVelha <= g.tarefa.size()) {

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
                    }else{
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
                } catch(Exception erro){
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
    public void ConcluirTarefa(){

    }
    public void Deletar(){

    }
    public void Sair(){
        dispose();
    }
}
