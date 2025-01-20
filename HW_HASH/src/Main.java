import java.util.*;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static Address address = new Address("Россия", "Казань");
    static Address address1 = new Address("Россия", "Ижевск");
    static Address address2 = new Address("Россия", "Псков");
    static Address address3 = new Address("Китай", "Шанхай");
    static Set<String> uniqueCountryArray = new HashSet<>();


    static Map<Address, Integer> mapDelivery = new HashMap<>();

    public static void main(String[] args) {
        mapDelivery.put(address, 100);
        mapDelivery.put(address1, 200);
        mapDelivery.put(address2, 1000);
        mapDelivery.put(address3, 2000);
        System.out.println(mapDelivery.get(new Address("Россия", "Казань")));
        int tmpCount = 0;
        while (true) {
            int answer = communiccationWithUser();
            if (answer == -1) {
                break;
            }
            tmpCount += answer;
            System.out.println("Общая стоимость всех доставок: " + tmpCount);
        }
        System.out.println("Общее кол-во уникальных стран: " + uniqueCountryArray.size());

    }

    private static int communiccationWithUser() {
        System.out.println("Заполнение нового заказа.");
        System.out.print("Введите страну: ");
        String tmpCountry = scanner.nextLine();
        if (tmpCountry.equals("end")) return -1;
        System.out.print("Введите город: ");
        String tmpCity = scanner.nextLine();
        if (tmpCity.equals("end")) return -1;
        System.out.print("Введите вес (кг): ");
        int tmpWeight;
        try {
            tmpWeight = Integer.valueOf(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Требуется число");
            return 0;
        }
        Address tmpAddress = new Address(tmpCountry, tmpCity);
        if (mapDelivery.containsKey(tmpAddress)) {
            System.out.println("Стоимость доставки составит: " + mapDelivery.get(tmpAddress) * tmpWeight);
            uniqueCountry(tmpCountry);
        } else {
            System.out.println("Доставки по этому адресу нет");
            return 0;
        }
        return (mapDelivery.get(tmpAddress) * tmpWeight);
    }

    private static void uniqueCountry(String tmpCountry){
        uniqueCountryArray.add(tmpCountry);
    }
}
