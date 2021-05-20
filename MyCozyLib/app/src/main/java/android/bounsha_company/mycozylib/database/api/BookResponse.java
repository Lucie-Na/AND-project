package android.bounsha_company.mycozylib.database.api;

import android.bounsha_company.mycozylib.models.Book;

import java.util.List;

public class BookResponse
{
    private String title;
    private String subtitle;
    private String authors;
    private String publisher;
    private int publishedDate;
    private String description;
    private int pageCount;
    private String thumbnail;

    private List<Book> books;

    public Book getBook()
    {
        Book newBook = new Book(title, subtitle, authors, publisher, publishedDate, description, pageCount, thumbnail);
        books.add(newBook);
        return newBook;
    }

    public List<Book> getListBook()
    {
        return books;
    }
}
