package AgendaDeContatos.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoMySQL {
    private Conexao conexao; // Classe de configuração para banco de dados

    public static Connection connection = null; // Conexão pública

    // Construtor que recebe uma instância de Conexao
    public ConexaoMySQL(Conexao conexao) {
        this.conexao = conexao;
    }

    // Construtor sem parâmetros
    public ConexaoMySQL() {
    }

    // Método para conectar ao banco de dados
    public Connection conectar() {
        if (conexao != null) {
            try {
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                        ":" + conexao.getPorta() +
                        "/" + conexao.getNomeBanco();

                // Carregar o driver JDBC para MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Estabelece a conexão e retorna a Connection
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );
                return connection;  // Retorna a Connection estabelecida
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar no banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                );
                return null; // Caso haja erro, retorna null
            }
        } else {
            return null;
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close(); // Fecha a conexão
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
