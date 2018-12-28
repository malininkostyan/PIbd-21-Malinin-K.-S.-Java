import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormParking {

	private JFrame frame;
	private JTextField maskedTextBox1;
    Parking<ITransport> parking;
    private PanelBus pictureBoxTakeBus;
    private PanelParking panelParking;
    private JButton buttonSetBus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormParking window = new FormParking();
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
	public FormParking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		panelParking= 	new PanelParking();

		panelParking.setBounds(0, 0, 775, 456);

		frame.getContentPane().add(panelParking);
		parking = panelParking.getParking();
		JPanel pictureBoxParking = new JPanel();
		pictureBoxParking.setBounds(0, 0, 778, 466);
		frame.getContentPane().add(pictureBoxParking);
		JButton buttonSetStandartBus = new JButton("Припарковать автобус");

		buttonSetStandartBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				StandartBus bus = new StandartBus(100, 1000, mainColor);
				int place = parking.Plus(bus);
				PanelBus.initialization = true;
				panelParking.repaint();
			}
		});
		buttonSetStandartBus.setBounds(790, 13, 176, 78);
		frame.getContentPane().add(buttonSetStandartBus);
		
		buttonSetBus = new JButton("Припарковать автобус с гармошкой");
		buttonSetBus.setToolTipText("");
		buttonSetBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Color dopColor = JColorChooser.showDialog(null, "Choose a color", Color.GRAY);
				Bus bus = new Bus(100, 1000, mainColor, dopColor, true, true);
                int place = parking.Plus(bus);
				PanelBus.initialization = true;     
				panelParking.repaint();
			}
		});
		buttonSetBus.setBounds(790, 106, 176, 78);
		frame.getContentPane().add(buttonSetBus);

		JPanel panel = new JPanel();
		panel.setBounds(779, 226, 187, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		pictureBoxTakeBus = new PanelBus();
		pictureBoxTakeBus.setBounds(12, 102, 163, 115);
		panel.add(pictureBoxTakeBus);

		JLabel label = new JLabel("Забрать автобус");
		label.setBounds(12, 0, 118, 16);
		panel.add(label);

		maskedTextBox1 = new JTextField();
		maskedTextBox1.setBounds(68, 29, 70, 22);
		panel.add(maskedTextBox1);
		maskedTextBox1.setColumns(10);

		JLabel label_1 = new JLabel("Место:");
		label_1.setBounds(12, 32, 56, 16);
		panel.add(label_1);

		JButton buttonTakeBus = new JButton("Забрать");
		buttonTakeBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!maskedTextBox1.getText().equals("")) {
					ITransport bus = parking.Minus(Integer.parseInt(maskedTextBox1.getText()));
					if (bus != null) {
						bus.SetPosition(5, 5, pictureBoxTakeBus.getWidth(), pictureBoxTakeBus.getHeight());
						pictureBoxTakeBus.setBus(bus);
						pictureBoxTakeBus.repaint();
						panelParking.repaint();
					} else {
						pictureBoxTakeBus.setBus(null);
						pictureBoxTakeBus.repaint();
					}
				}
			}
		});
		buttonTakeBus.setBounds(22, 64, 97, 25);
		panel.add(buttonTakeBus);
	}
}