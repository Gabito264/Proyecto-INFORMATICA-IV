package Informatica;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inventarioBuscar {

	private JFrame frame;
	private JTextField BCodigo;
	private JTextField BNombre;
	private JTextField BFecha;
	private JTextField BPrecio;
	private JTextField BCantidad;
	private JTextField BReservaciones;
	private ProductTable pTable;
	private Product product;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventarioBuscar window = new inventarioBuscar();
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
	public inventarioBuscar() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		 pTable = new ProductTable();
		pTable.load();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1150, 844);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar (C\u00F3digo)");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 360, 109);
		frame.getContentPane().add(lblNewLabel);
		
		BCodigo = new JTextField();
		BCodigo.setFont(new Font("Arial", Font.PLAIN, 30));
		BCodigo.setBounds(380, 11, 387, 109);
		frame.getContentPane().add(BCodigo);
		BCodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BCodigo.getText().equals("")){
					
				} else {
					product = pTable.getProduct(Integer.parseInt(BCodigo.getText()));
					BNombre.setText(product.getName());
					BPrecio.setText(String.valueOf(product.getPrice()));
					BFecha.setText(product.getReleaseDate());
					BCantidad.setText(String.valueOf(product.getAmmount()));
					BReservaciones.setText(String.valueOf(product.getReservations()));
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnBuscar.setBounds(777, 11, 349, 109);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNombre.setBounds(10, 131, 180, 109);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblD = new JLabel("Fecha de Lanzamiento");
		lblD.setFont(new Font("Arial", Font.PLAIN, 30));
		lblD.setBounds(10, 251, 306, 109);
		frame.getContentPane().add(lblD);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de Venta");
		lblPrecioDeVenta.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPrecioDeVenta.setBounds(10, 371, 306, 109);
		frame.getContentPane().add(lblPrecioDeVenta);
		
		JLabel lblCantidadDisponible = new JLabel("Cantidad Disponible");
		lblCantidadDisponible.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCantidadDisponible.setBounds(10, 491, 306, 109);
		frame.getContentPane().add(lblCantidadDisponible);
		
		JLabel lblCantidadDeReservaciones = new JLabel("Cantidad Reservaciones");
		lblCantidadDeReservaciones.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCantidadDeReservaciones.setBounds(10, 611, 387, 109);
		frame.getContentPane().add(lblCantidadDeReservaciones);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnRegresar.setBounds(777, 660, 349, 136);
		frame.getContentPane().add(btnRegresar);
		
		BNombre = new JTextField();
		BNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		BNombre.setColumns(10);
		BNombre.setBounds(380, 131, 387, 109);
		frame.getContentPane().add(BNombre);
		
		BFecha = new JTextField();
		BFecha.setFont(new Font("Arial", Font.PLAIN, 30));
		BFecha.setColumns(10);
		BFecha.setBounds(380, 251, 387, 109);
		frame.getContentPane().add(BFecha);
		
		BPrecio = new JTextField();
		BPrecio.setFont(new Font("Arial", Font.PLAIN, 30));
		BPrecio.setColumns(10);
		BPrecio.setBounds(380, 371, 387, 109);
		frame.getContentPane().add(BPrecio);
		
		BCantidad = new JTextField();
		BCantidad.setFont(new Font("Arial", Font.PLAIN, 30));
		BCantidad.setColumns(10);
		BCantidad.setBounds(380, 491, 387, 109);
		frame.getContentPane().add(BCantidad);
		
		BReservaciones = new JTextField();
		BReservaciones.setFont(new Font("Arial", Font.PLAIN, 30));
		BReservaciones.setColumns(10);
		BReservaciones.setBounds(380, 611, 387, 109);
		frame.getContentPane().add(BReservaciones);
	}

}
