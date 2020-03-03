package UI;

import java.util.Scanner;

class MenuFuncionario extends Menu {

    @Override
    public void printMenu() {
        displayHeader("Selecione uma opção:");
        System.out.println("1) Cadastrar produtos");
        System.out.println("2) Cadastrar pedidos");
        System.out.println("3) Cadastrar clientes");
        System.out.println("0) Sair");
    }

    @Override
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
            if (resposta < 0 || resposta > 3) {
                System.out.println("Essa opção não existe. Tente novamente.");
            }
        } while (resposta < 0 || resposta > 3);
        return resposta;
    }

}
