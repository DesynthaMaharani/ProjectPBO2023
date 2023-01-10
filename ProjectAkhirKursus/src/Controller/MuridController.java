package Controller;

import Entity.DaftarkurEntity;
import Entity.MuridEntity;
import java.util.Date;


public class MuridController implements ControllerInterface{

    int indexLogin = 0;
    public MuridController(){

    }

    public MuridEntity getData() {
        return AllObjectModel.muridModel.getMuridEntityArrayList(indexLogin);
    }

    public void daftarMurid(int indexMurid, MuridEntity muridEntity, boolean isVerified) {
        AllObjectModel.daftarKurModel.insertDataDaftarkur(new DaftarkurEntity(muridEntity, isVerified, indexMurid));
    }

    @Override
    public void login(String npm, String password) {
        indexLogin = AllObjectModel.muridModel.cekData(npm, password);
    }

    public void insert(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        AllObjectModel.muridModel.insert(new MuridEntity(npm, password, nama, no_telp, tglLahir, kelas));
    }

    public MuridEntity muridEntity() {
        return AllObjectModel.muridModel.getMuridEntityArrayList(indexLogin);
    }

    public int cekDaftarKur(String npm) {
        int cek = AllObjectModel.daftarKurModel.cekData(npm, null);
        return cek;
    }

    public DaftarkurEntity showDaftarKur(int index) {
        return AllObjectModel.daftarKurModel.showDaftarkur(index);
    }
}
