package com.chess.pieces;

import com.chess.board.Square;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Knight extends Piece {

    public Knight(int numColor, String name) {
        super(numColor, name);
    }

    @Override
    public LinkedList<Point> validMoves() {
        return new LinkedList<>(Arrays.asList(southSouthEast, southSouthWest, northNorthWest, northNorthEast));
    }

}
