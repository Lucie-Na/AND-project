package android.bounsha_company.mycozylib.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

@Entity(tableName = "book")
public class Book implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "ID")
    public int localID;
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "subtitle")
    private String subtitle;
    @ColumnInfo(name = "authors")
    private String authors;
    @ColumnInfo(name = "editor")
    private String publishers;
    @ColumnInfo(name = "published_date")
    private int publish_date;
    @ColumnInfo(name = "number_of_pages")
    private int number_of_pages;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "image")
    private String url;

    // constructor
    public Book(@NonNull String title, String subtitle, String author, String publisher,
                int publish_date, String description, int number_of_pages, String url)
    {
        setTitle(title);
        setSubtitle(subtitle);
        setAuthors(authors);
        setPublishers(publishers);
        setPublish_date(publish_date);
        setDescription(description);
        setNumber_of_pages(number_of_pages);
        setUrl(url);
    }


    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public int getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(int publish_date) {
        this.publish_date = publish_date;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
