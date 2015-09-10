package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textDni_Blancas;
	private JTextField textDni_Negras;
	private JTextField textField_2;
	private JTextField textField_3;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblJugadorBlancas = new JLabel("Jugador Blancas: ");
		
		textDni_Blancas = new JTextField();
		textDni_Blancas.setColumns(10);
		
		JLabel lblJugadorNegras = new JLabel("Jugador Negras: ");
		
		textDni_Negras = new JTextField();
		textDni_Negras.setColumns(10);
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				jugar();
			}
		});
		
		JLabel lblTurno = new JLabel("Turno: ");
		
		JLabel lblMovimientos = new JLabel("MOVIMIENTOS");
		lblMovimientos.setVerticalAlignment(SwingConstants.TOP);
		lblMovimientos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblOrigen = new JLabel("Origen :  ");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblDestino = new JLabel("Destino : ");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		
		JLabel lblBlancas = new JLabel("BLANCAS");
		lblBlancas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblNegras = new JLabel("NEGRAS");
		lblNegras.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JTextArea textArea_Blancas = new JTextArea();
		textArea_Blancas.setEditable(false);
		
		JTextArea textArea_Negras = new JTextArea();
		textArea_Negras.setEditable(false);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton btnMostrarPosiciones = new JButton("Mostrar Posiciones");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnGuardar)
								.addGap(276))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblBlancas)
									.addComponent(lblJugadorBlancas))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(84)
										.addComponent(lblNegras))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textDni_Negras, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
											.addComponent(textDni_Blancas, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(18)
												.addComponent(btnBuscarOponente))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(45)
												.addComponent(btnNewButton)))))
								.addGap(269)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textArea_Blancas, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textArea_Negras, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblOrigen)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDestino)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTurno)
								.addComponent(btnMover, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(22)
									.addComponent(lblMovimientos, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnSalir)
									.addComponent(btnMostrarPosiciones))))
						.addComponent(lblJugadorNegras))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDni_Blancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJugadorBlancas)
						.addComponent(btnBuscarOponente))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJugadorNegras)
						.addComponent(textDni_Negras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBlancas)
								.addComponent(lblNegras))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textArea_Blancas, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(textArea_Negras, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTurno)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMovimientos, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOrigen)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestino)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnMover)
							.addGap(18)
							.addComponent(btnMostrarPosiciones)))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnSalir))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void jugar(){
		ctrlJug.iniciarPartida(Integer.parseInt(textDni_Blancas.getText()), Integer.parseInt(textDni_Negras.getText()));
		
		
	}
	
	private void busquedaPartida(){
		
		ctrlJug.buscarOponente(Integer.parseInt(textDni_Blancas.getText()));
		
		
	}
}
