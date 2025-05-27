package AgendaDeContatos.controler;

import AgendaDeContatos.model.Contatos;
import AgendaDeContatos.view.notification.EmailNotifier;
import AgendaDeContatos.view.notification.Observer;
import AgendaDeContatos.view.notification.SmsNotifier;
import AgendaDeContatos.view.notification.UserNotifier;
import java.sql.Connection;
import java.util.List;

/**
 * Classe responsável por cadastrar usuários e enviar notificações
 * para os usuários antigos (exceto o recém cadastrado).
 * 
 * Aqui aplicamos o padrão Observer para notificar múltiplos observadores (notificadores)
 * quando um novo usuário é cadastrado.
 */
public class CadastroUsuario {
    // Objeto que gerencia os observadores (notificadores)
    private final UserNotifier userNotifier;
    // Repositório para acesso e manipulação dos dados dos contatos no banco
    private final ClienteRepository clienteRepository;
    // Conexão com o banco de dados
    private final Connection connection;

    // Construtor recebe as dependências via injeção para facilitar testes e manutenção
    public CadastroUsuario(UserNotifier userNotifier, ClienteRepository clienteRepository, Connection connection) {
        this.userNotifier = userNotifier;
        this.clienteRepository = clienteRepository;
        this.connection = connection;
    }

    /**
     * Método principal para cadastrar um novo usuário.
     * Salva no banco e notifica todos os usuários antigos sobre o novo cadastro.
     */
    public void cadastrarUsuario(Contatos novoUsuario) {
        // Tenta salvar o usuário no banco, se falhar, mostra erro e retorna
        if (!salvarUsuarioNoBanco(novoUsuario)) {
            System.out.println("❌ Erro ao cadastrar usuário no banco.");
            return;
        }

        System.out.println("✅ Usuário cadastrado: " + novoUsuario.getNome());

        // Obtém a lista de usuários antigos para notificação (exclui o novo usuário)
        List<Contatos> usuariosAntigos = obterUsuariosAntigos(novoUsuario);

        // Envia notificações para todos os usuários antigos informando novo cadastro
        enviarNotificacoes(usuariosAntigos, novoUsuario.getNome());
    }

    /**
     * Salva o novo usuário no banco utilizando o repositório.
     * @return true se salvar com sucesso, false caso contrário.
     */
    private boolean salvarUsuarioNoBanco(Contatos novoUsuario) {
        return clienteRepository.inserir(connection, novoUsuario);
    }

    /**
     * Obtém a lista de usuários já cadastrados no sistema, removendo o novo usuário da lista.
     */
    private List<Contatos> obterUsuariosAntigos(Contatos novoUsuario) {
        List<Contatos> usuariosCadastrados = clienteRepository.listarTodos(connection);
        // Remove o próprio usuário recém cadastrado da lista para não notificar ele mesmo
        usuariosCadastrados.removeIf(u -> u.getId() == novoUsuario.getId());
        return usuariosCadastrados;
    }

    /**
     * Método que configura os observadores para cada usuário antigo e dispara a notificação.
     * 
     * Aqui exemplificamos o padrão Observer:
     * - O UserNotifier é o sujeito (subject), que mantém uma lista de observadores.
     * - Os EmailNotifier e SmsNotifier são os observadores que reagem à notificação.
     */
    private void enviarNotificacoes(List<Contatos> usuariosAntigos, String nomeNovoUsuario) {
        // Para cada usuário, adiciona os observadores de email e sms
        for (Contatos usuario : usuariosAntigos) {
            userNotifier.adicionarObservador(new EmailNotifier(usuario.getEmail()));
            userNotifier.adicionarObservador(new SmsNotifier(usuario.getContato()));
        }
        // Dispara a notificação para todos os observadores cadastrados
        userNotifier.notificarTodos("Novo usuário cadastrado: " + nomeNovoUsuario);
    }
}
