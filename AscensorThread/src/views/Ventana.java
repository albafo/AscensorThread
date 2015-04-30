package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Gravedad;

public class Ventana extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		Gravedad gravedad=new Gravedad();
		Persona persona=new Persona(gravedad);
		persona.setSize(100, 200);
		persona.setLocation(77, 570);
		
		Ascensor ascensor=new Ascensor(gravedad);
		ascensor.setSize(295, 400);
		ascensor.setLocation(77, 400);
		
		contentPane.add(ascensor);
		contentPane.add(persona);
		contentPane.setComponentZOrder(ascensor, 1);
		contentPane.setComponentZOrder(persona, 0);
		(new Thread(ascensor)).start();
		//(new Thread(persona)).start();

	}

}
