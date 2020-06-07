/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class Impressao {
    
    
    ConcurrentLinkedQueue<String> filaMensagens;
    
    private static Impressao instancia;
    
    private Impressao() {
        filaMensagens = new ConcurrentLinkedQueue<>();
    }
    
    public static Impressao getInstancia() {
        if (instancia == null) {
            instancia = new Impressao();
        }
        return instancia;
    }
    
    List<ThreadImpressao> threads;

    public void adicionaMsgImpressao(String msgAuditoria) {
        filaMensagens.add(msgAuditoria);
    }

    String retiraMsgImpressao() {
        String msg = filaMensagens.poll();
        return msg;
    }
    
    public void ativar() {
        if (threads == null) {
            threads = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ThreadImpressao thread = new ThreadImpressao();
                thread.setName("Thread " + (i + 1));
                thread.start();
                threads.add(thread);
            }
        }
    }
    
    public void desativar() {
        if (threads != null) {
            for (ThreadImpressao thread : threads) {
                thread.setStatus(false);
                try {
                    thread.join(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (thread.isAlive()) {
                    thread.interrupt();
                }
            }
        }
    }
}
