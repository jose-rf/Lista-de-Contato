package AgendaDeContatos.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoMySQL {
    private Conexao conexao; // objeto da classe Conexao, com os dados da conexão

    public static Connection connection = null; // variável estática para armazenar a conexão

    // construtor que recebe a configuração da conexão
    public ConexaoMySQL(Conexao conexao) {
        this.conexao = conexao;
    }

    // construtor vazio (caso precise instanciar sem passar nada)
    public ConexaoMySQL() {
    }

    // método que faz a conexão com o banco de dados
    public Connection conectar() {
        if (conexao != null) { // verifica se o objeto conexao está preenchido
            try {
                // monta a URL de conexão com base nos dados da classe Conexao
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                        ":" + conexao.getPorta() +
                        "/" + conexao.getNomeBanco();

                // carrega o driver JDBC do MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // cria a conexão passando url, usuário e senha
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );
                return connection;  // retorna a conexão aberta
            } catch (Exception ex) {
                // mostra uma mensagem de erro caso aconteça alguma exceção
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar no banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                );
                return null; // retorna null se não conseguir conectar
            }
        } else {
            return null; // se o objeto conexao for null, também retorna null
        }
    }

    // método para fechar a conexão com o banco
    public static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close(); // fecha a conexão se ela estiver aberta
            }
        } catch (SQLException e) {
            e.printStackTrace(); // imprime o erro no console caso aconteça
        }
    }
}
