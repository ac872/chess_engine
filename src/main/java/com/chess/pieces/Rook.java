package com.chess.pieces;

import com.chess.board.Square;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Rook extends Piece {
    public Rook(int numColor, String name) {
        super(numColor, name);
    }

    @Override
    public LinkedList<Point> validMoves() {
        return new LinkedList<>(Arrays.asList(south, north, east, west));
    }
}
