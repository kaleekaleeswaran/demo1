package com.example.demo.controller;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")    //the url when we execute the request.
@CrossOrigin(origins = "http://localhost:3000/")  //tell that accepts request from a fronted app; tell that it will be an origin localed in the localhost.
public class NoteController {

    @Autowired  //dependency injection without making an instance from this class.
    private NoteService service;

    @GetMapping("get/notes")    //the url when we execute each method
    public List<Note> getAllNotes(){        //the return and the name of the method
        return service.getNotes();          //the instance of NoteService (service) and its method.
    }

    @PostMapping("save/note")
    public Note saveNote(@RequestBody Note note){   //@RequestBody in order to ask the date.
        return service.saveNote(note);
    }

    @PutMapping("update/note")
    public Note updateNote(@RequestBody Note note){
        return service.updateNote(note);
    }

    @DeleteMapping("delete/note/{id}")
    public void deleteNote(@PathVariable Long id){
        service.deleteNote(id);
    }



}
