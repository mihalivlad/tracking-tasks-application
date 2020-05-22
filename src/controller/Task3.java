package controller;

import model.MonitoredData;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface Task3 {
    Map<String, Integer> countActivity(ArrayList<MonitoredData> md);
}
