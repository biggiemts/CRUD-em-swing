import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame{
    ControlaTarefa ct = new ControlaTarefa();

    public Janela()  {
        setTitle("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        Menu();
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

        //tela erro (sem tarefas)
        JPanel painelErroPrincipal = new JPanel(new BorderLayout(10,10));
        JPanel pErro = new JPanel(new GridLayout(1,3));
        JPanel pbotao = new JPanel(new GridLayout(1,5));

        JPanel pInvisivel =  new JPanel(new FlowLayout());ct.criarLabel(" ",18,pInvisivel);

        ct.criarLabel("",20,pErro);
        ct.criarLabel("Não há nenhuma Tarefa!!!",20,pErro);
        ct.criarLabel("",20,pErro);
        ct.criarLabel(" ",18,pbotao);
        ct.criarBotao("Voltar",pbotao).addActionListener(e-> Menu());
        ct.criarLabel(" ",18,pbotao);
        ct.criarBotao("Adicionar Tarefa", pbotao).addActionListener(e -> Adicionar());
        ct.criarLabel(" ",18,pbotao);

        painelErroPrincipal.add(pErro, BorderLayout.NORTH);
        painelErroPrincipal.add(pbotao,  BorderLayout.CENTER);

        painelprincipal.add(pInvisivel,BorderLayout.NORTH);
        painelprincipal.add(painelErroPrincipal, BorderLayout.CENTER);

        add(painelprincipal, BorderLayout.CENTER);

        repaint();
        revalidate();
    }
    public void ConcluirTarefa(){

    }
    public void Deletar(){

    }
    public void Sair(){
        dispose();
    }
}
