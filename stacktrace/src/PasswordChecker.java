public class PasswordChecker {
    private static Integer lenght;
    private static Integer periodicity;

    public void setLenght(int lenght) {
        if (lenght < 0) {
            throw new IllegalArgumentException("Передали недопустимое значение длинны пароля " + lenght);
        } else{
            this.lenght = lenght;
        }
    }

    public void setPeriodicity(int periodicity) {
        if (periodicity <= 0) {
            throw new IllegalArgumentException("Передали недопустимое значение повторения символов " + periodicity);
        } else{
            this.periodicity = periodicity;
        }

    }

    public static boolean verify(String password) {
        if (lenght == null  && periodicity == null ) {
            throw new IllegalStateException("Длина пароля или количество повторений не установлены.");
        }
        int count = 1;
        if (password.length() < lenght) {
            return false;
        }

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i-1)) {
                count++;
                if (count > periodicity) {
                    return false;
                }
            } else {
                count = 1;
            }

        }
        return true;
        }

}
