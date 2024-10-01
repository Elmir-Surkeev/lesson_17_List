package pracktick;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Mainn {
    public static void mainn(String[] args) {
        List<Employee> data = new ArrayList<>();
        data.add(new Employee("Elmirbek", "Surkeev", 19));
        data.add(new Employee("Damirbiy", "Ibraimov", 18));
        data.add(new Employee("Nurislam", "Apdirapov", 18));

        //Collections.sort(data);
        for (Employee e: data){
            System.out.println(e);
        }
//        List<String> staff = new ArrayList<>();
//        staff.add("Vasya");
//        staff.add("Artem");
//        staff.add("Surkeev");
//        staff.add("Elmirbek");

        //Collections.sort(staff);
//        System.out.println(staff);
//        System.out.println(staff);
//        Collections.sort(staff, Comparator.naturalOrder());
//        System.out.println(staff);
//        Collections.sort(staff, Comparator.reverseOrder());
//        System.out.println(staff);

    }
//    public static void main(String[] args) {
//        //динамический массив начальный размер 2
//        List<String> list = new ArrayList<>(2);
//        //List
//        // doListStuff(list);
//        //связной список
//        List<String> linkedList = new ArrayList<>();
//
//        //Hash
//        //doHashStuff();
////
////        MyData obj1 = new MyData(1);
////        MyData obj2 = new MyData(2432);
////        MyData obj3 = new MyData(1);
////
////        Set<MyData> data = new HashSet<>();
////        data.add(obj1);
////        data.add(obj2);
////        System.out.println("Size should be 1. Actual: "+ data.size());
////        System.out.println("Contain obj 3: "+ data.contains(obj3));
////
////        for (MyData e: data){
////            System.out.println(e);
////        }
//        Map<String, String> phoneIndex = new HashMap<>();
//        phoneIndex.put("Vasya", "555-1274");
//        //нельзя два раза задавать значение, иначе ваши значения просто перепишутся
//        phoneIndex.put("Vasya", "New-555-1274");
//        phoneIndex.put("Elmirbek", "0995-19-09-19");
//        phoneIndex.put("Damirbiy", "0220-66-00-02");
//
//        //проверка на существования ключа выглядит следующим образом
//        System.out.println(phoneIndex.containsKey("Elmirbek"));
//        System.out.println(phoneIndex.containsKey("Elmir"));
//
//        //для получения значения ключа, существует 2 метода
//        //1 это name.get("name_key")
//        System.out.println(phoneIndex.get("Elmirbek"));
//        //2 это name.getOrDefault("name_key", "Name not found!")
//        System.out.println(phoneIndex.getOrDefault("Elmir", "Don't exist"));
//
//
//        String fmt = "Name : %s, Telephone: %s";
//        for (Map.Entry<String, String> kv: phoneIndex.entrySet()){
//            String msg = String.format(fmt, kv.getKey(), kv.getValue());
//            System.out.println(msg);
//        }
//
//    }

    public static void doListStuff(List<String> list){
        //Реально количество элементов в списке
        System.out.println("list size: %s".formatted(list.size()));
        list.add("First");
        list.add("Second");
        System.out.println("list size: %s".formatted(list.size()));
        list.add("Third");
        list.add("Fourth");
        System.out.println("list size: %s".formatted(list.size()));

        //удаляем элемент по списку
        //Удаление по индексу
        list.remove(1);
        //узнать индекс элемента
        //*.indexOf("data_name");
        System.out.println("Index of third "+ list.indexOf("Third"));
        //удаляем элемент по явному совпадению
        //медленно работает, требуется поиск по коллекцию
        list.remove("Third");
        //когда вызывается несуществующая переменная, выводится -1
        System.out.println("Index of third"+ list.indexOf("dontExistVariable"));
        System.out.println("list size: %s".formatted(list.size()));
        //добавление элемента по нулевому индексу
        //при добавленьях используется add(индекс, "text")
        list.add(0, "zeroth");
        //для вывода элемента по индексу можно использовать
        //name.get(индекс)
        System.out.println(list.get(0));
        //выполнение действий над всеми элементами в коллекциях
        //осуществляется forEach()

        list.forEach(System.out::println);
    }

    //в множестве отсеиваются похожие элементы
    public static void doHashStuff(){
        Set<String> countries = new HashSet<>();
        countries.add("England");
        countries.add("France");
        countries.add("Spain");

        //нижеприведенный код с добавлением "Spain" не будет иметься смысла
        //выведется ли один "Spain"
        ///countries.add("Spain");
        //countries.forEach(System.out::println);
        for (String e: countries){
            System.out.println(e);
        }
    }
}