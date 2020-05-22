/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Controller.LogsController;
import Model.Logs;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class ThreadGestaoMenssagensAuditoria extends Thread {

    private String nome;

    public ThreadGestaoMenssagensAuditoria(String nome) {
        this.nome = nome;
        start();
    }

    public void run() {
        LogsController l = new LogsController();
        Logs log = new Logs(nome);
        try {
            l.CadastrarLogs(log);
            Thread.sleep(1000);
            System.out.println("Thread Logs: " + nome);
            Thread.sleep(1000);

        } catch (Exception ex) {
            Logger.getLogger(ThreadGestaoMenssagensAuditoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
