
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Book class - represents a book in the library
class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;
    private String borrowerName;
    private LocalDate borrowDate;
    
    // Constructor
    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
        this.borrowerName = null;
        this.borrowDate = null;
    }
    
    // Getters and Setters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public String getBorrowerName() { return borrowerName; }
    public LocalDate getBorrowDate() { return borrowDate; }
    
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public void setBorrowerName(String borrowerName) { this.borrowerName = borrowerName; }
    public void setBorrowDate(LocalDate borrowDate) { this.borrowDate = borrowDate; }
    
    @Override
    public String toString() {
        String status = isAvailable ? "Available" : "Borrowed by " + borrowerName;
        return String.format("ID: %d | Title: %s | Author: %s | Category: %s | Status: %s",
                bookId, title, author, category, status);
    }
}

// Library class - manages all library operations
class Library {
    private ArrayList<Book> books;
    private HashMap<String, ArrayList<Book>> booksByCategory;
    private int nextBookId;
    
    public Library() {
        books = new ArrayList<>();
        booksByCategory = new HashMap<>();
        nextBookId = 1;
        
        // Add some sample books
        addSampleBooks();
    }
    
    // Add sample books to the library
    private void addSampleBooks() {
        addBook("The Java Programming Language", "James Gosling", "Programming");
        addBook("Clean Code", "Robert C. Martin", "Programming");
        addBook("Data Structures and Algorithms", "Thomas Cormen", "Computer Science");
        addBook("Introduction to Algorithms", "CLRS", "Computer Science");
        addBook("Harry Potter", "J.K. Rowling", "Fiction");
        addBook("The Hobbit", "J.R.R. Tolkien", "Fiction");
    }
    
    // Add a new book to the library
    public void addBook(String title, String author, String category) {
        Book newBook = new Book(nextBookId++, title, author, category);
        books.add(newBook);
        
        // Add to category map
        booksByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(newBook);
        
        System.out.println("✅ Book added successfully: " + newBook.getTitle());
    }
    
    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 No books in the library.");
            return;
        }
        
        System.out.println("\n📚 ALL BOOKS IN LIBRARY:");
        System.out.println("=" .repeat(80));
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    // Search books by title
    public void searchByTitle(String searchTitle) {
        System.out.println("\n🔍 Search Results for Title: '" + searchTitle + "'");
        System.out.println("=" .repeat(50));
        
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("❌ No books found with title containing: " + searchTitle);
        }
    }
    
    // Search books by author
    public void searchByAuthor(String searchAuthor) {
        System.out.println("\n🔍 Search Results for Author: '" + searchAuthor + "'");
        System.out.println("=" .repeat(50));
        
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(searchAuthor.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("❌ No books found by author: " + searchAuthor);
        }
    }
    
    // Display books by category
    public void displayByCategory(String category) {
        System.out.println("\n📖 Books in Category: '" + category + "'");
        System.out.println("=" .repeat(50));
        
        ArrayList<Book> categoryBooks = booksByCategory.get(category);
        if (categoryBooks == null || categoryBooks.isEmpty()) {
            System.out.println("❌ No books found in category: " + category);
            return;
        }
        
        for (Book book : categoryBooks) {
            System.out.println(book);
        }
    }
    
    // Borrow a book
    public void borrowBook(int bookId, String borrowerName) {
        Book book = findBookById(bookId);
        
        if (book == null) {
            System.out.println("❌ Book with ID " + bookId + " not found.");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("❌ Book '" + book.getTitle() + "' is already borrowed by " + book.getBorrowerName());
            return;
        }
        
        // Borrow the book
        book.setAvailable(false);
        book.setBorrowerName(borrowerName);
        book.setBorrowDate(LocalDate.now());
        
        System.out.println("✅ Book '" + book.getTitle() + "' borrowed successfully by " + borrowerName);
        System.out.println("📅 Borrow Date: " + book.getBorrowDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    
    // Return a book
    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        
        if (book == null) {
            System.out.println("❌ Book with ID " + bookId + " not found.");
            return;
        }
        
        if (book.isAvailable()) {
            System.out.println("❌ Book '" + book.getTitle() + "' is not currently borrowed.");
            return;
        }
        
        String previousBorrower = book.getBorrowerName();
        
        // Return the book
        book.setAvailable(true);
        book.setBorrowerName(null);
        book.setBorrowDate(null);
        
        System.out.println("✅ Book '" + book.getTitle() + "' returned successfully by " + previousBorrower);
    }
    
    // Find book by ID
    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    
    // Display available books only
    public void displayAvailableBooks() {
        System.out.println("\n📗 AVAILABLE BOOKS:");
        System.out.println("=" .repeat(80));
        
        boolean hasAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("❌ No books are currently available.");
        }
    }
    
    // Display borrowed books only
    public void displayBorrowedBooks() {
        System.out.println("\n📕 BORROWED BOOKS:");
        System.out.println("=" .repeat(80));
        
        boolean hasBorrowed = false;
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book + " | Borrowed on: " + 
                    book.getBorrowDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                hasBorrowed = true;
            }
        }
        
        if (!hasBorrowed) {
            System.out.println("✅ No books are currently borrowed.");
        }
    }
    
    // Get library statistics
    public void displayStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int borrowedBooks = 0;
        
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                borrowedBooks++;
            }
        }
        
        System.out.println("\n📊 LIBRARY STATISTICS:");
        System.out.println("=" .repeat(30));
        System.out.println("📚 Total Books: " + totalBooks);
        System.out.println("📗 Available Books: " + availableBooks);
        System.out.println("📕 Borrowed Books: " + borrowedBooks);
        System.out.println("📂 Categories: " + booksByCategory.size());
        
        System.out.println("\n📂 Books by Category:");
        for (String category : booksByCategory.keySet()) {
            System.out.println("   • " + category + ": " + booksByCategory.get(category).size() + " books");
        }
    }
}

