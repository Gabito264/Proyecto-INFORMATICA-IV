package Informatica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.Date;
public class rAddWindow {

	private JFrame frame;
	private JTextField BCode;
	private ProductTable pTable;
	private ReservationTable rTable;
	private Reservation reservation;
	private Product product;
	private JTextField BNombre;
	private JTextField CName;
	private JTextField NoticeBoard;
	private Date today;
	private Date releaseDate;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rAddWindow window = new rAddWindow();
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
	public rAddWindow() throws IOException{
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
		today = new Date();
		releaseDate = new Date();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1027, 1220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Reservaci\u00F3n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel.setBounds(10, 11, 429, 95);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar Producto (C\u00F3digo)");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 170, 358, 95);
		frame.getContentPane().add(lblNewLabel_1);
		
		BCode = new JTextField();
		BCode.setFont(new Font("Arial", Font.PLAIN, 30));
		BCode.setBounds(378, 170, 429, 95);
		frame.getContentPane().add(BCode);
		BCode.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product = pTable.getProduct(Integer.parseInt(BCode.getText()));
				if(product != null) {
					
				BNombre.setText(product.getName());
				} else {
					NoticeBoard.setText("El producto no existe!");
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnBuscar.setBounds(817, 170, 186, 95);
		frame.getContentPane().add(btnBuscar);
		
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
		btnReturn.setBounds(592, 998, 411, 174);
		frame.getContentPane().add(btnReturn);
		
		JButton btnAdd = new JButton("Realizar Reservaci\u00F3n");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				product = pTable.getProduct(Integer.parseInt(BCode.getText()));
				
				if(product != null) {
					String relDate = product.getReleaseDate();
					releaseDate.setDate(Integer.parseInt(relDate.substring(3,5)));
					releaseDate.setMonth(Integer.parseInt(relDate.substring(0,2))-1);
					releaseDate.setYear(Integer.parseInt(relDate.substring(6,10))-1900);
				if(releaseDate.compareTo(today) > 0) {
				
					reservation = new Reservation();
					reservation.setClientName(CName.getText());
					reservation.setWantedProduct(product);
					product.addReservations();
					reservation.setCode(rTable.getSize());
					rTable.add(reservation);
					try {
						pTable.save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						rTable.save();
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
						NoticeBoard.setText("Este producto no se puede reservar!");
					}
					rWindow window = null;
					try {
						window = new rWindow();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					NoticeBoard.setText("El producto no Existe!");
				}
			}
		});
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 40));
		btnAdd.setBounds(10, 998, 411, 174);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Producto");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(10, 276, 358, 83);
		frame.getContentPane().add(lblNewLabel_2);
		
		BNombre = new JTextField();
		BNombre.setFont(new Font("Arial", Font.PLAIN, 30));
		BNombre.setBounds(378, 276, 429, 83);
		frame.getContentPane().add(BNombre);
		BNombre.setColumns(10);
		
		CName = new JTextField();
		CName.setFont(new Font("Arial", Font.PLAIN, 30));
		CName.setBounds(378, 493, 429, 95);
		frame.getContentPane().add(CName);
		CName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre Cliente");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(10, 493, 358, 95);
		frame.getContentPane().add(lblNewLabel_4);
		
		NoticeBoard = new JTextField();
		NoticeBoard.setFont(new Font("Arial", Font.PLAIN, 30));
		NoticeBoard.setBounds(10, 632, 993, 95);
		frame.getContentPane().add(NoticeBoard);
		NoticeBoard.setColumns(10);
	}

}
