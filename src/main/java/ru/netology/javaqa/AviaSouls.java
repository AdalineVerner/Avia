package ru.netology.javaqa;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    public void add(Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from)) {
                if (ticket.getTo().equals(to)) {
                    result = addToArray(result, ticket);
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

    public Ticket[] searchAndSortBy(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from)) {
                if (ticket.getTo().equals(to)) {
                    result = addToArray(result, ticket);
                }
            }
        }
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(result, timeComparator);
        return result;
    }

    public int calculateFlightTime(Ticket ticket) {

        int flightTime;
        if (ticket.getTimeFrom() < ticket.getTimeTo()) {
            flightTime = ticket.getTimeTo() - ticket.getTimeFrom();

        } else {
            flightTime = (24 - ticket.getTimeFrom()) + ticket.getTimeTo();
        }
        return flightTime;
    }

}
