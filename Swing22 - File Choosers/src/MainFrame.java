import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame{
	
	
	private JButton btn;
	private Toolbar toolbar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	
	
	public MainFrame(){
		super("Hello World");
		
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		fileChooser = new JFileChooser();
		
		setJMenuBar(createMenuBar());
		
		toolbar.setStringListener(new StringListener(){
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}			
		});
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e){
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmploymentCategory();
				
				textPanel.appendText(name + ": "+ occupation + ": " +  ageCat + ": " + empCat + "\n");
				
				System.out.println(e.getGender());
			}
		});
		
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);
		add(formPanel, BorderLayout.WEST);
		
		setMinimumSize(new Dimension(500,400));
		setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem )ev.getSource();
				formPanel.setVisible(menuItem.isSelected());
			}			
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
			}			
		});
		
		exportDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
					System.out.println(fileChooser.getSelectedFile());
				}
			}			
		});
		
		exitItem.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e) {
				
				String text = JOptionPane.showInputDialog(MainFrame.this,
						"Enter your user name.",
						"Enter User Name", JOptionPane.OK_OPTION|JOptionPane.QUESTION_MESSAGE);
				
				System.out.println(text);
				
				int action = JOptionPane.showConfirmDialog(MainFrame.this,"Do you really want to exit the application?","Confirm Exit",JOptionPane.OK_CANCEL_OPTION);				
				if(action == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}			
		});
		return menuBar;
		
	}
}
