package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class rWindow {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rWindow window = new rWindow();
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
	public rWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.getContentPane().setLayout(null);
		
		JButton agregarRes = new JButton("Agregar Reservaci\u00F3n");
		agregarRes.setFont(new Font("Arial", Font.PLAIN, 48));
		agregarRes.setBounds(10, 885, 572, 147);
		frame.getContentPane().add(agregarRes);
		
		JButton CancelarRes = new JButton("Cancelar Reservaci\u00F3n");
		CancelarRes.setFont(new Font("Arial", Font.PLAIN, 48));
		CancelarRes.setBounds(670, 885, 572, 147);
		frame.getContentPane().add(CancelarRes);
		
		JButton Regresar = new JButton("Regresar");
		Regresar.setFont(new Font("Arial", Font.PLAIN, 48));
		Regresar.setBounds(1324, 885, 572, 147);
		frame.getContentPane().add(Regresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 1886, 732);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(50);
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"C\u00F3digo", "Nombre Cliente", "Fecha", "Nombre Producto", "Condici\u00F3n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.setRowHeight(50);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Reservaciones");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		lblNewLabel.setBounds(1534, 11, 362, 88);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
