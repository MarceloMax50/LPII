/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.LoginController;
import Model.Login;
import Model.User;

/**
 *
 * @author Usuário
 */
public class Iniciar {

    public static void main(String[] args) throws Exception {
        //Lança o login
        LoginController controlLog = new LoginController();
        boolean aux = true;

        MenuLogin menuL = new MenuLogin();
        String user = menuL.enterUser();
        String senha = menuL.enterSenha();
        Login log = new Login(user, senha);

        if (controlLog.validaLogin(log)) {
            System.out.println("Validando...");
            User usuario = controlLog.getPerfil(log);
            while (aux) {
                if (usuario.getPerfil().equals("Gerente")) {
                    MenuGerente menuG = new MenuGerente();
                    menuG.printHeader(log.getUsuario());
                    menuG.printMenu();
                    menuG.performAction(menuG.getUserMenu());
                } else {
                    MenuFuncionario menuF = new MenuFuncionario();
                    menuF.printHeader(log.getUsuario());
                    menuF.printMenu();
                    menuF.getUserMenu();
                }
            }
        } else {
            System.out.println("Usuário ou senha inválidos");
        }
    }
}
