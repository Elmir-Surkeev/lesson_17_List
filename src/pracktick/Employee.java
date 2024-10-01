package pracktick;

public class Employee implements Comparable<Employee>{
    private String name;
    private String surname;
    private int years;

    public Employee(String name, String surname, int years){
        this.name = name;
        this.surname = surname;
        this.years = years;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    @Override
    public String toString(){
        return String.format("[%s] %s %s", years, surname, name);
    }

    @Override
    public int compareTo(Employee o) {
        //сортировка фамилий по умолчанию
        if(this.getSurname().equals(o.getSurname())){
            return this.getName().compareTo(o.getName());
        }
        return this.getSurname().compareTo(o.getSurname());
    }
}
