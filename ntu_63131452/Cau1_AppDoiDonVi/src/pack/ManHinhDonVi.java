package pack;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ManHinhDonVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public ManHinhDonVi() {
		String[] data = {"km","m","mm"};
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhDonVi.class.getResource("/pack/doi-don-vi.png")));
		setTitle("App Đổi Đơn Vị");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chuyển đổi nhiệt độ");
		lblNewLabel.setBounds(251, 38, 115, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Đổi");
		btnNewButton.setBounds(261, 92, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(33, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(407, 95, 86, 20);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox(data);
		comboBox.setBounds(129, 92, 45, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(data);
		comboBox_1.setBounds(503, 92, 45, 22);
		contentPane.add(comboBox_1);
	}
}
