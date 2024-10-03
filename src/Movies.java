import java.util.List;
import java.util.Objects;

public class Movies{
    private String name;
    private int year;
    private Director director;
    private List<CastMember> cast;

    private int year_manufacture;
    private String description;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return year_manufacture == movies.year_manufacture && Objects.equals(name, movies.name) && Objects.equals(description, movies.description) && Objects.equals(director, movies.director) && Objects.equals(cast, movies.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year_manufacture, description, director, cast);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_manufacture() {
        return year_manufacture;
    }

    public void setYear_manufacture(int year_manufacture) {
        this.year_manufacture = year_manufacture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<CastMember> getCast() {
        return cast;
    }

    public void setCast(List<CastMember> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "name='" + name + '\'' +
                ", year_manufacture=" + year_manufacture +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }



}
