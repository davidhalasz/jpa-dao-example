package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.ZoneId;

public class BookGenerator {
    Faker faker = new Faker();
    public Book randomBook() {
        return Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .pages(faker.number().randomDigitNotZero())
                .available(faker.bool().bool())
                .build();
    }
}
