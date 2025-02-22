package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh implements Serializable{
	private int maTinh;
	private String tenTinh;
	
	public Tinh() {
	}

	public Tinh(int maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}
	
	public static ArrayList<Tinh> getDSTinh(){
		String[] arr_Tinh = {"Hà Giang",
							"Cao Bằng",
							"Lào Cai",
							"Sơn La",
							"Lai Châu",
							"Bắc Kạn",
							"Lạng Sơn",
							"Tuyên Quang",
							"Yên Bái",
							"Thái Nguyên",
							"Điện Biên",
							"Phú Thọ",
							"Vĩnh Phúc",
							"Bắc Giang",
							"Bắc Ninh",
							"Hà Nội",
							"Quảng Ninh",
							"Hải Dương",
							"Hải Phòng",
							"Hòa Bình",
							"Hưng Yên",
							"Hà Nam",
							"Thái Bình",
							"Nam Định",
							"Ninh Bình",
							"Thanh Hóa",
							"Nghệ An",
							"Hà Tĩnh",
							"Quảng Bình",
							"Quảng Trị",
							"Thừa Thiên Huế",
							"Đà Nẵng",
							"Quảng Nam",
							"Quảng Ngãi",
							"Kon Tum",
							"Gia Lai",
							"Bình Định",
							"Phú Yên",
							"Đắk Lắk",
							"Khánh Hòa",
							"Đắk Nông",
							"Lâm Đồng",
							"Ninh Thuận",
							"Bình Phước",
							"Tây Ninh",
							"Bình Dương",
							"Đồng Nai",
							"Bình Thuận",
							"Thành phố Hồ Chí Minh",
							"Long An",
							"Bà Rịa – Vũng Tàu",
							"Đồng Tháp",
							"An Giang",
							"Tiền Giang",
							"Vĩnh Long",
							"Bến Tre",
							"Cần Thơ",
							"Kiên Giang",
							"Trà Vinh",
							"Hậu Giang",
							"Sóc Trăng",
							"Bạc Liêu",
							"Cà Mau"};
		ArrayList<Tinh> listTinh = new ArrayList<Tinh>();
		int i = 0;
		for (String tentinh : arr_Tinh) {
			Tinh t = new Tinh(i, tentinh);
			listTinh.add(t);
			i++;
		}
		return listTinh;
	}

	public static Tinh getTinhById(int queQuan) {
		return Tinh.getDSTinh().get(queQuan);
	}

	public static Tinh getTinhByTen(String string) {
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			if(tinh.tenTinh.equals(string)) {
				return tinh;
			}
		}
		return null;
	}
	
}
