package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import Entidades.Partida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private Partida p;

	
	public void setP(Partida p){
		this.p =p;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
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
	public VentanaJuego() {
		setTitle("Ajedrez - Ventana Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPiezasBlancas = new JLabel("Piezas Blancas");
		lblPiezasBlancas.setFont(new Font("Arial", Font.BOLD, 12));
		
		JTextPane textPane = new JTextPane();
		
		JLabel lblPiezasNegras = new JLabel("Piezas Negras");
		lblPiezasNegras.setFont(new Font("Arial", Font.BOLD, 12));
		
		JTextPane textPane_1 = new JTextPane();
		
		JLabel lblTurno = new JLabel("Turno :");
		
		JLabel lblMovimientos = new JLabel("MOVIMIENTOS");
		lblMovimientos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblOrigen = new JLabel("Origen :");
		
		JLabel lblDestino = new JLabel("Destino :");
		
		JButton btnMover = new JButton("MOVER");
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPiezasBlancas)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir)
								.addComponent(btnMover)
								.addComponent(lblDestino)
								.addComponent(lblOrigen)
								.addComponent(lblMovimientos)
								.addComponent(lblTurno)))
						.addComponent(lblPiezasNegras))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPiezasBlancas)
						.addComponent(lblPiezasNegras))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textPane)
						.addComponent(textPane_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTurno)
							.addGap(26)
							.addComponent(lblMovimientos)
							.addGap(18)
							.addComponent(lblOrigen)
							.addGap(35)
							.addComponent(lblDestino)
							.addGap(39)
							.addComponent(btnMover)
							.addGap(34)
							.addComponent(btnSalir)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
