package com.focus.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.focus.dao.UserDao;
import com.focus.model.User;
import com.focus.util.DbUtil;
import com.focus.util.StringUtil;

public class LogInFrm extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrm frame = new LogInFrm();
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
	public LogInFrm() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setResizable(false);
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 22));
		lblNewLabel.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/logo.png")));
		
		JLabel label = new JLabel("用 户 名：");
		label.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/userName.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("密    码：");
		label_1.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/password.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/login.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(LogInFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(108, Short.MAX_VALUE)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordTxt)
								.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(button_1)))
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(111))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置窗体居中
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 登录按钮实现
	 * @param evt
	 */
	protected void loginActionPerformed(ActionEvent evt) {
		String userName = userNameTxt.getText();
		String password = new String(passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showConfirmDialog(null, "用户名不能为空！");
		}else if(StringUtil.isEmpty(password)){
			JOptionPane.showConfirmDialog(null, "密码不能为空！");
		}
		
		User user = new User(userName,password);
		Connection con = null;
		try {
			con = DbUtil.getCon();
			User currenUser = userDao.login(con, user);
			if(currenUser!=null){
				dispose();
				new MainFrm().setVisible(true);
			}else{
				JOptionPane.showConfirmDialog(null, "用户名或密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbUtil.close(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 重置按钮实现过程
	 * @param e
	 */
	protected void resultValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
