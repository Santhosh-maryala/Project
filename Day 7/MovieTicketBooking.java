import java.util.ArrayList;
import java.util.List;

// 1. Movie Class (Encapsulation)
class Movie {
    private String title;
    private int durationMinutes;

    public Movie(String title, int durationMinutes) {
        this.title = title;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() { return title; }
}

// 2. Seat Class with Category Pricing (Bonus)
class Seat {
    private int seatNumber;
    private String category; // Platinum, Gold, Silver
    private double price;
    private boolean isBooked;

    public Seat(int seatNumber, String category) {
        this.seatNumber = seatNumber;
        this.category = category;
        this.isBooked = false;
        // Bonus: Category Pricing
        switch (category.toLowerCase()) {
            case "platinum": this.price = 300.0; break;
            case "gold": this.price = 200.0; break;
            default: this.price = 100.0; // Silver
        }
    }

    public boolean isBooked() {
         return isBooked;
          }
    public void bookSeat() { 
        this.isBooked = true; 
        }
    public double getPrice() { 
        return price; 
        }
    public int getSeatNumber() { 
        return seatNumber; 
        }
    public String getCategory() { 
        return category;
         }
}

// 3. Theatre Class (Shared Resource)
class Theatre {
    private String name;
    private List<Seat> seats;

    public Theatre(String name, int totalSeats) {
        this.name = name;
        seats = new ArrayList<>();
        // Initialize seats (First half Platinum, second half Gold)
        for (int i = 1; i <= totalSeats; i++) {
            String cat = (i <= totalSeats / 2) ? "Platinum" : "Gold";
            seats.add(new Seat(i, cat));
        }
    }

    // 4. Prevent Overbooking using synchronized blocks
    public synchronized void bookTickets(String user, List<Integer> seatNumbers) {
        System.out.println(user + " is trying to book seats: " + seatNumbers);

        // Check if all requested seats are available
        for (int seatNum : seatNumbers) {
            if (seatNum > seats.size() || seats.get(seatNum - 1).isBooked()) {
                System.out.println("Booking failed for " + user + ". Seat " + seatNum + " already booked.");
                return;
            }
        }

        // If available, book them
        double totalCost = 0;
        for (int seatNum : seatNumbers) {
            Seat seat = seats.get(seatNum - 1);
            seat.bookSeat();
            totalCost += seat.getPrice();
        }
        System.out.println(user + " successfully booked " + seatNumbers + " for $" + totalCost);
    }
}

// 5. User Booking Simulation
class BookingTask implements Runnable {
    private Theatre theatre;
    private String userName;
    private List<Integer> requestedSeats;

    public BookingTask(Theatre theatre, String userName, List<Integer> requestedSeats) {
        this.theatre = theatre;
        this.userName = userName;
        this.requestedSeats = requestedSeats;
    }

    @Override
    public void run() {
        theatre.bookTickets(userName, requestedSeats);
    }
}

// Main System
public class MovieTicketBooking {
    public static void main(String[] args) {
        Theatre multiplex = new Theatre("Cinema One", 10);
        Movie movie = new Movie("Inception", 148);

        // Multiple users booking simultaneously
        Thread user1 = new Thread(new BookingTask(multiplex, "User A", List.of(1, 2)));
        Thread user2 = new Thread(new BookingTask(multiplex, "User B", List.of(2, 3))); // Conflict with User A
        Thread user3 = new Thread(new BookingTask(multiplex, "User C", List.of(5, 6)));

        user1.start();
        user2.start();
        user3.start();
    }
}
