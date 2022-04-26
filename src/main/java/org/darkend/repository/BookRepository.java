package org.darkend.repository;

import io.micronaut.core.annotation.NonNull;
import org.darkend.entity.Book;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface BookRepository {

    @NonNull
    Publisher<Book> list();

    Mono<Boolean> save(@NonNull @NotNull @Valid Book book);
}
