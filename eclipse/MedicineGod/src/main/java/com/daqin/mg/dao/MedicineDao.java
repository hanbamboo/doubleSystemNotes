package com.daqin.mg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daqin.mg.entity.Medicine;
import com.daqin.mg.util.JdbcUtils;
import com.daqin.mg.util.Utils;

public class MedicineDao {
	public boolean saveMedicine(Medicine medicine) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement(
					"insert into medicine (uid,keyid,name,desp,outdate,otc,barcode,yu,elabel,muse,company,show_flag)values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pps.setInt(1, medicine.getUid());
			pps.setString(2, medicine.getKeyid());
			pps.setString(3, medicine.getName());
			pps.setString(4, medicine.getDesp());
			pps.setString(5, medicine.getOutdate());
			pps.setString(6, medicine.getOtc());
			pps.setString(7, medicine.getBarcode());
			pps.setInt(8, medicine.getYu());
			pps.setString(9, medicine.getElabel());
			pps.setString(10, medicine.getMuse());
			pps.setString(11, medicine.getCompany());
			pps.setInt(12, medicine.getShowflag());
			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public ArrayList<Medicine> queryMedicines(int uid) {
		ArrayList<Medicine> medicines = new ArrayList<>();
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement("select * from medicine where uid = ? and del_flag = 0");
			pps.setInt(1, uid);
			resultSet = pps.executeQuery();
			while (resultSet.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(resultSet.getInt(1));
				medicine.setUid(resultSet.getInt(2));
				medicine.setKeyid(resultSet.getString(3));
				medicine.setName(resultSet.getString(4));
				medicine.setDesp(resultSet.getString(5));
				medicine.setImage(null);
				String outdate = resultSet.getString(7);
				long date = Utils.getDateFromString(outdate);
				medicine.setOutdate(outdate);
				medicine.setOutdate_str(Utils.getOutDateString(date, 2));
				String otc = resultSet.getString(8);
				medicine.setOtc(otc);
				switch (otc) {
				case "OTC-R":
					medicine.setOtc_str("OTC");
					break;
				case "OTC-G":
					medicine.setOtc_str("OTC");
					break;
				case "NONE":
					medicine.setOtc_str("无");
					break;
				case "RX":
					medicine.setOtc_str("RX");
					break;
				}
				medicine.setBarcode(resultSet.getString(9));
				medicine.setYu(resultSet.getInt(10));
				medicine.setElabel(resultSet.getString(11));
				medicine.setMuse(resultSet.getString(12));
				medicine.setLove(resultSet.getInt(13));
				medicine.setShare(resultSet.getString(14));
				medicine.setCompany(resultSet.getString(15));
				medicine.setDelflag(resultSet.getInt(16));
				medicine.setShowflag(resultSet.getInt(17));
				medicines.add(medicine);
			}

			return medicines;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public Medicine queryMedicine(String keyid) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement("select * from medicine where keyid = ? and del_flag = 0");
			pps.setString(1, keyid);
			resultSet = pps.executeQuery();

			while (resultSet.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(resultSet.getInt(1));
				medicine.setUid(resultSet.getInt(2));
				medicine.setKeyid(resultSet.getString(3));
				medicine.setName(resultSet.getString(4));
				medicine.setDesp(resultSet.getString(5));
				medicine.setImage(null);
				medicine.setOutdate(resultSet.getString(7));
				medicine.setOtc(resultSet.getString(8));
				medicine.setBarcode(resultSet.getString(9));
				medicine.setYu(resultSet.getInt(10));
				medicine.setElabel(resultSet.getString(11));
				medicine.setMuse(resultSet.getString(12));
				medicine.setLove(resultSet.getInt(13));
				medicine.setShare(resultSet.getString(14));
				medicine.setCompany(resultSet.getString(15));
				medicine.setDelflag(resultSet.getInt(16));
				medicine.setShowflag(resultSet.getInt(17));
				return medicine;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public boolean changeMedicine(Medicine medicine) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement(
					"update medicine set name =?,desp=?,outdate=?,otc=?,barcode=?,yu=?,elabel=?,company=?,muse=?,show_flag=? where keyid=?");
			pps.setString(1, medicine.getName());
			pps.setString(2, medicine.getDesp());
			pps.setString(3, medicine.getOutdate());
			pps.setString(4, medicine.getOtc());
			pps.setString(5, medicine.getBarcode());
			pps.setInt(6, medicine.getYu());
			pps.setString(7, medicine.getElabel());
			pps.setString(8, medicine.getCompany());
			pps.setString(9, medicine.getMuse());
			pps.setInt(10, medicine.getShowflag());
			pps.setString(11, medicine.getKeyid());

			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public boolean delMedicine(String keyid) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;

		try {
			pps = connection.prepareStatement("update medicine set del_flag=1 where keyid = ?");
			pps.setString(1, keyid);
			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public ArrayList<Medicine> queryMedicineBeDel(int uid) {
		ArrayList<Medicine> medicines = new ArrayList<>();
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement("select * from medicine where uid = ? and del_flag = 1");
			pps.setInt(1, uid);
			resultSet = pps.executeQuery();
			while (resultSet.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(resultSet.getInt(1));
				medicine.setUid(resultSet.getInt(2));
				medicine.setKeyid(resultSet.getString(3));
				medicine.setName(resultSet.getString(4));
				medicine.setDesp(resultSet.getString(5));
				medicine.setImage(null);
				medicine.setOutdate(resultSet.getString(7));
				medicine.setOtc(resultSet.getString(8));
				medicine.setBarcode(resultSet.getString(9));
				medicine.setYu(resultSet.getInt(10));
				medicine.setElabel(resultSet.getString(11));
				medicine.setMuse(resultSet.getString(12));
				medicine.setLove(resultSet.getInt(13));
				medicine.setShare(resultSet.getString(14));
				medicine.setCompany(resultSet.getString(15));
				medicine.setDelflag(resultSet.getInt(16));
				medicine.setShowflag(resultSet.getInt(17));
				medicines.add(medicine);
			}

			return medicines;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}

	public boolean cbackMedicine(String keyid) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		try {
			pps = connection.prepareStatement("update medicine set del_flag=0 where keyid = ?");
			pps.setString(1, keyid);
			return pps.executeUpdate() >= 1 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps);
		}
		return false;
	}

	public boolean checkMedicineKeyid(String keyid) {
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement("select * from medicine where keyid = ?");
			pps.setString(1, keyid);
			resultSet = pps.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return false;
	}

	
	public ArrayList<Medicine> queryOpenMedicine() {
		ArrayList<Medicine> medicines = new ArrayList<>();
		Connection connection = JdbcUtils.getCon();
		PreparedStatement pps = null;
		ResultSet resultSet = null;
		try {
			pps = connection.prepareStatement("select * from medicine where show_flag = 1 and del_flag = 0");
			resultSet = pps.executeQuery();
			while (resultSet.next()) {
				Medicine medicine = new Medicine();
				medicine.setId(resultSet.getInt(1));
				medicine.setUid(resultSet.getInt(2));
				medicine.setKeyid(resultSet.getString(3));
				medicine.setName(resultSet.getString(4));
				medicine.setDesp(resultSet.getString(5));
				medicine.setImage(null);
				String outdate = resultSet.getString(7);
				long date = Utils.getDateFromString(outdate);
				medicine.setOutdate(outdate);
				medicine.setOutdate_str(Utils.getOutDateString(date, 2));
				String otc = resultSet.getString(8);
				medicine.setOtc(otc);
				switch (otc) {
				case "OTC-R":
					medicine.setOtc_str("OTC");
					break;
				case "OTC-G":
					medicine.setOtc_str("OTC");
					break;
				case "NONE":
					medicine.setOtc_str("无");
					break;
				case "RX":
					medicine.setOtc_str("RX");
					break;
				}
				medicine.setBarcode(resultSet.getString(9));
				medicine.setYu(resultSet.getInt(10));
				medicine.setElabel(resultSet.getString(11));
				medicine.setMuse(resultSet.getString(12));
				medicine.setLove(resultSet.getInt(13));
				medicine.setShare(resultSet.getString(14));
				medicine.setCompany(resultSet.getString(15));
				medicine.setDelflag(resultSet.getInt(16));
				medicine.setShowflag(resultSet.getInt(17));
				medicines.add(medicine);
			}

			return medicines;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB(connection, pps, resultSet);
		}
		return null;
	}
	
	
	
	
	public void closeDB(Connection connection, PreparedStatement pps, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pps != null) {
			try {
				pps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDB(Connection connection, PreparedStatement pps) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pps != null) {
			try {
				pps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDB(PreparedStatement pps, ResultSet resultSet) {
		if (pps != null) {
			try {
				pps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeDB(Connection connection, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
