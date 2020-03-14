/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.Cliente;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class ClienteController {

    public int getClientId() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Cliente.txt";
        List<String[]> clienteList = file.ReadFile(fileName);
        String[] ultima = clienteList.get(clienteList.size() - 1);
        int soma = Integer.parseInt(ultima[0]) + 1;
        return soma;
    }

    public Cliente getClientById(int id) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Cliente.txt";
        List<String[]> clienteList = file.ReadFile(fileName);
        for (int i = 1; i < clienteList.size(); i++) {
            if (clienteList.get(i)[0].equals(Integer.toString(id))) {
                Cliente c = new Cliente(Integer.parseInt(clienteList.get(i)[0]), clienteList.get(i)[1]);
                return c;
            } else {
            }
        }
        return null;
    }

    public String CadastraCliente(Cliente cliente) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "Cliente.txt";

        try {
            if ((cliente.getNome() != null) && (cliente.getNome() != "")) {

                List<String[]> clienteList = file.ReadFile(fileName);
                for (int i = 0; i < clienteList.size(); i++) {

                    if (clienteList.get(i)[0].equals(cliente.getNome())) {
                        return "Esse sabor já existe. Por favor escolha outro.";
                    }
                }
                String novoCliente = cliente.getUserId() + "||" + cliente.getNome();
                file.WriteFile(fileName, novoCliente);
                return "Cliente cadastrada!";

            } else {
                return "Sabor não pode ser nulo.";
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }
}
