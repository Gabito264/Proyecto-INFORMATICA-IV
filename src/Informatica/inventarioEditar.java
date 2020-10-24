package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class inventarioEditar {

	private JFrame frame;
	private JTextField BCodigo;
	private JTextField NNombre;
	private JTextField NCantidad;
	private JTextField NPrecio;
	private JTextField NCodigo;
	private JTextField NDia;
	private JTextField NMes;
	private JTextField NAno;
	private ProductTable pTable;
	private Product product;
	private JTextField noticeBoard;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inventarioEditar window = new inventarioEditar();
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
	public inventarioEditar() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		pTable = new ProductTable();
		pTable.load();
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 1138);
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
		btnCancelar.setBounds(431, 901, 420, 189);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnEditar = new JButton("Realizar Cambios");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NCodigo.getText().equals("")) {
					noticeBoard.setText("Escriba un Código y presione buscar");
				}else {
				product.setName(NNombre.getText());
				product.setCode(Integer.parseInt(NCodigo.getText()));
				product.setPrice(Double.parseDouble(NPrecio.getText()));
				product.setAmmount(Integer.parseInt(NCantidad.getText()));
				product.setReleaseDate(Integer.parseInt(NAno.getText()), Integer.parseInt(NMes.getText()), Integer.parseInt(NDia.getText()));
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
			}
		});
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnEditar.setBounds(10, 901, 420, 189);
		frame.getContentPane().add(btnEditar);
		
		JLabel lblNewLabel = new JLabel("Buscar (C\u00F3digo)");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 271, 96);
		frame.getContentPane().add(lblNewLabel);
		
		BCodigo = new JTextField();
		BCodigo.setFont(new Font("Arial", Font.PLAIN, 30));
		BCodigo.setBounds(291, 11, 271, 96);
		frame.getContentPane().add(BCodigo);
		BCodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BCodigo.getText().equals("")) {
					noticeBoard.setText("Inserte un Código");
				} else {
					product = pTable.getProduct(Integer.parseInt(BCodigo.getText()));
					if(product!=null) {
					NCodigo.setText(String.valueOf(product.getCode()));
					NNombre.setText(product.getName());
					String fecha = product.getReleaseDate();
					NMes.setText(fecha.substring(0,2));
					NDia.setText(fecha.substring(3,5));
					NAno.setText(fecha.substring(6,10));
					NPrecio.setText(String.valueOf(product.getPrice()));
					NCantidad.setText(String.valueOf(product.getAmmount()));
					noticeBoard.setText("");
					} else {
						noticeBoard.setText("Producto Deseado no Existe!");
					}
				} 
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnBuscar.setBounds(572, 11, 271, 96);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 167, 271, 96);
		frame.getContentPane().add(lblNewLabel_1);
		
		NNombre = new JTextField();
		NNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		NNombre.setBounds(291, 167, 420, 96);
		frame.getContentPane().add(NNombre);
		NNombre.setColumns(10);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha Lanzamiento");
		lblFechaDeSalida.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFechaDeSalida.setBounds(10, 274, 271, 96);
		frame.getContentPane().add(lblFechaDeSalida);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCantidad.setBounds(10, 381, 271, 96);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPrecio.setBounds(10, 488, 271, 96);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCdigo.setBounds(10, 595, 271, 96);
		frame.getContentPane().add(lblCdigo);
		
		NCantidad = new JTextField();
		NCantidad.setFont(new Font("Arial", Font.PLAIN, 30));
		NCantidad.setColumns(10);
		NCantidad.setBounds(291, 381, 420, 96);
		frame.getContentPane().add(NCantidad);
		
		NPrecio = new JTextField();
		NPrecio.setFont(new Font("Arial", Font.PLAIN, 30));
		NPrecio.setColumns(10);
		NPrecio.setBounds(291, 488, 420, 96);
		frame.getContentPane().add(NPrecio);
		
		NCodigo = new JTextField();
		NCodigo.setFont(new Font("Arial", Font.PLAIN, 30));
		NCodigo.setColumns(10);
		NCodigo.setBounds(291, 595, 420, 96);
		frame.getContentPane().add(NCodigo);
		
		JLabel lblDa = new JLabel("D\u00EDa");
		lblDa.setFont(new Font("Arial", Font.PLAIN, 30));
		lblDa.setBounds(291, 274, 68, 96);
		frame.getContentPane().add(lblDa);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblMes.setBounds(460, 274, 68, 96);
		frame.getContentPane().add(lblMes);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAo.setBounds(625, 274, 68, 96);
		frame.getContentPane().add(lblAo);
		
		NDia = new JTextField();
		NDia.setFont(new Font("Arial", Font.PLAIN, 30));
		NDia.setColumns(10);
		NDia.setBounds(347, 274, 96, 96);
		frame.getContentPane().add(NDia);
		
		NMes = new JTextField();
		NMes.setFont(new Font("Arial", Font.PLAIN, 30));
		NMes.setColumns(10);
		NMes.setBounds(524, 274, 96, 96);
		frame.getContentPane().add(NMes);
		
		NAno = new JTextField();
		NAno.setFont(new Font("Arial", Font.PLAIN, 30));
		NAno.setColumns(10);
		NAno.setBounds(689, 274, 138, 96);
		frame.getContentPane().add(NAno);
		
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BCodigo.getText().equals("")) {
					noticeBoard.setText("Introdusca un código");
				} else {
					if(pTable.getProduct(Integer.parseInt(BCodigo.getText())) != null) {
					pTable.remove(Integer.parseInt(BCodigo.getText()));
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
					} else {
						noticeBoard.setText("Introdusca un código válido");
					}
				}
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnEliminar.setBounds(10, 702, 420, 189);
		frame.getContentPane().add(btnEliminar);
		
		noticeBoard = new JTextField();
		noticeBoard.setFont(new Font("Arial", Font.PLAIN, 30));
		noticeBoard.setBounds(440, 754, 411, 96);
		frame.getContentPane().add(noticeBoard);
		noticeBoard.setColumns(10);
		
	}
}
