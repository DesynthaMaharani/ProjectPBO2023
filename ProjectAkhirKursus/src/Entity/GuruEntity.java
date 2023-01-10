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
public class GuruEntity extends MuridAbstractEntity{
    
    private String Ruangan;
    public GuruEntity(String npm, String password, String nama, String no_telp, Date tglLahir, String ruang) {
        super(npm, password, nama, no_telp, tglLahir);
        this.Ruangan = ruang;
    }

    @Override
    public String getNpm() {
        return this.npm;
    }

    public String getRuangan() {
        return Ruangan;
    }

    public void setRuangan(String Ruangan) {
        this.Ruangan = Ruangan;
    }
    
    
}
