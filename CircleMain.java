class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

public class CircleMain {
    public static void main(String[] args) {
        // Create a circle object with radius 5
        Circle circle = new Circle(7);

        // Calculate and print the area of the circle
        double area = circle.calculateArea();
        System.out.println("Area of Circle is : " + area);

        // Calculate and print the circumference of the circle
        double circumference = circle.calculateCircumference();
        System.out.println("Circumference of Circle is : " + circumference);
    }
}