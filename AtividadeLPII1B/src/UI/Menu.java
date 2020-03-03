
package UI;
import java.util.Scanner;
public class Menu {

    //Instance Variables
    boolean exit;

    public void runMenu() {
        printHeader();
        while (!exit) {
            printMenu();
            int resposta = getUserMenu();
            performAction(resposta);
        }
    }

    public void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|          Bem vindo à N1           |");
        System.out.println("|             Pizzaria              |");
        System.out.println("+-----------------------------------+");
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
            System.out.print("Digite a opção: ");
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

    public void performAction(int resposta) {
        switch (resposta) {
            case 0:
                System.out.println("Me dá um 10 por favor. Saindo...");
                System.exit(0);
                break;
            case 1: {

                //cadastroProdutos();
            }
            break;
            case 2:
                //cadastroPedidos();
                break;
            case 3:
                //cadastroClientes();
                break;
            case 4:
                //cadastroFuncionario();
                break;
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

}
