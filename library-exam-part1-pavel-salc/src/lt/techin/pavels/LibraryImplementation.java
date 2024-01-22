package lt.techin.pavels;

import lt.techin.library.Author;
import lt.techin.library.Book;
import lt.techin.library.BookCatalog;
import lt.techin.library.BookNotFoundException;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryImplementation implements BookCatalog {
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null || book.getTitle() == null ||
                book.getIsbn().isBlank() || book.getTitle().isBlank())
            throw new IllegalArgumentException();
        if (books.stream()
                .noneMatch(book1 -> book1.getIsbn().equals(book.getIsbn()))) {
            books.add(book);

        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException();
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findAny().orElseThrow(() -> new BookNotFoundException(""));
    }

    @Override
    public List<Book> searchBooksByAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) throw new IllegalArgumentException();
        return books.stream().filter(book -> book.getAuthors().stream().allMatch(author -> author.getName().contains(authorName))).toList();
    }

    @Override
    public int getTotalNumberOfBooks() {
        return books.size();
    }

    @Override
    public boolean isBookInCatalog(String isbn) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException();
        return books.stream()
                .anyMatch((book1 -> book1.getIsbn().equals(isbn)));
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException();
        return books.stream()
                .anyMatch((book1 -> book1.getIsbn().equals(isbn) && book1.isAvailable()));
    }

    @Override
    public Book findNewestBookByPublisher(String publisher) {
        if (publisher == null || publisher.isBlank()) throw new IllegalArgumentException();
        return books.stream().filter(book -> book.getPublisher().equals(publisher)).max(Comparator.comparing(Book::getPublicationYear)).orElseThrow(() -> new BookNotFoundException(""));
    }

    @Override
    public List<Book> getSortedBooks() {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear).thenComparing(Book::getTitle).thenComparing(Book::getPageCount)).toList();
    }

    @Override
    public Map<String, List<Book>> groupBooksByPublisher() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> filterBooks(Predicate<Book> predicate) {
        if (predicate == null) throw new IllegalArgumentException();
        return books.stream()
                .filter(predicate).toList();
    }

    @Override
    public BigDecimal calculateTotalPrice() {
        return books.stream().map(Book::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Book> sortedByPrice() {
        return books.stream().sorted(Comparator.comparing(Book::getPrice)).toList();
    }

    public List<Book> findByPartOfTitle(String partOfTitle) {
        if (partOfTitle == null || partOfTitle.isBlank()) throw new IllegalArgumentException();
        List<Book> result = books.stream().filter(book -> book.getTitle().contains(partOfTitle)).toList();
        if (result.isEmpty()) {
            throw new BookNotFoundException("");
        } else {
            return result;
        }
    }
}
