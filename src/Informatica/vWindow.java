package Informatica;

import java.awt.EventQueue;

import java.util.Hashtable;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class vWindow {

	private JFrame frame;
	private JTable table;
	private JTextField BCODE;
	private JTextField EliminateCode;
	private ProductTable pTable;
	private VariableSaleTable vSTable;
	private SaleTable sTable;
	private Set<Integer> keys;
	private Hashtable<Integer, Product> variableTable;
	private Product wantedProduct;
	private JTextField sumPrice;
	private JTextField noticeBoard;
	private Sale saleProduct;
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vWindow window = new vWindow();
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
	public vWindow() throws IOException {
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
		
		vSTable = new VariableSaleTable();
		variableTable = vSTable.getTable();
		keys = vSTable.getKeys();
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.getContentPane().setLayout(null);
		
		
		createTable();
		
		JLabel lblNewLabel = new JLabel("Carrito de Compras");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 48));
		lblNewLabel.setBounds(10, 11, 567, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar Producto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(1356, 122, 540, 79);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnReturn = new JButton("Regresar");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnReturn.setFont(new Font("Arial", Font.PLAIN, 48));
		btnReturn.setBounds(1356, 907, 540, 125);
		frame.getContentPane().add(btnReturn);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo Producto");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(1356, 212, 240, 79);
		frame.getContentPane().add(lblNewLabel_2);
		
		BCODE = new JTextField();
		BCODE.setFont(new Font("Arial", Font.PLAIN, 30));
		BCODE.setBounds(1606, 212, 290, 79);
		frame.getContentPane().add(BCODE);
		BCODE.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wantedProduct = pTable.getProduct(Integer.parseInt(BCODE.getText()));
				if(wantedProduct != null) {
					if(wantedProduct.getAmmount()>0) {
					vSTable.add(wantedProduct);
				createTable();
				noticeBoard.setText("");
					}else {
						noticeBoard.setText("Este producto no está en existencias o disponible!");
					}
				} else {
					noticeBoard.setText("Código Inválido! Producto no existe");
				}
				BCODE.setText("");
				setTotal();
			}
		});
		btnAgregar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnAgregar.setBounds(1606, 302, 290, 79);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnClearTable = new JButton("Borrar todo");
		btnClearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(variableTable.size()>0) {
					variableTable.clear();
					createTable();
				}
			}
		});
		btnClearTable.setFont(new Font("Arial", Font.PLAIN, 40));
		btnClearTable.setBounds(10, 907, 429, 125);
		frame.getContentPane().add(btnClearTable);
		
		JLabel lblNewLabel_3 = new JLabel("Eliminar Producto de Tabla");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 44));
		lblNewLabel_3.setBounds(1356, 402, 540, 79);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel label = new JLabel("C\u00F3digo Producto");
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(1356, 492, 240, 79);
		frame.getContentPane().add(label);
		
		EliminateCode = new JTextField();
		EliminateCode.setFont(new Font("Arial", Font.PLAIN, 30));
		EliminateCode.setColumns(10);
		EliminateCode.setBounds(1606, 492, 290, 79);
		frame.getContentPane().add(EliminateCode);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(vSTable.getProduct(Integer.parseInt(EliminateCode.getText()))!=null){
				
				vSTable.remove(Integer.parseInt(EliminateCode.getText()));
				createTable();
				noticeBoard.setText("");
				} else {
					noticeBoard.setText("Código Inválido! No existe el Producto en el carrito!");
				}
				EliminateCode.setText("");
				setTotal();
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 30));
		btnEliminar.setBounds(1606, 582, 290, 79);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnVender = new JButton("Realizar Venta");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keys = vSTable.getKeys();
				for(Integer key:keys) {
					wantedProduct = vSTable.getProduct(key);
						
					wantedProduct.downAmmount();
					saleProduct = new Sale();
					saleProduct.setSoldProduct(wantedProduct);
					saleProduct.setTransActionCode(sTable.getSize());
					sTable.add(saleProduct);	
					
				}		
				
				try {
					sTable.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					pTable.save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				variableTable.clear();
				sumPrice.setText("");
				createTable();
			}
		});
		btnVender.setFont(new Font("Arial", Font.PLAIN, 48));
		btnVender.setBounds(488, 907, 429, 125);
		frame.getContentPane().add(btnVender);
		
		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 48));
		lblNewLabel_4.setBounds(488, 18, 240, 79);
		frame.getContentPane().add(lblNewLabel_4);
		
		sumPrice = new JTextField();
		sumPrice.setFont(new Font("Arial", Font.PLAIN, 30));
		sumPrice.setColumns(10);
		sumPrice.setBounds(659, 11, 354, 93);
		frame.getContentPane().add(sumPrice);
		
		noticeBoard = new JTextField();
		noticeBoard.setFont(new Font("Arial", Font.PLAIN, 20));
		noticeBoard.setBounds(1356, 675, 540, 79);
		frame.getContentPane().add(noticeBoard);
		noticeBoard.setColumns(10);
		
	}
	public void createTable() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 1336, 712);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Producto", "Nombre del Producto", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(91);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		table.setRowHeight(50);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 30));
		table.setFont(new Font("Arial", Font.PLAIN, 33));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		if(variableTable.size()>0) {
			for(Integer key:keys) {
				wantedProduct = vSTable.getProduct(key);
				model.addRow(new Object[] {wantedProduct.getCode(),wantedProduct.getName(),wantedProduct.getPrice()});
			}
		}
		scrollPane.setViewportView(table);
	}
	
	public void setTotal() {
		double total = 0;
		for(Integer key:keys) {
			wantedProduct = vSTable.getProduct(key);
			total+=wantedProduct.getPrice();
		}
		sumPrice.setText(Double.toString(total));
	}
}
