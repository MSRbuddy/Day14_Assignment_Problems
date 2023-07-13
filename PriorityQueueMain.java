import java.util.PriorityQueue;

class Books implements Comparable<Books> {
    private String title;
    private String author;
    private int year;

    public Books(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Books other) {
        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year;
    }
}

public class PriorityQueueMain {
    public static void main(String[] args) {
        PriorityQueue<Books> bookQueue = new PriorityQueue<>();

        // Add books to the queue
        bookQueue.add(new Books("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        bookQueue.add(new Books("To Kill a Mockingbird", "Harper Lee", 1960));
        bookQueue.add(new Books("Pride and Prejudice", "Jane Austen", 1813));
        bookQueue.add(new Books("1984", "George Orwell", 1949));

        // Print all the books in the queue
        System.out.println("All books in the queue:");
        while (!bookQueue.isEmpty()) {
            Books book = bookQueue.poll();
            System.out.println(book);
        }
    }
}
