/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Logs;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Usuário
 */
public class LogsController {

    public void CadastrarLogs(Logs log) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Logs.txt";

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String novoLog = dtf.format(now) + "||" + log.getLog();
            file.WriteFile(fileName, novoLog);
            
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }
}
