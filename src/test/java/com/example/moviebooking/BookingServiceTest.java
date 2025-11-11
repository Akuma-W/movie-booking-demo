package com.example.moviebooking;

import com.example.moviebooking.exception.SeatAlreadyBookException;
import com.example.moviebooking.model.Movie;
import com.example.moviebooking.model.Seat;
import com.example.moviebooking.model.Showtime;
import com.example.moviebooking.model.Ticket;
import com.example.moviebooking.repository.MovieRepository;
import com.example.moviebooking.service.BookingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private BookingService service;

    @BeforeEach
    void setup() {
        MovieRepository repository = new MovieRepository();
        Seat s1 = new Seat("A1");
        Seat s2 = new Seat("A2");
        Showtime st = new Showtime("ST01", LocalDateTime.now(), List.of(s1, s2));
        repository.addMovie(new Movie("M01", "Inception", List.of(st)));

        service = new BookingService(repository);
    }

    @Test
    void testBookTicketSuccessfully() {
        Ticket ticket = service.bookTicket("Inception", "ST01", "A1");
        assertEquals("A1", ticket.getSeatNumber());
    }

    @Test
    void testBookAlreadyBookedSeatThrowsException() {
        service.bookTicket("Inception", "ST01", "A2");
        assertThrows(SeatAlreadyBookException.class, () ->
                service.bookTicket("Inception", "ST01", "A2"));
    }

    @Test
    void testBookInvalidMovie() {
        assertThrows(IllegalArgumentException.class, () ->
                service.bookTicket("Avatar", "ST01", "A1"));
    }
}
