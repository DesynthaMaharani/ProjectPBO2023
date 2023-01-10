/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.GuruEntity;
import Entity.MuridEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author GITA
 */
public class MuridModel implements ModelInterface{
    
    private ArrayList<MuridEntity> muridEntityArrayList;

    public MuridModel() {
        muridEntityArrayList = new ArrayList<MuridEntity>();
    }
    
    public void insert(MuridEntity muridEntity) {
        muridEntityArrayList.add(muridEntity);
    }

    public int size() {
        return muridEntityArrayList.size();
    }
    
    @Override
    public void view() {
        for (MuridEntity muridEntity : muridEntityArrayList) {
            System.out.println("========================================");
            System.out.println("NPM : " + muridEntity .getNpm() + "\nNama : " + muridEntity .getNama()
                    + "\nPassowrd : " + muridEntity .getPassword() + "\nNo.Telp : " + muridEntity .getNo_telp()
                    + "\nTanggal Lahir : " + new SimpleDateFormat("dd-MM-yyyy").format(muridEntity .getTglLahir()));
            System.out.println("========================================");
        }
    }

    @Override
    public int cekData(String npm, String password) {
        int loop = 0;
        while (!muridEntityArrayList.get(loop).getNpm().equals(npm)
                && !muridEntityArrayList.get(loop).getPassword().equals(password)) {
            loop++;
        }
        return loop;
    }
    
    public MuridEntity getMuridEntityArrayList(int index) {
        return muridEntityArrayList.get(index);
    }
    
    
    
    
}
