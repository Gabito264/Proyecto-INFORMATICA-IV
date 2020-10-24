package Informatica;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.Set;
public class lvWindow {

	private JFrame frame;
	private JTable table;
	private SaleTable sTable;
	private ProductTable pTable;
	private Set<Integer> keys;
	private Sale sale;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lvWindow window = new lvWindow();
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
	public lvWindow() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		
		pTable = new ProductTable();
		pTable.load();
		sTable = new SaleTable();
		sTable.load(pTable);
		keys = sTable.getKeys();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1482, 1280);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 1448, 918);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo de transacci\u00F3n", "Producto vendido", "Fecha de Venta"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(122);
		table.getColumnModel().getColumn(1).setPreferredWidth(97);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		table.setRowHeight(50);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		if(sTable.getSize()>0) {
			for(Integer key:keys) {
				sale=sTable.getSale(key);
				model.addRow(new Object[] {sale.getTransActionCode(),sale.getProduct().getName(),sale.getDateSold()});
			}
		}
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Lista de Ventas");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 48));
		lblNewLabel.setBounds(10, 11, 490, 121);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnReturn = new JButton("Regresar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnReturn.setFont(new Font("Arial", Font.PLAIN, 48));
		btnReturn.setBounds(936, 1072, 522, 160);
		frame.getContentPane().add(btnReturn);
	}
}
