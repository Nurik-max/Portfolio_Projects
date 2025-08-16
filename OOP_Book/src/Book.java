public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;

    public Book(String title, String author, int year, int pages){
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }
    public void displayInfo(){
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nYear of book: " + year + "\nPages: " + pages);
    }
}
