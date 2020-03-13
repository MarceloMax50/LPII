/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Usuário
 */
public class Pedido {

    private String id;
    private List<Pizza> produtos;
    private Cliente clienteP;
    private User atendente;

    public Pedido(String id, List<Pizza> produtos, Cliente clienteP, User atendente) {
        this.id = id;
        this.produtos = produtos;
        this.clienteP = clienteP;
        this.atendente = atendente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Pizza> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Pizza> produtos) {
        this.produtos = produtos;
    }

    public Cliente getClienteP() {
        return clienteP;
    }

    public void setClienteP(Cliente clienteP) {
        this.clienteP = clienteP;
    }

    public User getAtendente() {
        return atendente;
    }

    public void setAtendente(User atendente) {
        this.atendente = atendente;
    }

}
