package com.igp.reportservice.model;

public class Examples {

    public static final Report EXAMPLE = Report.builder()
        .reportId("1")
        .username("johnbernadis93")
        .event("poker night")
        .reportHead("Fun night but..")
        .reportBody("overabundance of card counting")
        .reportRating("5")
        .build();
}
