/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Entity.DaftarkurEntity;
import Entity.GuruEntity;
import Entity.MuridEntity;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author GITA
 */
public class AdminController implements ControllerInterface{

    int indexLogin = 0;
    public AdminController(){

    }
    
    public void dataGuru() {
        String npmGuru[] = {"01", "02", "03"};
        String passwordGuru[] = {"01", "02", "03"};
        String namaGuru[] = {"Anggita", "Eka", "Rewina"};
        String noTelpGuru[] = {"01", "02", "03"};
        String tanggalLahirGuru[] = {"04/05/2000", "01/12/2000", "03/3/2000"};
        String Ruangan[] = {"Tadika", "Ceria", "Bahagia"};
        for(int i = 0; i < npmGuru.length; i++) {
            AllObjectModel.guruModel.insertGuru(new GuruEntity(npmGuru[i], passwordGuru[i], namaGuru[i], 
                    noTelpGuru[i], new Date(tanggalLahirGuru[i]), Ruangan[i]));
        }
    }
    
    public void viewGuru() {
        AllObjectModel.guruModel.view();
    }
    
    public void listPendaftarMapel() {
        AllObjectModel.daftarKurModel.view();
    }

    @Override
    public void login(String npm, String password) {
       indexLogin = AllObjectModel.guruModel.cekData(npm, password);
    }
    
    public GuruEntity guruEntity() {
        return AllObjectModel.guruModel.showDataGuru(indexLogin);
    }
    
    public void updateIsVerified(int index, int indexKur, MuridEntity muridEntity) {
        AllObjectModel.daftarKurModel.updateIsVerified(index, new DaftarkurEntity(muridEntity, true, indexKur));
    }
    
    public ArrayList<DaftarkurEntity> cekDaftarkurModel() {
        return AllObjectModel.daftarKurModel.getDaftarkurArrayList();
    }
    
}
