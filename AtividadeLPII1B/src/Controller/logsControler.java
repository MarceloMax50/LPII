/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Login;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class logsControler {

    public void CadastraLogin(String log) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Login.txt";

        try {

            file.WriteFile(fileName, log);
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }
}
