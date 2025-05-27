package AgendaDeContatos.view.notification;

/**
 * Interface Observer do padrão Observer.
 * Define o contrato para todos os objetos que desejam receber notificações.
 * 
 * Qualquer classe que implemente essa interface deve definir
 * o método `notificar`, que será chamado pelo sujeito (observable)
 * para enviar atualizações ou mensagens de notificação.
 */
public interface Observer {
    /**
     * Método chamado para notificar o observador.
     * 
     * @param mensagem A mensagem ou evento que está sendo notificado.
     */
    void notificar(String mensagem);
}
