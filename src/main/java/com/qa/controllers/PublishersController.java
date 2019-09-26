package com.qa.controllers;

import com.qa.models.Publishers;
import com.qa.repository.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class PublishersController {

    @Autowired
    private PublishersRepository repository;

    //Finds all of the publishers and returns them
    @RequestMapping(value = "publishers", method = RequestMethod.GET)
    public List<Publishers> listAllPublishers(){
        return repository.findAll();
    }

    //Adds a publisher to the table
    @RequestMapping(value = "publishers", method = RequestMethod.POST)
    public Publishers addPublisher(@RequestBody Publishers publisher){
        return repository.saveAndFlush(publisher);
    }

    //Updates a record in the table
    @Transactional
    @RequestMapping(value = "publishers/{publisherid}", method = RequestMethod.PUT)
    public Publishers updatePublisher(@RequestBody Publishers publisher, @PathVariable Long publisherid){
        Publishers existing = repository.findOne(publisherid);
        existing.setPublisher(publisher);
        return existing;
    }

    //Deletes a publisher from the table
    @RequestMapping(value = "publishers/{publisherid}", method = RequestMethod.DELETE)
    public Publishers deletePublisher(@PathVariable Long publisherid){
        Publishers existing = repository.findOne(publisherid);
        repository.delete(existing);
        return existing;
    }
}
