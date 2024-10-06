import java.util.*;

public class Action {
    public static void start() throws Exception {
        try {
            JSONFileHandler jsonFileHandler = new JSONFileHandler();
            List<Movies> movies = jsonFileHandler.getMovies();
            HashSet<Movies> moviesHashSet = new HashSet<>(jsonFileHandler.getMovies());
            MovieImpl movieImpl = new MovieImpl();

            boolean checkWorkWhile = true;
            while (checkWorkWhile) {
                Scanner sc = new Scanner(System.in);
                int choice = movieImpl.getInt(sc, "Добрый день уважаемый киноман\n" +
                        "введите 1 для просмотра всех фильмов\n" +
                        "введите 2 для поиска по названию\n" +
                        "введите 3 для сортировки фильмов по параметру\n" +
                        "введите 4 для поиска фильмов по актёру\n" +
                        "введите 5 для поиска фильмов по режиссёру\n" +
                        "введите 6 для поиска фильмов по году выпуска\n" +
                        "введите 7 для поиска фильмов по актёру\n" +
                        "введите 8 для списка актёров и фильмов с их ролями\n" +
                        "введите 0 для завершения работы программы");


                switch (choice) {
                    case 0:
                        checkWorkWhile = false;
                        break;
                    case 1:
                        try {
                            for (Movies movie : movies) {
                                System.out.println(movie.toString());
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при выводе всех фильмов: " + e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            String nameSearch = movieImpl.getString(sc, "название для пойска");
                            boolean found = false;
                            for (Movies movieSearch : movies) {
                                if (movieSearch.getName().toLowerCase().contains(nameSearch)) {
                                    System.out.println("Film : %s".formatted(movieSearch.getName()));
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Ничего по запросу - %s".formatted(nameSearch));
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при поиске фильма по названию: " + e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            int choiceSort = movieImpl.getInt(sc, "Киноман, у нас для тебя есть несколько выбора сортировки смотри \n" +
                                                                            "\" введи 1 для сортировки по году выпуска+\n" +
                                                                            "\" введи 2 для сортировки по полному названию\n" +
                                                                            "\" введи 3 для сортировки по любимому режиссеру\n" +
                                                                            "\"(можешь писать не учитывая регистры");
                            switch (choiceSort) {
                                case 1:
                                    int choiceSortYear = movieImpl.getInt(sc, "Введите 1 для сортировки по возрастанию \n" +
                                            "введите 2 для сортировки по убыванию");
                                    if (choiceSortYear == 1) {
                                        movies.sort(Comparator.comparing(Movies::getYear));
                                        System.out.println("Фильмы по возрастанию года выпуска:");
                                        movies.forEach(movie -> System.out.println("Название фильма: " + movie.getName() +
                                                " - Год выпуска: " + movie.getYear()));
                                    } else if (choiceSortYear == 2) {
                                        movies.sort(Comparator.comparing(Movies::getYear).reversed());
                                        System.out.println("\nФильмы по убыванию года выпуска:");
                                        movies.forEach(movie -> System.out.println("Название фильма: " + movie.getName() + " - Год выпуска: " + movie.getYear()));
                                    } else {
                                        throw new Exception("Вы ввели неправильные данные для сортировки поиска");
                                    }
                                    break;
                                case 2:
                                    boolean foundd = false;
                                    String nameSearchFilter = movieImpl.getString(sc, "название для поиска");
                                    for (Movies movieSearch : movies) {
                                        if (movieSearch.getName().toLowerCase().contains(nameSearchFilter)) {
                                            System.out.println("Фильмы : %s".formatted(movieSearch.getName()));
                                            foundd = true;
                                        }
                                    }
                                    if (!foundd) {
                                        System.out.println("Ничего по запросу - %s".formatted(nameSearchFilter));
                                    }
                                    break;
                                case 3:
                                    boolean foundDirector = false;
                                    String directorName = movieImpl.getString(sc, "имя режиссера");
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
                                    System.out.println("Ошибка: Проверьте корректность введенных данных");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при сортировке фильмов: " + e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            String favoriteActor = movieImpl.getString(sc, "актера");
                            for (Movies movieActor : moviesHashSet) {
                                for (CastMember castMember : movieActor.getCast()) {
                                    if (castMember.getFullname().toLowerCase().contains(favoriteActor)){
                                        System.out.println("Фильмы с вашим актёром: " + movieActor.getName());
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при поиске фильмов по актёру: " + e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            String nameDirector = movieImpl.getString(sc, "имя режиссера");
                            Map<String, List<String>> foundMovies = movieImpl.findMovieByDirector(nameDirector);
                            if (foundMovies.isEmpty()) {
                                System.out.println("Фильмы не найдены с режиссером %s".formatted(nameDirector));
                            } else {
                                for (Map.Entry<String, List<String>> entry : foundMovies.entrySet()) {
                                    System.out.println("Фильм: " + entry.getKey());
                                    System.out.println("Актеры: " + entry.getValue());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при поиске фильмов по режиссёру: " + e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            int yearRealise = movieImpl.getInt(sc, "Введите год выпуска");
                            if (yearRealise > 2024) {
                                System.out.println("Данные некорректны. Год должен быть меньше 2025.");
                            } else {
                                boolean checkOld = true;
                                for (Movies moviesYearRealise : movies) {
                                    if (moviesYearRealise.getYear() == yearRealise) {
                                        System.out.println("Фильм : %s ".formatted(moviesYearRealise.getName()));
                                        checkOld = false;
                                    }
                                }
                                if (checkOld) {
                                    System.out.println("Фильмы отсутствуют по поиску.");
                                }
                            }
                            if (yearRealise > 2024) {
                                System.out.println("Данные некорректны");
                            }

                        } catch (Exception e) {
                            System.out.println("Ошибка при поиске фильмов по году: " + e.getMessage());
                        }
                        break;
                    case 7:
                        try {
                            String nameActor = movieImpl.getString(sc, "актера");
                            Map<String, List<String>> foundMovie = movieImpl.findMovieByActor(nameActor);
                            if (foundMovie.isEmpty()) {
                                System.out.println("Фильмы не найдены с актером %s".formatted(nameActor));
                            } else {
                                for (Map.Entry<String, List<String>> entry : foundMovie.entrySet()) {
                                    System.out.println("Фильм: " + entry.getKey());
                                    System.out.println("Роль: " + entry.getValue());
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при поиске фильмов по актёру: " + e.getMessage());
                        }
                        break;
                    case 8:
                        try {
                            Set<CastMember> sortedActors = movieImpl.getUniqueActorsSorted();
                            System.out.println("Список всех актёров с их ролями:");
                            sortedActors.forEach(actor -> System.out.println(actor));
                            movies.sort(Comparator.comparing(Movies::getYear));
                            System.out.println("Фильмы, отсортированные по году:");
                            movies.forEach(movie -> System.out.println(movie.getName() + " (" + movie.getYear() + ")"));
                        } catch (Exception e) {
                            System.out.println("Ошибка при выводе списка актёров: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Вы ввели некорректное значение");
                }
            }
        }
        catch (RuntimeException e) {
            System.out.println("Общая ошибка программы: " + e.getMessage());
        }
    }
}
