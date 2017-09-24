package controller;

import javax.swing.JPanel;
import javax.swing.JWindow;

import view.FrmPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow{
	
	private int duration;

    public SplashScreen(int d) {
        duration = d;
    }

// Este é um método simples para mostrar uma tela de apresentção

// no centro da tela durante a quantidade de tempo passada no construtor

    public void showSplash() {        
        JPanel content = (JPanel)getContentPane();
        content.setBackground(Color.white);

        // Configura a posição e o tamanho da janela
        int width = 650;
        int height =250;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon("src/img/certificado.png"));
        JLabel copyrt = new JLabel
                ("Copyright 2017, Mpi Informática", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(0, 0, 0,  0);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 1));        
        // Torna visível
        setVisible(true);

        // Espera ate que os recursos estejam carregados
        try { Thread.sleep(duration); } catch (Exception e) {}        
        setVisible(false);        
    }

    public void showSplashAndExit() {        
        showSplash();
//        System.exit(0);        
    }

    public static void main(String[] args) {        
        // Mostra uma imagem com o título da aplicação 
        SplashScreen splash = new SplashScreen(2500);
        splash.showSplashAndExit();
        FrmPrincipal f = new FrmPrincipal();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


