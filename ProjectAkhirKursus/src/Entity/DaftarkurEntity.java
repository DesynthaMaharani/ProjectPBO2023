/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author GITA
 */
public class DaftarkurEntity {
    
    private MuridEntity murid;
    private boolean isVerified;
    private int indexKursus;

    public DaftarkurEntity(MuridEntity murid, boolean isVerified, int indexKursus) {
        this.murid = murid;
        this.isVerified = isVerified;
        this.indexKursus = indexKursus;
    }

    public MuridEntity getMurid() {
        return murid;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexKursus() {
        return indexKursus;
    }

    public void setIndexKursus(int indexKursus) {
        this.indexKursus = indexKursus;
    }
    
    
    
}
