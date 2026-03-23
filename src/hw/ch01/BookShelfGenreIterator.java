package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfGenreIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private String targetGenre;
    private int index;

    public BookShelfGenreIterator(BookShelf bookShelf, String targetGenre) {
        this.bookShelf = bookShelf;
        this.targetGenre = targetGenre;
        this.index = 0;
        findNextGenreBook();
    }

    private void findNextGenreBook() {
        while (index < bookShelf.getLength()) {
            Book book = bookShelf.getBookAt(index);
            if (book.getGenre().equals(targetGenre)) {
                break;
            }
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Book book = bookShelf.getBookAt(index);
        index++;
        findNextGenreBook();
        return book;
    }
}