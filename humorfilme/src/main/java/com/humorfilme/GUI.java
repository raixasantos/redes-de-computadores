package com.humorfilme;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private ArrayList<JRadioButton> botoes;
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
        BufferedImage teste=null;
        try{
            URL imageURL = new URL(path);
            teste = ImageIO.read(imageURL);
            
        }catch(IOException e){
            e.getStackTrace();
        }
        ImageIcon icon = new ImageIcon(teste);
        Image mudar = icon.getImage();
        Image dimensionar = mudar.getScaledInstance(width, height, mudar.SCALE_SMOOTH);
        return new ImageIcon(dimensionar);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 730, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        backGround = new MyPanel("back.jfif");
        frame.setContentPane(backGround);
        

        JLabel lblQuestaoHumor = new JLabel("Descubra qual filme combina com o seu humor hoje: ");
        lblQuestaoHumor.setBounds(170, 30, 500, 14);

        JLabel lblFeliz = new JLabel("Feliz");
        lblFeliz.setBounds(100, 60, 46, 14);

        botoes = new ArrayList<JRadioButton>();
        JRadioButton radioButton_feliz = new JRadioButton("Opção1");
        radioButton_feliz.setBounds(100, 75, 20, 20);
        radioButton_feliz.setOpaque(false);
        botoes.add(radioButton_feliz);

        JLabel lblPraBaixo = new JLabel("Pra baixo");
        lblPraBaixo.setBounds(200, 60, 80, 14);

        JRadioButton radioButton_praBaixo = new JRadioButton("Opção2");
        radioButton_praBaixo.setBounds(200, 75, 20, 20);
        radioButton_praBaixo.setOpaque(false);
        botoes.add(radioButton_praBaixo);

        JLabel lblOpcao3 = new JLabel("Inspirado(a)");
        lblOpcao3.setBounds(300, 60, 95, 14);

        JRadioButton radioButton_opcao3 = new JRadioButton("Opção3");
        radioButton_opcao3.setBounds(300, 75, 20, 20);
        radioButton_opcao3.setOpaque(false);
        botoes.add(radioButton_opcao3);
        
        JLabel lblOpcao4 = new JLabel("Com raiva");
        lblOpcao4.setBounds(400, 60, 80, 14);

        JRadioButton radioButton_opcao4 = new JRadioButton("Opção4");
        radioButton_opcao4.setBounds(400, 75, 20, 20);
        radioButton_opcao4.setOpaque(false);
        botoes.add(radioButton_opcao4);

        JLabel lblOpcao5 = new JLabel("Apaixonado(a)");
        lblOpcao5.setBounds(500, 60, 150, 14);

        JRadioButton radioButton_opcao5 = new JRadioButton("Opção5");
        radioButton_opcao5.setBounds(500, 75, 20, 20);
        radioButton_opcao5.setOpaque(false);
        botoes.add(radioButton_opcao5);

        ButtonGroup opcao = new ButtonGroup();

        opcao.add(radioButton_feliz);
        opcao.add(radioButton_praBaixo);
        opcao.add(radioButton_opcao3);
        opcao.add(radioButton_opcao4);
        opcao.add(radioButton_opcao5);

        JButton btnSubmit = new JButton("Descobrir");     
        btnSubmit.setBackground(Color.BLUE);    
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setBounds(280, 120, 140, 23);

        JLabel sugestoes = new JLabel();
        //sugestoes.setLayout(new GridBagLayout());
        sugestoes.setBorder( BorderFactory.createTitledBorder( "" ) ) ;
        sugestoes.setHorizontalAlignment( SwingConstants.CENTER );
        sugestoes.setBounds(80, 200, 560, 250);

        JLabel principal = new JLabel();
        principal.add(lblQuestaoHumor);
        principal.add(lblFeliz);
        principal.add(radioButton_feliz);
        principal.add(lblPraBaixo);
        principal.add(radioButton_praBaixo);
        principal.add(lblOpcao3);
        principal.add(radioButton_opcao3);
        principal.add(lblOpcao4);
        principal.add(radioButton_opcao4);
        principal.add(lblOpcao5);
        principal.add(radioButton_opcao5);
        principal.add(btnSubmit);
        principal.add(sugestoes);
        principal.setLayout(new BorderLayout());
        principal.setBackground(new Color(0,0,0,100));;
        frame.add(principal);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String urlImagem="";
                boolean escolheu=false;
                for(JRadioButton botao:botoes){
                    if(botao.isSelected()){
                        escolheu=true;
                        break;
                    }else{
                        escolheu=false;
                    }
                }
                String mood = "sad";
                if(!escolheu)
                    sugestoes.setText("Selecione uma opção!");
                else {
                    if(radioButton_feliz.isSelected()){
                        urlImagem = "https://raw.githubusercontent.com/Danilo25/Danilo25.github.io/master/Crocobite0000.jpg";
                        mood = "feliz";
                    }else if(radioButton_praBaixo.isSelected()){
                        urlImagem = "https://3.bp.blogspot.com/-VOzfr65GNOo/WdNZ9EB4XRI/AAAAAAAABhA/ElyD407GPE0j2w9vQaL5UoAdOUs1RSCNgCLcBGAs/s1600/water-209901_960_720.jpg";
                        mood = "pra baixo";
                    }else if(radioButton_opcao3.isSelected()){
                        urlImagem = "https://mozgate.co.mz/wp-content/uploads/2019/09/Rede-de-computadores.jpg";
                        mood = "inspirado(a)";
                    }else if(radioButton_opcao4.isSelected()){
                        urlImagem = "http://www.nintendoworldreport.com/media/33891/4/57.jpg";
                        mood = "com raiva";
                    }else if(radioButton_opcao5.isSelected()){
                        urlImagem = "https://site.uniaraxa.edu.br/wp-content/uploads/2019/12/sistemas.jpeg";
                        mood = "apaixonado(a)";
                    }
                    IMDB imdb = new IMDB();
                    
                    sugestoes.setText("Para o humor " + mood + ": " + imdb.callingAPIService("happy"));
                    sugestoes.setIcon(getImageURL(urlImagem, 100, 100));
                    
                    sugestoes.setHorizontalTextPosition(SwingConstants.CENTER);
                    sugestoes.setVerticalTextPosition(SwingConstants.TOP);
                    sugestoes.setHorizontalAlignment(SwingConstants.CENTER);
                    sugestoes.setVerticalAlignment(SwingConstants.BOTTOM);
                    
                } 
            }
        });
    }
}