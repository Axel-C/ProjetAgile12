package lesCases;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.scene.control.Separator;

public class Interface extends JFrame {
	JFrame fenetre;
	public JPanel couleur;

	public Interface() {

		// TODO Auto-generated constructor stub
		setTitle("Contrôles");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(3, 3));
		JButton haut = new JButton("HAUT");
		JButton droite = new JButton("DROITE");
		JButton bas = new JButton("BAS");
		JButton gauche = new JButton("GAUCHE");
		couleur = new JPanel();
		haut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(test.jeu.actif.equals(test.jeu.s1)){
				test.jeu.actif.deplacer(Directions.NORD);
				test.jeu.tourSuivant();
				}

			}
		});
		droite.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(test.jeu.actif.equals(test.jeu.s1)){
				test.jeu.actif.deplacer(Directions.EST);
				test.jeu.tourSuivant();
				}

			}
		});
		bas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(test.jeu.actif.equals(test.jeu.s1)){
				test.jeu.actif.deplacer(Directions.SUD);
				test.jeu.tourSuivant();
				}

			}
		});
		gauche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(test.jeu.actif.equals(test.jeu.s1)){
				test.jeu.actif.deplacer(Directions.OUEST);
				test.jeu.tourSuivant();
				}

			}
		});
		KeyListener listener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(test.jeu.actif.equals(test.jeu.s2)){
				if(e.getKeyChar() == 'z'){
					test.jeu.actif.deplacer(Directions.NORD);
					test.jeu.tourSuivant();
					System.out.println("test");
				}
				if(e.getKeyChar() == 'q'){
					test.jeu.actif.deplacer(Directions.OUEST);
					test.jeu.tourSuivant();
				}
				if(e.getKeyChar() == 'd'){
					test.jeu.actif.deplacer(Directions.EST);
					test.jeu.tourSuivant();
				}
					if(e.getKeyChar() == 's'){
						test.jeu.actif.deplacer(Directions.SUD);
						test.jeu.tourSuivant();
				}
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		add(new JPanel());
		add(haut);
		add(new JPanel());
		add(gauche);
		add(couleur);

		add(droite);
		add(new JPanel());
		add(bas);
		add(new JPanel());
		
		haut.addKeyListener(listener);
		gauche.addKeyListener(listener);
		droite.addKeyListener(listener);
		bas.addKeyListener(listener);
		setVisible(true);
		couleur.setBackground(Color.CYAN);

	}

	public void fermer() {
		dispose();
	}

}
