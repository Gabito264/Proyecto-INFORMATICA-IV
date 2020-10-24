package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
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
	public MainWindow() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		frame = new JFrame();
		frame.setBounds(100, 100, 1471, 1007);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton irInventario = new JButton("Inventario");
		irInventario.setBackground(new Color(100, 149, 237));
		irInventario.setFont(new Font("Arial", Font.PLAIN, 48));
		irInventario.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				iWindow inv = null;
				try {
					inv = new iWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					inv.newScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		irInventario.setBounds(10, 30, 706, 452);
		frame.getContentPane().add(irInventario);
		
		JButton irReservaciones = new JButton("Reservaciones");
		irReservaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rWindow res = null;
				try {
					res = new rWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JButton irVender = new JButton("Carrito de Compras");
		irVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vWindow ventasVariable = null;
				try {
					ventasVariable = new vWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventasVariable.newScreen();
			}
		});
		irVender.setBackground(new Color(255, 250, 205));
		irVender.setFont(new Font("Arial", Font.PLAIN, 48));
		irVender.setBounds(741, 507, 706, 452);
		frame.getContentPane().add(irVender);
	}
}
