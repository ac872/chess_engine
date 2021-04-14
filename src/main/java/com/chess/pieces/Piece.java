package com.chess.pieces;

import com.chess.board.Moves;

import java.awt.*;
import java.util.LinkedList;

abstract public class Piece {

    private final int color;
    private final String name;
    private boolean alive;
    public final Point north = new Point(0,1);
    public final Point south = new Point(0, -1);
    public final Point east = new Point(1, 0);
    public final Point west = new Point(-1, 0);
    public final Point northWest = new Point(-1, 1);
    public final Point northEast = new Point(1, 1);
    public final Point southEast = new Point(1, -1);
    public final Point southWest = new Point(-1, -1);
    public final Point northNorth = new Point(0, 2);
    public final Point southSouth = new Point(0, -2);

    public final Point northNorthEast = new Point(1, 2);
    public final Point northNorthWest = new Point(-1, 2);
    public final Point southSouthEast = new Point(1, -2);
    public final Point southSouthWest = new Point(-1, -2);

    public Piece(int numColor, String name) {
        String tempName;
        if (numColor == getBlack()) {
            this.color = getBlack();
            tempName = name.toUpperCase();
        } else {
            this.color = getWhite();
            tempName = name.toLowerCase();
        }
        this.name = tempName;
        this.alive = true;
    }

    public LinkedList<Point> validMoves() {
        return null;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean bool) {
        this.alive = bool;
    }

    public String getName() {
        return name;
    }

    private int getBlack() {
        return 0;
    }

    private int getWhite() {
        return 1;
    }

    public int getColor() {
        return color;
    }

    public boolean sameColor(Piece piece) {
        return color == piece.getColor();
    }

}
