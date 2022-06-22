package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }


    public boolean matchesFromTo(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return true;
        }
        if (ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAllWithSort(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesFromTo(ticket, from, to)) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }

}

