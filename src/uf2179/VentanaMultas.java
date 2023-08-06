package uf2179;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textNombre;
	private JTextField textApellidos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBox;
	private JLabel lblCantidad;
	private JRadioButton rdbtnNormal;
	private JRadioButton rdbtnPronto;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		// TODO Layout no absoluto utilizado 0.5/0.5
		contentPane.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(null);
		contentPane.add(panel, "cell 0 0 4 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblNewLabel = new JLabel("DGT - Infracciones");
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel, "cell 0 0");
		
		JLabel lblMatricula = new JLabel("Matrícula:");
		contentPane.add(lblMatricula, "cell 0 1,alignx trailing");
		
		// TODO CAjas de texto y etiquetas corretamente definidas 0.5/0.5
		textMatricula = new JTextField();
		contentPane.add(textMatricula, "cell 1 1,growx");
		textMatricula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 2 1,alignx trailing");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 3 1,growx");
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		contentPane.add(lblApellidos, "cell 0 2,alignx trailing");
		
		textApellidos = new JTextField();
		contentPane.add(textApellidos, "cell 1 2 3 1,growx");
		textApellidos.setColumns(10);
		
		JLabel lblSancion = new JLabel("Sanción:");
		contentPane.add(lblSancion, "cell 0 3,alignx trailing");
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSancion();
			}
		});
		// TODO JComboBox añadido correctamente con modelo y expuesto 0.5/0.5 
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No llevar Casco", "Conducción temeraria"}));
		contentPane.add(comboBox, "cell 1 3 3 1,growx");
		
		JLabel lblImporte = new JLabel("Importe:");
		contentPane.add(lblImporte, "cell 0 4,alignx right");
		
		lblCantidad = new JLabel("200");
		contentPane.add(lblCantidad, "cell 1 4");
		
		// TODO Botones radio definidos, expuestos, metidos en grupo y con opción por defecto 0.5/0.5
		rdbtnNormal = new JRadioButton("Pago Normal");
		rdbtnNormal.setSelected(true);
		buttonGroup.add(rdbtnNormal);
		rdbtnNormal.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(rdbtnNormal, "cell 1 5");
		
		rdbtnPronto = new JRadioButton("Pronto Pago");
		buttonGroup.add(rdbtnPronto);
		rdbtnPronto.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(rdbtnPronto, "cell 2 5");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerDatos();
			}
		});
		contentPane.add(btnAceptar, "cell 0 6 4 1,alignx center");
		
		// TODO Resto de componentes añadidos con valor por defecto para la etiqueta de importe
		// ya que está seleccionado por defecto No llevar casco 0.5/0.5

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 7 4 1,grow");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
	}

	// TODO Correcto. Datos recogidos correctamente y con validación de campos rellenos, eso sí deberías 
	// también comprobar la nulidad, no quedarte sólo en el isBlank 1.5/1.5
	protected void recogerDatos() {
		String matricula=textMatricula.getText();
		String nombre=textNombre.getText();
		String apellidos=textApellidos.getText();
		if (matricula.isBlank() || nombre.isBlank() || apellidos.isBlank())
			JOptionPane.showMessageDialog(contentPane, "Debes rellenar todas las casillas","Casillas en blanco",JOptionPane.ERROR_MESSAGE);
		String infraccion=(String) comboBox.getSelectedItem();
		// TODO Bien parseando la cantidad
		int importe=Integer.parseInt(lblCantidad.getText());
		String pagoString=rdbtnNormal.isSelected()?rdbtnNormal.getText():rdbtnPronto.getText();
		
		// TODO Bien construyendo el mensaje
		textPane.setText(
				"Conductor: "+nombre+" "+apellidos+
				"\nInfracción: "+infraccion+
				"\nImporte: "+importe);
		if (rdbtnPronto.isSelected())
			textPane.setText(textPane.getText()+
				"\nPronto pago: "+importe/2f);
	}

	// TODO método correcto, pero ten encuenta que LAS COMPARACIONES CON String 
	// SE HACEN SIEMPRE CON equals!!!!!, me duele la boca de decirlo ...
	// 0.8/1.0
	protected void cambiarSancion() {
		if (comboBox.getSelectedItem()=="No llevar Casco") lblCantidad.setText("200");
		else lblCantidad.setText("500");		
	}

}
