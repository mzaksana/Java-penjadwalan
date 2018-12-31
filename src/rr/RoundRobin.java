package rr;

import proses.Proses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoundRobin extends Thread{
    private List<Proses> AntrianProses;
    private int QuantumTime;
    private long start;
    private long end;

    public RoundRobin(int QuantumTime){
        AntrianProses = new ArrayList<>();
        this.setQuantumTime(QuantumTime);
    }
    public void setProses(Proses proses) {
        this.AntrianProses.add(proses);
    }

    public List<Proses> getAntrianProses() {
        return this.AntrianProses;
    }

    public void setAntrianProses(List<Proses> antrianProses) {
        //System.out.println("set Antrian Proses");
        for (Proses a:antrianProses){
            this.AntrianProses.add(new Proses(a));
        }
        //this.AntrianProses = new ArrayList<>(antrianProses);
    }

    public Proses getProses(int index){
        return AntrianProses.get(index);
    }

    public void setQuantumTime(int quantumTime) {
        this.QuantumTime = quantumTime;
    }

    public void runAntrianProses(){
        boolean flag = true;
        start = System.currentTimeMillis();
        while(flag){
            flag=false;
            for (Iterator<Proses> iter = AntrianProses.listIterator(); iter.hasNext();){
                Proses proses = iter.next();
                System.out.print("Proses :\t" + proses.getNameProses()+"\t"+proses.getTimeProses() +"Bt : \t");
                for (int a=1;a <=this.QuantumTime;a++){
                    System.out.print("1bt ");
                    proses.sleep(1,1);
                    if(proses.getTimeProses()==0){
                        iter.remove();
                        break;
                    }
                }
                System.out.println();
                flag=true;
            }
        }
        end = System.currentTimeMillis();

    }

    @Override
    public void run() {
        System.out.println("Star rr");
        this.runAntrianProses();
    }

    public void start(){
        super.start();
        //new Thread(this,"fcfs").start();
    }

    public String toString(){
        String aa="";
        for (Proses a: AntrianProses) {
            aa+=a.getNameProses()+" "+a.getTimeProses()+"\n";
        }
        return aa;
    }

    public long timeProses(){
        return end - start;
    }
}
