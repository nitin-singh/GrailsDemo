package com.ttnd.demo

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.ZoneOffset
import java.time.ZonedDateTime


class TimeController {

    def index() {
        //conversion without using calendar class
        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneOffset.UTC)
        ZoneOffset dubaiOffset = ZoneOffset.of("+04:00");
        ZonedDateTime dubaiTime = utcDateTime.withZoneSameInstant(dubaiOffset);
        println "UTC TIME:" + utcDateTime
        println "DUBAI TIME: " + dubaiTime

        render "UTC TIME: ${utcDateTime} <br> DUBAI TIME: ${dubaiTime}"

    }

    def usingCalendar() {
        //using calendar class
        Calendar currentdate = Calendar.getInstance()
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        TimeZone utc = TimeZone.getTimeZone("UTC")
        TimeZone dubai = TimeZone.getTimeZone("Asia/Dubai")
        formatter.setTimeZone(utc)
        System.out.println("UTC:: " + formatter.format(currentdate.getTime()))
        formatter.setTimeZone(dubai);
        System.out.println("Dubai:: " + formatter.format(currentdate.getTime()))

        render "See the Terminal for output"
    }
}
