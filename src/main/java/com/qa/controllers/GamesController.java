package com.qa.controllers;

import com.qa.models.Games;
import com.qa.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
public class GamesController {
    @Autowired
    private GamesRepository repository;

    @RequestMapping(value = "games", method = RequestMethod.GET)
    public List<Games> listAllGames(){
        return repository.findAll();
    }
}
