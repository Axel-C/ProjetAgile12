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

public class Interface extends JFrame implements KeyListener {
	JFrame fenetre ;
	public JPanel couleur ;
	
	public Interface() {
		
		// TODO Auto-generated constructor stub
		setTitle("Contrôles");
		setSize(300	, 200);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridLayout(3, 3));
		JButton haut = new JButton("HAUT");
		JButton droite = new JButton("DROITE");
		JButton bas = new JButton("BAS");
		JButton gauche = new JButton("GAUCHE");
		couleur = new JPanel();
		haut.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				test.jeu.actif.deplacer(Directions.NORD);
				test.jeu.tourSuivant();
				
			}
		});
droite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				test.jeu.actif.deplacer(Directions.EST);
				test.jeu.tourSuivant();
				
			}
		});
bas.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		test.jeu.actif.deplacer(Directions.SUD);
		test.jeu.tourSuivant();
		
	}
});
gauche.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		test.jeu.actif.deplacer(Directions.OUEST);
		test.jeu.tourSuivant();
		
	}
});


		
		
		
		
		
		add(new JPanel());
		add(haut);
		add(new JPanel());
		add(gauche);
		add(couleur);
		
		add(droite);
		add(new JPanel());
		add(bas);
		add(new JPanel());
		
		
		setVisible(true);
		couleur.setBackground(Color.CYAN);
		
		
		
	}
	
	public void fermer(){
		dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'z'){
			test.jeu.actif.deplacer(Directions.NORD);
			test.jeu.tourSuivant();
			System.out.println("dsiusvyusd");
		}
		System.out.println("hyvcysu");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
