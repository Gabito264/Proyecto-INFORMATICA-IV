package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class rCancelWindow {

	private JFrame frame;
	private JTextField BName;
	private JTextField BProductName;
	private JTextField BReservationDate;
	private JTextField BCode;
	private ProductTable pTable;
	private ReservationTable rTable;
	private JTextField NoticeBoard;
	private Reservation reservation;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rCancelWindow window = new rCancelWindow();
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
	public rCancelWindow() throws IOException{
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
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1112, 1274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cancelar Producto");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 11, 369, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnReturn = new JButton("Regresar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rWindow window = null;
				
				try {
					window = new rWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				window.newScreen();
				
				frame.dispose();
			}
		});
		btnReturn.setFont(new Font("Arial", Font.PLAIN, 40));
		btnReturn.setBounds(594, 982, 494, 244);
		frame.getContentPane().add(btnReturn);
		
		JButton btnCancel = new JButton("Cancelar Reservaci\u00F3n");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation = rTable.getReservation(Integer.parseInt(BCode.getText()));
				if(reservation != null) {
				if(reservation.getCondition()) {
					reservation.cancel();
					reservation.getWantedProduct().minusReservations();
					
					try {
						rTable.save();
						pTable.save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					rWindow window = null;
					try {
						window = new rWindow();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					window.newScreen();
					frame.dispose();
				} else {
					NoticeBoard.setText("¡El código es inválido, ya está cancelada esta reservación!");
				}
				} else {
					NoticeBoard.setText("La reservación no existe!");
				}
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 40));
		btnCancel.setBounds(10, 982, 494, 244);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo Reservaci\u00F3n:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 88, 287, 66);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente:");
		lblNombreCliente.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNombreCliente.setBounds(10, 295, 287, 66);
		frame.getContentPane().add(lblNombreCliente);
		
		JLabel lblProductoReservado = new JLabel("Producto Reservado:");
		lblProductoReservado.setFont(new Font("Arial", Font.PLAIN, 30));
		lblProductoReservado.setBounds(10, 447, 287, 66);
		frame.getContentPane().add(lblProductoReservado);
		
		JLabel lblFecha = new JLabel("Fecha Reservaci\u00F3n");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFecha.setBounds(10, 601, 287, 66);
		frame.getContentPane().add(lblFecha);
		
		BName = new JTextField();
		BName.setFont(new Font("Arial", Font.PLAIN, 30));
		BName.setBounds(303, 295, 369, 66);
		frame.getContentPane().add(BName);
		BName.setColumns(10);
		
		BProductName = new JTextField();
		BProductName.setFont(new Font("Arial", Font.PLAIN, 30));
		BProductName.setColumns(10);
		BProductName.setBounds(303, 447, 369, 66);
		frame.getContentPane().add(BProductName);
		
		BReservationDate = new JTextField();
		BReservationDate.setFont(new Font("Arial", Font.PLAIN, 30));
		BReservationDate.setColumns(10);
		BReservationDate.setBounds(303, 601, 369, 66);
		frame.getContentPane().add(BReservationDate);
		
		BCode = new JTextField();
		BCode.setFont(new Font("Arial", Font.PLAIN, 30));
		BCode.setColumns(10);
		BCode.setBounds(303, 88, 369, 66);
		frame.getContentPane().add(BCode);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservation = rTable.getReservation(Integer.parseInt(BCode.getText()));
				if(reservation != null) {
				if(reservation.getCondition()) {
					BName.setText(reservation.getClientName());
					BProductName.setText(reservation.getWantedProduct().getName());
					BReservationDate.setText(reservation.getReservationDate());
					NoticeBoard.setText("");
				} else {
					NoticeBoard.setText("¡El código es inválido, ya está cancelada esta reservación!");
				}
				} else {
					NoticeBoard.setText("La reservación no existe!");
				}
			}
		});
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 30));
		btnSearch.setBounds(713, 88, 287, 66);
		frame.getContentPane().add(btnSearch);
		
		NoticeBoard = new JTextField();
		NoticeBoard.setFont(new Font("Arial", Font.PLAIN, 30));
		NoticeBoard.setBounds(10, 702, 1078, 97);
		frame.getContentPane().add(NoticeBoard);
		NoticeBoard.setColumns(10);
	}
}
