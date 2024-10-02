import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        JSONFileHandler jsonFileHandler = new JSONFileHandler();

        List<Movies> movies = jsonFileHandler.getMovies();

        System.out.println(movies.toString());

    }
}
