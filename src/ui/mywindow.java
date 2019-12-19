package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import parser.MyNewGrammar;
import parser.ParseException;
import parser.SimpleNode;
import parser.Token;
import util.QTInfo;
import util.node;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class mywindow extends JFrame {

	private JPanel contentPane;
	MyNewGrammar parser=null;
	FileInputStream fileinputStream =null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mywindow frame = new mywindow();
					frame.setName("编译器");
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public mywindow() throws FileNotFoundException {
		setTitle("\u7F16\u8BD1\u5668");
		setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("选择文件");
		btnNewButton.setBounds(14, 142, 93, 27);
		
		JButton btnNewButton_1 = new JButton("词法分析");
		btnNewButton_1.setBounds(14, 252, 93, 27);
		
		
		JButton btnNewButton_2 = new JButton("语法分析");
		btnNewButton_2.setBounds(14, 324, 93, 27);
		
		
		JButton btnNewButton_3 = new JButton("语义分析");
		btnNewButton_3.setBounds(14, 395, 93, 27);
		 Font x = new Font("宋体",0,20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 224, 420, 495);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(564, 223, 382, 496);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(19, 726, 2, 232);
		
		JLabel lblNewLabel = new JLabel("\u9519\u8BEF\u4FE1\u606F");
		lblNewLabel.setBounds(267, 24, 77, 18);
		
		JLabel lblNewLabel_1 = new JLabel("\u7B26\u53F7\u8868");
		lblNewLabel_1.setBounds(731, 30, 61, 18);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F93\u5165\u6587\u4EF6\u4FE1\u606F");
		lblNewLabel_2.setBounds(267, 193, 90, 18);
		
		JLabel lblNewLabel_3 = new JLabel("\u8F93\u51FA\u6587\u4EF6\u4FE1\u606F");
		lblNewLabel_3.setBounds(702, 193, 90, 18);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_3);
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		contentPane.add(scrollPane);
		
		
		JTextArea text= new JTextArea();
		scrollPane.setViewportView(text);
		text.setFont(x);
		contentPane.add(scrollPane_1);
		JTextArea text2= new JTextArea();
		scrollPane_1.setViewportView(text2);
		text2.setFont(x);
		contentPane.add(scrollPane_2);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(564, 56, 382, 125);
		contentPane.add(scrollPane_4);
		
		JTextArea text4 = new JTextArea();
		scrollPane_4.setViewportView(text4);
		text4.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(132, 55, 414, 125);
		contentPane.add(scrollPane_3);
		JTextArea text3= new JTextArea();
		scrollPane_3.setViewportView(text3);
		text3.setFont(x);
		text3.setForeground(Color.RED);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(24, 182, 216, 34);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				Frame frame =new Frame("打开文件");
				FileDialog fopen =new FileDialog(frame,"打开文件",FileDialog.LOAD);
				fopen.setVisible(true);
				String filepath = fopen.getDirectory()+fopen.getFile();
				System.out.print(filepath);
				lblNewLabel_4.setText(fopen.getFile());
				 BufferedReader in = null;
			
					InputStreamReader isr = null;
				
					try {
						isr = new InputStreamReader(new FileInputStream(filepath), "UTF-8");
						in = new BufferedReader(isr);
				        String str = null;
				       
							while((str = in.readLine()) != null) 
							{  	   
								   text.append(str+"\n");
								
							}		           
							
							in.close();	
					
					} catch (UnsupportedEncodingException | FileNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						text2.setText("");
						text3.setText("");
						text4.setText("");
						String str = text.getText();
						File f = new File("my.txt");
						 
				        if(!f.exists()){
				 
				            f.createNewFile();
				        }

						FileWriter fout = new FileWriter(f);	
						fout.write(str);
						fout.flush();
						fout.close();
						
						FileInputStream fileinputStream = new FileInputStream("my.txt");
						parser = new MyNewGrammar(fileinputStream);
					
						Token token =null;
						while(true){
							token = parser.getNextToken();
							if(token.kind!=0)
							{
								text2.append("<"+token.kind+","+token.image+">\n");
							}
							else
							{
								break;
							}
						}
						
						
						fileinputStream.close();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
					
					
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str = text.getText();

				File f = new File("my.txt"); 
		      
		            try {
		            	text2.setText("");
						text3.setText("");
						text4.setText("");
		            	  if(!f.exists()){
						f.createNewFile();}
						FileWriter fout = new FileWriter(f);	
						fout.write(str);
						fout.flush();
						fout.close();
						FileInputStream fileinputStream = new FileInputStream("my.txt");
						parser = new MyNewGrammar(fileinputStream);
					
						
				      SimpleNode n = parser.Start();   
				      	n.dump("");
				      	
				    	
				    	if(parser.isError==true){
							Iterator<String> itr =  parser.listError.iterator();
							while (itr.hasNext()) {
								String tmp = (String) itr.next();
								text3.append(tmp.toString()+"\n");
							}	
							}
				      	
				      	
				           Iterator<String> itr =  SimpleNode.list.iterator();
							while (itr.hasNext()) {
								String tmp = (String) itr.next();
								text2.append(tmp.toString()+"\n");
							}				
							Iterator<node> itr2 =  parser.nodelist.Nodelist.iterator();
							while (itr2.hasNext()) {
								node tmp = (node) itr2.next();
								System.out.print("2");
								text4.append(tmp.toString()+"\n");
							}
						
							
				      fileinputStream.close();
					} catch (IOException | ParseException e1) {
						// TODO 自动生成的 catch 块
						text3.setText(e1.getMessage());
					}	
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String str = text.getText();
				
				File f = new File("my.txt"); 
		     
		            try {
		            	text2.setText("");
						text3.setText("");
						text4.setText("");
		            	   if(!f.exists()){
						f.createNewFile();
		            }
		            	   
						FileWriter fout = new FileWriter(f);	
						fout.write(str);
						fout.flush();
						fout.close();
						fileinputStream = new FileInputStream("my.txt");
						parser = new MyNewGrammar(fileinputStream);
					
						 SimpleNode n = parser.Start();
						
							if(parser.isError==true){
								Iterator<String> itr =  parser.listError.iterator();
								while (itr.hasNext()) {
									String tmp = (String) itr.next();
									text3.append(tmp.toString()+"\n");
								}	
								}
						 
						Iterator<QTInfo> itr = parser.qtList.QTList.iterator();
							while (itr.hasNext()) {
								QTInfo tmp = (QTInfo) itr.next();
								text2.append(tmp.toString()+"\n");
							}
							
							Iterator<node> itr2 =  parser.nodelist.Nodelist.iterator();
							while (itr2.hasNext()) {
								node tmp = (node) itr2.next();
								text4.append(tmp.toString()+"\n");
							}
						 QTInfo.size=99;
						
							fileinputStream.close();
					}catch (IOException | ParseException e1) {
						// TODO 自动生成的 catch 块
						text3.setText(e1.getMessage());
					}
		        
			
			}
		});
		
		
	}
}
