package com.cosc341project19.project19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class WebsiteReader {

    public static void main(String[] args) throws Exception {
        //class is designed to pull information off: https://www2.gov.bc.ca/gov/content/safety/wildfire-status
        //once information is buffered it can be split up into different parts using methods which will return the relevant information when requested by a class.

        URL dangerClass = new URL("http://bcfireinfo.for.gov.bc.ca/hprScripts/DgrCls/index.asp?Region=5");
        BufferedReader dc = new BufferedReader(new InputStreamReader(dangerClass.openStream()));
        String inputLine;

        while ((inputLine = dc.readLine()) != null) {
            ArrayList<String> dangerList = new ArrayList<>();
            System.out.println(inputLine);
            dangerList.add(dc.readLine());
        }
        dc.close();

        URL infoBulletins = new URL("http://bcfireinfo.for.gov.bc.ca/hprScripts/WildfireNews/News.asp");
        BufferedReader ib = new BufferedReader(new InputStreamReader(infoBulletins.openStream()));

        while ((inputLine = ib.readLine()) != null) {
            ArrayList<String> infoList = new ArrayList<>();
            System.out.println(inputLine);
            infoList.add(ib.readLine());
        }
        ib.close();

        URL activeFires = new URL("http://bcfireinfo.for.gov.bc.ca/hprScripts/WildfireNews/Fires.asp?Mode=normal&AllFires=0&FC=5");
        BufferedReader af = new BufferedReader(new InputStreamReader(activeFires.openStream()));

        while ((inputLine = af.readLine()) != null) {
            ArrayList<String> fireList = new ArrayList<>();
            System.out.println(inputLine);
            fireList.add(af.readLine());
        }
        af.close();

    }

}