/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Arquivos;
import Model.User;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class UserController {

    public int getUserId() throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "User.txt";
        List<String[]> usuarioList = file.ReadFile(fileName);
        String[] ultima = usuarioList.get(usuarioList.size() - 1);
        int soma = Integer.parseInt(ultima[0]) + 1;
        return soma;
    }

    public String CadastraUsuario(User usuario) throws Exception {
        Arquivos file = new Arquivos();
        String fileName = "User.txt";

        try {
            if ((usuario.getUserId() != null) && (usuario.getUserId() != "")) {

                List<String[]> usuarioList = file.ReadFile(fileName);
                for (int i = 0; i < usuarioList.size(); i++) {

                    if (usuarioList.get(i)[0].equals(usuario.getUserId())) {
                        return "Esse usuário já existe. Por favor escolha outro.";
                    }
                }
                String novoFuncionario = usuario.getUserId() + "||" + usuario.getNome() + "||" + usuario.getPerfil();

                file.WriteFile(fileName, novoFuncionario);
                return "Funcionário cadastrado!";

            } else {
                return "Usuário não pode ser nulo.";
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e);
            throw e;
        }
    }
}
