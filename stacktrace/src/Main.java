import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        try {
            passwordChecker.setLenght(Integer.parseInt(message("Введите мин. длину пароля: ")));
        } catch (NumberFormatException e) {
            System.out.printf("Недопустимое значение длинны пароля: %S%n  Выход из программы BYE", e);
            Runtime.getRuntime().exit(1);
        }
        try {
            passwordChecker.setPeriodicity(Integer.parseInt(message("Введите макс. допустимое количество повторений символа подряд: ")));
        } catch (NumberFormatException e) {
            System.out.printf("Недопустимое значение повторения символов: %S%n Выход из программы BYE", e);
            Runtime.getRuntime().exit(2);
        }
        while (true) {
            String password = message("Введите пароль или end: ");
            if (password.equals("end")) {
                break;
            } else {
                if (PasswordChecker.verify(password)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            }
        }

    }

    public static String message(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}