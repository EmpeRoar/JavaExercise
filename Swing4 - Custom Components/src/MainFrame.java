import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private JTextArea textArea;
	private JButton btn;
	
	private TextPanel textPanel;
	
	public MainFrame(){
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		btn = new JButton("Click Me!");
		
		add(textPanel, BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				textPanel.appendText("Hello \n");
			}		
		});
		
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
