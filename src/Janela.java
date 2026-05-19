import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame{

    Gerencia g = new Gerencia();
    ControlaTarefa ct = new ControlaTarefa(g);

    public Janela()  {
        setTitle("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);

        Menu();
    }
    public JPanel TelaErro(){
            getContentPane().removeAll();
        //tela erro (sem tarefas)
            JPanel painelErroPrincipal = new JPanel(new BorderLayout(10,10));
            JPanel pErro = new JPanel(new GridLayout(1,3));
            JPanel pbotao = new JPanel(new GridLayout(1,5));

            ct.criarLabel("",20,pErro);
            JLabel titulo = ct.criarLabel("   Não há nenhuma Tarefa!!!",20,pErro); titulo.setForeground(Color.RED);
            ct.criarLabel("",20,pErro);
            ct.criarLabel(" ",18,pbotao);
            ct.criarBotao("Voltar",pbotao).addActionListener(e-> Menu());
            ct.criarLabel(" ",18,pbotao);
            ct.criarBotao("Adicionar Tarefa", pbotao).addActionListener(e -> Adicionar());
            ct.criarLabel(" ",18,pbotao);
        // add painel erro, sem tarefa
            painelErroPrincipal.add(pErro, BorderLayout.CENTER);
            painelErroPrincipal.add(pbotao,  BorderLayout.SOUTH);

            revalidate();
            repaint();

            return painelErroPrincipal;
    }
    public void Menu(){
        getContentPane().removeAll();
        JPanel painel = new JPanel();

        //organiza e nao deixa ocupar
        setLayout(new FlowLayout());

        //seta o tanto de linhas colunas e mais umas duas paradas
        painel.setLayout(new GridLayout(7,1,10,10));

        //crio o botao dentro do panel para que o java organize sozinho
        ct.criarLabel("\n-- Sua lista de Tarefas --", 25, painel);
        ct.criarBotao("Adicionar Tarefa", painel).addActionListener(e -> Adicionar());
        ct.criarBotao("mostrar Tarefas", painel).addActionListener( e -> Mostrar());
        ct.criarBotao("Editar Tarefa", painel).addActionListener(e ->Editar());
        ct.criarBotao("Concluir Tarefa", painel).addActionListener( e -> ConcluirTarefa());
        ct.criarBotao("Deletar Tarefa", painel).addActionListener(e -> Deletar());
        ct.criarBotao("sair", painel).addActionListener(e -> Sair());

        // adiciono o painel e coloco aonde ele vai se situar
        add(painel);

        revalidate();
        repaint();
    }
    public void Adicionar(){
        getContentPane().removeAll();

        JPanel painelPrincipal = new JPanel();
        JPanel pTitulo = new JPanel();
        JPanel pCampo = new JPanel();
        JPanel pMensagem = new JPanel();
        JPanel pBotoes = new JPanel();
        JPanel pbotaoMostrar = new JPanel();

        painelPrincipal.setLayout(new GridLayout(5,1,10,10)); //paienl principal
        pTitulo.setLayout(new GridLayout(1,2,10,10));//painel do primeiro titulo
        pCampo.setLayout(new GridLayout(1,1,10,10));//painel do campo adiciona tarefa
        pMensagem.setLayout(new GridLayout(1,1,10,10)); //painel pra mensagem de exito ao adicionar
        pBotoes.setLayout(new GridLayout(1,3,10,10));//painel dos botoes
        pbotaoMostrar.setLayout(new GridLayout(1,3,10,10));

        pMensagem.setVisible(false);

        ct.criarLabel(" Adicionar Tarefa: ", 18, pTitulo);ct.criarLabel(" ",18,pTitulo);
        JLabel label = ct.criarLabel("", 18,pMensagem);
        JTextField texto = ct.criarCampo(pCampo);
        ct.criarBotao("voltar", pBotoes).addActionListener(e -> Menu());
        ct.criarLabel(" ",18,pBotoes);
        ct.criarBotao("Adicionar Tarefa", pBotoes).addActionListener(e ->
                ct.botaoAdiciona(texto, label, painelPrincipal, pMensagem)
        );
        ct.criarLabel(" ",18,pbotaoMostrar);
        ct.criarBotao("mostrar Tarefas", pbotaoMostrar).addActionListener(e -> Mostrar());
        ct.criarLabel(" ",18,pbotaoMostrar);

        painelPrincipal.add(pTitulo);
        painelPrincipal.add(pCampo);
        painelPrincipal.add(pMensagem);
        painelPrincipal.add(pBotoes);
        painelPrincipal.add(pbotaoMostrar);
        add(painelPrincipal);

        revalidate();
        repaint();
    }
    public void Mostrar(){
        getContentPane().removeAll();

        JPanel painelPrincipal = new JPanel( new BorderLayout(10,10));
        JPanel pTArea = new JPanel();
        JPanel pBotoes = new JPanel();
        JTextArea areaTexto = ct.criarCampoArea(pTArea);

        pTArea.setLayout(new GridLayout(1,1));
        pBotoes.setLayout(new GridLayout(1,3));
        areaTexto.setPreferredSize(new Dimension(400,400));

        ct.criarBotao("Voltar",  pBotoes).addActionListener(e -> Menu());
        ct.criarLabel(" ",18,pBotoes);
        ct.criarBotao("adicionar Tarefa", pBotoes).addActionListener(e -> Adicionar());

        painelPrincipal.add(pTArea, BorderLayout.CENTER);
        painelPrincipal.add(pBotoes, BorderLayout.SOUTH);
        add(painelPrincipal);

        repaint();
        revalidate();
    }
    public void Editar(){
            getContentPane().removeAll();

            JPanel painelprincipal = new JPanel( new BorderLayout(10,10));
            JPanel pInvisivel =  new JPanel(new FlowLayout());ct.criarLabel(" ",18,pInvisivel);

        // tela edita
            JPanel painelEditaPrincipal = new JPanel(new BorderLayout(10,10));
            JPanel pEditaPrincipal = new JPanel(new GridLayout(1,2));
            JPanel pTextarea = new JPanel(new GridLayout(1,1));
            JPanel pCampos = new JPanel(new GridLayout(6,3));

            JTextArea areaTexto = ct.criarCampoArea(pTextarea);
            areaTexto.setPreferredSize(new Dimension(200,200));

            //1 linha
            ct.criarLabel("Qual tarefa deseja editar? ", 18, pCampos);
            ct.criarLabel(" ",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            //2 linha
            JTextField campoTarefaVelha = ct.criarCampo(pCampos);
            ct.criarLabel("",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            //3 linha
            ct.criarLabel("Digite a nova tarefa:",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            //4 linha
            JTextField campoTarefaNova = ct.criarCampo(pCampos);
            ct.criarLabel(" ",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            //5 linha
            JLabel titutoAvar = ct.criarLabel(" ",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            ct.criarLabel(" ",18,pCampos);
            //6 linha
            ct.criarBotao("Voltar", pCampos).addActionListener(e -> Menu());
            ct.criarLabel(" ",18,pCampos);
            ct.criarBotao("confirmar mudanças", pCampos).addActionListener(e ->ct.botaoEditar(campoTarefaVelha,campoTarefaNova,titutoAvar, pCampos, areaTexto));
        //add painel para editar
            painelEditaPrincipal.add(pEditaPrincipal, BorderLayout.NORTH);
            painelEditaPrincipal.add(pTextarea, BorderLayout.CENTER);
            painelEditaPrincipal.add(pCampos, BorderLayout.SOUTH);
        // add painel principal
            painelprincipal.add(pInvisivel,BorderLayout.NORTH);
            if (g.temTarefa()){
                painelprincipal.add(painelEditaPrincipal,BorderLayout.CENTER);
            }else{
                painelprincipal.add(TelaErro());
            }
            add(painelprincipal, BorderLayout.CENTER);
        repaint();
        revalidate();
    }
    public void ConcluirTarefa(){
            getContentPane().removeAll();

            JPanel painelPrincipal = new JPanel(new BorderLayout(10,10));
            JPanel pInvisivel =  new JPanel(new FlowLayout());
            ct.criarLabel(" ",18,pInvisivel);

        // painel
            JPanel pPrincipal = new JPanel(new BorderLayout(10,10));
            JPanel pTexto = new JPanel(new GridLayout(1,1));
            JPanel pCampos = new JPanel(new GridLayout(3,2));
            JPanel pBotoes = new JPanel(new GridLayout(1,3));

        //campos e botao
            JTextArea areaMostraTarefa = ct.criarCampoArea(pTexto);
            areaMostraTarefa.setPreferredSize(new Dimension(300,300));

            ct.criarLabel("Qual tarefa deseja concluir ou reabrir? ", 18, pCampos);
            ct.criarLabel(" ",18,pCampos);
            JTextField campoEntrada = ct.criarCampo(pCampos);
            ct.criarLabel(" ",18,pCampos);
            JLabel tituloAvar = ct.criarLabel("",18,pCampos);
            ct.criarLabel(" ",18,pCampos);

            ct.criarBotao("Voltar", pBotoes).addActionListener(e -> Menu());
            ct.criarLabel(" ",18,pBotoes);
            ct.criarBotao("confirmar mudanças", pBotoes).addActionListener( e -> ct.botaoConcluir(areaMostraTarefa, tituloAvar, campoEntrada, pPrincipal));

        //add painel
            pPrincipal.add(pTexto, BorderLayout.NORTH);
            pPrincipal.add(pCampos, BorderLayout.CENTER);
            pPrincipal.add(pBotoes, BorderLayout.SOUTH);
        //add
            painelPrincipal.add(pInvisivel,BorderLayout.NORTH);
            if (g.temTarefa()){
                painelPrincipal.add(pPrincipal, BorderLayout.CENTER);
            }else{
                    painelPrincipal.add(TelaErro());
            }
            add(painelPrincipal, BorderLayout.CENTER);

            revalidate();
            repaint();
    }
    public void Deletar(){

    }
    public void Sair(){
        dispose();
    }
}
