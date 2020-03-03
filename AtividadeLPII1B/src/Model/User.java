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
public class User {

    private String UserId;
    private String nome;
    private String perfil;

    public User(String id, String name, String per) {
        setNome(name);
        setUserId(id);
        setPerfil(per);
    }

    public void setUserId(String id) {
        this.UserId = id;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public void setPerfil(String per) {
        this.perfil = per;
    }

    public String getUserId() {
        return UserId;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }
}
