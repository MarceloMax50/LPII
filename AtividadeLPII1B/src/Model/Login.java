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
public class Login {
    
    //private int loginId;
    private String usuario;
    private String senha;
    
    public Login(String user, String sen){
        setUsuario(user);
        //setId(id); 
        setSenha(sen);
    }

    //public  void setId(int id){
    //    this.loginId = id;
    //}
    public  void setUsuario(String user){
        this.usuario = user;
    }
    public  void setSenha(String sen){
        this.senha = sen;
    }
   // public  int getId(){
        //return loginId;
    //}
    public String getUsuario(){
        return usuario;
    }
    public String getSenha(){
        return senha;
    }
    
}
