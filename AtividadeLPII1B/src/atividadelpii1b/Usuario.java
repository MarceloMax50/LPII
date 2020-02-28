/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadelpii1b;

/**
 *
 * @author 082170021
 */
public class Usuario {
     private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    private String codigo;
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    private String perfil; 
    public String getPerfil(){
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    private String senha;
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public Usuario (String nome, String codigo, String perfil, String senha){
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setPerfil(perfil);
        this.setSenha(senha);
    }
}
