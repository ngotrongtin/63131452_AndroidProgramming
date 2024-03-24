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
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManHinhDonVi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Length_Input;
	private JTextField Length_Output;
	private JTextField Temp_Input;
	private JTextField Temp_Output;
	private JComboBox lengthInput_type;
	private JComboBox tempInput_type;
	private JComboBox lengthOutput_type;
	private JComboBox tempOutput_type;
	/**
	 * Create the frame.
	 */
	public ManHinhDonVi() {
		String[] LengthData = {"mm","m","km"};
		String[] TempData = {"F","C"};
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManHinhDonVi.class.getResource("/pack/doi-don-vi.png")));
		setTitle("App Đổi Đơn Vị");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chuyển đổi đơn vị đo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(195, 30, 226, 47);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnLegth = new JButton("Đổi");
		btnLegth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertLength();
			}
		});
		btnLegth.setBounds(261, 92, 89, 23);
		contentPane.add(btnLegth);
		
		Length_Input = new JTextField();
		Length_Input.setBounds(33, 95, 86, 20);
		contentPane.add(Length_Input);
		Length_Input.setColumns(10);
		
		Length_Output = new JTextField();
		Length_Output.setEditable(false);
		Length_Output.setColumns(10);
		Length_Output.setBounds(407, 95, 86, 20);
		contentPane.add(Length_Output);
		
		lengthInput_type = new JComboBox(LengthData);
		lengthInput_type.setBounds(129, 92, 67, 22);
		contentPane.add(lengthInput_type);
		
		lengthOutput_type = new JComboBox(LengthData);
		lengthOutput_type.setBounds(503, 92, 67, 22);
		contentPane.add(lengthOutput_type);
		
		JLabel lblNewLabel_1 = new JLabel("Chuyển đổi nhiệt độ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(195, 212, 226, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnTemp = new JButton("Đổi");
		btnTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertTemp();
			}
		});
		btnTemp.setBounds(261, 284, 89, 23);
		contentPane.add(btnTemp);
		
		Temp_Input = new JTextField();
		Temp_Input.setColumns(10);
		Temp_Input.setBounds(33, 285, 86, 20);
		contentPane.add(Temp_Input);
		
		tempInput_type = new JComboBox(new Object[]{});
		tempInput_type.setModel(new DefaultComboBoxModel(TempData));
		tempInput_type.setBounds(129, 284, 45, 22);
		contentPane.add(tempInput_type);
		
		Temp_Output = new JTextField();
		Temp_Output.setEditable(false);
		Temp_Output.setColumns(10);
		Temp_Output.setBounds(407, 285, 86, 20);
		contentPane.add(Temp_Output);
		
		tempOutput_type = new JComboBox(new Object[]{});
		tempOutput_type.setModel(new DefaultComboBoxModel(TempData));
		tempOutput_type.setBounds(503, 284, 45, 22);
		contentPane.add(tempOutput_type);
	}
	
	private int gapValue(int nums_of_zero) {
		int temp = 1;
		for(int i=1;i<=nums_of_zero;i++) {
			temp *= 10;
		}
		return temp;
	}
	
	private int getIndex(String t) {
		int index = -1;
		if(t.equals("km"))
			index = 2;
		else if(t.equals("m"))
			index = 1;
		else if(t.equals("mm"))
			index = 0;
		
		return index;
	}
	
	private void convertLength() {
		int[] gap = {0,3,6};
		int inputValue = Integer.parseInt(Length_Input.getText());
		double outputValue;
		String formatted;
		int lengthInputType_str = getIndex(lengthInput_type.getSelectedItem().toString());
		int lengthOnputType_str = getIndex(lengthOutput_type.getSelectedItem().toString());
		if(lengthInputType_str >= lengthOnputType_str) {
			outputValue = inputValue * gapValue(gap[lengthInputType_str - lengthOnputType_str]);
			formatted = String.format("%.1f", outputValue);
		}else {
			outputValue = inputValue * (1.0/gapValue(gap[lengthOnputType_str - lengthInputType_str]));
			formatted = String.format("%.7f", outputValue);
		}
		
		Length_Output.setText(formatted);
	}
	
	private void convertTemp() {
		int inputValue = Integer.parseInt(Temp_Input.getText());
		double outputValue;
		String formatted;
		String tempInputType_str = tempInput_type.getSelectedItem().toString();
		String tempOutputType_str = tempOutput_type.getSelectedItem().toString();
		
		if(tempInputType_str.equals(tempOutputType_str)) {
			outputValue = inputValue;
		}else if(tempInputType_str.equals("C") && tempOutputType_str.equals("F")){
			outputValue = (9.0/5)*inputValue + 32;
		}else {
			outputValue = (inputValue - 32) * (5.0/9);
		}
		formatted = String.format("%.5f", outputValue);
		Temp_Output.setText(formatted);
	}
}
