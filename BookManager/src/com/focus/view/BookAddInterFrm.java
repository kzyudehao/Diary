package com.focus.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.management.Descriptor;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.OptionPaneUI;

import com.focus.dao.BookDao;
import com.focus.dao.BookTypeDao;
import com.focus.model.Book;
import com.focus.model.BookType;
import com.focus.util.DbUtil;
import com.focus.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private JTextField priceTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private DbUtil dbUtil = new DbUtil();
	private StringUtil stringUtil = new StringUtil();

	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书添加");
		setBounds(100, 100, 500, 598);

		JLabel label = new JLabel("图书名称：");

		JLabel label_1 = new JLabel("图书作者：");

		JLabel label_2 = new JLabel("作者性别：");

		JLabel label_3 = new JLabel("图书价格：");

		JLabel label_4 = new JLabel("图书类别：");

		JLabel label_5 = new JLabel("图书描述：");

		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);

		authorTxt = new JTextField();
		authorTxt.setColumns(10);

		priceTxt = new JTextField();
		priceTxt.setColumns(10);

		bookTypeJcb = new JComboBox();

		bookDescTxt = new JTextArea();

		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));

		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));

		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);

		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(79)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(button)
												.addGap(68).addComponent(button_1).addGap(187))
										.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(label_5)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(bookDescTxt))
												.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
																.addComponent(label_4)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))
														.addGroup(Alignment.LEADING,
																groupLayout.createSequentialGroup()
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(label)
																				.addComponent(label_2))
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addGroup(groupLayout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(groupLayout
																						.createSequentialGroup()
																						.addComponent(manJrb).addGap(18)
																						.addComponent(femaleJrb))
																				.addComponent(bookNameTxt,
																						GroupLayout.PREFERRED_SIZE, 91,
																						GroupLayout.PREFERRED_SIZE))))
														.addGap(18).addGroup(
																groupLayout.createParallelGroup(Alignment.LEADING)
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(label_3)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(priceTxt,
																						GroupLayout.PREFERRED_SIZE, 91,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(groupLayout.createSequentialGroup()
																				.addComponent(label_1)
																				.addPreferredGap(
																						ComponentPlacement.UNRELATED)
																				.addComponent(authorTxt,
																						GroupLayout.PREFERRED_SIZE, 91,
																						GroupLayout.PREFERRED_SIZE)))))
												.addContainerGap(71, Short.MAX_VALUE)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(82)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(label_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(44)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(label_3)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(manJrb).addComponent(femaleJrb))
				.addGap(42)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_4).addComponent(
						bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(55)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_5)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
				.addGap(74)));
		getContentPane().setLayout(groupLayout);
		fillBookType(); // 初始化图书类别列表
	}

	/**
	 * 添加按钮处理
	 * 
	 * @param evt
	 */
	private void addBookActionPerformed(ActionEvent evt) {
		if (stringUtil.isEmpty(bookNameTxt.getText())) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}

		if (stringUtil.isEmpty(authorTxt.getText())) {
			JOptionPane.showMessageDialog(null, "作者名称不能为空");
			return;
		}

		if (stringUtil.isEmpty(priceTxt.getText())) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
			return;
		}

		String sex = null;
		if (manJrb.isSelected()) {
			sex = "男";
		} else {
			sex = "女";
		}

		Book book = new Book();
		book.setBookName(bookNameTxt.getText());
		book.setAuthor(authorTxt.getText());
		book.setSex(sex);
		try{
			if(StringUtil.isNotEmpty(priceTxt.getText())){
				book.setPrice(Float.parseFloat(priceTxt.getText()));
			}
		}catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "输入的价格有误");
			return;
		}
		
		book.setBookTypeId(bookTypeJcb.getSelectedIndex());
		book.setBookDesc(bookDescTxt.getText());
		Connection con =null;
		
		try {
			con = dbUtil.getCon();
			bookDao.addBook(con, book);
			JOptionPane.showMessageDialog(null, "添加图书成功");
			resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加图书失败");
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "添加图书失败");
			}
		}
		
	}

	/**
	 * 重置按钮处理
	 * 
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		resetValue();
	}

	/**
	 * 图书类别列表初始化
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.listBookType(con, new BookType());
			while (rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "初始化图书类别失败");
		} finally {
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "初始化图书类别失败");
			}
		}
	}

	/**
	 * 清空文本框内容
	 */
	private void resetValue() {
		bookNameTxt.setText("");
		authorTxt.setText("");
		priceTxt.setText("");
		bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			bookTypeJcb.setSelectedIndex(0);
		}

	}

}