package view;

import model.MonitoredData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskWriter {
    public void writeTask6(List<String> strList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task6.txt"));
            strList.forEach(str -> {
                try {
                    writer.write(str+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTask5(Map<String, Integer> durationMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task5.txt"));
            writeMap(durationMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTask4(Map<Integer, Map<String, Integer>> activityDayCnt) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task4.txt"));
            activityDayCnt.entrySet().stream().sorted(Map.Entry.<Integer, Map<String, Integer>>comparingByKey()).forEach((countEntry) -> {
                countEntry.getValue().entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach((countEntry2) -> {
                    try {
                        writer.write(countEntry.getKey()+"      "+countEntry2.getKey()+"       "+countEntry2.getValue()+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTask3(Map<String, Integer> activityCnt) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task3.txt"));
            writeMap(activityCnt, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTask2(Map<Date, Integer> count) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task2.txt"));
            writer.write(count.size()+"\n");
            count.entrySet().stream().sorted(Map.Entry.<Date, Integer>comparingByKey()).forEach((countEntry) -> {
                try {
                    writer.write(sdf.format(countEntry.getKey())+"       "+countEntry.getValue()+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeTask1(ArrayList<MonitoredData> md) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Task1.txt"));
            md.forEach(monitor -> {
                try {
                    writer.write(monitor.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMap(Map<String, Integer> durationMap, BufferedWriter writer) throws IOException {
        durationMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach((countEntry) -> {
            try {
                writer.write(countEntry.getKey()+"       "+countEntry.getValue()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }
}
