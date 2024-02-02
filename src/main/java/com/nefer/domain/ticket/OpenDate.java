package com.nefer.domain.ticket;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OpenDate {
    private LocalDate now;
    private LocalDateTime Opendate;
    public OpenDate() {
        this.now = LocalDate.now();
        DecideOpendate();
    }
    public int getDayofWeek (LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();
        return dayOfWeekNumber;
    }
    public void DecideOpendate(){
        if(getDayofWeek(now) == 1) Opendate = now.plusDays(6).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 2) Opendate = now.plusDays(5).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 3) Opendate = now.plusDays(4).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 4) Opendate = now.plusDays(3).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 5) Opendate = now.plusDays(2).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 6) Opendate = now.plusDays(1).atTime(LocalTime.of(17,00));
        else if(getDayofWeek(now) == 7) Opendate = now.atTime(LocalTime.of(17,00));
    }
    public String printOpenDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = Opendate.format(formatter);
        return formattedDate;
    }
}
