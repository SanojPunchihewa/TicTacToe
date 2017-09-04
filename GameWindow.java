/*	
	Author : Sanoj Punchihewa 	E/14/262
	CO225 Lab3 TicTacToe
*/

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

    private GameState gameState = new GameState();

    private JButton[] btnArray = new JButton[9];

    private JLabel label_current_player, status;

    public GameWindow(){

        super("Tic Tac Toe");

        JPanel panel = new JPanel(new GridLayout(3, 3));

        for(int pos = 0; pos < 9; pos++){
            btnArray[pos] = new JButton();
            btnArray[pos].setPreferredSize(new Dimension(100, 100));
            btnArray[pos].setBackground(new Color(32, 32, 32));
            btnArray[pos].setForeground(new Color(254, 192, 6));
            btnArray[pos].setFont(new Font(Font.DIALOG, Font.BOLD, 28));
            btnArray[pos].setBorder(new LineBorder(Color.GRAY));
            btnArray[pos].setFocusPainted(false);
            btnArray[pos].addActionListener(this);
            panel.add(btnArray[pos]);
        }

        JPanel panel_player = new JPanel(new FlowLayout());
        panel_player.setBackground(new Color(32, 32, 32));
        JLabel label_player = new JLabel("'s Turn");
        label_player.setForeground(Color.WHITE);
        label_current_player = new JLabel("Player 1");
        label_current_player.setForeground(new Color(254, 192, 6));

        panel_player.add(label_current_player);
        panel_player.add(label_player);

        JPanel panel_status = new JPanel(new FlowLayout());
        panel_status.setBackground(new Color(32, 32, 32));
        status = new JLabel(" ");
        //status.setVisible(false);
        status.setForeground(new Color(247, 31, 38));
        panel_status.add(status);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 350));
        setLocationRelativeTo(null);
        add(panel_player, BorderLayout.PAGE_START);
        add(panel);
        add(panel_status, BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int pos = 0; pos < 9; pos++){
            if(e.getSource() == btnArray[pos]){
                if(gameState.getMatrixValueAt(pos) == 0){
                    status.setText(" ");
                    int player = gameState.getCurrentPlayer();
                    btnArray[pos].setText(String.valueOf(player));

                    gameState.setMatrixValue(pos, player);
                    int winner = gameState.getWinner();
                    if(winner != 0){
                        new ResultWindow("Player " + String.valueOf(winner) + " wins !");
                        dispose();
                    }else if (gameState.isFull()){
                        new ResultWindow("Draw Match !");
                        dispose();
                    }
                    if(player == 1){
                        gameState.setCurrentPlayer(2);
                        label_current_player.setText("Player 2");
                        label_current_player.setForeground(new Color(18, 193, 116));
                    }else{
                        btnArray[pos].setForeground(new Color(18, 193, 116));
                        gameState.setCurrentPlayer(1);
                        label_current_player.setText("Player 1");
                        label_current_player.setForeground(new Color(254, 192, 6));
                    }
                }else{
                    status.setText("Already selected, choose an Empty block !");
                }
            }
        }
    }

}
