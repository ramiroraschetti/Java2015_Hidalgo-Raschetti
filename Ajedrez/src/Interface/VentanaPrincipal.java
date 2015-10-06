package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;






import Controlador.CtrlJugar;
import Entidades.Partida;
import Entidades.Pieza;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textDni_Jug1;
	private JTextField textDni_Jug2;
	
	private CtrlJugar ctrlJug = new CtrlJugar(); 
	private ArrayList<Partida> partidasEmpezadas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Ajedrez - Ventana Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 141);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblJugador1 = new JLabel("Jugador 1: ");
		
		textDni_Jug1 = new JTextField();
		textDni_Jug1.setColumns(10);
		
		JLabel lblJugador2 = new JLabel("Jugador 2: ");
		
		textDni_Jug2 = new JTextField();
		textDni_Jug2.setColumns(10);
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				jugar();
			}
		});
		
		JButton btnBuscarOponente = new JButton("Buscar Oponente");
		btnBuscarOponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busquedaPartida();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblJugador1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textDni_Jug2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(textDni_Jug1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnBuscarOponente))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(45)
									.addComponent(btnNewButton))))
						.addComponent(lblJugador2))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDni_Jug1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJugador1)
						.addComponent(btnBuscarOponente))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugador2)
						.addComponent(textDni_Jug2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void jugar(){
		Partida p = new Partida();
		p = ctrlJug.iniciarPartida(Integer.parseInt(textDni_Jug1.getText()), Integer.parseInt(textDni_Jug2.getText()));
		if ( p != null){
			VentanaJuego juego = new VentanaJuego();
			juego.setP(p);
			juego.setVisible(true);
		}
		
	}
	
	private void busquedaPartida(){
		
		ctrlJug.buscarOponente(Integer.parseInt(textDni_Jug1.getText()));
		
		
	}
}
