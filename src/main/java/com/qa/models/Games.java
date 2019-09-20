package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameid;
    private String gameName;
    private String publisher;
    private String platform;
    private int yearOfRelease;


    public Games() {
        super();
    }

    public Games(String gameName, String publisher, String platform, int yearOfRelease) {
        super();
        this.gameid = gameid;
        this.gameName = gameName;
        this.publisher = publisher;
        this.platform = platform;
        this.yearOfRelease = yearOfRelease;
    }

    public Long getGameid(){
        return gameid;
    }

    public void setGameid(Long gameid) {
        this.gameid = gameid;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setGame(Games game) {

        this.gameName = game.gameName;
        this.publisher = game.publisher;
        this.platform = game.platform;
        this.yearOfRelease = game.yearOfRelease;
    }
}
