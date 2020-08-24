package games.board;
import games.board.Board;
import games.board.Cell;
import games.board.Mark;
import games.board.Outcome;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.AbstractAction;

public class TicTacToeGame extends JFrame {
	public static void main(String[] args) {
		SwingUtilities.invokeLater( new Runnable () {
	           public void run() { new TicTacToeGame();}
	    });
		}
	
	private static Board gb;
	private static int turn;
	private int getOutcome;
		
		private void takeTurn(Cell c) {
			Mark curMark = (turn++ % 2 == 0)? Mark.NOUGHT: Mark.CROSS;
			gb.setCell(curMark,c.getRow(),c.getColumn());
		}
		
		private TicTacToeGame() {
				gb = new Board(3, 3, new ActionListener() {
						public void actionPerformed(ActionEvent ae) {
							Cell c = (Cell) ae.getSource();
								takeTurn(c);
		}
		});
				this.add(gb);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setTitle("TIC-TAC-TOE");
				this.setSize(300, 300);
				this.setVisible(true);
		}
		
		static Outcome winOrTie() {
			//ROWS//
			if(gb.getCells()[0][0].getContent() == Mark.NOUGHT 
					&& gb.getCells()[0][1].getContent() == Mark.NOUGHT 
					&& gb.getCells()[0][2].getContent() == Mark.NOUGHT) 
						{return Outcome.PLAYER1_WIN;}
				if(((Cell) gb.Cell[1][0]).getContent() == Mark.NOUGHT 
					&& ((Cell) gb.Cell[1][1]).getContent() == Mark.NOUGHT 
					&& ((Cell) gb.Cell[1][2]).getContent() == Mark.NOUGHT)
						{return Outcome.PLAYER1_WIN;}
				if(((Cell) gb.Cell[2][0]).getContent() == Mark.NOUGHT 
					&& ((Cell) gb.Cell[2][1]).getContent() == Mark.NOUGHT 
					&& ((Cell) gb.Cell[2][2]).getContent() == Mark.NOUGHT) 
						{return Outcome.PLAYER1_WIN;}
			
				if(	((Cell) gb.Cell[0][0]).getContent() == Mark.CROSS 
						&& ((Cell) gb.Cell[0][1]).getContent() == Mark.CROSS 
						&& ((Cell) gb.Cell[0][2]).getContent() == Mark. CROSS) 
							{return Outcome.PLAYER2_WIN;}
					if(((Cell) gb.Cell[1][0]).getContent() == Mark. CROSS
						&& ((Cell) gb.Cell[1][1]).getContent() == Mark. CROSS
						&& ((Cell) gb.Cell[1][2]).getContent() == Mark. CROSS)
							{return Outcome.PLAYER2_WIN;}
					if(((Cell) gb.Cell[2][0]).getContent() == Mark. CROSS
						&& ((Cell) gb.Cell[2][1]).getContent() == Mark. CROSS
						&& ((Cell) gb.Cell[2][2]).getContent() == Mark. CROSS) 
							{return Outcome.PLAYER2_WIN;}
			
			//COLUMNS//
					if(gb.getCells()[0][0].getContent() == Mark.NOUGHT 
							&& gb.getCells()[1][0].getContent() == Mark.NOUGHT 
							&& gb.getCells()[2][0].getContent() == Mark.NOUGHT) 
								{return Outcome.PLAYER1_WIN;}
						if(((Cell) gb.Cell[0][1]).getContent() == Mark.NOUGHT 
							&& ((Cell) gb.Cell[1][1]).getContent() == Mark.NOUGHT 
							&& ((Cell) gb.Cell[2][1]).getContent() == Mark.NOUGHT)
								{return Outcome.PLAYER1_WIN;}
						if(((Cell) gb.Cell[0][2]).getContent() == Mark.NOUGHT 
							&& ((Cell) gb.Cell[1][2]).getContent() == Mark.NOUGHT 
							&& ((Cell) gb.Cell[2][2]).getContent() == Mark.NOUGHT) 
								{return Outcome.PLAYER1_WIN;}

						if(gb.getCells()[0][0].getContent() == Mark.CROSS 
								&& gb.getCells()[1][0].getContent() == Mark.CROSS 
								&& gb.getCells()[2][0].getContent() == Mark.CROSS) 
									{return Outcome.PLAYER2_WIN;}
						if(((Cell) gb.Cell[0][1]).getContent() == Mark.CROSS 
								&& ((Cell) gb.Cell[1][1]).getContent() == Mark.CROSS 
								&& ((Cell) gb.Cell[2][1]).getContent() == Mark.CROSS)
									{return Outcome.PLAYER2_WIN;}
						if(((Cell) gb.Cell[0][2]).getContent() == Mark.CROSS 
								&& ((Cell) gb.Cell[1][2]).getContent() == Mark.CROSS 
								&& ((Cell) gb.Cell[2][2]).getContent() == Mark.CROSS) 
									{return Outcome.PLAYER2_WIN;}

			//DIAGONALS//
						if(gb.getCells()[0][0].getContent() == Mark.NOUGHT 
									&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
									&& gb.getCells()[2][2].getContent() == Mark.NOUGHT) 
										{return Outcome.PLAYER1_WIN;}
						if(gb.getCells()[0][2].getContent() == Mark.NOUGHT 
									&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
									&& gb.getCells()[2][0].getContent() == Mark.NOUGHT) 
										{return Outcome.PLAYER1_WIN;}

						if(gb.getCells()[0][0].getContent() == Mark.CROSS 
										&& gb.getCells()[1][1].getContent() == Mark.CROSS 
										&& gb.getCells()[2][2].getContent() == Mark.CROSS) 
											{return Outcome.PLAYER2_WIN;}
						if(gb.getCells()[0][2].getContent() == Mark.CROSS 
										&& gb.getCells()[1][1].getContent() == Mark.CROSS 
										&& gb.getCells()[2][0].getContent() == Mark.CROSS) 
											{return Outcome.PLAYER2_WIN;}

			//TIES//
						if(gb.getCells()[2][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark. NOUGHT
											&& gb.getCells()[1][1].getContent() == Mark. NOUGHT
											&& gb.getCells()[0][1].getContent() == Mark. NOUGHT
											&& gb.getCells()[2][0].getContent() == Mark. NOUGHT) 
												{return Outcome.TIE;}
						if (gb.getCells()[0][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2].getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#2
						if (gb.getCells()[0][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT
											&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0].getContent() == Mark.NOUGHT) 
												{return Outcome.TIE;}//**#3
						if (gb.getCells()[2][0].getContent() == Mark.NOUGHT
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#4
						if (gb.getCells()[0][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT
											&& gb.getCells()[1][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 											
											&& gb.getCells()[2][0].getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#5
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#6
						if (gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;} //**#7
						if (gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;} //**#8
						if(gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#9
						if(gb.getCells()[0][0] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#10
						if(gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#11
						if(gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#12
						if (gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#13
						if (gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#14
						if (gb.getCells()[0][0] .getContent() == Mark.NOUGHT
											 && gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#15
						if (gb.getCells()[0][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#16
						if (gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#17
						if (gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#18
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#19
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#20
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#21
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#22
						if (gb.getCells()[0][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#23
						if (gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#24
						if (gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#25
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#26
						if (gb.getCells()[0][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#27
						if (gb.getCells()[2][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#28
						if (gb.getCells()[0][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#29
						if (gb.getCells()[0][0].getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][0] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[0][2] .getContent() == Mark.NOUGHT 
											&& gb.getCells()[1][2].getContent() == Mark.NOUGHT 
											&& gb.getCells()[2][1] .getContent() == Mark.NOUGHT)
												{return Outcome.TIE;}//**#30
									return Outcome.CONTINUE;
		
   }
}