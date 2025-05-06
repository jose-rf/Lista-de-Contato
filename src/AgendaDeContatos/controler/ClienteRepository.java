package AgendaDeContatos.controler;

import static AgendaDeContatos.controler.ConexaoMySQL.connection;
import AgendaDeContatos.model.Contatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteRepository implements Crud<Contatos> {
    
    //método inserir
    @Override
    public boolean inserir(Connection connection, Contatos entity) {
       String comando = "INSERT INTO CLIENTES(nome, email, contato) VALUES(?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(comando)) {
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getEmail()); // Corrigido: agora usa índice 2 corretamente
        stmt.setString(3, entity.getContato()); // Corrigido: agora usa índice 3 corretamente
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
        String comando = "UPDATE CLIENTES SET nome = ?, email = ?, contato = ? WHERE contato = ?";
    try (PreparedStatement stmt = connection.prepareStatement(comando)) {
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getEmail()); // Corrigido índice 2 corretamente
        stmt.setString(3, entity.getContato()); // Corrigido índice 3 corretamente
        stmt.setString(4, entity.getContato()); // Corrigido índice 4 corretamente
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
    
    public boolean deletarPorId(Connection conn, int id) {
    String sql = "DELETE FROM clientes WHERE id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public List<Contatos> listarTodos() {
    List<Contatos> lista = new ArrayList<>();
    String comando = "SELECT * FROM CLIENTES";
    
    try (PreparedStatement stmt = connection.prepareStatement(comando);
         ResultSet rs = stmt.executeQuery()) {
        
        while (rs.next()) {
            Contatos contato = new Contatos();
            contato.setId(rs.getInt("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setContato(rs.getString("contato"));
            lista.add(contato);
        }
    } catch (SQLException ex) {
        System.err.println("Erro ao listar contatos: " + ex.getMessage());
    }
    
    return lista;
}
}
