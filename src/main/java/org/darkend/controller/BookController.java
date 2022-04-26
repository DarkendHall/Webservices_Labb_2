package org.darkend.controller;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.darkend.entity.Book;
import org.darkend.repository.BookRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get
    Publisher<Book> list() {
        return bookRepository.list();
    }

    @Post
    Mono<HttpStatus> save(@NonNull @NotNull @Valid @Body Book book) {
        return bookRepository.save(book)
                .map(added -> added ? HttpStatus.CREATED : HttpStatus.CONFLICT);
    }
}
