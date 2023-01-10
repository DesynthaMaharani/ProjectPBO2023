/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.DaftarkurEntity;
import Entity.MapelEntity;
import Entity.MuridEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author GITA
 */
public class DaftarkurModel implements ModelInterface{
    
    private ArrayList<DaftarkurEntity> daftarkurArrayList;
    
    public DaftarkurModel() {
        daftarkurArrayList = new ArrayList<DaftarkurEntity>();
    }
    
    public void insertDataDaftarkur(DaftarkurEntity daftarkur) {
        daftarkurArrayList.add(daftarkur);
    }
    
    public ArrayList<DaftarkurEntity> getDaftarkurArrayList() {
        return daftarkurArrayList;
    }

    public int size() {
        return daftarkurArrayList.size();
    }

    @Override
    public void view() {
        for (DaftarkurEntity daftarkur : daftarkurArrayList) {
            System.out.println("========================================");
            System.out.println("NPM : " + daftarkur.getMurid().getNpm() + "\nNPM : " + daftarkur.getMurid().getNama()
                    + "\nPassword : " + daftarkur.getMurid().getPassword() + "\nNo.Telp : " + daftarkur.getMurid().getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(daftarkur.getMurid().getTglLahir())
                    + "\nMapel : " + MapelEntity.mapel[daftarkur.getIndexKursus()] + "\nIsVerified : ");
            if (daftarkur.isIsVerified() == false) {
                System.out.println("Telah Di Verifikasi Admin");
            } else {
                System.out.println("Belum Di Verifikasi");
            }
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String npm, String password) {
        int loop = 0;
        if (daftarkurArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < daftarkurArrayList.size(); i++) {
                if (daftarkurArrayList.get(i).getMurid().getNpm().equals(npm)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public DaftarkurEntity showDaftarkur(int index) {
        return daftarkurArrayList.get(index);
    }
    
    public void updateIsVerified(int index, DaftarkurEntity daftarkur) {
        daftarkurArrayList.set(index, daftarkur);
    }
    
    
}