// Main class with menu system
public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("🏛️  WELCOME TO LIBRARY MANAGEMENT SYSTEM");
        System.out.println("=========================================");
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    library.displayBorrowedBooks();
                    break;
                case 8:
                    displayByCategory();
                    break;
                case 9:
                    library.displayStatistics();
                    break;
                case 0:
                    System.out.println("👋 Thank you for using Library Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
            
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            clearScreen();
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n📋 LIBRARY MANAGEMENT SYSTEM - MENU");
        System.out.println("====================================");
        System.out.println("1. 📚 Display All Books");
        System.out.println("2. ➕ Add New Book");
        System.out.println("3. 🔍 Search Books");
        System.out.println("4. 📖 Borrow Book");
        System.out.println("5. 📤 Return Book");
        System.out.println("6. 📗 Display Available Books");
        System.out.println("7. 📕 Display Borrowed Books");
        System.out.println("8. 📂 Display Books by Category");
        System.out.println("9. 📊 Library Statistics");
        System.out.println("0. ❌ Exit");
        System.out.print("\nEnter your choice: ");
    }
    
    private static int getChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void addNewBook() {
        System.out.println("\n➕ ADD NEW BOOK");
        System.out.println("================");
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        
        library.addBook(title, author, category);
    }
    
    private static void searchBooks() {
        System.out.println("\n🔍 SEARCH BOOKS");
        System.out.println("===============");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.print("Enter your choice: ");
        
        int searchChoice = getChoice();
        
        switch (searchChoice) {
            case 1:
                System.out.print("Enter title to search: ");
                String title = scanner.nextLine();
                library.searchByTitle(title);
                break;
            case 2:
                System.out.print("Enter author to search: ");
                String author = scanner.nextLine();
                library.searchByAuthor(author);
                break;
            default:
                System.out.println("❌ Invalid search option.");
        }
    }
    
    private static void borrowBook() {
        System.out.println("\n📖 BORROW BOOK");
        System.out.println("===============");
        
        library.displayAvailableBooks();
        
        System.out.print("\nEnter Book ID to borrow: ");
        int bookId = getChoice();
        
        System.out.print("Enter borrower name: ");
        String borrowerName = scanner.nextLine();
        
        library.borrowBook(bookId, borrowerName);
    }
    
    private static void returnBook() {
        System.out.println("\n📤 RETURN BOOK");
        System.out.println("===============");
        
        library.displayBorrowedBooks();
        
        System.out.print("\nEnter Book ID to return: ");
        int bookId = getChoice();
        
        library.returnBook(bookId);
    }
    
    private static void displayByCategory() {
        System.out.print("Enter category name: ");
        String category = scanner.nextLine();
        library.displayByCategory(category);
    }
    
    private static void clearScreen() {
        // Simple way to clear screen (works on most terminals)
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}
