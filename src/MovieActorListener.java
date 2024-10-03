import java.util.*;

public class MovieActorListener {
    private List<Movies> movies;

    public MovieActorListener(List<Movies> movies) {
        this.movies = movies;
    }

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
