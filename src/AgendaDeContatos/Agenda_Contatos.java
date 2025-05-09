package AgendaDeContatos;

// importando a tela inicial da aplicação
import AgendaDeContatos.view.TelaInicial;

/**
 *
 * @author joser
 */
public class Agenda_Contatos {

    /**
     * Método principal, é onde o programa começa
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
