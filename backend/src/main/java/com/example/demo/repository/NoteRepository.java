package com.example.demo.repository;

import com.example.demo.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}



//Here we have the connection to the database
/*This repository extends from JpaRepository, its arguments gonna be first the type of data,
that are going to represent the table, and second the data Type of the identifier. */