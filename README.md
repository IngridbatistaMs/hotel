# Hotel Service

```mermaid
classDiagram
    class Hotel {
        Long id
        String name
        String address
    }

    class Room {
        Long id
        RoomType type
        BigDecimal price
    }

    class Guest {
        Long id
        String name
        String email
    }

    class Reservation {
        Long id
        LocalDate checkIn
        LocalDate checkOut
    }

    class RoomType {
        <<enumeration>>
        DOUBLE
        TRIPLE
        FAMILY
    }

    Hotel "1" --> "0..*" Room : contains
    Room "1" --> "0..*" Reservation : booked_for
    Guest "1" --> "0..*" Reservation : makes
    Room "0..*" --> "1" Hotel : belongs_to
    Reservation "0..*" --> "1" Room : in
