import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JSONFileHandler {
    public List<Movies> getMovies(){
        Gson gson = new Gson();

        Type mapType = new TypeToken<Map<String, List<Movies>>>(){}.getType();
        try (FileReader reader = new FileReader("movies.json")) {
            // Чтение и парсинг JSON в карту, где ключ - "movies", а значение - список фильмов
            Map<String, List<Movies>> movieMap = gson.fromJson(reader, mapType);
            return movieMap.get("movies"); // Возвращаем список фильмов
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
