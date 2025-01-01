import java.time.LocalDateTime;

public class SmartLogger implements Logger{

    private int count=1;

    @Override
    public void log(String msg) {
        if(msg.toLowerCase().contains("error")){
            System.out.printf("ERROR #%d [%s] - %s%n", count, LocalDateTime.now(), msg);

        } else {
            System.out.printf("INFO #%d [%s] - %s%n", count, LocalDateTime.now(), msg);
        }
        count=count+1;

    }
}
