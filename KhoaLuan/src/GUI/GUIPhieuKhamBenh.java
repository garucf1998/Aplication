package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controller.TaiKhoanController;
import enity.NhanVien;
import enity.Role;
import enity.TaiKhoan;

public class GUIPhieuKhamBenh extends JFrame implements MouseListener,ActionListener{

	private JPanel contentPane;
	private JComponent menuBar;
	private JMenu mnFile;
	private JMenu mnEdit;
	private JMenu mnHelp;
	
	private TaiKhoan mTaiKhoan;
	private NhanVien mNhanVien;
	
	private JTextField txthoTen;
	private JTextField txtcmnd;
	private JRadioButton radnam;
	private JRadioButton radnu;
	private JLabel lblsDT;
	private JTextField txtsDT;
	private JLabel lbldiaChi;
	private JTextField txtdiaChi;
	private JPanel Jpanel;
	private JLabel lblngaySinh;
	private JDateChooser txtngaySinh;
	private JTextField txtemail;
	
	private JTextField txtma;
	private JTextField txtChucVu;


	/**
	 * Create the frame.
	 */
	public GUIPhieuKhamBenh(TaiKhoan taikhoan,NhanVien nhanvien) {
		this.mTaiKhoan=taikhoan;
		this.mNhanVien=nhanvien;
		setTitle("Phiếu khám bệnh");
		setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1177, 700);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmngXut = new JMenuItem("Đăng Xuất");
		mnFile.add(mntmngXut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHpngBn = new JLabel("Phiếu Khám Bệnh");
		lblHpngBn.setBounds(371, 0, 325, 27);
		lblHpngBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblHpngBn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		contentPane.add(lblHpngBn);
		
		Jpanel = new JPanel();
		Jpanel.setBackground(SystemColor.inactiveCaptionBorder);
		Jpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Jpanel.setBounds(10, 51, 1104, 204);
		contentPane.add(Jpanel);
		Jpanel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");

		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(33, 126, 86, 20);
		Jpanel.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtemail.setColumns(10);
		txtemail.setUI(new HintTextFieldUI("					Nhập email . VD: duyvien159@gmail.com", true, Color.GRAY));
		txtemail.setBounds(152, 126, 268, 20);
		Jpanel.add(txtemail);
		
	
		
		txtma = new JTextField();
		txtma.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtma.setColumns(10);
		txtma.setVisible(false);
		txtma.setBounds(152, 157, 268, 20);
		Jpanel.add(txtma);
		
		lblsDT = new JLabel("Số điện thoại:");
		lblsDT.setBounds(33, 95, 86, 20);
		Jpanel.add(lblsDT);
		lblsDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtsDT = new JTextField();
		txtsDT.setBounds(152, 95, 268, 20);
		Jpanel.add(txtsDT);
		txtsDT.setUI(new HintTextFieldUI("					Nhập số điện thoại khách hàng. VD: 0399972888", true, Color.GRAY));
		txtsDT.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtsDT.setColumns(10);
		
		JLabel lblgioiTinh = new JLabel("Giới tính:");
		lblgioiTinh.setBounds(33, 61, 86, 20);
		Jpanel.add(lblgioiTinh);
		lblgioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblhoTen = new JLabel("Họ tên: ");
		lblhoTen.setBounds(33, 31, 86, 20);
		Jpanel.add(lblhoTen);
		lblhoTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txthoTen = new JTextField();
		txthoTen.setBounds(152, 32, 268, 20);
		Jpanel.add(txthoTen);
		txthoTen.setUI(new HintTextFieldUI("					Nhập họ tên khách hàng. VD: Nguyễn Văn B", true, Color.GRAY));
		txthoTen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txthoTen.setColumns(10);
		
		
		radnam = new JRadioButton("Nam");
		radnam.setBounds(152, 61, 59, 23);
		Jpanel.add(radnam);
		radnam.setBackground(SystemColor.inactiveCaptionBorder);
		radnam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radnam.isSelected())
				{
					radnu.setSelected(false);
				}
				
			}
		});
		radnam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		radnam.setSelected(true);
		
		
		
		radnu = new JRadioButton("Nữ");
		radnu.setBounds(228, 61, 70, 23);
		Jpanel.add(radnu);
		radnu.setBackground(SystemColor.inactiveCaptionBorder);
		radnu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radnu.isSelected())
				{
					radnam.setSelected(false);
				}
				
			}
		});
		radnu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblcmnd = new JLabel("Chứng minh nhân dân:");
		lblcmnd.setBounds(621, 35, 135, 16);
		Jpanel.add(lblcmnd);
		lblcmnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		lblngaySinh = new JLabel("Ngày sinh:");
		lblngaySinh.setBounds(621, 95, 86, 20);
		Jpanel.add(lblngaySinh);
		lblngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtngaySinh = new JDateChooser();
		txtngaySinh.setBounds(768, 95, 268, 20);
		Jpanel.add(txtngaySinh);
		txtngaySinh.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtngaySinh.setDateFormatString("yyyy-MM-dd");
		
		txtdiaChi = new JTextField();
		txtdiaChi.setBounds(768, 65, 268, 20);
		Jpanel.add(txtdiaChi);
		txtdiaChi.setUI(new HintTextFieldUI("					Nhập địa chỉ khách hàng. VD: Bình Thuận", true, Color.GRAY));
		txtdiaChi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtdiaChi.setColumns(10);
		
		txtcmnd = new JTextField();
		txtcmnd.setBounds(768, 35, 268, 20);
		Jpanel.add(txtcmnd);
		txtcmnd.setUI(new HintTextFieldUI("					Nhập số chứng minh nhân dân. VD: 261464277", true, Color.GRAY));
		txtcmnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtcmnd.setColumns(10);
		
		lbldiaChi = new JLabel("Địa chỉ:");
		lbldiaChi.setBounds(621, 65, 86, 20);
		Jpanel.add(lbldiaChi);
		lbldiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblrole = new JLabel("Chức Vụ :");
		lblrole.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblrole.setBounds(621, 126, 135, 16);
		Jpanel.add(lblrole);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(768, 126, 268, 20);
		Jpanel.add(txtChucVu);
		
		JLabel lblma = new JLabel("Mã bệnh nhân :");
		lblma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblma.setBounds(33, 157, 86, 20);
		Jpanel.add(lblma);
		
		
		radnu.addActionListener(this);
		radnam.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


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
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
