/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n1entregasockets;

import connect.PrintServer;
import impressao.Impressao;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuário
 */
public class N1EntregaSockets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        PrintServer server = new PrintServer();
        server.start();
        Impressao.getInstancia().ativar();
        Scanner scan = new Scanner(System.in);
        try {
            boolean sair = false;
            do {
                
                System.out.println("1 - Listar clientes");
                System.out.println("2 - Sair");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        server.listarClientes();
                        break;
                    case 2:
                        sair = true;
                        break;
                }
            } while (!sair);
        } finally {
            scan.close();
            server.encerra();
            Impressao.getInstancia().desativar();
        }
        
        
    }
    
}
