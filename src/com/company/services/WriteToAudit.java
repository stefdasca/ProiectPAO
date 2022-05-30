package com.company.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class WriteToAudit {
    private static WriteToAudit instance;
    private static synchronized WriteToAudit getInstance(){
        if(instance == null){
            instance = new WriteToAudit();
        }
        return instance;
    }
    public void DeleteFromAudit() throws IOException{
        FileWriter FW = new FileWriter("src/com/company/files/audit.csv", false);
        BufferedWriter text = new BufferedWriter(FW);
        text.append("Used command, time of usage\n");
        text.close();
        FW.close();
    }

    public void WriteToAudit(String command) throws IOException{
        FileWriter FW = new FileWriter("src/com/company/files/audit.csv", true);
        BufferedWriter text = new BufferedWriter(FW);
        text.append(command);
        text.append(" ");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        text.append(formatter.format(date));
        text.append("\n");
        text.close();
        FW.close();
    }
}
