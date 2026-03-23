package practice.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240761 이름: 이명진");

        // 책 테스트
        Book book = new Book("name: Java Programming");
        System.out.println("Book Name: " + book.getName());

        // 책장 테스트
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("name: Java Programming")); //javaprogramming 책을 꽂음
        bookShelf.appendBook(new Book("name: Design Patterns")); //Design Patterns 책을 꽂음
        bookShelf.appendBook(new Book("name: Effective Java")); //Effective Java 책을 꽂음

        //책장에 있는 책 출력

        //방법1: 클라이언트가 책꽂이에 직접 접근하여 책을 가져오는 방법
        for(int i = 0; i < bookShelf.getLength(); i++) {
            System.out.println("Book " + (i + 1) + ": " + bookShelf.getBookAt(i).getName()); //getbookAt을 알고 있어야함

        }
        //client가 영향을 덜 받게 하려면 iterator를 이용하는 방법이 더 좋음
        // 방법 2: Iterator를 통해서 책꽂이에 책을 꺼내오는 방법
        //Iterator를 얻어옴
        Iterator<Book> it = bookShelf.iterator();
        while(it.hasNext()) { 
            System.out.println("Book: " + it.next().getName());
        }

        // 방법3 확장for문을 이용한 방법
        // 이게 가능한 이유는 BookShelf 클래스가 Iterable 인터페이스를 구현했기 때문
        for(Book b : bookShelf) { //형식: for(요소타입 변수명 : 컬렉션) {... } 
            System.out.println("Book: " + b.getName());
        }


    }
}