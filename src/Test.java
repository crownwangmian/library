import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Test {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();

        Book book1 = new Book("Java Programming", 299.99);
        EBook ebook1 = new EBook("Python Programming", 199.99, 5.0);

        library.addBook(book1);
        library.addBook(ebook1);

        String[] menu = {"1. Add Book", "2. Display All Books", "3. Sort Books by Price", "4. Sort Books by Title", "5. Search Book by Title or Price", "6. Exit"};

        System.out.println("welcome to IT school`s library");

        Scanner sc = new Scanner(System.in);

        while (true) {
            Arrays.stream(menu).forEach(System.out::println);
            String choiceStr = sc.nextLine();
            if (choiceStr.matches("\\d+")) {  // sing regular expressions so avoid potential errors and skip using try catch
                int choice = Integer.parseInt(choiceStr);
                if (choice == 6) {
                    System.out.println("Welcome to use again.");
                    break;
                }
                menu(choice, library);  // create a Fun method to handle the menu choices
            } else {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }


    private static void menu(int choice, LibrarySystem library) {
        switch (choice) {
            case 1:
                addBook(library);
                System.out.println(Book.getBookCount());
                break;
            case 2:
                System.out.println("Displaying all books:");
                library.displayAllBooks();
                break;
            case 3:
                System.out.println("Sorting books by price:");
                library.bubbleSortByPrice();
                library.displayAllBooks();
                break;
            case 4:
                System.out.println("Sorting books by title:");
                library.selectionSortByTitle();
                library.displayAllBooks();
                break;
            case 5:
                System.out.println("Searching for book by title or price:");
                searchBookByNameOrPrice(library);
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void addBook(LibrarySystem library) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the type of book to add:");
        System.out.println("1. Add a Regular Book");
        System.out.println("2. Add an eBook");
        String typeChoice = sc.nextLine();

        String title;
        double price;

        switch (typeChoice) {
            case "1":
                System.out.println("Enter book title:");
                title = sc.nextLine();
                price = getValidDoubleInput(sc, "Enter book price:");
                Book regularBook = new Book(title, price);
                library.addBook(regularBook);
                break;
            case "2":
                System.out.println("Enter book title:");
                title = sc.nextLine();
                price = getValidDoubleInput(sc, "Enter book price:");
                double fileSize = getValidDoubleInput(sc, "Enter file size (MB):");
                EBook ebook = new EBook(title, price, fileSize);
                library.addBook(ebook);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 for Regular Book or 2 for eBook.");
        }
    }

    // Helper method to get valid double input
    private static double getValidDoubleInput(Scanner sc, String prompt) {
        double value;
        while (true) {
            try {
                System.out.println(prompt);
                value = Double.parseDouble(sc.nextLine());
                break;  // valid input, break out of the loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
        return value;
    }

    private static void searchBookByNameOrPrice(LibrarySystem library) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book's name or price:");
        String input = sc.nextLine();
        try {
            // if type is double
            double priceQuery = Double.parseDouble(input);
            // search books by price
            Book foundBook = library.linearSearch(priceQuery);  // 调用按价格搜索的方法
            if (foundBook != null) {
                foundBook.displayDetails();
            } else {
                System.out.println("No book found with the given price.");
            }
        } catch (NumberFormatException e) {
            // if not double, search by name
            Book foundBook = library.linearSearch(input);  // Implement method overloading
            if (foundBook != null) {
                foundBook.displayDetails();
            } else {
                System.out.println("No book found with the given title.");
            }
        }
    }

}

