package com.iservport.concurrency.domain;

public enum CardSuit {

    S("SPADE"), C("CLOVER"), H("HEART"), D("DIAMOND");

    private String suitName;

    CardSuit(String suitName) {
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
    }
}
