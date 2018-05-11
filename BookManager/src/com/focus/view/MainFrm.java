package com.focus.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MainFrm extends JFrame {
	
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("基本数据维护");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu mnNewMenu = new JMenu("图书类别管理");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(mnNewMenu);
		
		JMenuItem menuItem_2 = new JMenuItem("图书类别添加");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeFrm = new BookTypeAddInterFrm();
				bookTypeFrm.setVisible(true);
				table.add(bookTypeFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("图书类别维护");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerInterFrm bookTypeManagerFrm = new BookTypeManagerInterFrm();
				bookTypeManagerFrm.setVisible(true);
				table.add(bookTypeManagerFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu.add(menuItem_3);
		
		JMenu menu_2 = new JMenu("图书管理");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem_4 = new JMenuItem("图书增加");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookFrm = new BookAddInterFrm();
				bookFrm.setVisible(true);
				table.add(bookFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("图书维护");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerInterFrm bookManagerFrm = new BookManagerInterFrm();
				bookManagerFrm.setVisible(true);
				table.add(bookManagerFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否安全退出系统！");	//返回值0：是，1：否，2：取消
				if(result ==0){
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("关于我们");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("焦点信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutMeInterFrm aboutMeInterFrm = new AboutMeInterFrm();
				aboutMeInterFrm.setVisible(true);
				table.add(aboutMeInterFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/me.png")));
		menu_1.add(menuItem_1);
		
		//设置主界面最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(table, BorderLayout.CENTER);
		
	}



}
