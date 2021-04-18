package com.chess;

import com.chess.board.Board;
import com.chess.board.Square;
import com.chess.pieces.King;
import com.chess.pieces.Piece;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Board board = new Board(8, 8);
        board.setGrid();
        board.initializePieces();
        King whiteKing = (King) board.getGrid().get(new Point(5, 1)).getPiece();
        King blackKing = (King) board.getGrid().get(new Point(5, 8)).getPiece();
        Scanner input = new Scanner(System.in);
        boolean play = true;
        board.updateBoard();

        do {
            if (!whiteKing.checkMate()) {
                System.out.println("Player One");
                Point startW = getPoint(input);
                Point endW = getPoint(input);
                if (board.isValid(startW, endW)) {
                    board.movePiece(startW, endW);
                }
                board.updateBoard();

            } else {play = false;}
            if (!blackKing.checkMate()) {
                System.out.println("Player Two");
                Point startW = getPoint(input);
                Point endW = getPoint(input);
                if (board.isValid(startW, endW)) {
                    board.movePiece(startW, endW);
                }
                board.updateBoard();
            } else {play = false;}
        }
        while (play);


        board.updateBoard();
    }

    private static Point getPoint(Scanner input) {
        Map<String, Integer> mapping = Map.ofEntries(
                Map.entry("a", 1),
                Map.entry("b", 2),
                Map.entry("c", 3),
                Map.entry("d", 4),
                Map.entry("e", 5),
                Map.entry("f", 6),
                Map.entry("g", 7),
                Map.entry("h", 8)
        );

        String pieceCoordinates = input.nextLine();
        String a = Character.toString(pieceCoordinates.charAt(0)).toLowerCase();
        int x = mapping.get(a);
        int y = Character.getNumericValue(pieceCoordinates.charAt(1));
        return new Point(x, y);
    }
}


