package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class MonitoredData {
    Date startTime;
    Date endTime;
    String activityLabel;

    public MonitoredData(Date startTime, Date endTime, String activityLabel) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityLabel = activityLabel;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
          Date dateWithoutTime = sdf.parse(sdf.format(startTime));
          return dateWithoutTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public int getDuration(){
        return (int) ((endTime.getTime()-startTime.getTime())/1000/60);
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatData=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatData.format(startTime) +
                "       " + formatData.format(endTime) +
                "       " + activityLabel + '\n';
    }
}
