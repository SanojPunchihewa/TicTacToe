/*	
	Author : Sanoj Punchihewa 	E/14/262
	CO225 Lab3 TicTacToe
*/

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultWindow extends JFrame implements ActionListener{

    private JButton btnClose;
    private JButton btnPlayAgain;

    public ResultWindow(String result){

        super("Game Summary");

        JPanel panelText = new JPanel();

        JLabel txtResult = new JLabel(result);
        txtResult.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        txtResult.setForeground(Color.WHITE);
        panelText.setBackground(new Color(32, 32, 32));
        panelText.add(txtResult);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 32, 32));

        btnClose = new JButton("Exit");
        btnClose.setPreferredSize(new Dimension(100, 35));
        btnClose.setBackground(new Color(32, 32, 32));
        btnClose.setForeground(new Color(254, 192, 6));
        btnClose.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        btnClose.setBorder(new LineBorder(new Color(254, 192, 6)));
        btnClose.setFocusPainted(false);
        btnClose.addActionListener(this);
        panel.add(btnClose);
        btnPlayAgain = new JButton("Play Again");
        btnPlayAgain.setPreferredSize(new Dimension(150, 35));
        btnPlayAgain.setBackground(new Color(254, 192, 6));
        btnPlayAgain.setForeground(new Color(32, 32, 32));
        btnPlayAgain.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        btnPlayAgain.setBorderPainted(false);
        btnPlayAgain.setFocusPainted(false);
        btnPlayAgain.addActionListener(this);
        panel.add(btnPlayAgain);

        setPreferredSize(new Dimension(300, 200));
        setMinimumSize(new Dimension(300, 150));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panelText);
        add(panel, BorderLayout.PAGE_END);
        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnPlayAgain){
          new GameWindow();
        }

        dispose();

    }

}
