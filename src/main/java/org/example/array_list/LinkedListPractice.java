package org.example.array_list;

import java.awt.print.Book;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class BookStore{
    String name;
    String author;
    String isbn;
    double price;

    BookStore(String name, String author, String isbn, double price){
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Book = {name: "+name+" author: "+author+" isbn: "+isbn+" price: "+price+" }";
    }

    @Override
    public boolean equals(Object o){
        if(o == null)return false;
        if(o.getClass() != getClass()) return false;

        BookStore book = (BookStore) (o);
        return name == book.name && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, author);
    }

}
public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList<BookStore> books = new LinkedList<>();
        books.add(new BookStore("HP", "Ashu", "36728", 300.0));
        books.add(new BookStore("HP1", "Ashu1", "36728", 300.0));
        books.add(new BookStore("HP2", "Ashu2", "36728", 300.0));
        books.add(new BookStore("HP3", "Ashu3", "36728", 300.0));


        books.addFirst(new BookStore("HP4", "Ashu4", "36728", 300.0));
        books.addLast(new BookStore("HP5", "Ashu5", "36728", 300.0));

        System.out.println("BOOKS");
        for(BookStore book: books){
            System.out.println(book);
        }

        System.out.println("First Book In List: "+books.getFirst());
        System.out.println("Last Book In List: "+books.getLast());

        books.removeFirst();
        books.removeLast();

        System.out.println("UPDATED BOOKS AFTER REMOVING FIRST AND LAST");
        for(BookStore book: books){
            System.out.println(book);
        }

        BookStore searchBook = new BookStore("HP1", "Ashu1", "36728", 300.0);
        System.out.println(books.contains(searchBook));
    }
}
