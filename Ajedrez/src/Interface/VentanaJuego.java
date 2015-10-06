package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

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

import Controlador.CtrlJugar;
import Entidades.Partida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private Partida p;
	private JTextField txtTurno;
	private JTextArea txtPosicionesPiezasBlancas;
	private CtrlJugar ctrlJug = new CtrlJugar(); 
	
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
		
		JLabel lblPiezasNegras = new JLabel("Piezas Negras");
		lblPiezasNegras.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblTurno = new JLabel("Turno :");
		
		JLabel lblMovimientos = new JLabel("MOVIMIENTOS");
		lblMovimientos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblOrigen = new JLabel("Origen :");
		
		JLabel lblDestino = new JLabel("Destino :");
		
		JButton btnMover = new JButton("MOVER");
		btnMover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				realizarMovimiento();
			}

			
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTurno();
				mostrarPiezas();
			}
		});
		
		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setColumns(10);
		
		txtPosicionesPiezasBlancas = new JTextArea();
		txtPosicionesPiezasBlancas.setEditable(false);
		txtPosicionesPiezasBlancas.setRows(16);
		

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPiezasBlancas)
						.addComponent(txtPosicionesPiezasBlancas, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir)
								.addComponent(btnMover)
								.addComponent(lblDestino)
								.addComponent(lblOrigen)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTurno)
									.addGap(18)
									.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMovimientos)))
						.addComponent(lblPiezasNegras))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPiezasBlancas)
						.addComponent(lblPiezasNegras))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTurno)
								.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addComponent(lblMovimientos)
							.addGap(18)
							.addComponent(lblOrigen)
							.addGap(35)
							.addComponent(lblDestino)
							.addGap(39)
							.addComponent(btnMover)
							.addGap(34)
							.addComponent(btnSalir))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPosicionesPiezasBlancas, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
								)))
					.addGap(245))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void realizarMovimiento() {
	
		
	}
	public void mostrarPiezas(){

		txtPosicionesPiezasBlancas.setText(p.mostrarPiezas("blanca"));
		
		
	}
	public void cargarTurno() {
		txtTurno.setText(p.getTurno());
	}
}
