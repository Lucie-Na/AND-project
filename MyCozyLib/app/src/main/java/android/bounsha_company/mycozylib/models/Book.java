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
    int localID;
    @NonNull
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "subtitle")
    private String subtitle;
    @ColumnInfo(name = "authors")
    private String authors;
    @ColumnInfo(name = "editor")
    private String editor;
    @ColumnInfo(name = "published_date")
    private int publishedDate;
    @ColumnInfo(name = "number_of_pages")
    private int pageCount;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "image")
    private String image;

    // constructor
    public Book(@NonNull String title, String subtitle, String authors, String editor,
                int publishedDate, String description, int pageCount, String image)
    {
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.editor = editor;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.image = image;
    }

    // get and set methods
    public int getLocalID() { return localID; }

    public void setLocalID(int localID) { this.localID = localID; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String publisher) {
        this.editor = publisher;
    }

    public int getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
