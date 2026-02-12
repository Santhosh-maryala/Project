
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;



// Custom Exception Class for unavailable books
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// 1. Book Class (Encapsulation)
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Initially available
    }

    // Getters and Setters (Encapsulation)
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

// 2. Member Class (Encapsulation, Collections for borrowed books)
class Member {
    private String memberId;
    private final String name;
    private List<Book> borrowedBooks = new ArrayList<>(); // Collections

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    public boolean returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}

// 3. Library Management Class (Collections, Comparator, Exception Handling)
public class LibraryManagementSystem {
    // Collections to store books and members
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    // A simple way to track issue dates and calculate fines. In a real system, you'd use a separate Issue record class
    private List<IssueRecord> issueRecords = new ArrayList<>();

    class IssueRecord {
        String bookId;
        String memberId;
        LocalDate issueDate;

        IssueRecord(String bookId, String memberId, LocalDate issueDate) {
            this.bookId = bookId;
            this.memberId = memberId;
            this.issueDate = issueDate;
        }
    }

    // Add sample data
    public LibraryManagementSystem() {
        books.add(new Book("B001", "The Lord of the Rings", "J.R.R. Tolkien"));
        books.add(new Book("B002", "Dune", "Frank Herbert"));
        books.add(new Book("B003", "Foundation", "Isaac Asimov"));
        members.add(new Member("M001", "Alice"));
        members.add(new Member("M002", "Bob"));
    }

    // Method to find a book by ID
    private Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    // Method to find a member by ID
    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    // Issue Book (Exception Handling, Prevent issuing if unavailable)
    public void issueBook(String bookId, String memberId) throws BookNotAvailableException {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);

        if (book == null || member == null) {
            System.out.println("Error: Book or Member not found.");
            return;
        }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book with ID " + bookId + " is currently unavailable.");
        }

        member.borrowBook(book);
        issueRecords.add(new IssueRecord(bookId, memberId, LocalDate.now()));
        System.out.println("Book " + bookId + " issued to Member " + memberId + ".");
    }

    // Return Book (Late fine calculation bonus)
    public void returnBook(String bookId, String memberId) {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        IssueRecord recordToRemove = null;

        if (book == null || member == null) {
            System.out.println("Error: Book or Member not found.");
            return;
        }

        for (IssueRecord record : issueRecords) {
            if (record.bookId.equals(bookId) && record.memberId.equals(memberId)) {
                recordToRemove = record;
                break;
            }
        }

        if (recordToRemove != null) {
            long daysLate = ChronoUnit.DAYS.between(recordToRemove.issueDate.plusDays(14), LocalDate.now()); // Assuming 14 days loan period
            if (daysLate > 0) {
                double fine = daysLate * 1.0; // $1.0 fine per day
                System.out.printf("Book returned late by %d days. Fine: $%.2f%n", daysLate, fine);
            } else {
                System.out.println("Book returned on time.");
            }
            member.returnBook(book);
            issueRecords.remove(recordToRemove);
        } else {
            System.out.println("Error: No issue record found for this book and member combination.");
        }
    }

    // Sort Books by Title or Author (Comparator)
    public void sortBooks(String by) {
        if (by.equalsIgnoreCase("title")) {
            Collections.sort(books, Comparator.comparing(Book::getTitle));
            System.out.println("Books sorted by Title:");
        } else if (by.equalsIgnoreCase("author")) {
            Collections.sort(books, Comparator.comparing(Book::getAuthor));
            System.out.println("Books sorted by Author:");
        } else {
            System.out.println("Invalid sort criteria. Use 'title' or 'author'.");
            return;
        }
        displayBooks();
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Sort Books by Title");
            System.out.println("4. Sort Books by Author");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMemberId = scanner.nextLine();
                    try {
                        library.issueBook(issueBookId, issueMemberId);
                    } catch (BookNotAvailableException e) {
                        System.out.println("Issuing Failed: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = scanner.nextLine();
                    library.returnBook(returnBookId, returnMemberId);
                    break;
                case 3:
                    library.sortBooks("title");
                    break;
                case 4:
                    library.sortBooks("author");
                    break;
                case 5:
                    library.displayBooks();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
