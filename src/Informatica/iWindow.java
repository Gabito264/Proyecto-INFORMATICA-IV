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

public class iWindow {

	private JFrame frame;
	private JTable table;
	private JTextField Buscar;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
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
	public iWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.getContentPane().setLayout(null);
		
		JButton agregar = new JButton("Agregar Producto");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		agregar.setFont(new Font("Arial", Font.PLAIN, 48));
		agregar.setBounds(10, 885, 572, 147);
		frame.getContentPane().add(agregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 1886, 747);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		table.setRowHeight(50);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nombre Producto", "Fecha de Salida", "Precio", "Cantidad", "No. Reservas"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		 table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		scrollPane.setViewportView(table);
		
		JButton editar = new JButton("Editar Producto");
		editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		editar.setFont(new Font("Arial", Font.PLAIN, 48));
		editar.setBounds(664, 885, 572, 147);
		frame.getContentPane().add(editar);
		
		JButton regresar = new JButton("Regresar");
		regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		regresar.setFont(new Font("Arial", Font.PLAIN, 48));
		regresar.setBounds(1324, 885, 572, 147);
		frame.getContentPane().add(regresar);
		
		JLabel Label1 = new JLabel("Buscar Producto (C\u00F3digo)");
		Label1.setFont(new Font("Arial", Font.PLAIN, 48));
		Label1.setBounds(10, 11, 579, 90);
		frame.getContentPane().add(Label1);
		
		Buscar = new JTextField();
		Buscar.setFont(new Font("Arial", Font.PLAIN, 48));
		Buscar.setBounds(599, 11, 572, 90);
		frame.getContentPane().add(Buscar);
		Buscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 58));
		lblNewLabel.setBounds(1615, 11, 281, 90);
		frame.getContentPane().add(lblNewLabel);
	}
}
