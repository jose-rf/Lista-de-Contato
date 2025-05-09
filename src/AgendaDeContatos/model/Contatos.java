package AgendaDeContatos.model;

/**
 * Classe que representa um contato da agenda.
 * Tem os atributos: nome, email, contato (telefone) e id.
 */
public class Contatos {
    private String nome;    // nome do contato
    private String email;   // email do contato
    private String contato; // telefone ou número de contato
    private int id;         // identificador único do contato (no banco de dados)

    // construtor com todos os atributos
    public Contatos(String nome, String email, String contato, int id) {
        this.nome = nome;
        this.email = email;
        this.contato = contato;
        this.id = id;
    }

    // construtor vazio (útil para frameworks ou quando quiser setar depois)
    public Contatos() {
    }

    // getters e setters
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
