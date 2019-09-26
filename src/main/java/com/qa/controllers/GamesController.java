package com.qa.controllers;

import com.qa.models.Games;
import com.qa.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class GamesController {

    @Autowired
    private GamesRepository repository;

    //Finds all of the games in the games table and returns them
    @RequestMapping(value = "Games", method = RequestMethod.GET)
    public List<Games> listAllGames(){
        return repository.findAll();
    }

    //Adds a game to the table
    @RequestMapping(value = "Games", method = RequestMethod.POST)
    public Games addGame(@RequestBody Games game){
        return repository.saveAndFlush(game);
    }

    //Updates a record in the table
    @Transactional
    @RequestMapping(value = "Games/{gameid}", method = RequestMethod.PUT)
    public Games updateGame(@RequestBody Games game, @PathVariable Long gameid){
        Games existing = repository.findOne(gameid);
        existing.setGame(game);
        return existing;
    }

    //Deletes a record from the games table
    @RequestMapping(value = "Games/{gameid}", method = RequestMethod.DELETE)
    public Games deleteGame(@PathVariable Long gameid){
        Games existing = repository.findOne(gameid);
        repository.delete(existing);
        return existing;
    }

}
