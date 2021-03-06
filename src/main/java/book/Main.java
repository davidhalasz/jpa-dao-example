package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;


public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);
        BookGenerator bookGenerator = new BookGenerator();
        for (int i = 0; i < 1000; i++) {
            Book book = bookGenerator.randomBook();
            bookDao.persist(book);
        }
        bookDao.findAll()
                .forEach(System.out::println);
    }
}
