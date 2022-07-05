package pt.ipbeja.po2.chartracer.model;

import java.io.File;
import java.util.*;

import static java.lang.Thread.sleep;

public class ChartRacer{

    private View view;
    private ArrayList<Data> dataArrayList;
    private WriteDataFile writeDataFile;
    private ArrayList<String> periods;

    public ChartRacer(View view, File file){
        this.view = view;
        this.dataArrayList = ReadFile.readFile(file);
        this.dataArrayList = this.orderList(this.dataArrayList);
        //this.writeDataFile = new WriteDataFile(this.dataArrayList);
        this.periods = this.getPeriods();
        //this.view.updateBoard("1800");
    }

    public ArrayList<Data> orderList(ArrayList<Data> list){
        Collections.sort(list);
        return list;
    }

    public ArrayList<Data> getDatabyDate(String date){
        ArrayList<Data> dataArrayList = new ArrayList<>();

        for (int i = 0; i < this.dataArrayList.size(); i++) {
            if (this.dataArrayList.get(i).year.equals(date)) {
                dataArrayList.add(this.dataArrayList.get(i));
            }
        }

        return dataArrayList;
    }

    public ArrayList<Data> getDataArrayList() {
        return this.dataArrayList;
    }

    public ArrayList<String> getPeriods(){
        ArrayList<String> periods = new ArrayList<>();
        periods.add(dataArrayList.get(0).year);

        int j = 0;

        for (int i = 1; i < dataArrayList.size(); i++)
        {
            if (!dataArrayList.get(i).year.equals(periods.get(j))){
                periods.add(dataArrayList.get(i).year);
                j++;
            }
        }

        return periods;
    }

    private Runnable t1 = () -> {
        try {
            for (int i = 0;  i < periods.size(); i++){
                this.view.updateBoard(periods.get(i));
                sleep(200);
            }
        } catch (Exception e) {}
    };

    public void executeNewThread(){
        executeThread(()-> {
            for (int i = 0;  i < periods.size(); i++){
                try {
                    this.view.updateBoard(periods.get(i));
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



    public void executeThread(Runnable runnable) {
        new Thread(runnable).start();
    }

}