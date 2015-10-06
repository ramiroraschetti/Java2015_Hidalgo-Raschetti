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
import Entidades.Pieza;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private Partida p;
	private Pieza pieza;
	private JTextField txtTurno;
	private JTextField textField_Origen;
	private JTextField textField_Destino;
	private JTextArea txtPosicionesPiezasBlancas;
	private JTextArea txtPosicionesPiezasNegras;
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
		setBounds(100, 100, 535, 377);
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
				realizarMovimiento(p, pieza);
				cargarTurno();
				mostrarPiezas();
				limpiar();
			}

			

			
		});
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		txtTurno = new JTextField();
		txtTurno.setHorizontalAlignment(SwingConstants.CENTER);
		txtTurno.setEditable(false);
		txtTurno.setColumns(10);
		
		txtPosicionesPiezasBlancas = new JTextArea();
		txtPosicionesPiezasBlancas.setEditable(false);
		txtPosicionesPiezasBlancas.setRows(16);
		
		txtPosicionesPiezasNegras = new JTextArea();
		txtPosicionesPiezasNegras.setRows(16);
		txtPosicionesPiezasNegras.setEditable(false);
		
		textField_Origen = new JTextField();
		textField_Origen.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Origen.setColumns(3);
		
		textField_Destino = new JTextField();
		textField_Destino.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Destino.setColumns(3);
		
		
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
							.addComponent(txtPosicionesPiezasNegras, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSalir)
								.addComponent(btnMover)
								.addComponent(lblMovimientos)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTurno)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblOrigen)
											.addComponent(lblDestino))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_Destino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_Origen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addGap(45))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPiezasNegras)
							.addContainerGap(279, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPiezasBlancas)
						.addComponent(lblPiezasNegras))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTurno)
								.addComponent(txtTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addComponent(lblMovimientos)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOrigen)
								.addComponent(textField_Origen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_Destino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDestino))
							.addGap(42)
							.addComponent(btnMover)
							.addGap(34)
							.addComponent(btnSalir))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtPosicionesPiezasBlancas, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPosicionesPiezasNegras, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void realizarMovimiento(Partida partida, Pieza pieza) {
	ctrlJug.guardarPiezas(partida, pieza);
		
	}
	public void mostrarPiezas(){

		txtPosicionesPiezasBlancas.setText(p.mostrarPiezas("blanca").toString());
		txtPosicionesPiezasNegras.setText(p.mostrarPiezas("negra").toString());
		
	}
	public void cargarTurno() {
		txtTurno.setText(p.getTurno());
	}
	private void limpiar() {
		textField_Origen.setText("");
		textField_Destino.setText("");
		
	}
}
