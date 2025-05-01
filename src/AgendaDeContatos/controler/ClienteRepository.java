package AgendaDeContatos.controler;

import static AgendaDeContatos.controler.ConexaoMySQL.connection;
import AgendaDeContatos.model.Contatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClienteRepository implements Crud<Contatos> {
    
    //método inserir
    @Override
    public boolean inserir(Connection connection, Contatos entity) {
        String comando = "INSERT INTO CLIENTES(nome, email, contato) " +
                         "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, entity.getNome());
            stmt.setString(3, entity.getEmail());
            stmt.setString(4, entity.getContato());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    //método de atualizar com base no cpf
    @Override
    public boolean atualizar(Connection connection, Contatos entity) {
          String comando = "UPDATE CLIENTES SET nome = ?, endereco = ?, email = ?, contato = ?, WHERE telefone = ?";
    try (PreparedStatement stmt = connection.prepareStatement(comando)) {
        stmt.setString(1, entity.getNome());
        stmt.setString(3, entity.getEmail());
        stmt.setString(4, entity.getContato());
        stmt.setString(8, entity.getContato());  // Usando o CPF para localizar o cliente
        stmt.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return false;
    }
    }   
    
    //método de deletar com base no cpf
    @Override
    public boolean deletar(Connection connection, Contatos entity) {
            String comando = "DELETE FROM CLIENTES WHERE contato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, entity.getContato());  // Usando CPF para excluir o cliente
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // Selecionar pelo CPF
    @Override
    public Contatos selecionar(String contato) {
        String comando = "SELECT * FROM CLIENTES WHERE contato = ?";
        try (PreparedStatement stmt = connection.prepareStatement(comando)) {
            stmt.setString(1, contato);  // Usando CPF para consulta
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Contatos cliente = new Contatos();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setContato(rs.getString("contato"));
                return cliente;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;  // Retorna null caso não encontre o CPF
    }
}
