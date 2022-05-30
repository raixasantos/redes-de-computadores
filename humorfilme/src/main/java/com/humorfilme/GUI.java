package com.humorfilme;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUI{

    private JFrame frame;
    static JLabel back;

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
        lblQuestaoHumor.setBounds(300, 30, 175, 14);

        JLabel lblFeliz = new JLabel("Feliz");
        lblFeliz.setBounds(300, 60, 46, 14);

        JRadioButton radioButton_feliz = new JRadioButton("");
        radioButton_feliz.setBounds(302, 75, 20, 20);

        JLabel lblPraBaixo = new JLabel("Pra baixo");
        lblPraBaixo.setBounds(390, 60, 80, 14);

        JRadioButton radioButton_praBaixo = new JRadioButton("");
        radioButton_praBaixo.setBounds(406, 75, 20, 20);

        ButtonGroup opcao = new ButtonGroup();

        opcao.add(radioButton_feliz);
        opcao.add(radioButton_praBaixo);

        JButton btnSubmit = new JButton("Submit");     
        btnSubmit.setBackground(Color.BLUE);    
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setBounds(330, 120, 89, 23);

        JLabel sugestoes = new JLabel();
        sugestoes.setBorder( BorderFactory.createTitledBorder( "" ) ) ;
        sugestoes.setHorizontalAlignment( SwingConstants.CENTER );
        sugestoes.setBounds(90, 200, 460, 80);

        ImageIcon backGround = new ImageIcon(getClass().getResource("teste.jfif"));
        back = new JLabel();
        back.setIcon(backGround);
        Painel principal = new Painel();
        //principal.add(back);
        //principal.setBounds(1, 1, 50, 50);
       // principal.setVisible(true);

        //Painel backGroundP = new Painel();
       // principal.add(backGroundP);



        frame.add(principal);
        frame.getContentPane().add(lblQuestaoHumor);
        frame.getContentPane().add(lblFeliz);
        frame.getContentPane().add(radioButton_feliz);
        frame.getContentPane().add(lblPraBaixo);
        frame.getContentPane().add(radioButton_praBaixo);
        frame.getContentPane().add(btnSubmit);
        frame.getContentPane().add(sugestoes);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String texto="";
                if(((!radioButton_feliz.isSelected())&&(!radioButton_praBaixo.isSelected())))
                    sugestoes.setText("Selecione uma opção!");
                else {
                    if(radioButton_feliz.isSelected()){
                        texto = "Feliz!";
                    }else if(radioButton_praBaixo.isSelected()){
                        texto = "Triste!";
                    }
                    IMDB imdb = new IMDB();
                    sugestoes.setText("Testando conexão com IMDB: " + texto + imdb.callingAPIService().getExpression() );
                } 
            }
        });
    }
}