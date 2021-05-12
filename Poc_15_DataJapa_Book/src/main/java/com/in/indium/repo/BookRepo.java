package com.in.indium.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.indium.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
