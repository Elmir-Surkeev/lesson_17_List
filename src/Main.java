import java.util.*;


public class Main {
    public static void main(String[] args) {
        JSONFileHandler jsonFileHandler = new JSONFileHandler();

        List<Movies> movies = jsonFileHandler.getMovies();


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название для поиска");
        //String nameSearch = sc.nextLine().toLowerCase();
        int yearSearch = sc.nextInt();
        System.out.println("Результаты пойска");
        boolean found = false;

//        movies.forEach(movie -> System.out.println(movie.getName()+ " - " + movie.getYear()));
        for (Movies movie :movies){
            //System.out.println("Film : %s".formatted(movie.getName()));
            if (movie.getYear() == yearSearch){
                System.out.println(movie.getName()+ " - " + movie.getYear());
            }
//            if (movie.getName().toLowerCase().contains(nameSearch)){
//                System.out.println("Название: " + movie.getName());
//                System.out.println("Год выпуска: " + movie.getYear());
//
//                System.out.println("Режиссер: " + movie.getCast());
//                System.out.println();
//                found = true;
   }
//        }
//        if (!found) {
//            System.out.println("Ничего по запросу - %s".formatted(nameSearch));
//        }

    }
}
