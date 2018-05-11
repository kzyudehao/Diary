package com.focus.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction;

import com.focus.dao.BookTypeDao;
import com.focus.model.BookType;
import com.focus.util.DbUtil;
import com.focus.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManagerInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	private JTextField searchBookTypeNameTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerInterFrm frame = new BookTypeManagerInterFrm();
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
	public BookTypeManagerInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 464, 542);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
		});
		
		JLabel label = new JLabel("图书类别名称：");
		
		searchBookTypeNameTxt = new JTextField();
		searchBookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookTypeNameActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(searchBookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button))
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchBookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(40)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("编号：");
		
		JLabel label_2 = new JLabel("图书类别名称：");
		
		JLabel label_3 = new JLabel("描述：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdataActionPerformed();
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManagerInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookTypeActionPerformed(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookTypeManagerInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_1)
							.addGap(58)
							.addComponent(button_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(label_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
			}
		});
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u7801", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
		
		//类构造时初始化表格，填充内容
		this.fillTable(new BookType());

	}
	
	/**
	 * 删除图书类别--删除事件处理
	 * @param evt
	 */
	private void deleteBookTypeActionPerformed(ActionEvent evt) {
		int id = 0;
		
		if(StringUtil.isEmpty(idTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择需要删除的数据");
			return;
		}else{
			id = Integer.parseInt(idTxt.getText());
		}
		
		Connection con = null;
		try {
			con = DbUtil.getCon();
			int n = JOptionPane.showConfirmDialog(null, "确定要删除数据嘛？");
			if(n==0){
				bookTypeDao.deleteBookType(con, id);
				JOptionPane.showMessageDialog(null, "删除图书类别名称成功！");
				fillTable(new BookType());
				resetJPane();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除图书类别名称失败！");
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 修改图书类别--修改事件处理
	 */
	private void bookTypeUpdataActionPerformed() {
		int id = 0;
		String bookTypeName = bookTypeNameTxt.getText();
		String bookTypeDesc = bookTypeDescTxt.getText();
		
		if(StringUtil.isEmpty(idTxt.getText())){
			JOptionPane.showMessageDialog(null, "请选择需要修改的数据");
			return;
		}else{
			id = Integer.parseInt(idTxt.getText());
		}
		
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
		}else{
			Connection con = null;
			BookType bookType = new BookType(id,bookTypeName,bookTypeDesc);
			
			try {
				con = dbUtil.getCon();
				bookTypeDao.updataBookType(con, bookType);
				JOptionPane.showMessageDialog(null, "修改图书类别名称成功！");
				fillTable(new BookType());
				resetJPane();
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "修改图书类别名称失败！");
			}finally{
				try {
					dbUtil.close(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * 表格鼠标单击事件处理
	 * @param evt
	 */
	private void bookTypeTableMousePressed(MouseEvent evt) {
		int row = bookTypeTable.getSelectedRow();
		idTxt.setText(Integer.toString((int) bookTypeTable.getValueAt(row, 0)));				//获取选中行第0列数据
		bookTypeNameTxt.setText((String) bookTypeTable.getValueAt(row, 1));
		bookTypeDescTxt.setText((String) bookTypeTable.getValueAt(row, 2));
	}

	/**
	 * 图书类别查询单击事件
	 * @param evt
	 */
	private void searchBookTypeNameActionPerformed(ActionEvent evt) {
		String bookTypeName = this.searchBookTypeNameTxt.getText();
		if(StringUtil.isNotEmpty(bookTypeName)){
			BookType bookType = new BookType();
			bookType.setBookTypeName(bookTypeName);
			this.fillTable(bookType);
		}
	}

	/**
	 * 表格初始化，填充表格
	 * @param bookType
	 */
	private void fillTable(BookType bookType){
		
		DefaultTableModel dtm =(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.listBookType(con, bookType);
			while(rs.next()){
				Vector v = new Vector<>();
				v.add(rs.getInt("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	
	private void resetJPane(){
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
	
	
}
