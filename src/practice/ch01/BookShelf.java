package practice.ch01;

import java.util.Iterator;
//java.lang은 자동으로 import되기 때문에 생략 가능
public class BookShelf implements 
 { /*주석해제하면 방법2 */
//public class BookShelf { /*주석해제하면 방법1 */
    private Book[] books; //배열 선언 책꽂이가 책을 가지고 있다.
    private int last = 0; //책의 마지막 위치

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; //배열 생성될 때 최대 크기 필요
    }

    public Book getBookAt(int index) { //책을 가져오는  메소드   
        return books[index];
    }

    public void appendBook(Book book) { //책을 추가하는 메소드
        this.books[last] = book;
        last++;
    }

    public int getLength() { //책의 개수를 반환하는 메소드
        return last;
    }

    @Override
    public Iterator<Book> iterator() { //자기 자신(현재 책꽂이)의 Iterator를 생성해서 반환하는 메소드
        return new BookShelfIterator(this); //this는 현재 책꽂이를 가리킴
    } /*주석해제하면 방법2 */
}
