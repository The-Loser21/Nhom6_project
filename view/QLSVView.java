package view;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.SinhVien;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFormattedTextField;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class QLSVView extends JFrame {
	public QLSVModel model;
	public JPanel contentPane;
	public JTextField textField_maSinhVien;
	public JTable table;
	public JTextField textField_id;
	public JTextField textField_hoTen;
	public JTextField textField_ngaySinh;
	public JTextField textField_diem1;
	public JTextField textField_diem2;
	public JTextField textField_diem3;
	public JComboBox comboBox_diaChi;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton rdbtnRadio_nam;
	public JRadioButton rdbtnRadio_nu;
	public JComboBox comboBox_queQuan;

	
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 758);
		
		QLSVController ac = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.addActionListener(ac);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(ac);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(ac);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(ac);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(ac);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Nhập thông tin sinh viên cần tìm kiếm
		JLabel jLabel_queQuan = new JLabel("Quê quán");
		jLabel_queQuan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_queQuan.setBounds(42, 32, 84, 37);
		contentPane.add(jLabel_queQuan);
		
		JLabel jLabel_maSinhVien = new JLabel("Mã sinh viên");
		jLabel_maSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_maSinhVien.setBounds(362, 32, 111, 37);
		contentPane.add(jLabel_maSinhVien);
		
		textField_maSinhVien = new JTextField();
		textField_maSinhVien.setBounds(478, 32, 198, 31);
		contentPane.add(textField_maSinhVien);
		textField_maSinhVien.setColumns(10);
		
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(136, 32, 198, 32);
		contentPane.add(comboBox_queQuan);
		
		// btn tìm kiếm
		JButton btn_tim = new JButton("Tìm");
		btn_tim.addActionListener(ac);
		btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_tim.setBounds(708, 32, 91, 31);
		contentPane.add(btn_tim);
		
		JButton btn_huyTim = new JButton("Huỷ tìm");
		btn_huyTim.addActionListener(ac);
		btn_huyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_huyTim.setBounds(822, 32, 103, 31);
		contentPane.add(btn_huyTim);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 100, 915, 2);
		contentPane.add(separator_1);
		
		// bảng danh sách sinh viên
		JLabel jLabel_queQuan_1 = new JLabel("Danh sách sinh viên");
		jLabel_queQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_queQuan_1.setBounds(20, 100, 198, 37);
		contentPane.add(jLabel_queQuan_1);
		
		table = new JTable();
		table.setFont(table.getFont().deriveFont(table.getFont().getSize() + 8f));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3", "T\u00EAn", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m M\u00F4n 2", "\u0110i\u1EC3m M\u00F4n 1", "\u0110i\u1EC3m M\u00F4n 3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 141, 915, 234);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 385, 915, 2);
		contentPane.add(separator_1_1);
		
		// Thông tin sinh viên
		JLabel jLabel_thongTin = new JLabel("Thông tin sinh viên");
		jLabel_thongTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_thongTin.setBounds(20, 385, 198, 37);
		contentPane.add(jLabel_thongTin);
		
		JLabel jLabel_maSV = new JLabel("Mã sinh viên");
		jLabel_maSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_maSV.setBounds(52, 427, 111, 37);
		contentPane.add(jLabel_maSV);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(202, 432, 198, 31);
		contentPane.add(textField_id);
		
		JLabel jLabel_hoTen = new JLabel("Họ và Tên");
		jLabel_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_hoTen.setBounds(52, 467, 111, 37);
		contentPane.add(jLabel_hoTen);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(202, 473, 198, 31);
		contentPane.add(textField_hoTen);
		
		JLabel jLabel_diaChi = new JLabel("Địa chỉ");
		jLabel_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_diaChi.setBounds(52, 509, 111, 37);
		contentPane.add(jLabel_diaChi);
		
		comboBox_diaChi = new JComboBox();
		comboBox_diaChi.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_diaChi.addItem(tinh.getTenTinh());
		}
		comboBox_diaChi.setBounds(202, 514, 198, 32);
		contentPane.add(comboBox_diaChi);
		
		JLabel jLabel_ngaySinh = new JLabel("Ngày sinh");
		jLabel_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_ngaySinh.setBounds(52, 551, 111, 37);
		contentPane.add(jLabel_ngaySinh);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(202, 556, 198, 31);
		contentPane.add(textField_ngaySinh);
		
		// Giới tính
		JLabel jLabel_gioiTinh = new JLabel("Giới tính");
		jLabel_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_gioiTinh.setBounds(513, 427, 111, 37);
		contentPane.add(jLabel_gioiTinh);
		
		rdbtnRadio_nam = new JRadioButton("Nam");
		rdbtnRadio_nam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRadio_nam.setBounds(645, 435, 103, 21);
		contentPane.add(rdbtnRadio_nam);
		
		rdbtnRadio_nu = new JRadioButton("Nữ");
		rdbtnRadio_nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRadio_nu.setBounds(750, 436, 103, 21);
		contentPane.add(rdbtnRadio_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtnRadio_nam);
		btn_gioiTinh.add(rdbtnRadio_nu);
		
		// Điểm
		JLabel jLabel_diem1 = new JLabel("Điểm Môn 1");
		jLabel_diem1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_diem1.setBounds(513, 467, 111, 37);
		contentPane.add(jLabel_diem1);
		
		JLabel jLabel_diem2 = new JLabel("Điểm Môn 2");
		jLabel_diem2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_diem2.setBounds(513, 509, 111, 37);
		contentPane.add(jLabel_diem2);
		
		JLabel jLabel_diem3 = new JLabel("Điểm Môn 3");
		jLabel_diem3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jLabel_diem3.setBounds(513, 551, 111, 37);
		contentPane.add(jLabel_diem3);
		
		textField_diem1 = new JTextField();
		textField_diem1.setColumns(10);
		textField_diem1.setBounds(645, 467, 198, 31);
		contentPane.add(textField_diem1);
		
		textField_diem2 = new JTextField();
		textField_diem2.setColumns(10);
		textField_diem2.setBounds(645, 509, 198, 31);
		contentPane.add(textField_diem2);
		
		textField_diem3 = new JTextField();
		textField_diem3.setColumns(10);
		textField_diem3.setBounds(645, 551, 198, 31);
		contentPane.add(textField_diem3);
		
		
		// Các button điều khiển 
		
		JButton btn_them = new JButton("Thêm");
		btn_them.addActionListener(ac);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_them.setBounds(31, 631, 127, 31);
		contentPane.add(btn_them);
		
		JButton btn_xoa = new JButton("Xoá");
		btn_xoa.addActionListener(ac);
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_xoa.setBounds(217, 631, 127, 31);
		contentPane.add(btn_xoa);
		
		JButton btn_capNhat = new JButton("Cập nhật");
		btn_capNhat.addActionListener(ac);
		btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_capNhat.setBounds(412, 631, 127, 31);
		contentPane.add(btn_capNhat);
		
		JButton btn_luu = new JButton("Lưu");
		btn_luu.addActionListener(ac);
		btn_luu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_luu.setBounds(597, 631, 127, 31);
		contentPane.add(btn_luu);
		
		JButton btn_huy = new JButton("Huỷ bỏ");
		btn_huy.addActionListener(ac);
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_huy.setBounds(771, 631, 127, 31);
		contentPane.add(btn_huy);

		this.setVisible(true);
	}


	public void xoaForm() {
		textField_id.setText("");
		textField_hoTen.setText("");
		textField_ngaySinh.setText("");
		comboBox_diaChi.setSelectedIndex(-1);
		textField_diem1.setText("");
		textField_diem2.setText("");
		textField_diem3.setText("");
		btn_gioiTinh.clearSelection();
	}

	public void themSinhVienVaoTable(SinhVien sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[]{
				sv.getMaSinhVien()+"",
				sv.getTenSinhVien(),
				sv.getQueQuan().getTenTinh(),
				sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900),
				(sv.isGioiTinh()? "Nam":"Nữ"),
				sv.getDiemMon1()+"",
				sv.getDiemMon2()+"",
				sv.getDiemMon3()+""
		});
	}
	
	public void themHoacCapNhatSinhVien(SinhVien sv) {
		DefaultTableModel model_table_1 = (DefaultTableModel) table.getModel();
		if(!(this.model.kiemTraTonTai(sv))) {
			this.model.insert(sv);
			this.themSinhVienVaoTable(sv);
		}else {
			this.model.update(sv);
			int soLuong = model_table_1.getRowCount();
			for(int i = 0 ;i < soLuong; i++) {
				String id = model_table_1.getValueAt(i, 0)+"";
				if(id.equals(sv.getMaSinhVien()+"")) {
					model_table_1.setValueAt(sv.getMaSinhVien()+"", i, 0);
					model_table_1.setValueAt(sv.getTenSinhVien()+"", i, 1);
					model_table_1.setValueAt(sv.getQueQuan().getTenTinh()+"", i, 2);
					model_table_1.setValueAt(sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/"+(sv.getNgaySinh().getYear()+1900)+"", i, 3);
					model_table_1.setValueAt((sv.isGioiTinh()? "Nam":"Nữ")+"", i, 4);
					model_table_1.setValueAt(sv.getDiemMon1()+"", i, 5);
					model_table_1.setValueAt(sv.getDiemMon2()+"", i, 6);
					model_table_1.setValueAt(sv.getDiemMon3()+"", i, 7);
				}
			}
		}
		
	}

	public SinhVien getSinhVien() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int maSinhVien = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenSinhVien = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diem1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diem2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diem3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
		return sv;
	}
	
	
	public void hienThiThongTinSinhVienDaChon() {
		SinhVien sv = getSinhVien();
		this.textField_id.setText(sv.getMaSinhVien()+"");	
		this.textField_hoTen.setText(sv.getTenSinhVien());	
		this.comboBox_diaChi.setSelectedItem(sv.getQueQuan().getTenTinh());	
		this.textField_ngaySinh.setText(sv.getNgaySinh().getDate()+"/"+(sv.getNgaySinh().getMonth()+1)+"/" + (sv.getNgaySinh().getYear()+1900)+"");	
		if(sv.isGioiTinh()) {
			rdbtnRadio_nam.setSelected(true);
		}else {
			rdbtnRadio_nu.setSelected(true);
		}
		this.textField_diem1.setText(sv.getDiemMon1()+"");	
		this.textField_diem2.setText(sv.getDiemMon2()+"");	
		this.textField_diem3.setText(sv.getDiemMon3()+"");
	}


	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá");
		if(luaChon == JOptionPane.YES_OPTION) {
			SinhVien sv = getSinhVien();
			this.model.delete(sv);
			model_table.removeRow(i_row);
		}
	}


	public void thucHienCapNhatSinhVien() {
		int maSinhVien = Integer.valueOf(this.textField_id.getText());
		String tenSinhVien = this.textField_hoTen.getText();
		int queQuan = this.comboBox_diaChi.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		String s_ngaySinh1 = this.textField_ngaySinh.getText()+"";
		Date ngaySinh = new Date(s_ngaySinh1);
		boolean gioiTinh =true;
		if(this.rdbtnRadio_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.rdbtnRadio_nu.isSelected()){
			gioiTinh = false;
		}
		float diem1 = Float.valueOf(this.textField_diem1.getText());
		float diem2 = Float.valueOf(this.textField_diem2.getText());
		float diem3 = Float.valueOf(this.textField_diem3.getText());
		
		SinhVien sv = new SinhVien(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
		
		this.themHoacCapNhatSinhVien(sv);
	}


	public void thucHienTim() {
		// Gọi hàm huỷ tìm kiếm
		this.thucHienTaiLaiDL();
		// Thực hiện tìm kiếm
		int queQuan = this.comboBox_queQuan.getSelectedIndex()-1;
		String maSinhVien = this.textField_maSinhVien.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<Integer>();
		int soLuong = model_table.getRowCount();
		if(queQuan >= 0) {
			Tinh tinh = Tinh.getTinhById(queQuan);
			for(int i = 0 ;i < soLuong; i++) {
				String id = model_table.getValueAt(i, 0)+""; 	
				String tenTinh = model_table.getValueAt(i, 2)+"";
				if(!(tenTinh.equals(tinh.getTenTinh()))) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		if(maSinhVien.length() > 0) {
			for(int i = 0 ;i < soLuong; i++) {
				String maSVTrongTable = model_table.getValueAt(i,0)+""; 	
				String id = model_table.getValueAt(i, 0)+""; 
				if(!(maSVTrongTable.equals(maSinhVien))) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			soLuong = model_table.getRowCount();
			System.out.println(idCanXoa);
			for(int i = 0 ;i < soLuong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+""; 	
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}
	
	
	public void thucHienTaiLaiDL() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuong = model_table.getRowCount();
			if(soLuong == 0) {
				break;
			}else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (SinhVien sv : this.model.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
	}
	
	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sv : this.model.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
	public void openFile(File file) {
		ArrayList<SinhVien> ds = new ArrayList<SinhVien>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv = null;
			while((sv = (SinhVien) ois.readObject())!=null) {
				ds.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsSinhVien(ds);
	}
	
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDL();
		} 
	}
}
