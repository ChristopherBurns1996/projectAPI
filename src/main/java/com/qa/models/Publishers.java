package com.qa.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Publishers")
public class Publishers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publisherid;
    private String publisherName;
    private String currentCEO;
    //Date yearEstablished;

    public Publishers() {
        super();
    }

    public Publishers(String publisherName, String currentCEO) {
        super();
        this.publisherName = publisherName;
        this.currentCEO = currentCEO;
    }

    public Long getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(Long publisherid) {
        this.publisherid = publisherid;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCurrentCEO() {
        return currentCEO;
    }

    public void setCurrentCEO(String currentCEO) {
        this.currentCEO = currentCEO;
    }

    public void setPublisher(Publishers publisher){
        this.publisherName = publisher.publisherName;
        this.currentCEO = publisher.currentCEO;
    }
}
