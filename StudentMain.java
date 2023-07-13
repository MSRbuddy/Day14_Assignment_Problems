class Student {
    private String name;
    private int age;
    private int ID;

    public Student(String name, int age, int ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public void printNameAndAge() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        // Create a student object
        Student student = new Student("Meghana Dasari", 20, 525);

        // Print the name and age of the student
        student.printNameAndAge();
    }
}
