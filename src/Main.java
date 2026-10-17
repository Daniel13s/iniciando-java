import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> users = new ArrayList<>();

        users.add("Daniel");
        users.add("Thyffanny");

       users.stream()
               .forEach(System.out::println);
    }
}