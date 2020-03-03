/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 *
 * @author Usuário
 */
public class Arquivos {

    public List<String[]> ReadFile(String fileName) throws Exception {

        File arquivo = new File("./src/arquivos/" + fileName);
        if (arquivo.exists()) {
            List<String[]> dadosConta = new ArrayList<>();
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));
                String dados;
                while (in.ready()) {
                    dados = in.readLine(); // linha a linha do txt
                    dadosConta.add(dados.split(Pattern.quote ("||"))); // armazena a linha do txt splitada em uma List
                }
                in.close();

                return dadosConta;
            } catch (FileNotFoundException  e) {
                System.out.println("Erro: "+ e);
                throw e;
            }
        } else {
            System.out.println("Erro na leitura do arquivo.");
            throw new Exception();
        }
    }

}
