package controller;

import model.MonitoredData;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {
    public ArrayList<MonitoredData> toArrayList(){
        Task1 task = () -> {
            ArrayList<MonitoredData> md = new ArrayList<>();
            try {
                new BufferedReader(new FileReader("Activities.txt")).lines().forEach(str -> {
                    String[] arrstr = str.split("\\t+");
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        md.add(new MonitoredData(format.parse(arrstr[0]), format.parse(arrstr[1]), arrstr[2]));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return md;
        };
        return task.toArrayList();
    }

    public Map<Date, Integer> countDays(ArrayList<MonitoredData> md){
        Task2 task = (mdarr)->{
            Map<Date, Integer> count = new HashMap<>();
            mdarr.forEach(monitor ->{
                if(count.containsKey(monitor.getStartDate())){
                    count.put(monitor.getStartDate(), count.get(monitor.getStartDate())+1);
                }else{
                    count.put(monitor.getStartDate(), 1);
                }
            });
            return count;
        };
        return task.countDays(md);
    }

    public Map<String, Integer> countActivity(ArrayList<MonitoredData> md){
        Task3 task = (mdarr)->{
            Map<String, Integer> count = new HashMap<>();
            mdarr.forEach(monitor ->{
                if(count.containsKey(monitor.getActivityLabel())){
                    count.put(monitor.getActivityLabel(), count.get(monitor.getActivityLabel())+1);
                }else{
                    count.put(monitor.getActivityLabel(), 1);
                }
            });
            return count;
        };
        return task.countActivity(md);
    }

    public Map<Integer, Map<String, Integer>> countActivityDay(ArrayList<MonitoredData> md){
        Task4 task = (mdarr)-> {
            Map<Integer, Map<String, Integer>> count = new HashMap<>();
            int dayCount = 1;
            ArrayList<MonitoredData> dayArray = new ArrayList<>();
            ListIterator itr = mdarr.listIterator();
            while (itr.hasNext()) {
                if(!itr.hasPrevious()){
                    itr.next();
                }
                Date prev = ((MonitoredData) itr.previous()).getStartDate();
                itr.next();
                MonitoredData monitor = (MonitoredData) itr.next();
                if (prev.equals(monitor.getStartDate())) {
                    dayArray.add(monitor);
                } else {
                    count.put(dayCount++, countActivity(dayArray));
                    dayArray = new ArrayList<>();
                    dayArray.add(monitor);
                }
            }
            return count;
        };
        return task.countActivityDay(md);
    }

    public Map<String, Integer> computeDuration(ArrayList<MonitoredData> md){
        Task5 task = (mdarr)->{
            Map<String, Integer> count = new HashMap<>();
            mdarr.forEach(monitor ->{
                if(count.containsKey(monitor.getActivityLabel())){
                    count.put(monitor.getActivityLabel(), count.get(monitor.getActivityLabel())+monitor.getDuration());
                }else{
                    count.put(monitor.getActivityLabel(), monitor.getDuration());
                }
            });
            return count;
        };
        return task.computeDuration(md);
    }

    public List<String> filter(ArrayList<MonitoredData> md){
        Task6 task = (mdarr)->{
            Map<String, Integer> count = countActivity(mdarr);
            List<String> strList = new ArrayList<>();
            count.forEach((label, rep)->{
                int cnt= (int) mdarr.stream().filter(m -> {
                    return label.equals(m.getActivityLabel());
                }).filter(m -> m.getDuration() < 5).count();
                if(rep*0.9 < cnt){
                    strList.add(label);
                }
            });
            return strList;
        };
        return task.filter(md);
    }
}
