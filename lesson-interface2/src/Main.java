import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger log = new SimpleLogger();
        Logger slog = new SmartLogger();
        log.log("произошла какая то канитель 1");
        for (int i = 0; i < 20; i++) {
            if(i % 5 == 0){
                slog.log(randomString(50) + " error");
            }else if (i % 8 == 0) {
                slog.log(randomString(50) + " Error");
            } else {
                slog.log(randomString(50));
            }
        }

    }
public static String randomString(int length){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    StringBuilder sb = new StringBuilder();
     Random random = new Random();
    for(int i = 0; i < length; i++) {
        int index = random.nextInt(alphabet.length());
        char randomChar = alphabet.charAt(index);
        sb.append(randomChar);
    }
    return sb.toString();
}

}