/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class ThreadImpressao extends Thread{
    private boolean status;
    
    @Override
    public void run() {
        setStatus(true);
        while (status) {
            try {
                String msg = Impressao.getInstancia().retiraMsgImpressao();
                if (msg != null) {
                    enviaMensagemParaImpressao(msg);
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadImpressao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void setStatus(boolean value) {
        status = value;
    }
    private void enviaMensagemParaImpressao(String msg) throws InterruptedException {
        System.out.printf("%s - Impressão pela %s = %s\n", Instant.now().toString(), getName(), msg);
        Thread.sleep(1000);
    }
}
