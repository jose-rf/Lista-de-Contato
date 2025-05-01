/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgendaDeContatos.model;

/**
 *
 * @author joser
 */
public class Contatos {
    private String nome;
    private String email;
    private String contato;
    private int id;

    public Contatos(String nome, String email, String contato, int id) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
        this.id = id;
    }

    
    public Contatos() {
    
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
