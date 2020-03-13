/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Pizza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class ProdutoController {

    public void getCardapio() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Produto.txt";
        List<String[]> produtoList = file.ReadFile(fileName);
        List<String> cardapio = new ArrayList<String>();
    }

    public int getProductId() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Produto.txt";
        List<String[]> produtoList = file.ReadFile(fileName);
        String[] ultima = produtoList.get(produtoList.size() - 1);
        int soma = Integer.parseInt(ultima[0]) + 1;
        return soma;
    }

    public String CadastraPizza(Pizza produto) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Produto.txt";

        try {
            if ((produto.getName() != null) && (produto.getName() != "")) {

                List<String[]> produtoList = file.ReadFile(fileName);
                for (int i = 0; i < produtoList.size(); i++) {

                    if (produtoList.get(i)[0].equals(produto.getName())) {
                        return "Esse sabor já existe. Por favor escolha outro.";
                    }
                }
                String novoSabor = produto.getId() + "||" + produto.getName() + "||" + produto.getPreco();
                file.WriteFile(fileName, novoSabor);
                return "Pizza cadastrada!";

            } else {
                return "Sabor não pode ser nulo.";
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }

}
