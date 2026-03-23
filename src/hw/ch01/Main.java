package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("학번: 20240761 이름: 이명진");
        System.out.println();

        BookShelf shelf = new BookShelf(10);

        shelf.appendBook(new Book("클린코드", "기술", 2008, 30000.0));
        shelf.appendBook(new Book("해리포터와 마법사의 돌", "소설", 1997, 15000.0));
        shelf.appendBook(new Book("사피엔스", "역사", 2011, 18000.0));
        shelf.appendBook(new Book("이펙티브 자바", "기술", 2018, 36000.0));
        shelf.appendBook(new Book("객체지향의 사실과 오해", "기술", 2015, 20000.0));
        shelf.appendBook(new Book("레미제라블", "소설", 1862, 12000.0));
        shelf.appendBook(new Book("총균쇠", "역사", 1997, 22000.0));
        shelf.appendBook(new Book("리팩터링", "기술", 2018, 34000.0));
        shelf.appendBook(new Book("로마인 이야기", "역사", 1992, 25000.0));
        shelf.appendBook(new Book("어린왕자", "소설", 1943, 9000.0));

        System.out.println("=== 소설 장르 도서 목록 ===");
        Iterator<Book> genreIt = shelf.iteratorByGenre("소설");
        while (genreIt.hasNext()) {
            Book book = genreIt.next();
            printBook(book);
        }

        System.out.println();

        // 소설만 따로 담을 책장 생성
        BookShelf novelShelf = new BookShelf(10);
        Iterator<Book> novelIt = shelf.iteratorByGenre("소설");
        while (novelIt.hasNext()) {
            novelShelf.appendBook(novelIt.next());
        }

        System.out.println("=== 소설 장르 도서 목록 (출판연도 역순) ===");
        Iterator<Book> yearIt = novelShelf.iteratorByYear();
        while (yearIt.hasNext()) {
            Book book = yearIt.next();
            printBook(book);
        }
    }

    public static void printBook(Book book) {
        System.out.println(
            "제목: " + book.getName()
            + " / 장르: " + book.getGenre()
            + " / 출판연도: " + book.getYear()
            + " / 가격: " + book.getPrice()
        );
    }
}