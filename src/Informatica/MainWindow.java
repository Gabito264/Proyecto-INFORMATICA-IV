package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1471, 1007);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton irInventario = new JButton("Inventario");
		irInventario.setBackground(new Color(100, 149, 237));
		irInventario.setFont(new Font("Arial", Font.PLAIN, 48));
		irInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iWindow inv = new iWindow();
				inv.newScreen();
			}
		});
		irInventario.setBounds(10, 30, 706, 452);
		frame.getContentPane().add(irInventario);
		
		JButton irReservaciones = new JButton("Reservaciones");
		irReservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rWindow res = new rWindow();
				res.newScreen();
			}
		});
		irReservaciones.setBackground(new Color(255, 160, 122));
		irReservaciones.setFont(new Font("Arial", Font.PLAIN, 48));
		irReservaciones.setBounds(741, 30, 706, 452);
		frame.getContentPane().add(irReservaciones);
		
		JButton irLVentas = new JButton("Lista de Ventas");
		irLVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lvWindow listaVenta = new lvWindow();
				listaVenta.newScreen();
			}
		});
		irLVentas.setBackground(new Color(135, 206, 250));
		irLVentas.setFont(new Font("Arial", Font.PLAIN, 48));
		irLVentas.setBounds(10, 507, 706, 452);
		frame.getContentPane().add(irLVentas);
		
		JButton irVender = new JButton("Realizar Venta");
		irVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vWindow ventasVariable = new vWindow();
				ventasVariable.newScreen();
			}
		});
		irVender.setBackground(new Color(255, 250, 205));
		irVender.setFont(new Font("Arial", Font.PLAIN, 48));
		irVender.setBounds(741, 507, 706, 452);
		frame.getContentPane().add(irVender);
	}
}
