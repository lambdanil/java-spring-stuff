package io.github.lambdanil.spring;

public class Book {
    private String name;
    private String author;
    private long year;
    private long id;

    public Book() {
        super();
    }

    public Book(String name, String author, long year) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", id=" + id +
                '}';
    }
}
