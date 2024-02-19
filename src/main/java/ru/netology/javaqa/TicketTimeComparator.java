package ru.netology.javaqa;

import java.time.Duration;
import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {

        AviaSouls avia = new AviaSouls();
        int flightTime1 = avia.calculateFlightTime(o1);
        int flightTime2 = avia.calculateFlightTime(o2);

        if (flightTime1 < flightTime2) {
            return -1;
        } else if (flightTime1 > flightTime2) {
            return 1;
        } else {
            return 0;
        }
    }

}
