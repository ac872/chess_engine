package com.chess.board;


import java.awt.Point;

public interface Moves {

    boolean isValid(Point from, Point to);

    boolean isPathClear(Point from, Point to);

    void movePiece(Point origin, Point dest);

}
