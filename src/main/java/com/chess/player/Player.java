package com.chess.player;

public class Player {

    private boolean inPlay;
    private int points;
    private int color;

    public Player(int colour) {
        this.inPlay = true;
        this.points = 0;
    }

    public boolean getInPlay() {
        return inPlay;
    }

    public void setInPlay(boolean play) {
        this.inPlay = play;
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int num){
        this.points = num;
    }
}
