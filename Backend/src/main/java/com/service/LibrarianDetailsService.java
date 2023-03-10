package com.service;

import com.model.BookDetails;
import com.model.LibrarianDetails;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LibrarianDetailsService {

    List<LibrarianDetails> getLibrarianDetails();

    LibrarianDetails create(LibrarianDetails librarianDetails);

}
