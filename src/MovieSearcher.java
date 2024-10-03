import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieSearcher {
    private List<Movies> movies;

    public MovieSearcher(List<Movies> movies) {
        this.movies = movies;
    }

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
}
