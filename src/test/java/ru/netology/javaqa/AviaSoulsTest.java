package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Pulkovo Airport,St. Petersburg",
            "Incheon International Airport, Seoul ",
            35000,
            10,
            2);

    Ticket ticket2 = new Ticket("Pulkovo Airport,St. Petersburg",
            "Incheon International Airport, Seoul ",
            38000,
            13,
            4);
    Ticket ticket3 =new Ticket("Pulkovo Airport,St. Petersburg",
            "Sheremetyevo International Airport, Moscow",
            4000,
            23,
            1
            );

    Ticket ticket4 = new Ticket("Pulkovo Airport,St. Petersburg",
            "Incheon International Airport, Seoul ",
            29000,
            8,
            1);


    Ticket ticket5 =new Ticket("Sheremetyevo International Airport, Moscow",
            "Tokyo International Airport, Tokyo",
            38000,
            15,
            5
    );
    Ticket ticket6 =new Ticket("Sheremetyevo International Airport, Moscow",
            "Tokyo International Airport, Tokyo",
            43000,
            17,
            10
    );

    Ticket ticket7 =new Ticket("Sheremetyevo International Airport, Moscow",
            "Tokyo International Airport, Tokyo",
            39000,
            9,
            19
    );

    AviaSouls avia = new AviaSouls();


    @BeforeEach
    public void setUp(){
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);
        avia.add(ticket7);
    }

    @Test
    public void shouldAddTickets(){
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = avia.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldCompareToTickets(){
        Arrays.sort(avia.findAll());

        Ticket[] expected = {ticket3, ticket4, ticket1, ticket2, ticket5, ticket7, ticket6};
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTickets(){
        String from ="Pulkovo Airport,St. Petersburg";
        String to = "Incheon International Airport, Seoul ";

        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = avia.search(from,to);

        Assertions.assertArrayEquals(expected,actual);


    }

    @Test
    public void shouldCompareTickets(){
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Arrays.sort(avia.findAll(), timeComparator);


        Ticket[] expected = {ticket3, ticket7, ticket5, ticket2, ticket1, ticket4, ticket6};
        Ticket[] actual = avia.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldSearchAndSortByTickets(){
        String from = "Sheremetyevo International Airport, Moscow";
        String to = "Tokyo International Airport, Tokyo";

        TicketTimeComparator timeComparator =new TicketTimeComparator();

        Ticket[] expected = {ticket5, ticket7, ticket6};
        Ticket[] actual = avia.search(from, to);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCalculateFlightTime(){

        int expected = 16;
        int actual = avia.calculateFlightTime(ticket1);
        Assertions.assertEquals(expected, actual);
    }


    }







