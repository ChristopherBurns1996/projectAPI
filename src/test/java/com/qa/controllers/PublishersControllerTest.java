package com.qa.controllers;

import com.qa.models.Publishers;
import com.qa.repository.PublishersRepository;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PublishersControllerTest {

    @InjectMocks
    private PublishersController publishersController;

    @Mock
    private PublishersRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listAllPublishersTest(){
        List<Publishers> publishersList = new ArrayList<>();
        Publishers publisher = new Publishers();
        publisher.setPublisherid(0l);
        publisher.setPublisherName("Bungie");
        publisher.setCurrentCEO("IDK");
        publisher.setYearEstablished(2000);
        publishersList.add(publisher);

        when(repository.findAll()).thenReturn(publishersList);

        assertEquals(publishersController.listAllPublishers().get(0).getPublisherName(), "Bungie");
    }

    @Test
    public void addPublisherTest(){
        Publishers publisher = new Publishers();
        publisher.setPublisherid(0l);
        publisher.setPublisherName("Bungie");
        publisher.setCurrentCEO("IDK");
        publisher.setYearEstablished(2000);

        when(repository.saveAndFlush(publisher)).thenReturn(publisher);

        assertEquals(publishersController.addPublisher(publisher).getCurrentCEO(), "IDK");
    }

}
