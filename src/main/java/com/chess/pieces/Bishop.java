package com.chess.pieces;

import com.chess.board.Square;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Bishop extends Piece {
    public Bishop(int numColor, String name) {
        super(numColor, name);
    }

    @Override
    public LinkedList<Point> validMoves() {
        return new LinkedList<>(Arrays.asList(northEast, southEast, northWest, southWest));
    }
}

