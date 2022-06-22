package ru.netology.repository.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(321, 38_000, "AVA", "MAU", 394);
    Ticket ticket2 = new Ticket(214, 24_500, "VDO", "UTA", 394);
    Ticket ticket3 = new Ticket(793, 52_000, "NRE", "LON", 394);
    Ticket ticket4 = new Ticket(818, 76_000, "POS", "SOL", 394);
    Ticket ticket5 = new Ticket(496, 121_800, "TEL", "DEO", 394);
    Ticket ticket6 = new Ticket(167, 21_000, "MIO", "PER", 394);


    @Test
    public void findAll() {
        Ticket ticket = new Ticket();
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);


        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void removeById() {
        Ticket ticket = new Ticket();
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);

        repository.removeById(793);
        repository.findAll();

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};

        assertArrayEquals(actual, expected);
    }


}