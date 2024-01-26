package com.nefer;

import java.util.ArrayList;
import java.util.Random;
import java.util.random.*;
public class FinalFirstPlaceCalculator {

    private ArrayList<FinalFirstCandidate> arr;

    public FinalFirstPlaceCalculator() {
        this.arr = new ArrayList<>();
    }

    public void add(FinalFirstCandidate finalFirstCandidate) {
        this.arr.add(finalFirstCandidate);

    }

    public Integer draw() {
        Random random = new Random();
        return random.nextInt(this.arr.size());
    }

    public ArrayList<FinalFirstCandidate> getArr() {
        return this.arr;
    }

    public User selectFinalWinner(){
        return arr.get(draw()).getUser();
    }
}
