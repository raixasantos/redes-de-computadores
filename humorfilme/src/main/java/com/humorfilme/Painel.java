package com.humorfilme;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class Painel extends JPanel {
    private ImageIcon backGround = new ImageIcon(getClass().getResource("teste.jfif"));

    public void paintComponents(Graphics g){
        super.paintComponents(g);
        Image fundo = backGround.getImage();
        g.drawImage(fundo, 0, 0, this);
    }
}
