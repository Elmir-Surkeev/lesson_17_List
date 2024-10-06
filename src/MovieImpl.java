import java.util.*;

public class MovieImpl implements Movible{
    private List<Movies> movies;
    @Override
    public String getString(Scanner sc, String sentence) throws Exception {
        System.out.println("Введите %s".formatted(sentence));
        String name = sc.next().toLowerCase();
        return name;
    }
    @Override
    public int getInt(Scanner sc, String sentence)throws Exception{
        System.out.println("(Вводите число)\n %s".formatted(sentence));
        int count = sc.nextInt();
        return count;
    }

    @Override
    public Map<String, List<String>> findMovieByDirector(String directorName){
        Map<String, List<String>> result = new HashMap<>();

        for (Movies movie : movies) {
            if (movie.getDirector().getFullName().toLowerCase().contains(directorName)) {
                String movieName = movie.getName();
                List<String> actors = movie.getCast().stream()
                        .map(castMember -> castMember.getFullName())
                        .toList();
                result.put(movieName, actors);
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> findMovieByActor(String actorName){
        Map<String, List<String>> result = new HashMap<>();

        for (Movies movie : movies) {
            for (CastMember castMember: movie.getCast()){
                if (castMember.getFullname().toLowerCase().contains(actorName)){
                    String movieName = movie.getName();
                    List<String> roles = movie.getCast().stream()
                            .map(CastMember::getFullName)
                            .toList();
                    result.put(movieName, roles);

                }
            }
        }
        return result;
    }

    @Override
    public Set<CastMember> getUniqueActorsSorted() {
        Set<CastMember> uniqueActors = new HashSet<>();

        for (Movies movie : movies) {
            for (CastMember castMember : movie.getCast()) {
                uniqueActors.add(new CastMember(castMember.getFullName(), castMember.getRole()));
            }
        }

        return new TreeSet<>(Comparator.comparing(CastMember::getFullName));
    }
}
