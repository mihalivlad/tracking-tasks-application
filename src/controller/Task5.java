package controller;

import model.MonitoredData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public interface Task5 {
    Map<String, Integer> computeDuration(ArrayList<MonitoredData> md);
}
