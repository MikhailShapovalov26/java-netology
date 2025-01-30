import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");

    public static void main(String[] args) {
        Queue<String> queueManicure = new LinkedList<>(firstClients);

        while (!queueManicure.isEmpty()) {
            System.out.println("Cделал новый маникюр " + queueManicure.peek());
            String tmpNewClient = addNewClient(queueManicure.poll());
            if (tmpNewClient != null) {
                queueManicure.offer(tmpNewClient);
            }
        }
    }

    private static String addNewClient(String nameClient) {
        if (Math.random() < 0.5) {
            return "friend of " + nameClient;
        } else {
            return null;
        }
    }
}