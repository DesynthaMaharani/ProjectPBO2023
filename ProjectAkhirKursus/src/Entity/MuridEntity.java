/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author GITA
 */
public class MuridEntity extends MuridAbstractEntity{


    private String kelas;
    public MuridEntity(String npm, String password, String nama, String no_telp, Date tglLahir, String kelas) {
        super(npm, password, nama, no_telp, tglLahir);
        this.kelas = kelas;
    }

    @Override
    public String getNpm() {
        return npm;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    
    
    
    
    
}
