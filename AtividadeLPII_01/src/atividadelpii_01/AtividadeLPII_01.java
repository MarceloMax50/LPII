/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadelpii_01;

/**
 *
 * @author Usuário
 */
import java.util.Scanner;
public class AtividadeLPII_01 {
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
  
    int numero1, numero2, soma;
    Scanner sc = new Scanner(System.in);
    System.out.print("Entre com o primeiro número inteiro: ");
    numero1 = sc.nextInt();
    System.out.print("Entre com o segundo número inteiro: ");
    numero2 = sc.nextInt();
    soma = numero1 + numero2;
    System.out.printf("A soma de %d e %d resulta em %d\n",numero1, numero2, soma);
  
       }
        
     
    
}
