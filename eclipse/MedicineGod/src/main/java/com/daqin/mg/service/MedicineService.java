package com.daqin.mg.service;

import java.util.ArrayList;

import com.daqin.mg.dao.MedicineDao;
import com.daqin.mg.entity.Medicine;

public class MedicineService {

	public boolean saveMedicine(Medicine medicine) {

		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.saveMedicine(medicine);

	}

	public ArrayList<Medicine> checkMedicine(int uid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.queryMedicines(uid);
	}

	public Medicine queryMedicine(String keyid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.queryMedicine(keyid);
	}

	public boolean changeMedicine(Medicine medicine) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.changeMedicine(medicine);

	}

	public boolean delMedicine(String keyid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.delMedicine(keyid);

	}

	public ArrayList<Medicine> queryMedicineBeDel(int uid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.queryMedicineBeDel(uid);
	}

	public boolean cbackMedicine(String keyid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.cbackMedicine(keyid);

	}
	public boolean checkMedicineKeyid(String keyid) {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.checkMedicineKeyid(keyid);

	}
	public ArrayList<Medicine> queryOpenMedicine() {
		MedicineDao medicineDao = new MedicineDao();
		return medicineDao.queryOpenMedicine();

	}
}
