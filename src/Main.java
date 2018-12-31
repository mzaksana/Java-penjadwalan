/*
*   code metode penjadwalan , Round robin, SJF dan FCFS
*   soruce tersedia di : https://github.com/muammarZA/Java-penjadwalan
*   Pada program ini hanya dijelaskan bagaimana implementasi mendasar untuk 3 metode diatas.
*
*
*   @author Muammar Zikri Aksana
*   @since 3.1
*
*
*
* */

import fcfs.Fcfs;
import file.FileProses;
import rr.RoundRobin;
import sjf.Sjf;

import java.util.ArrayList;


public class Main extends Thread{
    private RoundRobin antrian1;
    private Fcfs antrian2;
    private Sjf antrian3;
    private FileProses readProses;

    public Main(){
        readProses = new FileProses("out/production/Penjadwalan/data/Proses.csv");
        antrian1 = new RoundRobin    (2);
        antrian2 = new Fcfs();
        antrian3 = new Sjf();
    }

    public void setAntrian(){
        antrian1.setAntrianProses(readProses.getAntrianProses());
        antrian2.setAntrianProses(readProses.getAntrianProses());
        antrian3.setAntrianProses(readProses.getAntrianProses());
    }

    public void run(){
        this.setAntrian();
        antrian1.start();
        try {
            antrian1.join();
        }catch (Exception e){/**/}
        antrian2.start();
        try {
            antrian2.join();
        }catch (Exception e){/**/}
        antrian3.start();
        try {
            antrian3.join();
        }catch (Exception e){/**/}
    }
    public void showTime(){
        System.out.println("Lama waktu :");
        System.out.println("RoundRobin : \t"+antrian1.timeProses()+" ms");
        System.out.println("FCFS : \t"+antrian2.timeProses()+" ms");
        System.out.println("SJF : \t"+antrian3.timeProses()+" ms");
    }
    public static void main(String[] args) {
       Main main = new Main();
        main.start();
        try {
            main.join();
        }catch (Exception e){}
        main.showTime();
//        FileProses readProses = new FileProses("out/production/Penjadwalan/data/Proses.csv");
//        RoundRobin antrian1 = new RoundRobin(2);
//        Fcfs antrian2 = new Fcfs();
//        antrian1.setAntrianProses(readProses.getAntrianProses());
//        antrian2.start();

    }
}

