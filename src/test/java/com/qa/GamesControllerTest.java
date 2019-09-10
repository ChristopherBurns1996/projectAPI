package com.qa;

import com.qa.controllers.GamesController;
import com.qa.models.Games;
import com.qa.repository.GamesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GamesControllerTest {

    @InjectMocks
    private GamesController gamesController;

    @Mock
    private GamesRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listAllGamesTest(){
        List<Games> gamesList = new ArrayList<>();
        Games game = new Games();
        game.setGameid(0l);
        game.setGameName("Halo 3");
        game.setPublisher("Bungie");
        game.setPlatform("Xbox 360");
        game.setYearOfRelease(2007);
        gamesList.add(game);

        when(repository.findAll()).thenReturn(gamesList);

        assertEquals(gamesController.listAllGames().get(0).getGameName(), "Halo 3");
    }

    @Test
    public void addGameTest(){
        Games game = new Games();
        game.setGameid(0l);
        game.setGameName("Halo 3");
        game.setPublisher("Bungie");
        game.setPlatform("Xbox 360");
        game.setYearOfRelease(2007);

        when(repository.saveAndFlush(game)).thenReturn(game);

        assertEquals(gamesController.addGame(game).getPublisher(), "Bungie");
    }

    @Test
    public void updateGameTest(){
        Games game = new Games();
        game.setGameid(0l);
        game.setGameName("Halo 3");
        game.setPublisher("Bungie");
        game.setPlatform("Xbox 360");
        game.setYearOfRelease(2007);

        when(repository.findOne(0l)).thenReturn(game);

        assertEquals(gamesController.updateGame(game, 0l).getPlatform(), "Xbox 360");
    }
}
