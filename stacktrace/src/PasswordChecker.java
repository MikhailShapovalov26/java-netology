public class PasswordChecker {
    private static Integer lenght;
    private static Integer periodicity;


    public void PassswordChecker(int lenght, int periodicity) {
        this.lenght = lenght;
        this.periodicity = periodicity;
    }

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
            throw new IllegalStateException("Передали недопустимое значение " + lenght);
        }
        int count = 1;
        if (password.length() >= lenght) {
            for (int i = 0; i < password.length() - 1; i++) {
                for (int j = i + 1; j < password.length(); j++) {
                    if (password.charAt(i) == password.charAt(j)) {
                        count = count + 1;
                    } else {
                        count = 1;
                    }
                    if (count > periodicity) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }

}
