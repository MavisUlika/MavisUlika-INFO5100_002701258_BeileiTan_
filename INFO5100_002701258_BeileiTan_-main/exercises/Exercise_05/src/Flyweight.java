import java.util.HashMap;

public class Flyweight {
    // 2nd step: Create concrete class implementing the same interface.
    public static class Book implements Language {
        private String language;
        private int numberOfPage;
        private int pubishedYear;
        private String author;

        public Book(String language) {
            this.language = language;
        }

        public void setNumberOfPage(int numberOfPage) {
            this.numberOfPage = numberOfPage;
        }

        public void setPubishedYear(int pubishedYear) {
            this.pubishedYear = pubishedYear;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void write() {
            System.out.println("The book is written in: " + language + ", number of page: " + numberOfPage + ", published year: " + pubishedYear + ", author: " + author);
        }
    }
    //3rd step: Create a factory to generate object of concrete class based on given information.
    public static class bookStorage{
        private static final HashMap bookMap = new HashMap<>();
        // Try to reuse already existing similar kind objects by storing them in Map
        public static Language getBook(String languange){
            Book book = (Book) bookMap.get(languange);
       //For Object written in existing language, no need to re-create it, hence reducing the number of objects created.
            if(book == null){
                book = new Book(languange);
                bookMap.put(languange, book);
                System.out.println("Creating circle written in language: " + languange);
            }
            return book;
        }
    }

    static String getRandomLanguage(){
        return Main.langauges[(int)(Math.random()* Main.langauges.length)];
    }

    static int getRandomPage(){
        return (int)(Math.random() * 100);
    }

    static int getRandomYear(){
        int min = 1861;
        int max = 1941;
        return min + (int)(Math.random() * (max - min + 1));
    }

}