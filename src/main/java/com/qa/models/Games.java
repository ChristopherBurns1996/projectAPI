package com.qa.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Games")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long gameid;
    String gameName;
    String publisher;
    String platform;
    //Date yearOfRelease;

    public Games() {
        super();
    }

    public Games(String gameName, String publisher, String platform) {
        super();
        this.gameName = gameName;
        this.publisher = publisher;
        this.platform = platform;
    }

    public Long getGameid() {
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

    public void setGame(Games game) {
        this.gameName = game.gameName;
        this.publisher = game.publisher;
        this.platform = game.platform;
    }

    //    public Date getYearOfRelease() {
//        return yearOfRelease;
//    }
//
//    public void setYearOfRelease(Date yearOfRelease) {
//        this.yearOfRelease = yearOfRelease;
//    }
}
