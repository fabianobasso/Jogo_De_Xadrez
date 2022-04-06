package chess.pieces;

import boardGame.Board;
import boardGame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{

	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// Noroeste
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		
		while (getBoard().positionExists(p) && !getBoard().thereIsAPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);;
		}
		if(getBoard().positionExists(p) && isThereOpponentPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		// Nordeste
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
				
		while (getBoard().positionExists(p) && !getBoard().thereIsAPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);;
		}
		if(getBoard().positionExists(p) && isThereOpponentPice(p)) {
		mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sudeste
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
						
		while (getBoard().positionExists(p) && !getBoard().thereIsAPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1 , p.getColumn() + 1);;
		}
		if(getBoard().positionExists(p) && isThereOpponentPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		// Sudoeste
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
				
		while (getBoard().positionExists(p) && !getBoard().thereIsAPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPice(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}

}

