package chess;

import boardGame.BoardExcepion;

public class ChessException extends BoardExcepion{
	private static final long serialVersionUID = 1L;
	
	public ChessException(String msg) {
		super(msg);
	}

}
