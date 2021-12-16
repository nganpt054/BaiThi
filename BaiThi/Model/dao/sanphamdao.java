package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import bean.sanphambean;

public class sanphamdao {
public ArrayList<sanphambean> getsach() throws Exception{
		
	
	   	
		ArrayList<sanphambean> ds=new ArrayList<sanphambean>();
		//B1: kết nối
		DungChung dc = new DungChung();
		dc.KetNoi();
		//b2: lay du lieu ve
		String sql = "Select *from QLSanPham";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		//b3: duyet qua cac du lieu lay ve de luu vao 1 mang
		while(rs.next()) {
    		int MaSP=rs.getInt("MaSP");
    		String TenSanPham=rs.getString("TenSanPham");
    		int MaLoaiSanPham=rs.getInt("MaLoaiSanPham");
    		String GiaCa=rs.getString("GiaCa");
    		String Anh=rs.getString("Anh");
    		ds.add(new sanphambean(MaSP, TenSanPham, MaLoaiSanPham, GiaCa, Anh));
    	}
    	//Dong ket noi
    	rs.close();
    	dc.cn.close();
 
    	 return ds;
	}
}
