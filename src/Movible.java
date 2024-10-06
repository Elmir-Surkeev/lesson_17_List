import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public interface Movible {
    String getString(Scanner sc, String sentence) throws Exception;
    int getInt(Scanner sc, String sentence) throws Exception;
    Map<String, List<String>> findMovieByDirector(String director) throws Exception;
    Map<String, List<String>> findMovieByActor(String actorName) throws Exception;
    Set<CastMember> getUniqueActorsSorted() throws Exception;
}
