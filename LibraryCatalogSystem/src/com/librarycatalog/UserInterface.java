package com.librarycatalog;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private LibraryCatalog catalog;
    private Scanner scanner;

    public UserInterface(LibraryCatalog catalog) {
        this.catalog = catalog;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nLibrary Catalog System");
            System.out.println("1. Add a book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by author");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 1) {
                addBook();
            } else if (option == 2) {
                searchByTitle();
            } else if (option == 3) {
                searchByAuthor();
            } else if (option == 4) {
                listBooks();
            } else if (option == 5) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn);
        catalog.addBook(book);
    }

    private void searchByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        List<Book> results = catalog.searchByTitle(title);

        if (results.isEmpty()) {
            System.out.println("No books found with the title: " + title);
        } else {
            System.out.println("Books found:");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private void searchByAuthor() {
        System.out.print("Enter author to search: ");
        String author = scanner.nextLine();
        List<Book> results = catalog.searchByAuthor(author);

        if (results.isEmpty()) {
            System.out.println("No books found by the author: " + author);
        } else {
            System.out.println("Books found:");
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private void listBooks() {
        catalog.listBooks();
    }

	public void start() {
		// TODO Auto-generated method stub
		
	}
}
