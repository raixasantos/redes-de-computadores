package com.humorfilme;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
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
    private MyPanel backGround;
    static JLabel back;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                    window.frame.setTitle("HumorFilme");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {
        initialize();
    }
    public ImageIcon getImageURL(String path, int width, int height) {
        try{
            URL imageURL = new URL(path);
            ImageIcon teste = new ImageIcon(imageURL);
            Image mudar = teste.getImage();
            Image dimensionar = mudar.getScaledInstance(width, height, mudar.SCALE_SMOOTH);
            return new ImageIcon(dimensionar);
        }catch(Exception e){
            e.getStackTrace();
        }
        return null;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        backGround = new MyPanel("teste.jfif");
        frame.setContentPane(backGround);
        

        JLabel lblQuestaoHumor = new JLabel("Qual é o seu humor do dia?");
        lblQuestaoHumor.setBounds(300, 30, 175, 14);

        JLabel lblFeliz = new JLabel("Feliz");
        lblFeliz.setBounds(300, 60, 46, 14);

        JRadioButton radioButton_feliz = new JRadioButton("");
        radioButton_feliz.setBounds(302, 75, 20, 20);
        radioButton_feliz.setOpaque(false);

        JLabel lblPraBaixo = new JLabel("Pra baixo");
        lblPraBaixo.setBounds(390, 60, 80, 14);

        JRadioButton radioButton_praBaixo = new JRadioButton("");
        radioButton_praBaixo.setBounds(406, 75, 20, 20);
        radioButton_praBaixo.setOpaque(false);

        JLabel lblOpcao3 = new JLabel("Opção3");
        lblOpcao3.setBounds(484, 60, 80, 14);

        JRadioButton radioButton_opcao3 = new JRadioButton("Opção3");
        radioButton_opcao3.setBounds(500, 75, 20, 20);
        radioButton_opcao3.setOpaque(false);
        
        JLabel lblOpcao4 = new JLabel("Pra baixo");
        lblOpcao4.setBounds(390, 60, 80, 14);

        JRadioButton radioButton_lblOpcao4 = new JRadioButton("");
        radioButton_lblOpcao4.setBounds(406, 75, 20, 20);
        radioButton_lblOpcao4.setOpaque(false);

        JLabel lblOpcao5 = new JLabel("Opção3");
        lblOpcao5.setBounds(484, 60, 80, 14);

        JRadioButton radioButton_opcao5 = new JRadioButton("Opção3");
        radioButton_opcao5.setBounds(500, 75, 20, 20);
        radioButton_opcao5.setOpaque(false);

        ButtonGroup opcao = new ButtonGroup();

        opcao.add(radioButton_feliz);
        opcao.add(radioButton_praBaixo);
        opcao.add(radioButton_opcao3);

        JButton btnSubmit = new JButton("Submit");     
        btnSubmit.setBackground(Color.BLUE);    
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setBounds(330, 120, 89, 23);

        JLabel sugestoes = new JLabel();
        //sugestoes.setLayout(new GridBagLayout());
        sugestoes.setBorder( BorderFactory.createTitledBorder( "" ) ) ;
        sugestoes.setHorizontalAlignment( SwingConstants.CENTER );
        sugestoes.setBounds(120, 200, 460, 150);

        JLabel principal = new JLabel();
        principal.add(lblQuestaoHumor);
        principal.add(lblFeliz);
        principal.add(radioButton_feliz);
        principal.add(lblPraBaixo);
        principal.add(radioButton_praBaixo);
        principal.add(lblOpcao3);
        principal.add(radioButton_opcao3);
        principal.add(btnSubmit);
        principal.add(sugestoes);
        principal.setLayout(new BorderLayout());
        principal.setBackground(new Color(0,0,0,100));;
        frame.add(principal);

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

                    JLabel imagens = new JLabel();
                    imagens.setIcon(getImageURL("https://raw.githubusercontent.com/Danilo25/Danilo25.github.io/master/Crocobite0000.jpg", 100, 100));
                    sugestoes.setVerticalAlignment(SwingConstants.TOP);
                    imagens.setBounds(190, 30, 100, 100);
                    imagens.setHorizontalAlignment(SwingConstants.CENTER);
                    imagens.setVerticalAlignment(SwingConstants.BOTTOM);
                    imagens.setLayout(new BorderLayout());
                    sugestoes.add(imagens);
                    
                } 
            }
        });
    }
}