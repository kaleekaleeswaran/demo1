package com.example.demo.service;

import com.example.demo.entity.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{   // it extends from the interface already created.

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getNotes() {
        return noteRepository.findAll();    //it will bring all the notes
    }

    @Override
    public Note saveNote(Note note) {       //it will create a new note
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {     //it's the same the previous, but if and id is given it
        return noteRepository.save(note);   //will update the note with this id.
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);      //delete the note with the given id.
    }
}
