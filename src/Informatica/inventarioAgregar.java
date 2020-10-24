package Informatica;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.IOException;
import java.util.Hashtable;
public class inventarioAgregar {

	private JFrame frame;
	private JTextField Nombre;
	private JTextField Precio;
	private JTextField Cantidad;
	private JTextField Codigo;
	private ProductTable pTable;
	private Product product;
	private JTextField Ano;
	private JTextField Mes;
	private JTextField Dia;
	/**
	 * Launch the application.
	 */
	public static void newScreen() throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventarioAgregar window = new inventarioAgregar();
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
	public inventarioAgregar() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		pTable = new ProductTable();
		pTable.load();
		
		product = new Product();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1139, 1228);
		frame.getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iWindow window = null;
				try {
					 window = new iWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					window.newScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnCancelar.setBounds(583, 993, 531, 186);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product.setName(Nombre.getText());
				product.setCode(Integer.parseInt(Codigo.getText()));
				product.setPrice(Double.parseDouble(Precio.getText()));
				product.setAmmount(Integer.parseInt(Cantidad.getText()));
				product.setReleaseDate(Integer.parseInt(Ano.getText()), Integer.parseInt(Mes.getText()), Integer.parseInt(Dia.getText()));
				pTable.add(product);
				try {
					pTable.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				iWindow ventana = null;
				try {
					ventana = new iWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ventana.newScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnAgregar.setBounds(10, 993, 531, 186);
		frame.getContentPane().add(btnAgregar);
		
		JLabel lblNewLabel = new JLabel("Agregar Producto");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 48));
		lblNewLabel.setBounds(10, 11, 531, 116);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNombre.setBounds(10, 138, 237, 116);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha de Lanzamiento");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFecha.setBounds(10, 243, 311, 116);
		frame.getContentPane().add(lblFecha);
		
		JLabel lblprecio = new JLabel("Precio");
		lblprecio.setFont(new Font("Arial", Font.PLAIN, 30));
		lblprecio.setBounds(10, 318, 237, 116);
		frame.getContentPane().add(lblprecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCantidad.setBounds(10, 409, 237, 100);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCodigo.setBounds(10, 503, 237, 100);
		frame.getContentPane().add(lblCodigo);
		
		Nombre = new JTextField();
		Nombre.setFont(new Font("Arial", Font.PLAIN, 30));
		Nombre.setBounds(257, 158, 470, 77);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		Precio = new JTextField();
		Precio.setFont(new Font("Arial", Font.PLAIN, 30));
		Precio.setColumns(10);
		Precio.setBounds(257, 338, 470, 77);
		frame.getContentPane().add(Precio);
		
		Cantidad = new JTextField();
		Cantidad.setFont(new Font("Arial", Font.PLAIN, 30));
		Cantidad.setColumns(10);
		Cantidad.setBounds(257, 421, 470, 77);
		frame.getContentPane().add(Cantidad);
		
		Codigo = new JTextField();
		Codigo.setFont(new Font("Arial", Font.PLAIN, 30));
		Codigo.setColumns(10);
		Codigo.setBounds(257, 515, 470, 77);
		frame.getContentPane().add(Codigo);
		
		JLabel lblDa = new JLabel("D\u00EDa");
		lblDa.setFont(new Font("Arial", Font.PLAIN, 30));
		lblDa.setBounds(362, 243, 62, 116);
		frame.getContentPane().add(lblDa);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblMes.setBounds(521, 243, 62, 116);
		frame.getContentPane().add(lblMes);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAo.setBounds(726, 243, 62, 116);
		frame.getContentPane().add(lblAo);
		
		Ano = new JTextField();
		Ano.setFont(new Font("Arial", Font.PLAIN, 30));
		Ano.setBounds(798, 250, 153, 77);
		frame.getContentPane().add(Ano);
		Ano.setColumns(10);
		
		Mes = new JTextField();
		Mes.setFont(new Font("Arial", Font.PLAIN, 30));
		Mes.setColumns(10);
		Mes.setBounds(593, 250, 117, 77);
		frame.getContentPane().add(Mes);
		
		Dia = new JTextField();
		Dia.setFont(new Font("Arial", Font.PLAIN, 30));
		Dia.setColumns(10);
		Dia.setBounds(434, 250, 77, 77);
		frame.getContentPane().add(Dia);
		
	}
}
