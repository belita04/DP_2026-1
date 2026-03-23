package hw.ch01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfYearIterator implements Iterator<Book> {
    private ArrayList<Book> sortedBooks;
    private int index;

    public BookShelfYearIterator(BookShelf bookShelf) {
        this.sortedBooks = new ArrayList<Book>();
        this.index = 0;

        for (int i = 0; i < bookShelf.getLength(); i++) {
            sortedBooks.add(bookShelf.getBookAt(i));
        }

        for (int i = 0; i < sortedBooks.size() - 1; i++) {
            for (int j = i + 1; j < sortedBooks.size(); j++) {
                if (sortedBooks.get(i).getYear() < sortedBooks.get(j).getYear()) {
                    Book temp = sortedBooks.get(i);
                    sortedBooks.set(i, sortedBooks.get(j));
                    sortedBooks.set(j, temp);
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < sortedBooks.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Book book = sortedBooks.get(index);
        index++;
        return book;
    }
}