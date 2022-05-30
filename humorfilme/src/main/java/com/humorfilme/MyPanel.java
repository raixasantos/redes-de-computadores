package com.humorfilme;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    private Image image;

    public MyPanel(String local) {
        this.initialize(local);
    }

    protected void initialize(String local) {
        this.image = this.getImageFile(local);

        this.setLayout(new BorderLayout());
    }
    public void Imagens(String local,int x, int y, int width1, int height1, int width2, int height2){
        JLabel label = new JLabel();
        label.setIcon(this.getImageURL(local, width2, height2));
        label.setBounds(x, y, width1, height1);
        this.add(label);
    }

    public Image getImageFile(String path) {
        URL imageURL = getClass().getResource(path);
        if (imageURL == null)
            return null;

        return new ImageIcon(imageURL).getImage();
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dDesktop = this.getSize();

        double width = dDesktop.getWidth();
        double height = dDesktop.getHeight();

        Image background = new ImageIcon(this.image.getScaledInstance(
                (int) width, (int) height, 1)).getImage();

        g.drawImage(background, 0, 0, this);
    }
}