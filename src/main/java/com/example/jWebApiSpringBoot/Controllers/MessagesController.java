package com.example.jWebApiSpringBoot.Controllers;

import com.example.jWebApiSpringBoot.Models.Message;
import com.example.jWebApiSpringBoot.Repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/messages")
public class MessagesController {
    @Autowired
    private MessagesRepository messagesRepository;

    @GetMapping
    public @ResponseBody
    Iterable<Message> getMessages() {
        return messagesRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") String id) {
        Optional<Message> user = messagesRepository.findById(id);
        return user.isPresent() ? new ResponseEntity<>(user.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Message> postMessage(@RequestBody Message message) {
        messagesRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable("id") String id) {
        Optional<Message> user = messagesRepository.findById(id);
        if (!user.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else {
            messagesRepository.delete(user.get());
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
    }

}
