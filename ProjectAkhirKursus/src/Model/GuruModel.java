/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Entity.GuruEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author GITA
 */
public class GuruModel implements ModelInterface{
    
    private ArrayList<GuruEntity> guruEntityArrayList;

    public GuruModel() {
        guruEntityArrayList = new ArrayList<GuruEntity>();
    }
    
    public void insertGuru(GuruEntity guru) {
        guruEntityArrayList.add(guru);
    }

    @Override
    public void view() {
        for (GuruEntity guruEntity : guruEntityArrayList) {
            System.out.println(guruEntity.getNpm());
            System.out.println(guruEntity.getNama());
            System.out.println(guruEntity.getPassword());
            System.out.println(guruEntity.getNo_telp());
            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(guruEntity.getTglLahir()));
        }
    }

    @Override
    public int cekData(String npm, String password) {
         int loop = 0;
        for (GuruEntity guruEntity : guruEntityArrayList) {
            if (guruEntity.getNpm().equals(npm) && guruEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public GuruEntity showDataGuru(int index) {
        return guruEntityArrayList.get(index);
    }
    
    
    
    
    
}
