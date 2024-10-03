import java.util.Objects;

public class CastMember {
    private String fullName;
    private String role;

    public CastMember(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastMember that = (CastMember) o;
        return Objects.equals(fullName, that.fullName) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, role);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFullname(){
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CastMember{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
