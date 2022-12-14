package storage;


import model.Book;

public class BookStorage {

    private Book[] array = new Book[10];
    private int size = 0;


    public void add(Book book) {
        if (array.length == size) {
            extend();
        }
        array[size++] = book;

    }

    private void extend() {
        Book[] temp = new Book[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    public void printBooksByGenre(String genre) {
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i]);
                break;
            } else {
                System.out.println("The book you are looking for was not found");
            }
        }
    }

    public void printBooksByAuthorName(String authorName) {
        boolean b = false;
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthor().equals(authorName)) {
                System.out.println(array[i]);
                b = true;
            }
        }
        if (!b) {
            System.out.println("Wrong authorName");
        }
    }

    public void printBooksByPriceRange(double minPrice, double maxPrice) {
        boolean setPrice = false;
        for (int i = 0; i < size; i++) {
            if (array[i].getPrice() >= minPrice && array[i].getPrice() <= maxPrice) {
                System.out.println(i + " . " + array[i]);
                setPrice = true;
            }
            if (!setPrice) {
                System.out.println("Wrong price!");
            }
        }
    }


    public int getSize() {
        return size;
    }


}


