package com.nefer;

import java.util.ArrayList;

public class FinalFirstPlaceCalculator {

    private ArrayList<FinalFirstCandidate> arr;

    public FinalFirstPlaceCalculator() {
        this.arr = new ArrayList<>();
    }

    public void add(FinalFirstCandidate finalFirstCandidate) {
        this.arr.add(finalFirstCandidate);

    }

    private void draw() {

    }

    public ArrayList<FinalFirstCandidate> getArr() {
        return this.arr;
    }
}
