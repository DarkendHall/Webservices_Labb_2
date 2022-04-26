package org.darkend.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.darkend.MongoDbConfig;
import org.darkend.entity.Book;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Singleton
public class MongoDbBookRepository implements BookRepository {

    private final MongoDbConfig mongoConfig;
    private final MongoClient mongoClient;

    public MongoDbBookRepository(MongoDbConfig mongoConfig, MongoClient mongoClient) {
        this.mongoConfig = mongoConfig;
        this.mongoClient = mongoClient;
    }

    @Override
    @NonNull
    public Publisher<Book> list() {
        return getCollection().find();
    }

    @Override
    @NonNull
    public Mono<Boolean> save(@NonNull @NotNull @Valid Book book) {
        return Mono.from(getCollection().insertOne(book))
                .map(insertOneResult -> true)
                .onErrorReturn(false);
    }

    private MongoCollection<Book> getCollection() {
        return mongoClient.getDatabase(mongoConfig.getName())
                .getCollection(mongoConfig.getCollection(), Book.class);
    }
}
