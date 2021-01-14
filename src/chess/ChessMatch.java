package chess;
import boardGame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8, 8);
		this.initialSetup();
	}
	
	public ChessPiece[][] getPiece(){
		ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];
		for(int i = 0; i < this.board.getRows(); i++) {
			for(int j = 0; j < this.board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) this.board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void placeNewPice (char column, int row, ChessPiece pice) {
		board.placePiece(pice, new ChessPosition(column, row).toPosition());
	}
	
	/**
	 * Método reponsável iniciar a peça no tabuleiro
	 */
	public void initialSetup() {
		this.placeNewPice('b', 6, new Rook(board, Color.WHITE));
		this.placeNewPice('e', 8, new King(board, Color.BLACK));
		this.placeNewPice('e', 1, new King(board, Color.WHITE));
	}
}
