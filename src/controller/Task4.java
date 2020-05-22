package controller;

import model.MonitoredData;

import java.util.ArrayList;
import java.util.Map;

public interface Task4 {
    Map<Integer, Map<String, Integer>> countActivityDay(ArrayList<MonitoredData> md);
}
