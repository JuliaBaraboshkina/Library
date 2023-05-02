import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = createBooks(); // Создание списка книг
        Library library = new Library(); // Создание объекта библиотеки
        Room room = new Room(); // Создание объекта читательного зала
        library.setBooks(books); // Установка списка книг в библиотеке

        // Создание потоков для каждого читателя
        Thread reader1 = new Thread(new Reader(library, room, "Антонов"), "reader1");
        Thread reader2 = new Thread(new Reader(library, room, "Веселова"), "reader2");
        Thread reader3 = new Thread(new Reader(library, room, "Смирнов"), "reader3");
        Thread reader4 = new Thread(new Reader(library, room, "Дневная"), "reader4");
        Thread reader5 = new Thread(new Reader(library, room, "Елисеев"), "reader5");
        Thread reader6 = new Thread(new Reader(library, room, "Флорова"), "reader6");

        // Запуск потоков
        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        reader5.start();
        reader6.start();
    }

    // Метод создания списка книг
    private static ArrayList<Book> createBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            String name = "«Книга №" + i +"»";
            Book book = new Book(name, new Random().nextBoolean());
            books.add(book);
        }
        return books;
    }
}