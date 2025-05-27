package AgendaDeContatos;

// importando a tela inicial da aplicação
import AgendaDeContatos.view.TelaInicial;

import AgendaDeContatos.controler.ConexaoMySQL;
import AgendaDeContatos.controler.ClienteRepository;
import AgendaDeContatos.model.Contatos;
import AgendaDeContatos.view.notification.EmailNotifier;
import AgendaDeContatos.view.notification.Observer;
import AgendaDeContatos.view.notification.SmsNotifier;
import AgendaDeContatos.view.notification.UserNotifier;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author joser
 */
public class Agenda_Contatos {

    /**
     * Método principal, é onde o programa começa
     * @param args
     */
    public static void main(String[] args) {
        // Cria uma nova instância da tela inicial
        TelaInicial telaInicial = new TelaInicial();
        
        // deixa a tela visível
        telaInicial.setVisible(true);
        
        // define o título da janela
        telaInicial.setTitle("Cadastro de clientes");
        
    }
    }
    

