/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgendaDeContatos.controler;

/**
 *
 * @author joser
 */
public class Conexao {
    // atributos para armazenar os dados da conexão
    private String endereco;  // endereço do servidor (ex: localhost)
    private String user;      // usuário do banco
    private String password;  // senha do banco
    private int porta;        // porta de conexão (ex: 3306 para MySQL)
    private String nomeBanco; // nome do banco de dados
    
    // construtor que recebe todos os dados necessários para conectar
    public Conexao(String endereco, String user, String password, int porta, String nomeBanco) {
        this.endereco = endereco;
        this.user = user;
        this.password = password;
        this.porta = porta;
        this.nomeBanco = nomeBanco;
    }

    // métodos getters e setters (acessar ou alterar os valores dos atributos)

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}
