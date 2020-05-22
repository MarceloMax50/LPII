package UI;

import Controller.ClienteController;
import Controller.LoginController;
import Controller.LogsController;
import Controller.PedidosController;
import Controller.ProdutoController;
import Controller.UserController;
import Model.Cliente;
import Model.Login;
import Model.Logs;
import Model.Pedido;
import Model.Pizza;
import Model.User;
import java.util.List;
import java.util.Scanner;
import Threads.ThreadGestaoMenssagensAuditoria;

public class Menu {

    String usuariON;

    //Instance Variables
    boolean exit;

    public void runMenu() throws Exception {
        printHeader("");
        while (!exit) {
            printMenu();
            int resposta = getUserMenu();
            performAction(resposta);
        }
    }

    public void printHeader(String u) {
        System.out.println("+-----------------------------------+");
        System.out.println("|          Bem vindo à N1           |");
        System.out.println("|             Pizzaria              |");
        System.out.println("+-----------------------------------+");
        usuariON = u;
    }

    public void printMenu() {
        displayHeader("Selecione uma opção:");
        System.out.println("1) Cadastrar produtos");
        System.out.println("2) Cadastrar pedidos");
        System.out.println("3) Cadastrar clientes");
        System.out.println("4) Cadastrar Funcionários");
        System.out.println("0) Sair");
    }

    public int getUserMenu() {
        Scanner keyboard = new Scanner(System.in);
        int resposta = -1;
        do {
            System.out.println("Digite a opção: ");
            try {
                resposta = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opçãoinválida. Apenas números.");
            }
            if (resposta < 0 || resposta > 4) {
                System.out.println("Essa opção não existe. Tente novamente.");
            }
        } while (resposta < 0 || resposta > 4);
        return resposta;
    }

    public void performAction(int resposta) throws Exception {
        switch (resposta) {
            case 0:
                System.out.println("Me dá um 10 por favor. Saindo...");
                System.exit(0);
                break;
            case 1: {

                Pizza nova = cadastroProdutos();
                ProdutoController exe = new ProdutoController();
                exe.CadastraPizza(nova);
                System.out.println("Pizza Cadastrada!");

                String strLOG = usuariON + " cadastrou um novo produto!";
                printMenu();
                ThreadGestaoMenssagensAuditoria thr = new ThreadGestaoMenssagensAuditoria(strLOG);
        
            }
            break;
            case 2: {

                Pedido novo = cadastroPedidos();
                PedidosController exe = new PedidosController();
                exe.Cadastrapedido(novo);
                System.out.println("Pedido Cadastrado!");
                //Print pedido realizado
                System.out.println(exe.getPedido());

                String strLOG = usuariON + " cadastrou um novo pedido!";
                printMenu();
                ThreadGestaoMenssagensAuditoria thr = new ThreadGestaoMenssagensAuditoria(strLOG);
        
            }
            case 3: {
                Cliente novo = cadastroClientes();
                ClienteController exe = new ClienteController();
                exe.CadastraCliente(novo);
                System.out.println("Cliente Cadastrado!");

                String strLOG = usuariON + " cadastrou um novo cliente!";
                printMenu();
                ThreadGestaoMenssagensAuditoria thr = new ThreadGestaoMenssagensAuditoria(strLOG);
        
            }
            case 4: {
                User novo = cadastroFuncionario();
                UserController exe = new UserController();
                exe.CadastraUsuario(novo);
                System.out.println("Cliente Cadastrado!");
                System.out.println("Cadestre uma senha para o seu novo funcionario:");
                Login nova = cadastroSenha(novo);
                LoginController s = new LoginController();
                s.CadastraLogin(nova);

               String strLOG = usuariON + " cadastrou um novo funcionário!";
                printMenu();
                ThreadGestaoMenssagensAuditoria thr = new ThreadGestaoMenssagensAuditoria(strLOG);
        
            }
            default:
                System.out.println("Erro desconhecido.");
        }
    }

    protected void displayHeader(String message) {
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (int i = 0; i < width; ++i) {
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }

    private Pizza cadastroProdutos() throws Exception {
        ProdutoController pro = new ProdutoController();
        displayHeader("Cadastro de produtos:");
        System.out.println("Cadastre  o Sabor da pizza:");
        Scanner keyboard = new Scanner(System.in);
        String newPizza = keyboard.nextLine();
        System.out.println("Cadastre  o Preço da pizza:");
        String pizzaPrice = keyboard.nextLine();
        int id = pro.getProductId();

        Pizza produto = new Pizza(newPizza, id, pizzaPrice);
        return produto;

    }

    private Pedido cadastroPedidos() throws Exception {
        ProdutoController pro = new ProdutoController();
        PedidosController p = new PedidosController();
        ClienteController c = new ClienteController();

        List<String[]> productList = pro.getProductList();
        String pedidoStr = "";
        displayHeader("Pedidos:");
        System.out.println("Escolha o(s) sabor(es):");
        System.out.println(pro.getCardapio());
        Scanner keyboard = new Scanner(System.in);
        double total = 0;
        String resposta = "";
        //Get produtos
        do {
            System.out.println("Digite o código da pizza ou 'c' para continuar.");
            resposta = keyboard.next();
            if (!resposta.equals("c")) {
                for (int i = 0; i < productList.size(); i++) {

                    if (productList.get(i)[0].equals(resposta)) {
                        pedidoStr += productList.get(i)[0] + ";" + productList.get(i)[1] + ";" + productList.get(i)[2] + "-";
                        total += Double.parseDouble(productList.get(i)[2]);
                    }
                }
            }

        } while (!resposta.equals("c"));
        //Get Cliente
        System.out.println("Digite o código do cliente");
        int resp = Integer.parseInt(keyboard.next());
        Cliente cli = c.getClientById(resp);

        //Get Id Pedido
        int id = p.getPedidoId();
        //(int id, String produtos, String clienteP, String atendente, double total)
        Pedido ped = new Pedido(id, pedidoStr, cli.getNome(), usuariON, total);
        return ped;

    }

    private Cliente cadastroClientes() throws Exception {
        ClienteController c = new ClienteController();
        displayHeader("Cadastro de Clientes:");
        System.out.println("Cadastre  o nome do cliente:");
        Scanner keyboard = new Scanner(System.in);
        String newClient = keyboard.nextLine();
        int id = c.getClientId();

        Cliente cli = new Cliente(id, newClient);
        return cli;
    }

    private User cadastroFuncionario() {
        displayHeader("Cadastro de Funcionários:");
        System.out.println("Cadastre  o nome do funionário:");
        Scanner keyboard = new Scanner(System.in);
        String newFunc = keyboard.nextLine();
        System.out.println("Cadastre  um user name");
        keyboard = new Scanner(System.in);
        String u = keyboard.nextLine();
        System.out.println("Escolha o perfil do funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Vendedor");
        keyboard = new Scanner(System.in);
        String perfil = keyboard.nextLine();
        if (null == perfil) {
            System.out.println("Opção inválida!");
        } else {
            switch (perfil) {
                case "1":
                    perfil = "Gerente";
                    break;
                case "2":
                    perfil = "Vendedor";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        User fun = new User(u, newFunc, perfil);
        return fun;
    }

    private Login cadastroSenha(User u) {
        displayHeader("Cadastro da senha:");
        System.out.println("Cadastre  a senha do funionário:");
        Scanner keyboard = new Scanner(System.in);
        String senha = keyboard.nextLine();
        Login fun = new Login(u.getUserId(), senha);
        return fun;
    }
}
