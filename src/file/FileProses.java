package file;

import proses.Proses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileProses{

    private String namaFileSrc;
    private BufferedReader reader;
    public List<Proses> AntrianProses;

    public FileProses(){/**/}
    public FileProses(String namaFileSrc){
        this.namaFileSrc=namaFileSrc;
        AntrianProses = new ArrayList<>();
        this.init();
    }

    public int init(){
        String isi;
        try {
            reader = new BufferedReader(new FileReader(this.namaFileSrc));
            while ((isi = reader.readLine()) != null) {
                Scanner s2 = new Scanner(isi);
                while (s2.hasNext()) {
                    String s = s2.next();
                    try{
                        //System.out.println(breakString(s));
                        //System.out.println(s);
                        Proses proses = new Proses(s.substring(0,breakString(s)),Integer.parseInt(s.substring(breakString(s)+1)));
                        AntrianProses.add(proses);
                    }catch(Exception e){
                        // data yang diambil hanya yang formatnya sesuai
                        System.out.println("formatnya");
                        continue;
                    }

                }
                s2.close();
            }
            return 1;
        } catch (FileNotFoundException e) {
            System.out.println("not found " + this.namaFileSrc + " in "+System.getProperty("user.dir"));
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return 0;
    }

    public List<Proses> getAntrianProses() {
        return AntrianProses;
    }

    private int breakString(String line){
        for (int a=0; a<line.length();a++ ) {
            if(line.charAt(a)==','){
                return a;
            }
        }
        return line.length();
    }

    public String toString(){
        String aa="";
        for (Proses a: AntrianProses) {
            aa+=a.getNameProses()+" "+a.getTimeProses()+"\n";
        }
        return aa;
    }
}