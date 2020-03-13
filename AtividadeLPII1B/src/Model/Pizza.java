/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Usuário
 */
public class Pizza {
     private int pizzaId;
    private String sabor;
    private String preco;
    
    public Pizza(String flavor, int id, String price){
        setSabor(flavor);
        setId(id); 
        setPreco(price);
    }

    public  void setId(int id){
        this.pizzaId = id;
    }
    public  void setSabor(String flavor){
        this.sabor = flavor;
    }
    public  void setPreco(String price){
        this.preco = price;
    }
    public  int getId(){
        return pizzaId;
    }
    public String getName(){
        return sabor;
    }
    public String getPreco(){
        return preco;
    }
}
