/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.LoginController;
import DAO.Arquivos;
import Model.Login;
import Model.User;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class Iniciar {

    public static void main(String[] args) throws Exception {
        //Lança o login
        LoginController controlLog = new LoginController();
        boolean aux = true;
        while (aux) {
            MenuLogin menuL = new MenuLogin();
            String user = menuL.enterUser();
            String senha = menuL.enterSenha();
            Login log = new Login(user, senha);

            if (controlLog.validaLogin(log)) {
                System.out.println("Validado....");
                User usuario = controlLog.getPerfil(log);
                if (usuario.getPerfil().equals("Gerente")) {
                    MenuGerente menuG = new MenuGerente();
                    menuG.printHeader();
                    menuG.printMenu();
                    menuG.getUserMenu();
                } else {
                    MenuFuncionario menuF = new MenuFuncionario();
                    menuF.printHeader();
                    menuF.printMenu();
                    menuF.getUserMenu();
                }

                aux = false;
            } else {
                System.out.println("Usuário ou senha inválidos");
            }
        }
    }

}
