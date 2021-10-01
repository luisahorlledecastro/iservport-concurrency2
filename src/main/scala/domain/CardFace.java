package com.iservport.concurrency.domain;

public enum CardFace {

    _A(false),
    _1,
    _2,
    _3,
    _4,
    _5,
    _6,
    _7,
    _8,
    _9,
    _10,
    _J(false),
    _Q(false),
    _K(false);

    private boolean numeric = false;

    private CardFace() {
        this.numeric = true;
    }

    private CardFace(boolean numeric) {
        this.numeric = numeric;
    }

    public boolean isNumeric() {
        return numeric;
    }
}
