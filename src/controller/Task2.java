package controller;

import model.MonitoredData;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface Task2 {
    Map<Date, Integer> countDays(ArrayList<MonitoredData> md);
}
