package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Infractor;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class VentanaMostrarInfractores extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private Controlador controlador;


	/**
	 * Create the frame.
	 */
	public VentanaMostrarInfractores() {
		setBounds(100, 100, 491, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[40px,grow,fill][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("    DGT - Infracciones");
		lblNewLabel_4.setPreferredSize(new Dimension(97, 30));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setOpaque(true);
		contentPane.add(lblNewLabel_4, "cell 0 0,growx");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Lista de infractores:");
		panel.add(lblNewLabel_3, "cell 0 0,alignx left");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Antig\u00FCedad", "Sanci\u00F3n", "Puntos"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, Float.class, Integer.class
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
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 2,grow");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;		
	}


	public void setListaInfractores(ArrayList<Infractor> listaInfractores) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		
		for (Infractor infractor : listaInfractores) {
			
			Object fila[]= {
					infractor.getDni(),
					infractor.getNombre(),
					infractor.getApellidos(),
					infractor.getAntiguedad(),
					infractor.getSancion(),
					infractor.getPuntos()
			};
			modelo.addRow(fila);
		}
		
	}
}
