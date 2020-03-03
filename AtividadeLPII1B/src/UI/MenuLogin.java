/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author Usuário
 */
public class MenuLogin {
    
    public String enterUser(){
        
        System.out.println("Digite seu usuário:");
        Scanner keyboard = new Scanner(System.in);
        String resposta = keyboard.nextLine();
        return resposta;
    }
    public String enterSenha(){
        System.out.println("Digite sua senha:");
        Scanner keyboard = new Scanner(System.in);
        String resposta = keyboard.nextLine();
        return resposta;
    }
    
}
