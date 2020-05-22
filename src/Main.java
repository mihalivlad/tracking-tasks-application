import controller.Controller;
import model.MonitoredData;
import view.TaskWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Controller c = new Controller();
        TaskWriter writer = new TaskWriter();
        ArrayList<MonitoredData> md = c.toArrayList();
        writer.writeTask1(md);
        Map<Date, Integer> count = c.countDays(md);
        writer.writeTask2(count);

        Map<String, Integer> activityCnt = c.countActivity(md);
        writer.writeTask3(activityCnt);

        Map<Integer, Map<String, Integer>> activityDayCnt = c.countActivityDay(md);
        writer.writeTask4(activityDayCnt);

        Map<String, Integer> durationMap = c.computeDuration(md);
        writer.writeTask5(durationMap);

        List<String> strList = c.filter(md);
        writer.writeTask6(strList);
    }


}
