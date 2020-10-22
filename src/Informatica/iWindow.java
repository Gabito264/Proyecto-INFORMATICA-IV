package Informatica;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;


public class iWindow {

	private JFrame frame;
	private JTable table;
	private ProductTable pTable;
	private Product product;
	private Set<Integer> keys;
	/**
	 * Launch the application.
	 */
	public static void newScreen() throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					iWindow window = new iWindow();
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
	public iWindow() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		
		pTable = new ProductTable();
		pTable.load();
		keys = pTable.getKeys();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.getContentPane().setLayout(null);
		
		JButton agregar = new JButton("Agregar Producto");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventarioAgregar agregar = null;
				try {
					agregar = new inventarioAgregar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					agregar.newScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		agregar.setFont(new Font("Arial", Font.PLAIN, 48));
		agregar.setBounds(10, 885, 572, 147);
		frame.getContentPane().add(agregar);
		
		createTable();
		
		JButton editar = new JButton("Editar Producto");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventarioEditar edit = null;
				try {
					edit = new inventarioEditar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				edit.newScreen();
				frame.dispose();
			}
		});
		editar.setFont(new Font("Arial", Font.PLAIN, 48));
		editar.setBounds(664, 885, 572, 147);
		frame.getContentPane().add(editar);
		
		JButton regresar = new JButton("Regresar");
		regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		regresar.setFont(new Font("Arial", Font.PLAIN, 48));
		regresar.setBounds(1324, 885, 572, 147);
		frame.getContentPane().add(regresar);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 58));
		lblNewLabel.setBounds(1615, 11, 281, 90);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 48));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventarioBuscar window = null;
				try {
					window = new inventarioBuscar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.newScreen();
				
			}
		});
		btnBuscar.setBounds(10, 11, 387, 90);
		frame.getContentPane().add(btnBuscar);
	}
	
	public void createTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 1886, 747);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		table.setRowHeight(50);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre Producto", "Fecha de Lanzamiento", "Precio", "Cantidad", "No. Reservas"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(157);
		table.getColumnModel().getColumn(2).setPreferredWidth(122);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(pTable.getSize() > 0) {
		for(Integer key : keys) {
			product = pTable.getProduct(key);
		model.addRow(new Object[]{product.getCode(),product.getName(),product.getReleaseDate(),product.getPrice(),product.getAmmount(),product.getReservations()});
			}
		}
		 table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		scrollPane.setViewportView(table);
	}
}
