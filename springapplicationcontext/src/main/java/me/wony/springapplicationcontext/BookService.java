package me.wony.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepository;

    public void printBookRepository(){
        System.out.println(this.bookRepository.size());
    }

}
