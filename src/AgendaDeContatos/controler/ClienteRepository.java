package AgendaDeContatos.controler;

import static AgendaDeContatos.controler.ConexaoMySQL.connection;
import AgendaDeContatos.model.Contatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// classe responsável pelas operações no banco de dados
public class ClienteRepository implements Crud<Contatos> {
    
    // método para inserir um novo cliente
    @Override
    public boolean inserir(Connection connection, Contatos entity) {
        String comando = "INSERT INTO CLIENTES(nome, email, contato) VALUES(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            // setando os valores do cliente na query
            stmt.setString(1, entity.getNome());
            stmt.setString(2, entity.getEmail());
            stmt.setString(3, entity.getContato());
            stmt.executeUpdate(); // executa o insert
            return true; // se der certo, retorna true
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // mostra o erro no console
            return false; // se der erro, retorna false
        }
    }
    
    // método para atualizar um cliente pelo contato
    @Override
    public boolean atualizar(Connection connection, Contatos entity) {
        String comando = "UPDATE CLIENTES SET nome = ?, email = ?, contato = ? WHERE contato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            // setando os novos valores e o contato que será usado para encontrar o cliente
            stmt.setString(1, entity.getNome());
            stmt.setString(2, entity.getEmail());
            stmt.setString(3, entity.getContato());
            stmt.setString(4, entity.getContato());
            stmt.executeUpdate(); // executa o update
            return true; // se der certo, retorna true
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // mostra o erro no console
            return false; // se der erro, retorna false
        }
    }   
    
    // método para deletar um cliente pelo contato
    @Override
    public boolean deletar(Connection connection, Contatos entity) {
        String comando = "DELETE FROM CLIENTES WHERE contato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, entity.getContato()); // usa o contato pra deletar
            stmt.executeUpdate(); // executa o delete
            return true; // se der certo, retorna true
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // mostra o erro no console
            return false; // se der erro, retorna false
        }
    }

    // método para buscar um cliente pelo contato
    @Override
    public Contatos selecionar(String contato) {
        String comando = "SELECT * FROM CLIENTES WHERE contato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, contato); // usa o contato pra buscar
            ResultSet rs = stmt.executeQuery(); // executa o select
            if (rs.next()) {
                // se encontrar, cria um objeto Contatos e preenche os dados
                Contatos cliente = new Contatos();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato(rs.getString("contato"));
                return cliente; // retorna o cliente encontrado
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); // mostra o erro no console
        }
        return null; // se não encontrar, retorna null
    }
    
    // método para deletar um cliente pelo ID
    public boolean deletarPorId(Connection conn, int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // define o ID que vai ser deletado
            int linhasAfetadas = stmt.executeUpdate(); // executa o delete
            return linhasAfetadas > 0; // retorna true se deletou algo
        } catch (SQLException e) {
            e.printStackTrace(); // imprime o erro
            return false; // se der erro, retorna false
        }
    }

    // método para listar todos os clientes
    public List<Contatos> listarTodos() {
        List<Contatos> lista = new ArrayList<>();
        String comando = "SELECT * FROM CLIENTES";
        
        try (PreparedStatement stmt = connection.prepareStatement(comando);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                // cria um objeto Contatos para cada linha e adiciona na lista
                Contatos contato = new Contatos();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setContato(rs.getString("contato"));
                lista.add(contato);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao listar contatos: " + ex.getMessage()); // mostra o erro no console
        }
        
        return lista; // retorna a lista de contatos
    }
}
