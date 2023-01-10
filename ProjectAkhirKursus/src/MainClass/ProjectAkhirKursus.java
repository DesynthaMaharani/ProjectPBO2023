/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClass;
import Entity.MapelEntity;
import Controller.AdminController;
import Controller.MuridController;
import Controller.AllObjectModel;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author GITA
 */
public class ProjectAkhirKursus {

    private static AdminController admin = new AdminController();
    private static Scanner input = new Scanner(System.in);
    private static MuridController murid = new MuridController();

    public static void main(String[] args) {

        int loop = 0;
        int pilih = 0;
        int pilLogin = 0;
        admin.dataGuru();
        do {
            System.out.println("Selamat Datang di Kursus ABC !!"
                    + "\n1. Login"
                    + "\n2. Daftar Murid"
                    + "\n0. Stop"
                    + "\nMasukkan Pilihan Anda : ");
            pilih = input.nextInt();
            if (pilih == 1) {
                System.out.println("1. Login Guru" + "\n2. Login Murid" + "\nPilih : ");
                pilLogin = input.nextInt();
                if (pilLogin == 1) {
                    loginGuru();
                } else {
                    loginMurid();
                }
            } else if (pilih == 2) {
                registerMurid();
            } else if (pilih == 3) {
                admin.viewGuru();
            } else {
                break;
            }
        } while (pilih != 0);
    }

    static void loginGuru() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Passwrod : ");
        String password = input.next();
        try {
            admin.login(npm, password);
            System.out.println("Selamat Datang " + admin.guruEntity().getNama() + " dari ruang "
                    + admin.guruEntity().getRuangan());
            if (admin.cekDaftarkurModel().size() == 0) {
                System.out.println("Data Masih Kosong !!!");
            } else {
                viewDaftarKur();
                updateIsVerified();
            }
        } catch (Exception e) {
            System.out.println("NPM atau Password Anda Salah !!!");
        }
    }

    static void loginMurid() {
        System.out.println("NPM : ");
        String npm = input.next();
        System.out.println("Password : ");
        String password = input.next();
        murid.login(npm, password);
        System.out.println("Selamat Datang " + murid.muridEntity().getNama());
        int cek = murid.cekDaftarKur(murid.muridEntity().getNpm());
        if (cek == -1) {
            System.out.println("Anda Belum Tedaftar Praktikum !!");
            registerMapel();
        } else if (cek == -2) {
            System.out.println("Anda Belum Tedaftar Praktikum !!");
            registerMapel();
        } else {
            System.out.println("====================================");
            System.out.print(" NPM : " + murid.showDaftarKur(cek).getMurid().getNpm()
                    + "\n Nama : " + murid.showDaftarKur(cek).getMurid().getNama()
                    + "\n No Telp : " + murid.showDaftarKur(cek).getMurid().getNo_telp()
                    + "\n Tanggal Lahir : " + new SimpleDateFormat("dd-MM--yyyy").format(murid.showDaftarKur(cek).getMurid().getTglLahir())
                    + "\n Praktikum : " + MapelEntity.mapel[murid.showDaftarKur(cek).getIndexKursus()]
                    + "\n isVerified  ");
            if (murid.showDaftarKur(cek).isIsVerified() == false) {
                System.out.println("Belum Di Verifikasi Admin");
            } else {
                System.out.println("Telah Di Verifikasi Admin");
            }
            System.out.println(" Kelas : " + murid.showDaftarKur(cek).getMurid().getKelas());
            System.out.println("====================================");
        }
    }

    static void registerMurid() {
        try {
            System.out.println("Input NPM : ");
            String npm = input.next();
            System.out.println("Input Nama : ");
            String nama = input.next();
            System.out.println("Input Password : ");
            String password = input.next();
            System.out.println("Input No. Telp : ");
            String notelp = input.next();
            System.out.println("Input Tgl Lahir dd/mm/yyyy : ");
            Date tglLahir = new Date(input.next());
            System.out.println("Kelas : ");
            String kelas = input.next();
            murid.insert(npm, password, nama, notelp, tglLahir, kelas);
            System.out.println("Daftar Sukses !!");
        } catch (Exception e) {
            System.out.println("Format Pengisian Salah");
        }
    }

    static void registerMapel() {
        System.out.println("Pilih mapel : ");
        for (int i = 0; i < MapelEntity.mapel.length; i++) {
            System.out.println((i) + " " + MapelEntity.mapel[i]);
        }
        int pilPrak = input.nextInt();
        murid.daftarMurid(pilPrak,murid.getData(), false);
        admin.listPendaftarMapel();
    }



    static void viewDaftarKur() {
        admin.listPendaftarMapel();
    }

    static void updateIsVerified() {
        System.out.println("NPM Mapel : ");
        String npm = input.next();
        int index = AllObjectModel.daftarKurModel.cekData(npm, null);
        admin.updateIsVerified(index, murid.showDaftarKur(index).getIndexKursus(), murid.showDaftarKur(index).getMurid());
    }

    }
    

