package AgendaDeContatos.view.notification;

/**
 * Observador concreto que implementa a interface Observer.
 * Este observador envia notificações via SMS.
 * 
 * Faz parte da implementação do padrão Observer, onde múltiplos
 * observadores (como EmailNotifier, SmsNotifier, etc.) recebem
 * atualizações do sujeito (UserNotifier).
 */
public class SmsNotifier implements Observer {
    // Número de telefone do usuário para envio da notificação
    private final String numero;

    public SmsNotifier(String numero) {
        this.numero = numero;
    }

    /**
     * Método que será chamado para notificar o usuário via SMS.
     * 
     * @param mensagem A mensagem a ser enviada.
     */
    @Override
    public void notificar(String mensagem) {
        System.out.println("📱 Enviando SMS para " + numero + ": " + mensagem);
    }
}
