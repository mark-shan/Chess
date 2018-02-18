package chess;

import java.util.ArrayList;

public class King extends ChessPiece{
	
	public King(ChessModel m, PlayerColour pc, Position pos){
		super(m, pc, pos, ChessPieceType.KING);
	}
	
	public ArrayList<Position> getPossibleMoves(){

		int col = this.getPosition().getFirst();
		int row = this.getPosition().getSecond();

		ArrayList<Position> moves = new ArrayList<Position>();

		for (int dCol = -1; dCol <= 1; dCol++){
			for (int dRow = -1; dRow <= 1; dRow++){
				if (dCol == 0 && dRow == 0) continue;
				if (this.getModel().inBoard(col + dCol) && this.getModel().inBoard(row + dRow)){
					
					Position newPos = new Position(col + dCol, row + dRow);
					ChessPiece target = this.getModel().getBoard().getPiece(newPos);
					
					if ((null == target || this.getPlayerColour() != target.getPlayerColour()) &&
							!this.tryMoveCheck(newPos)){
						moves.add(new Position(col + dCol, row + dRow));
					}
				}
			}
		}
		return moves;
	}
}
