import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class Book implements BookOperations {
    private static int bookCount = 0;

    public static int getBookCount() {
        return bookCount;
    }

    protected String title;
    protected double price;
    protected int bookId;
    protected Date addedDate;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        this.bookId = new Random().nextInt(1000);
        this.addedDate = new Date();
        bookCount++;
    }

    @Override
    public void displayDetails() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(addedDate);
        System.out.printf("Title: %s, Price: %.2f, Book ID: %d, Added Date: %s\n", title, price, bookId, formattedDate);
    }

    public boolean search(String query) {
        return title.contains(query);
    }

    public boolean search(double price) { //解决double所带来的失精的问题
        double tolerance = 0.01;
        return Math.abs(this.price - price) < tolerance;

    }
}