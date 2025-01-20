import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startApp(scanner);
    }

    private static void startApp(Scanner scanner) {
        List<String> list = new ArrayList<>();
        while (true) {
            messageStart();
            int answer;
            try {
                answer = Integer.valueOf(scannerText(scanner));
            } catch (NumberFormatException e) {
                System.out.print("Так не надо делать, нужно циферки");
                return;
            }
            switch (answer) {
                case 0:
                    return;
                case 1:
                    list.add(action("Введите название задачи:", scanner));
                    System.out.println("Добавлено");
                    System.out.println(list);
                    break;
                case 2:
                    System.out.println(list);
                    break;
                case 3:
                    int index = Integer.valueOf(action("Введите номер для удаления:", scanner));
                    System.out.println(index);
                    list.remove(index);
                    System.out.println("Удаленно");
                    System.out.println(list);
                    break;
                case 4:
                    deleteElement(action("Удаление по точному совпадению:", scanner), list);
                    break;
                case 5:
                    String deleteElement = action("Удаление по ключевому слову:", scanner);
                    String toRemove = new String();
                    for (String item : list) {
                        if (item.contains(deleteElement)) {
                            toRemove = item;
                        }
                    }
                    deleteElement(toRemove, list);
                    break;
                default:
                    System.out.println("Такой цифры тут нет");
                    break;
            }
        }

    }

    private static String scannerText(Scanner scanner) {
        return scanner.nextLine();
    }

    private static void messageStart() {
        System.out.print("Выберите операцию:\n" + "\n" + "0. Выход из программы\n" + "1. Добавить дело\n" + "2. Показать дела\n" + "3. Удалить дело по номеру\n" + "4. Удалить дело по названию\n" + "5. Удаление по ключевому слову\n" + "Ваш выбор: ");
    }


    public static List<String> deleteElement(String element, List<String> list) {
        if (list.remove(element)) {
            System.out.println("Удаленно");
        } else {
            System.out.println("Данной задачи нет в списке");
        }
        System.out.println(list);
        return list;
    }

    private static String action(String ask, Scanner scanner) {
        System.out.print(ask + " ");
        String result = scannerText(scanner);
        return result;
    }
}