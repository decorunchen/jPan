package sysu.java.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.*;
import java.net.*;

public class ClientUI {
  private int command;
	private String fname = "";
	private Socket socket = null;
	private JComboBox<String> box;
	private ImageIcon icon;
	private JPanel panel = new JPanel();
	private JPanel spanel = new JPanel();
	
	public byte[] intToByte4(int num) {
		byte[] b = new byte[4];
		b[0] = (byte)(num & 0xff);
		b[1] = (byte)((num >> 8) & 0xff);
		b[2] = (byte)((num >> 16) & 0xff);
		b[3] = (byte)((num >> 24) & 0xff);
		return b;
	}
	
	public client(String title) throws UnknownHostException, IOException {
		
		setTitle(title);
		init();
	}
	
	public void init() throws UnknownHostException, IOException {
		try {        
   		 	for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {    
   		 		if ("Nimbus".equals(info.getName())) {            
   		 			javax.swing.UIManager.setLookAndFeel(info.getClassName());     
   		 			break;        
   		 		}      
   		 	}     
   	 	}catch(Exception e) {      
   	 		System.out.println(e);       
   	 	}
		
		JPopupMenu pmenu = new JPopupMenu();
		JMenuItem create, upload;
		upload = new JMenuItem("UpLoad");
		upload.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		
		create = new JMenuItem("NewFolder");
		create.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		pmenu.add(upload);
		pmenu.add(create);
		
		upload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES ); 
		        chooser.showDialog(new JLabel(), "ѡ��");
			}
			
		});
		
	
		icon = new ImageIcon(getClass().getResource("../icon/1.png"));
		this.setIconImage(icon.getImage());
		
		//panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		spanel = new JPanel();
		JLabel disc = new JLabel("�ҵ�����");
		disc.setBackground(Color.DARK_GRAY);
		disc.setFont(new Font(Font.DIALOG, Font.BOLD, 22));
		disc.setBounds(20, 30, 200, 20);
		panel.add(disc, BorderLayout.CENTER);
		
		panel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON3) {
					pmenu.setVisible(true);
					pmenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(panel);
	}
	
	public void createFile(String name) {
		JLabel label = new JLabel(name);
		JPopupMenu menu = new JPopupMenu();
		JMenuItem download, delete;
		download = new JMenuItem("DownLoad");
		delete = new JMenuItem("Delete");
		menu.add(download);
		menu.add(delete);
		
		download.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES ); 
		        chooser.showDialog(new JLabel(), "ѡ��");
				File in = chooser.getSelectedFile();
				if(in.isDirectory()) {
					
				} else {
					
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		label.addMouseListener(new MouseListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getButton() == MouseEvent.BUTTON1) {
					label.setOpaque(false);
				}
				
				if(e.getButton() == MouseEvent.BUTTON3) {
					menu.setVisible(true);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				label.setOpaque(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void sendMessage(Socket socket, String m) throws IOException {
		PrintWriter w = null;
		
	}
	
	public void receiveMessage(Socket socketm, String m) {
		
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		JFrame _c = new client("Net Disc");
		_c.setSize(1300, 900);
		_c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_c.setLocationRelativeTo(null);
		_c.setVisible(true);
		_c.setBackground(Color.BLACK);
	}
}
