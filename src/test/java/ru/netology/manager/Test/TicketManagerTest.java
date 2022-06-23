package ru.netology.manager.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

public class TicketManagerTest {


    Ticket ticket1 = new Ticket(321, 38_000, "AVA", "MAU", 217);
    Ticket ticket2 = new Ticket(214, 24_500, "AEL", "DEO", 618);
    Ticket ticket3 = new Ticket(793, 52_000, "AVA", "LON", 301);
    Ticket ticket4 = new Ticket(818, 76_000, "PKS", "SUL", 214);
    Ticket ticket5 = new Ticket(496, 121_800, "TEL", "DEO", 222);

    @Test
    void findAllWithSort() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.findAllWithSort("AVA", "DEO");
        Ticket[] expected = {ticket2, ticket1, ticket3, ticket5};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void findEmptyRepository() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        repository.removeById(793);

        Ticket[] actual = manager.findAllWithSort("AVA", "DEO");
        Ticket[] expected = {ticket2, ticket1, ticket5};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void emptyRepository1() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket1);

        repository.removeById(321);

        Ticket[] actual = manager.findAllWithSort("AVA", "DEO");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void emptyRepository() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);


        Ticket[] actual = manager.findAllWithSort("AVA", "DEO");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);

    }

}
