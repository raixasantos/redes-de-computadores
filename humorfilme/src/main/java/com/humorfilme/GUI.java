package com.humorfilme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class GUI {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblQuestaoHumor = new JLabel("Qual é o seu humor do dia?");
        lblQuestaoHumor.setBounds(90, 60, 46, 14);

        JLabel lblFeliz = new JLabel("Feliz");
        lblFeliz.setBounds(168, 60, 46, 14);

        JRadioButton radioButton_feliz = new JRadioButton("");
        radioButton_feliz.setBounds(202, 57, 109, 23);

        JLabel lblPraBaixo = new JLabel("Pra baixo");
        lblPraBaixo.setBounds(332, 60, 46, 14);

        JRadioButton radioButton_praBaixo = new JRadioButton("");
        radioButton_praBaixo.setBounds(377, 57, 109, 23);

        JButton btnSubmit = new JButton("Submit");     
        btnSubmit.setBackground(Color.BLUE);    
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setBounds(90, 120, 89, 23);

        JLabel sugestoes = new JLabel();
        sugestoes.setBorder( BorderFactory.createTitledBorder( "" ) ) ;
        sugestoes.setHorizontalAlignment( SwingConstants.CENTER );
        sugestoes.setBounds(90, 200, 460, 80);

        frame.getContentPane().add(lblQuestaoHumor);
        frame.getContentPane().add(lblFeliz);
        frame.getContentPane().add(radioButton_feliz);
        frame.getContentPane().add(lblPraBaixo);
        frame.getContentPane().add(radioButton_praBaixo);
        frame.getContentPane().add(btnSubmit);
        frame.getContentPane().add(sugestoes);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(((!radioButton_feliz.isSelected())&&(!radioButton_praBaixo.isSelected())))
                    sugestoes.setText("Selecione uma opção!");
                else {
                    IMDB imdb = new IMDB();
                    sugestoes.setText("Testando conexão com IMDB: " + imdb.callingAPIService().getExpression() );
                } 
            }
        });
    }
}