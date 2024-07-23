# Hotel Service

## Systema de gerenciamento de reserva de um hotel

### Open API
- localhost:8080/swagger-ui/index.html

### Tecnologias Utilizadas

- **Java** 17
- **Spring Boot** 3.3.2
- **Spring Data JPA**
- **Hibernate**
- **Gradle**
- **H2 Database**
- **PostgreSQL**

### Diagrama de Classes

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
