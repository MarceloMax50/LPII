/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Pedido;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class PedidosController {

    public int getPedidoId() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Pedidos.txt";
        List<String[]> pedidoList = file.ReadFile(fileName);
        String[] ultima = pedidoList.get(pedidoList.size() - 1);
        int soma = Integer.parseInt(ultima[0]) + 1;
        return soma;
    }

    public String getPedido() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Pedidos.txt";
        List<String[]> pedidoList = file.ReadFile(fileName);
        String[] ultima = pedidoList.get(pedidoList.size() - 1);
        String str = "Codigo do pedido: "+ultima[0] +"\r\nProdutos: "+ ultima[1] +"\r\nNome do Cliente: "+ ultima[2] +"\r\nNome do vendedor: "+ ultima[3]+"\r\nValor total do pedido: R$"+ ultima[4];
        return str;
    }

    public String Cadastrapedido(Pedido pedido) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Pedidos.txt";

        try {
            if ((pedido != null)) {

                List<String[]> pedidoList = file.ReadFile(fileName);
                for (int i = 0; i < pedidoList.size(); i++) {

                }
                String novoPedido = pedido.getId() + "||" + pedido.getProdutos() + "||" + pedido.getClienteP() + "||" + pedido.getAtendente()+ "||" + pedido.getTotal();
                file.WriteFile(fileName, novoPedido);
                return "pedido cadastrada!";

            } else {
                return "Pedido não pode ser nulo.";
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }
}
