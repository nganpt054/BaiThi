package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;



public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds=new ArrayList<loaibean>();
		DungChung dc= new DungChung();
		dc.KetNoi();
	
		String sql="Select * from QLLoaiSanPham";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs=cmd.executeQuery();
		
		while (rs.next()) {
			int MaLoaiSanPham=rs.getInt("MaLoaiSanPham");
			String TenLoaiSanPham=rs.getString("TenLoaiSanPham");
			ds.add(new loaibean(MaLoaiSanPham, TenLoaiSanPham));
		}

		rs.close();
		dc.cn.close();
		return ds;
		
	}
}
