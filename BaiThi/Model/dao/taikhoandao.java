package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import bean.taikhoanbean;



public class taikhoandao {
public taikhoanbean getkh(String un,String pass) throws Exception{
		
		//B1: káº¿t ná»‘i
				DungChung dc = new DungChung();
				dc.KetNoi();
				//b2: lay du lieu ve
				String sql = "Select * from QLTaiKhoan where TenDangNhap=? and MatKhau=?";
				PreparedStatement cmd = dc.cn.prepareStatement(sql);
				//Truyá»�n 01 tham sá»‘: un; pas vÃ o cmd
				cmd.setString(1, un);
				cmd.setString(2, pass);
				ResultSet rs = cmd.executeQuery();
				//Náº¿u rs.next==false return null
				// else: return kh;
					// Táº¡o ra 1 khachhang:kh vÃ  return kh;
				if (rs.next()==false) return null;
				else {
					
					int ID=rs.getInt("ID");
		    		String HoTen=rs.getString("HoTen");
		    		String DiaChi=rs.getString("DiaChi");
		    		String TenDangNhap=rs.getString("TenDangNhap");
		    		String MatKhau=rs.getString("MatKhau");
		    		int GhiChu=rs.getInt("GhiChu");
		    		taikhoanbean kh=new taikhoanbean(ID, HoTen, DiaChi, TenDangNhap, MatKhau, GhiChu);
		    		rs.close();
			    	dc.cn.close();
		    		return kh;
					}
		    	//Dong ket noi	
	}
public taikhoanbean ktkh(String un) throws Exception{
	
	//B1: káº¿t ná»‘i
			DungChung dc = new DungChung();
			dc.KetNoi();
			//b2: lay du lieu ve
			String sql = "Select * from QLTaiKhoan where TenDangNhap=? ";
			PreparedStatement cmd = dc.cn.prepareStatement(sql);
			//Truyá»�n 01 tham sá»‘: un; pas vÃ o cmd
			cmd.setString(1, un);
			ResultSet rs = cmd.executeQuery();
			//Náº¿u rs.next==false return null
			// else: return kh;
				// Táº¡o ra 1 khachhang:kh vÃ  return kh;
			while (rs.next()) 
		 {
				
				int ID=rs.getInt("ID");
	    		String HoTen=rs.getString("HoTen");
	    		String DiaChi=rs.getString("DiaChi");
	    		String TenDangNhap=rs.getString("TenDangNhap");
	    		String MatKhau=rs.getString("MatKhau");
	    		int GhiChu=rs.getInt("GhiChu");
	    		taikhoanbean kh=new taikhoanbean(ID, HoTen, DiaChi, TenDangNhap, MatKhau, GhiChu);
	    		rs.close();
		    	dc.cn.close();
	    		return kh;
			}
			return null;
	    	//Dong ket noi	
}

public void dangky(String hoten,String diachi,String un,String pass )throws Exception {
	
	
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "insert into QLTaiKhoan values (?,?,?,?,?) ";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, un);
		cmd.setString(4, pass);
		cmd.setInt(5, 1);
		cmd.executeUpdate();
	
	
}
}
