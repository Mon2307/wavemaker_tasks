package com.service;

import com.model.BookDetails;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public interface BookDetailsService {

    String getBookByName();
    List<BookDetails> getBookDetails();

    BookDetails create(BookDetails bookDetails);


    BookDetails getBookById(int id);

    Boolean deleteBookById(int id);

    BigInteger totalbooks();
}
