/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Login;
import Model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class LoginController {

    public boolean validaLogin(Login modLog) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Login.txt";
        try {
            if ((modLog.getUsuario() != null) && (modLog.getUsuario() != "")) {
                boolean achou = false;
                List<String[]> dadosLogin = file.ReadFile(fileName);
                for (int i = 0; i < dadosLogin.size(); i++) {

                    if (dadosLogin.get(i)[0].equals(modLog.getUsuario())) {

                        if (dadosLogin.get(i)[1].equals(modLog.getSenha())) {
                            achou = true;
                            continue;
                        }
                    }
                }
                return achou;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }

    public User getPerfil(Login modLog) throws Exception {
        try {
            Arquivos file = new Arquivos();

            String fileName = "User.txt";
            List<String[]> dadosUser = file.ReadFile(fileName);
            for (int i = 1; i < dadosUser.size(); i++) {

                if (dadosUser.get(i)[0].equals(modLog.getUsuario())) {

                    User userData = new User(dadosUser.get(i)[0], dadosUser.get(i)[1], dadosUser.get(i)[2]);
                    return userData;
                }
            }
            return null;
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }

    }
}
