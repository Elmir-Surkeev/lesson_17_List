import java.util.Scanner;

public class MovieImpl implements Moviable{
    @Override
    public String getString(Scanner sc, String sentence) throws Exception {
        System.out.println("Введите %s".formatted(sentence));
        String name = sc.next().toLowerCase();
        return name;
    }
}
