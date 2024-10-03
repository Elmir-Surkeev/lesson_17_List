import java.util.Objects;

public class Director {
    private String fullName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(fullName, director.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Director(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
