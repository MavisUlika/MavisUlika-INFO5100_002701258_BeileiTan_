package neu5100;

public class TextBook {
    int id;
    String title;
    String author;
    boolean isHardCover;
    boolean isDamaged;
    int numberOfPages;
    String publisher;
    String publishDate;

    // Constructor Declaration of class
    public TextBook(int id, boolean isHardCover, int numberOfPages, String title) {
        this.id = id;
        this.isHardCover = isHardCover;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

    //get id
    public int getId(){
        return id;
    }

    //Method 1
    public boolean isHardCover(){
        return isHardCover;
    }

    //Method 2
    public int getNumberOfPages(){
        return numberOfPages;
    }

    //method 3
    public String getTitle(){
        return title;
    }

    @Override
    public String toString()
    {
        return("the TextBook has id:" + this.getId());
    }

    // Main method to instantiate at least 3 objects
    public static void main(String[] args){
        TextBook g = new TextBook(7,true, 300, "Algorithm");
        System.out.println(g);
    }

}
