package AgendaDeContatos.view.notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o "Subject" (sujeito) no padrão Observer.
 * 
 * Responsável por manter a lista de observadores (Observers) inscritos,
 * permitindo que sejam adicionados novos observadores e notificando todos
 * eles quando ocorre algum evento relevante.
 * 
 * Neste caso, a notificação é uma mensagem que será enviada a todos os observadores.
 * 
 * Após notificar todos, a lista de observadores é limpa para evitar notificações duplicadas
 * no próximo evento.
 */
public class UserNotifier {
    // Lista que mantém todos os observadores cadastrados
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Adiciona um novo observador à lista.
     * 
     * @param observer Observador que deseja receber notificações.
     */
    public void adicionarObservador(Observer observer) {
        observers.add(observer);
    }

    /**
     * Notifica todos os observadores registrados enviando a mensagem.
     * 
     * @param mensagem Mensagem a ser enviada para todos os observadores.
     */
    public void notificarTodos(String mensagem) {
        for (Observer observer : observers) {
            observer.notificar(mensagem);
        }
        // Após notificar, limpa a lista para evitar notificações repetidas
        observers.clear();
    }
}
