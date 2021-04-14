package com.chess.board;

import com.chess.pieces.Piece;

import java.awt.Point;

public class Square{

    private boolean isFilled = false;
    private String contents;
    private Piece piece;
    private final Point point;

    public Square(int x, int y) {
        this.point = new Point(x, y);
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece.isAlive()){
            setFilled(true);
        }
    }

    public void setEmpty(){
        setFilled(false);
        piece = null;
    }

    public Piece getPiece() {
        return piece;
    }

    public Point getPoint() {
        return point;
    }
}
