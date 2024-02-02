package com.nefer.domain.member;

public enum Ranking {

    FIRST(1), SECOND(2), THIRD(3), LOSE(-1);



    private final int rank;

    Ranking(int rank) { this.rank = rank; }

    public int getRank() { return rank; }
}
