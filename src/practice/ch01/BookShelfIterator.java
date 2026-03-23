package practice.ch01;

import java.util.Iterator; //jdk 제공
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index; //책꽂이에서 현재 위치를 나타내는 변수

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0; //책꽂이의 첫 번째 책부터 시작하기 위해 index를 0으로 초기화
    }

    @Override //compiler에게 알려줌
    public boolean hasNext() { //책꽃이에서 꺼내올 다음 책이 있는지 확인하는 메소드
        if (index < bookShelf.getLength()) { //책의 개수보다 작으면
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() { //책꽂이에서 다음 책을 꺼내오는 메소드
        if (!hasNext()) {
            throw new NoSuchElementException(); //다음 책이 없으면 예외를 던짐
        }
        Book book = bookShelf.getBookAt(index); //책꽂이에서 현재 위치의 책을 가져옴
        index++;
        return book;
    }
}
