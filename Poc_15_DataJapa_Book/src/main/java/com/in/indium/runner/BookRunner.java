package com.in.indium.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in.indium.model.Auther;
import com.in.indium.model.Book;
import com.in.indium.repo.AutherRepo;
import com.in.indium.repo.BookRepo;
@Component
public class BookRunner implements CommandLineRunner {
    @Autowired
	private BookRepo repo;
    
    @Autowired
    private AutherRepo aurepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//repo.save(new Book(1,"r",5000.8,);
		Book book=new Book();
		book.setId(1);
		book.setName("java");
		book.setCost(5000.8);
		
		   //
		  book.setAuth( Arrays.asList( new Auther(101), new Auther(102), new
		  Auther(103) ) );
		 
		
		/*
		 * book.setAuth(
		 * 
		 * Arrays.asList( aurepo.findById(105), aurepo.findById(106) ) );
		 */
		
		repo.save(book);
	
	}

}
