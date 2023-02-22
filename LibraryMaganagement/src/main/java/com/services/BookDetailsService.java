package com.services;

import com.model.BookDetails;
import org.springframework.stereotype.Service;
import java.util.List;

public interface BookDetailsService {

    List<BookDetails> getBookDetails();

    BookDetails create(BookDetails bookDetails);


    BookDetails getBookById(int id);

    BookDetails updateBook(BookDetails bookDetails);


    BookDetails deleteBookById(int id);

}
