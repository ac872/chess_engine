package com.chess;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.Piece;

import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    private final int a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, g = 7, h = 8;

    public static void main(String[] args) {
        Board board = new Board(8, 8);
        board.setGrid();
        board.initializePieces();

        Scanner input = new Scanner(System.in);
        System.out.println("Player One");
        System.out.println("Enter Coordinates of piece");
        String pieceCoordinates = input.nextLine();
        int q = Character.getNumericValue(pieceCoordinates.charAt(0));
        int w = Character.getNumericValue(pieceCoordinates.charAt(1));
        Point start = new Point(q, w);

        System.out.println("Where to move?");
        String moveCoordinates = input.nextLine();
        int e = Character.getNumericValue(moveCoordinates.charAt(0));
        int r = Character.getNumericValue(moveCoordinates.charAt(1));
        Point dest = new Point(e, r);


        HashMap<Point, Square> grid = board.getGrid();
        Square from = grid.get(start);
        Square to = grid.get(dest);

        Piece piece = from.getPiece();
        System.out.println(isPathClear(start, dest, board));

//        if (start.equals(dest)) return false; // nothing in between by definition



        board.updateBoard();
    }

    public static boolean isPathClear(Point start, Point dest, Board board) {
        Point direction = new Point((int)Math.signum(dest.x - start.x), (int)Math.signum(dest.x - start.x));
        System.out.println(direction);

        Point current = new Point(start.x + direction.x, start.y + direction.y);
        while (!current.equals(dest)) {
            if (board.getGrid().get(current).isFilled())
                return false;
            current.x = current.x + direction.x;
            current.y = current.y + direction.y;
        }
        return true;
    }

}


