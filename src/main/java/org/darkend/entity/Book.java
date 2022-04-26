package org.darkend.entity;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Introspected
@Serdeable.Deserializable
public class Book {

    @NonNull
    @BsonProperty("title")
    private final String title;
    @NonNull
    @BsonProperty("author")
    private final String author;
    @NonNull
    @BsonProperty("category")
    private final String category;

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    @Creator
    @BsonCreator
    public Book(@NonNull @BsonProperty("title") String title, @NonNull @BsonProperty("author") String author,
                @NonNull @BsonProperty("category") String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }
}
