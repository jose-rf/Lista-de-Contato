package AgendaDeContatos.view.notification;

/**
 * Observador concreto que representa a notificação via e-mail.
 * 
 * Implementa a interface Observer, recebendo as atualizações do sujeito (UserNotifier).
 * Quando notificado, simula o envio de um e-mail para o endereço especificado.
 */
public class EmailNotifier implements Observer {
    // Endereço de e-mail do usuário a ser notificado
    private final String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    /**
     * Método chamado pelo sujeito para notificar o observador.
     * Aqui a notificação é simulada com um print no console.
     * 
     * @param mensagem Mensagem da notificação a ser enviada.
     */
    @Override
    public void notificar(String mensagem) {
        System.out.println("🔔 Enviando e-mail para " + email + ": " + mensagem);
    }
}
