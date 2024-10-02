import java.util.ArrayList;
import java.util.Collections;

public class LibrarySystem {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.search(title)) {
                return book;
            }
        }
        return null;
    }

    public Book linearSearch(double price) {
        for (Book book : books) {
            if (book.search(price)) {
                return book;
            }
        }
        return null;
    }

//    public void bubbleSortByPrice() {
//        int n = books.size();
//        boolean swapped;
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (books.get(j).price > books.get(j + 1).price) {
//                    Collections.swap(books, j, j + 1);
//                    swapped = true;  // 发生交换
//                }
//            }
//            // 如果没有发生交换，提前终止排序
//            if (!swapped) {
//                break;
//            }
//        }
//    }

    public void bubbleSortByPrice() {
        int n = books.size();
        boolean swapped;
        double epsilon = 0.0001;  // 定义容差范围，确保浮点数比较的精度

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // 使用容差范围进行浮点数比较
                if (compareDouble(books.get(j).price, books.get(j + 1).price) > 0) {
                    Collections.swap(books, j, j + 1);
                    swapped = true;  // 发生交换
                }
            }
            // 如果没有发生交换，提前终止排序
            if (!swapped) {
                break;
            }
        }
    }

    // 自定义浮点数比较方法，使用 epsilon 来比较两个 double 值
    private int compareDouble(double d1, double d2) {
        double epsilon = 0.0001;  // 设置容差
        if (Math.abs(d1 - d2) < epsilon) {
            return 0;  // 两个值在容差范围内，认为相等
        } else if (d1 > d2) {
            return 1;  // d1 大于 d2
        } else {
            return -1;  // d1 小于 d2
        }
    }


    public void selectionSortByTitle() {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (books.get(j).title.compareToIgnoreCase(books.get(minIndex).title) < 0) { //忽略大小写
                    minIndex = j;
                }
            }
            Collections.swap(books, i, minIndex);
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("Java Programming", 299.99);
        EBook ebook1 = new EBook("Python Programming", 199.99, 5.0);

        library.addBook(book1);
        library.addBook(ebook1);

        System.out.println("All books:");
        library.displayAllBooks();

        System.out.println("\nSorting books by price:");
        library.bubbleSortByPrice();
        library.displayAllBooks();

        System.out.println("\nSorting books by title:");
        library.selectionSortByTitle();
        library.displayAllBooks();

        System.out.println("\nSearching for book with title 'Java':");
        Book foundBook = library.linearSearch("Java");
        if (foundBook != null) {
            foundBook.displayDetails();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("\nTotal number of books: " + Book.getBookCount());
    }
}