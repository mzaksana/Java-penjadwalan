package proses;

public class Proses extends Thread{
    private String nameProses;
    private int timeProses;

    public Proses(String nameProses, int timeProses){
        this.nameProses=nameProses;
        this.timeProses=timeProses;
    }

    public Proses(Proses clone){
        this.nameProses=clone.nameProses;
        this.timeProses=clone.timeProses;
    }

    public String getNameProses() {
        return nameProses;
    }

    public int getTimeProses() {
        return timeProses;
    }

    public void sleep(int time,int cpu){
        try {
            this.timeProses-=cpu;
            Thread.sleep(1000*time);
        }catch (Exception e){
            System.out.println("cant sleep");
        }
    }

}
