package com.focus.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.focus.dao.BookDao;
import com.focus.dao.BookTypeDao;
import com.focus.model.Book;
import com.focus.model.BookType;
import com.focus.util.DbUtil;
import com.focus.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManagerInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	
	private BookDao bookDao = new BookDao();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private DbUtil dbUtil = new DbUtil();
	private StringUtil stringUtil = new StringUtil();
	
	private JComboBox s_bookTypeJcb;
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerInterFrm frame = new BookManagerInterFrm();
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
	public BookManagerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书管理");
		setBounds(100, 100, 732, 650);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("编号：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("图书名称：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("作者性别：");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel label_5 = new JLabel("价格：");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("图书作者：");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("图书类别：");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_8 = new JLabel("图书描述：");
		
		bookDescTxt = new JTextArea();
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_8)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGap(31)
										.addComponent(button_2))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))))
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGap(28)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookNameTxt))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_6)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
								.addGap(32)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(manJrb)
										.addGap(18)
										.addComponent(femaleJrb))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
					.addGap(47))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(33)
							.addComponent(label_8))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(40)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("图书名称：");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者：");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别：");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManagerInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u6027\u522B", "\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		fillBookType("search");
		this.fillTable(new Book());
		fillBookType("modify");

	}
	
	/**
	 * 删除按钮事件处理
	 * @param e
	 */
	private void deleteBookActionPerformed(ActionEvent ae) {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择需要修改的数据");
			return;
		}
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			int n = JOptionPane.showConfirmDialog(null, "确认删除数据嘛？");
			if(n==0){
				bookDao.deleteBook(con, Integer.parseInt(id));
				JOptionPane.showMessageDialog(null, "删除数据成功");
				fillTable(new Book());
				resetValue();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

	/**
	 * 修改按钮事件
	 * @param e
	 */
	private void updateBookActionPerformed(ActionEvent ae) {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择需要修改的数据");
			return;
		}
		String bookName = bookNameTxt.getText();
		String sex = null;
		if(manJrb.isSelected()){
			sex = "男";
		}else if(femaleJrb.isSelected()){
			sex="女";
		}
		
		float price = Float.parseFloat(priceTxt.getText());
		String author = authorTxt.getText();
		BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		String bookDesc = bookDescTxt.getText();
		
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "作者名称不能为空");
			return;
		}
		
		Book book = new Book(Integer.parseInt(id),bookName, author, sex, price, bookTypeId, bookDesc);
		Connection con = null;
		
		try {
			con=dbUtil.getCon();
			int num = bookDao.updateBook(con, book);
			if(num==1){
				JOptionPane.showMessageDialog(null, "修改成功");
				fillTable(new Book());
				resetValue();
			}else{
				JOptionPane.showMessageDialog(null, "修改失败");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
			return;
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}
	}
	
	private void resetValue(){
		this.idTxt.setText("");
		this.bookNameTxt.setText("");
		this.manJrb.setEnabled(true);
		this.priceTxt.setText("");
		this.authorTxt.setText("");
		this.bookTypeJcb.setSelectedIndex(0);
		this.bookDescTxt.setText("");
	}
	/**
	 * 图书列表鼠标单击事件
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		int row = bookTable.getSelectedRow();
		int id = (int) bookTable.getValueAt(row, 0);
		String bookName = (String) bookTable.getValueAt(row, 1);
		String author = (String) bookTable.getValueAt(row, 2);
		String sex = (String) bookTable.getValueAt(row, 3);
		float price = (float) bookTable.getValueAt(row, 4);
		String bookDesc = (String) bookTable.getValueAt(row, 5);
		String bookTypeName = (String) bookTable.getValueAt(row, 6);
		
		this.idTxt.setText(id+"");
		this.bookNameTxt.setText(bookName);
		if(sex!=null && "男".equals(sex)){
			this.manJrb.setSelected(true);
		}else{
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText(price+"");
		this.authorTxt.setText(author);
		
		int n=this.bookTypeJcb.getItemCount();	//图书类型列表总数
		for(int i=0;i<n;i++){
			BookType item = (BookType) bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)){
				bookTypeJcb.setSelectedIndex(i);
			}
		}
		
		this.bookDescTxt.setText(bookDesc);
		
		
	}

	/**
	 * 图书查询按钮处理
	 * @param evt
	 */
	private void searchBookActionPerformed(ActionEvent evt) {
		String bookName = s_bookNameTxt.getText();
		String author = s_authorTxt.getText();
		BookType bookType = (BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		Book book = new Book(bookName, author, bookTypeId);
		this.fillTable(book);
	}

	/**
	 * 表格内容加载
	 */
	private void fillTable(Book book){
		DefaultTableModel dtm =(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.listBook(con, book);
			while(rs.next()){
				Vector v = new Vector<>();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 图书类别列表初始化
	 * @param type
	 */
	private void fillBookType(String type){
		Connection con = null;
		BookType bookType = new BookType();
		try {
			
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.listBookType(con, new BookType());
			if("search".equals(type)){
				bookType.setBookTypeName("请选择...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while(rs.next()){
				bookType = new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)){
					this.s_bookTypeJcb.addItem(bookType);
					
				}else if("modify".equals(type)){
					this.bookTypeJcb.addItem(bookType);
				}
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
