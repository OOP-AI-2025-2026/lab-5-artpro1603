package ua.opnu;

public class Main {
    public static void main(String[] args) {
        // Створюємо об'єкти Student та Lecturer
        Student s1 = new Student("Іваненко", "Олег", 20, "АІ-244", "ST12345");
        Student s2 = new Student("Петренко", "Марія", 19, "АІ-242", "ST12346");

        Lecturer l1 = new Lecturer("Сидоренко", "Олександр", 45, "Комп'ютерні науки", 15000);
        Lecturer l2 = new Lecturer("Коваль", "Ірина", 38, "Математика", 12000);

        Person[] people = { s1, s2, l1, l2 };

        for (Person p : people) {
            System.out.println(p.toString());
        }
    }
}