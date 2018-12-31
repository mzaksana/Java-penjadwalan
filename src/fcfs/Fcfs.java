package fcfs;


import proses.Proses;
import java.util.ArrayList;
import java.util.List;

public class Fcfs extends Thread{
    private List<Proses> AntrianProses;
    private long start;
    private long end;
    public Fcfs(){
        AntrianProses = new ArrayList<>();
    }
    public void setProses(Proses proses) {
        this.AntrianProses.add(proses);
    }

    public List<Proses> getAntrianProses() {
        return this.AntrianProses;
    }

    public void setAntrianProses(List<Proses> antrianProses) {
        for (Proses a:antrianProses){
            this.AntrianProses.add(new Proses(a));
        }
    }

    public Proses getProses(int index){
        return AntrianProses.get(index);
    }

    public void runAntrianProses() {
        start = System.currentTimeMillis();
        while (AntrianProses.size()>=1) {
            System.out.print("Proses :\t" + AntrianProses.get(0).getNameProses() + "\t" + AntrianProses.get(0).getTimeProses() + "Bt\t");
                int index = AntrianProses.get(0).getTimeProses();
                for (int a = 1; a <= index;a++ ) {
                    System.out.print("1bt ");
                    AntrianProses.get(0).sleep(1, 1);
                    if(AntrianProses.get(0).getTimeProses()==0){
                        AntrianProses.remove(0);
                        break;
                    }
                }
            System.out.println();
        }
        end = System.currentTimeMillis();
    }
    @Override
    public void run() {
        System.out.println("Star fcfs");
        this.runAntrianProses();
    }

    public void start(){
        super.start();
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
