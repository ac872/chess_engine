package com.chess.pieces;

import com.chess.board.Moves;
import com.chess.board.Square;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;


public class Pawn extends Piece {



    private boolean firstMove = true;

    public Pawn(int color, String name) { super(color, name); }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean madeFirstMove) {
        this.firstMove = madeFirstMove;
    }

    @Override
    public LinkedList<Point> validMoves() {
        if (isFirstMove()) {
            if (getColor() == 0) {
                return new LinkedList<>(Arrays.asList(south, southEast, southWest, southSouth));
            }
            else {
                return new LinkedList<>(Arrays.asList(north, northEast, northWest, northNorth));
            }
        } else {
            if (getColor() == 0) {
                return new LinkedList<>(Arrays.asList(south, southEast, southWest));
            }
            else {
                return new LinkedList<>(Arrays.asList(north, northEast, northWest));
            }
        }
    }
}

