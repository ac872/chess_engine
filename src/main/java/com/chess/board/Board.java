package com.chess.board;

import com.chess.pieces.*;

import java.util.HashMap;
import java.awt.Point;
import java.util.LinkedList;


public class Board implements Moves{

    private HashMap<Point, Square> grid;
    private final int x;
    private final int y;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public HashMap<Point, Square> getGrid() {
        return grid;
    }

    public void setGrid() {
        grid = createGrid();
    }

    public void initializePieces(){

//        Initialize Pawns
        for (int j = 1; j <= x; j++){
            Pawn whitePawn = new Pawn(1, "  p  ");
            Square square1 = grid.get(new Point(j, 2));
            square1.setPiece(whitePawn);

            Pawn blackPawn = new Pawn(0, "  p  ");
            Square square2 = grid.get(new Point(j, 7));
            square2.setPiece(blackPawn);
        }

//        Initialize Kings
        King whiteKing = new King(1, "  k  ");
        Square whiteKingSquare = grid.get(new Point(5, 1));
        whiteKingSquare.setPiece(whiteKing);
        King blackKing = new King(0, "  k  ");
        Square blackKingSquare = grid.get(new Point(5, 8));
        blackKingSquare.setPiece(blackKing);

//        Initialize Queen
        Queen whiteQueen = new Queen(1, "  q  ");
        Square whiteQueenSquare = grid.get(new Point(4, 1));
        whiteQueenSquare.setPiece(whiteQueen);
        Queen blackQueen = new Queen(0, "  q  ");
        Square blackQueenSquare = grid.get(new Point(4, 8));
        blackQueenSquare.setPiece(blackQueen);

//        Initialize Bishops

        Bishop whiteBishop = new Bishop(1, "  b  ");
        Square whiteBSq1 = grid.get(new Point(3, 1));
        Square whiteBSq2 = grid.get(new Point(6, 1));
        whiteBSq1.setPiece(whiteBishop);
        whiteBSq2.setPiece(whiteBishop);

        Bishop blackBishop = new Bishop(0, "  b  ");
        Square blackBSq1 = grid.get(new Point(3, 8));
        Square blackBSq2 = grid.get(new Point(6, 8));
        blackBSq1.setPiece(blackBishop);
        blackBSq2.setPiece(blackBishop);

//        Initialize Knights
        Knight whiteKnight = new Knight(1, "  n  ");
        Square whiteNSq1 = grid.get(new Point(2, 1));
        Square whiteNSq2 = grid.get(new Point(7, 1));
        whiteNSq1.setPiece(whiteKnight);
        whiteNSq2.setPiece(whiteKnight);

        Knight blackKnight = new Knight(0, "  n  ");
        Square blackNSq1 = grid.get(new Point(2, 8));
        Square blackNSq2 = grid.get(new Point(7, 8));
        blackNSq1.setPiece(blackKnight);
        blackNSq2.setPiece(blackKnight);

//        Initialize Rooks
        Rook whiteRook = new Rook(1, "  r  ");
        Square whiteRSq1 = grid.get(new Point(1,1));
        Square whiteRSq2 = grid.get(new Point(8, 1));
        whiteRSq1.setPiece(whiteRook);
        whiteRSq2.setPiece(whiteRook);

        Rook blackRook = new Rook(0, "  r  ");
        Square blackRSq1 = grid.get(new Point(1, 8));
        Square blackRSq2 = grid.get(new Point(8, 8));
        blackRSq1.setPiece(blackRook);
        blackRSq2.setPiece(blackRook);

    }

    public void updateBoard(){
        printBoard();
    }

    private void printBoard() {
        System.out.println("   |  A  |  B  |  C  |  D  |  E  |  F  |  G  |  H  |");
        System.out.println("   -------------------------------------------------");
        for (int i = 1; i <= x; i++) {
            System.out.print(i + "  |");
            for (int j = 1; j <= y; j++) {
                Square square = grid.get(new Point(j, i));
                if (square.isFilled()){
                    System.out.print(square.getPiece().getName());
                }
                else {
                    System.out.print(grid.get(new Point(j, i)).getContents());
                }
                System.out.print("|");
            }
            System.out.println();
            System.out.println("   -------------------------------------------------");
        }
    }

    private HashMap<Point, Square> createGrid() {
        HashMap<Point, Square> board = new HashMap<>();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++){
                Square square = new Square(j, i);
                square.setContents("     ");
                board.put(new Point(j, i), square);
            }
        }
        return board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean isValid(Point from, Point to) {
//        Check points are different
        if (from.equals(to)) return false;

        Piece pieceOrigin = grid.get(from).getPiece();
        String pieceOriginName = pieceOrigin.getName().toLowerCase();
        pieceOriginName = pieceOriginName.replaceAll("\\s+","");
        Piece pieceDest = null;

//        Return false if the pieces are the same colour, true if different colour or empty.
        try {
            pieceDest = grid.get(to).getPiece();
            if (pieceOrigin.getColor() == pieceDest.getColor()) return false;
        } catch (NullPointerException ignored){}
        LinkedList<Point> possibleDirections = pieceOrigin.validMoves();
        Point direction = new Point((to.x - from.x), (to.y - from.y));

        switch (pieceOriginName) {
            case "n":
                if (possibleDirections.contains(direction)) return true;
            case "k":
                King king = (King) pieceOrigin;
                if (Math.abs(direction.x) > 1 || Math.abs(direction.y) > 1) return false;
//                Checkmate Check Here??
            case "p":
                if (grid.get(to).isFilled() && Math.abs(direction.x) != 1) return false;
                if (!possibleDirections.contains(direction)) return false;
                Pawn pawn = (Pawn) pieceOrigin;
                pawn.setFirstMove(false);
//                if (Math.abs(direction.y) > 1 && Math.abs(direction.x) != 1) return false;
//                if (Math.abs(direction.x) == 1 && pieceDest != null && Math.abs(direction.y) == 1)
//                    return true;
        }
        return isPathClear(from, to);
    }

    @Override
    public void movePiece(Point orig, Point dest) {
        Square origin = grid.get(orig);
        Square destination = grid.get(dest);
        Piece pieceOrig = origin.getPiece();
        try {
            Piece pieceDest = destination.getPiece();
            pieceDest.setAlive(false);
//            Code in here to add the piece to a tally for score etc..
        } catch (NullPointerException ignored) {}
        origin.setEmpty();
        destination.setPiece(pieceOrig);
        origin.setEmpty();
    }

    @Override
    public boolean isPathClear(Point from, Point to) {
//        Test only if path between the two points are clear, not if destination is empty.
        Point direction = new Point((int)Math.signum(to.x - from.x),
                (int)Math.signum(to.y - from.y));
        Point temp = new Point(from.x + direction.x, from.y + direction.y);
        while (!temp.equals(to)) {
            if (grid.get(temp).isFilled()) return false;
            temp = new Point(temp.x + direction.x, temp.y + direction.y);
        }
        return true;
    }
}
