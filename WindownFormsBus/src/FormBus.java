import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormBus {

	private JFrame frame;
	private PanelBus panel;
	private JButton buttonUp;
	private JButton buttonDown;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonCreate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormBus window = new FormBus();
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
	public FormBus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new PanelBus();
		panel.setBounds(0, 0, 883, 453);
		frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    buttonCreate = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
	    buttonCreate.setBounds(12, 5, 88, 31);
	    panel.add(buttonCreate);
	    buttonCreate.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		Random rnd = new Random();
	    		PanelBus.bus = new Bus(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000, Color.GREEN, Color.YELLOW,true, true);
	    		PanelBus.initialization = true;
	    		PanelBus.bus.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10, panel.getWidth(), panel.getHeight());
	    		RedrawUI();
	    		
	    	}
	    });
		
	    buttonLeft = new JButton("\u2190");
	    buttonLeft.setBounds(725, 416, 50, 37);
	    panel.add(buttonLeft);
	    buttonLeft.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (PanelBus.initialization) {
	    			PanelBus.bus.MoveTransport(Direction.Left);
	    		}
	    		RedrawUI();
	    	}
	    });
		
		buttonRight = new JButton("\u2192");
		buttonRight.setBounds(833, 416, 50, 37);
		panel.add(buttonRight);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelBus.initialization) {
					PanelBus.bus.MoveTransport(Direction.Right);
				}
				RedrawUI();
			}
		});
		
		buttonDown = new JButton("\u2193");
		buttonDown.setBounds(782, 410, 45, 43);
		panel.add(buttonDown);
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelBus.initialization) {
					PanelBus.bus.MoveTransport(Direction.Down);
				}
				RedrawUI();
			}
		});
		
		buttonUp = new JButton("\u2191");
		buttonUp.setBounds(782, 367, 45, 43);
		panel.add(buttonUp);
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PanelBus.initialization) {
					PanelBus.bus.MoveTransport(Direction.Up);
				}
				RedrawUI();
			}
		});
		frame.getContentPane().setLayout(null);
	}
	private void RedrawUI() {
		panel.updateUI();	
	}
}
