package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.SinhVien;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener{
	private QLSVView view;

	public QLSVController(QLSVView view2) {
		this.view = view2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.view, "Bạn đã nhấn vào nút"+cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Lưu");
		}else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienCapNhatSinhVien();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(cm.equals("Cập nhật")) {
			this.view.hienThiThongTinSinhVienDaChon();
		}else if(cm.equals("Xoá")) {
			this.view.thucHienXoa();
		}else if(cm.equals("Huỷ bỏ")) {
			this.view.xoaForm();
		}else if(cm.equals("Tìm")) {
			this.view.thucHienTim();
		}else if(cm.equals("Huỷ tìm")) {
			this.view.thucHienTaiLaiDL();
		}else if(cm.equals("About me")) {
			this.view.hienThiAbout();
		}else if(cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if(cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
	}

}
