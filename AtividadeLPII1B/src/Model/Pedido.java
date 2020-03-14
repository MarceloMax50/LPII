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
public class Pedido {

    private int id;
    private String produtos;
    private String clienteP;
    private String atendente;
    private double total;

    public Pedido(int id, String produtos, String clienteP, String atendente, double total) {
        this.id = id;
        this.produtos = produtos;
        this.clienteP = clienteP;
        this.atendente = atendente;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getClienteP() {
        return clienteP;
    }

    public void setClienteP(String clienteP) {
        this.clienteP = clienteP;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

}
