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

public class Interface {
	JFrame fenetre ;
	public JPanel couleur ;
	
	public Interface() {
		
		// TODO Auto-generated constructor stub
		fenetre = new JFrame("Contrôles");
		fenetre.setSize(300	, 200);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setLayout(new GridLayout(3, 3));
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

couleur.addKeyListener(new KeyListener() {
	
	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'z'){
			test.jeu.actif.deplacer(Directions.NORD);
			test.jeu.tourSuivant();
		}
		if((e.getKeyCode()==KeyEvent.VK_ENTER)){
            System.out.println("vous avez apuyer sur entrer"); 
}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyChar() == 'z'){
			test.jeu.actif.deplacer(Directions.NORD);
			test.jeu.tourSuivant();
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
});
		
		
		
		
		
		fenetre.add(new JPanel());
		fenetre.add(haut);
		fenetre.add(new JPanel());
		fenetre.add(gauche);
		fenetre.add(couleur);
		
		fenetre.add(droite);
		fenetre.add(new JPanel());
		fenetre.add(bas);
		fenetre.add(new JPanel());
		
		
		fenetre.setVisible(true);
		couleur.setBackground(Color.CYAN);
		
		
		
	}
	
	public void fermer(){
		fenetre.dispose();
	}

}
