package boardGame;

public class Board {
	
	private int rows;
	private int columns;
	
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardExcepion("Erro ao criar o tabuleiro: Deve haver pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!this.positionExists(row, column)) {
			throw new BoardExcepion("Posição não existe no tabuleiro"); 
		}
		return this.pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardExcepion("Posição não existe no tabuleiro"); 
		}
		return this.pieces[position.getRow()][position.getColumn()];
	}
	
	/**
	 * Método responsável por receber a peça e a posição e para colocar no tabuleiro.
	 * 
	 * @param piece
	 * @param position
	 */
	public void placePiece(Piece piece, Position position) {
		if (this.thereIsAPice(position)) {
			throw new BoardExcepion("Já existe uma peça nessa posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardExcepion("Posição não existe no tabuleiro");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPice(Position position) {
		if(!this.positionExists(position)) {
			throw new BoardExcepion("Posição não existe no tabuleiro"); 
		}
		return this.piece(position) != null;
	}
	
	

}
