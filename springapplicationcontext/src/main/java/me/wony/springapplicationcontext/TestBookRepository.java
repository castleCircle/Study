package me.wony.springapplicationcontext;


import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/*
프로파일
 */
@Repository
@Profile("!test")
public class TestBookRepository implements BookRepository{
}
