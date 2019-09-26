package com.qa.models;


import javax.persistence.*;

@Entity
@Table(name = "Publishers")
public class Publishers {
    //Creates the fields for the Publishers table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publisherid;
    private String publisherName;
    private String currentCEO;
    private int yearEstablished;

    //An empty constructor for spring
    public Publishers() {
        super();
    }

    //An overloaded constructor that I can use to create Publisher objects
    public Publishers(String publisherName, String currentCEO, int yearEstablished) {
        super();
        this.publisherName = publisherName;
        this.currentCEO = currentCEO;
        this.yearEstablished = yearEstablished;
    }

    //Getters and setters
    public Long getPublisherid(){
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

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    //Method to set the values of a publisher apart from the id
    public void setPublisher(Publishers publisher){
        this.publisherName = publisher.publisherName;
        this.currentCEO = publisher.currentCEO;
        this.yearEstablished = publisher.yearEstablished;
    }
}
