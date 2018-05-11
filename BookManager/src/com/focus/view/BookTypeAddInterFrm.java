package com.focus.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.focus.dao.BookTypeDao;
import com.focus.model.BookType;
import com.focus.util.DbUtil;
import com.focus.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private StringUtil stringUtil;
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private DbUtil dbUtil;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("图书类别名称");
		
		JLabel lblNewLabel_1 = new JLabel("图书类别描述");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPerformed(e);
			}
			
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(43)
							.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(43)
							.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
					.addGap(19))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(118)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(button)))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblNewLabel_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addGap(45))
		);
		getContentPane().setLayout(groupLayout);

	}

	
	/**
	 * 添加按钮过程 
	 * @param evt
	 */
	protected void addActionPerformed(ActionEvent evt) {
		String bookTypeName = this.bookTypeNameTxt.getText();
		String bookTypeDesc = this.bookTypeDescTxt.getText();
		if(stringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		Connection con = null;
		BookType bookType = new BookType(bookTypeName,bookTypeDesc);
	
		try {
			con = DbUtil.getCon();
			int result = bookTypeDao.addBookType(con, bookType);
			if(result==1){
				JOptionPane.showMessageDialog(null, "添加类别成功！");
				reset();
			}else{
				JOptionPane.showMessageDialog(null, "添加类别失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加类别失败！");
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void resetActionPerformed(ActionEvent evt) {
		this.reset();
	}
	
	private void reset(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
	
}
