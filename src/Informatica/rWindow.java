package Informatica;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable; 
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class rWindow {

	private JFrame frame;
	private JTable table;
	private ReservationTable rTable;
	private Reservation reservation;
	private Set<Integer> keys;
	private Hashtable <Integer, Product> pble;
	private ProductTable pTable;
	private Hashtable <Integer, Reservation> rble;
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
	public rWindow() throws IOException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		pTable = new ProductTable();
		pTable.load();
		rTable = new ReservationTable();
		rTable.load(pTable);
		keys = rTable.getKeys();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.getContentPane().setLayout(null);
		
		JButton agregarRes = new JButton("Agregar Reservaci\u00F3n");
		agregarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rAddWindow window = null;
				try {
					window = new rAddWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.newScreen();
				frame.dispose();
			}
		});
		agregarRes.setFont(new Font("Arial", Font.PLAIN, 48));
		agregarRes.setBounds(10, 885, 572, 147);
		frame.getContentPane().add(agregarRes);
		
		JButton CancelarRes = new JButton("Cancelar Reservaci\u00F3n");
		CancelarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rCancelWindow cWindow = null;
				
				try {
					cWindow = new rCancelWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cWindow.newScreen();
				frame.dispose();
			}
		});
		CancelarRes.setFont(new Font("Arial", Font.PLAIN, 48));
		CancelarRes.setBounds(670, 885, 572, 147);
		frame.getContentPane().add(CancelarRes);
		
		JButton Regresar = new JButton("Regresar");
		Regresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		Regresar.setFont(new Font("Arial", Font.PLAIN, 48));
		Regresar.setBounds(1324, 885, 572, 147);
		frame.getContentPane().add(Regresar);
		
		createTable();
		
		JLabel lblNewLabel = new JLabel("Reservaciones");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		lblNewLabel.setBounds(1534, 11, 362, 88);
		frame.getContentPane().add(lblNewLabel);
		
	}
	
	public void createTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 1886, 732);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(50);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
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
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(rTable.getSize() > 0) {
			for(Integer key:keys) {
				reservation = rTable.getReservation(key);
				if(reservation.getCondition()) {
				model.addRow(new Object[] {reservation.getReservationCode(), reservation.getClientName(), reservation.getReservationDate(), reservation.getWantedProduct().getName(), "Activo" });
					} else {
						model.addRow(new Object[] {reservation.getReservationCode(), reservation.getClientName(), reservation.getReservationDate(), reservation.getWantedProduct().getName(), "Cancelado" });
					}
				
			}
		}
		
		table.setRowHeight(50);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		scrollPane.setViewportView(table);
	}
}
