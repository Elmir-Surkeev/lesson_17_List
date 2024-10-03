import cats.kernel.Hash;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        JSONFileHandler jsonFileHandler = new JSONFileHandler();
        List<Movies> movies = jsonFileHandler.getMovies();
        HashSet<Movies> moviesHashSet = new HashSet<>(jsonFileHandler.getMovies());

        try {
            boolean checkWorkWhile = true;
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Добрый день уважаемый киноман \n" +
                        " введите 1 для просмотра всех фильмов \n" +
                        " введите 2 для просмотра по полному или частичному названию в фильмах \n" +
                        " введите 3 для сортировки коллекций фильмов по углубленному параметру \n" +
                        " введите 4 для поиска фильмов по актеру \n" +
                        " введите 5 для поиска фильмов по режиссеру" +
                        " введите 0 для завершения работы программы");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        checkWorkWhile = false;
                        break;
                    case 1:
                        for (Movies movie : movies) {
                            System.out.println(movie.toString());
                        }
                        break;
                    case 2:
                        System.out.println("Введите название для поиска");
                        String nameSearch = sc.next().toLowerCase();
                        boolean found = false;
                        for (Movies movieSearch : movies) {
                            if (movieSearch.getName().toLowerCase().contains(nameSearch)){
                                System.out.println("Film : %s".formatted(movieSearch.getName()));
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Ничего по запросу - %s".formatted(nameSearch));
                        }
                        break;
                    case 3:
                        System.out.println("Киноман, у нас для тебя есть несколько выбора сортировки смотри \n" +
                                " введи 1 для сортировки по году выпуска \n" +
                                " введи 2 для сортировки по полному названию \n" +
                                " введи 3 для сортировки по любимому режиссеру \n" +
                                "(можешь писать не учитывая регистры");
                        int choiceSort = sc.nextInt();
                        switch (choiceSort) {
                            case 1:
                                System.out.println("Введите 1 для сортировки по возрастанию \n" +
                                        "введите 2 для сортировки по убыванию");
                                int choiceSortYear = sc.nextInt();
                                if (choiceSortYear == 1){
                                    movies.sort(Comparator.comparing(Movies::getYear));
                                    System.out.println("Фильмы по возрастанию года выпуска:");
                                    movies.forEach(movie -> System.out.println("Название фильма: " + movie.getName()  +
                                            " - Год выпуска: " + movie.getYear()));
                                }else if(choiceSortYear == 2){
                                    movies.sort(Comparator.comparing(Movies::getYear).reversed());
                                    System.out.println("\nФильмы по убыванию года выпуска:");
                                    movies.forEach(movie -> System.out.println("Название фильма: " + movie.getName() + " - Год выпуска: " + movie.getYear()));
                                }else {
                                    throw new Exception("Вы ввели неправильные данные для сортировки поиска");
                                }
                                break;
                            case 2:
                                System.out.println("Введите название для поиска");
                                String nameSearchFilter = sc.next().toLowerCase();
                                boolean foundd = false;
                                for (Movies movieSearch : movies) {
                                    if (movieSearch.getName().toLowerCase().contains(nameSearchFilter)){
                                        System.out.println("Фильмы : %s".formatted(movieSearch.getName()));
                                        found = true;
                                    }
                                    if (!foundd) {
                                        System.out.println("Ничего по запросу - %s".formatted(nameSearchFilter));
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Введите имя режиссера");
                                String directorName = sc.next().toLowerCase();
                                boolean foundDirector = false;

                                for (Movies movie : movies) {
                                    if (movie.getDirector().getFullName().toLowerCase().contains(directorName)) {
                                        System.out.println("Фильмы с выбранным режиссёром: " + movie.getName());
                                        System.out.println("Режиссёр: " + movie.getDirector().getFullName());
                                        foundDirector = true;
                                    }
                                }
                                if (!foundDirector) {
                                    System.out.println("Фильмы с режиссёром " + directorName + " не найдены.");
                                }
                                break;
                            default:
                                System.out.println("Выходит ошибка может проверите корректность введенных данных");
                        }
                        break;
                    case 4:
                        System.out.println("Введите любимого актера");
                        String favoriteActor = sc.next().toLowerCase();
                        for (Movies movieActor : moviesHashSet){
                           for (CastMember castMember: movieActor.getCast()){
                               if(castMember.getFullname().toLowerCase().contains(favoriteActor));
                               System.out.println("Фильмы с вашим актёром: " + movieActor.getName());
                               break;
                           }
                        }
                        break;
                    case 5:
                        System.out.println("Введите имя режиссера");
                        String nameDirector = sc.next().toLowerCase();
                        MovieSearcher searchMovie = new MovieSearcher(movies);
                        Map<String, List<String>> foundMovies = searchMovie.findMovieByDirector(nameDirector);
                        if (foundMovies.isEmpty()){
                            System.out.println("Фильмы не найдены с режиссером %s".formatted(nameDirector));
                        }else {
                            for (Map.Entry<String, List<String>> entry: foundMovies.entrySet()){
                                System.out.println("Фильм: " + entry.getKey());
                                System.out.println("Актеры: " + entry.getValue());
                            }
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
