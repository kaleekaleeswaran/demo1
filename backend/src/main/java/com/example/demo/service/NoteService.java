package com.example.demo.service;


//Here we will create the methods that we have

import com.example.demo.entity.Note;

import java.util.List;

public interface NoteService {

    //bring all the notes
     List<Note> getNotes();

     //save notes
    Note saveNote(Note note);    //Data_returned Name_method (objeto note de tipo Note)

    //Update note
    Note updateNote(Note note);

    //Delete note
    void deleteNote(Long id);
}
