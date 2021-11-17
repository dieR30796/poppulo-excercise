poppulo-excercise

Simple Rest interface for a lottery system.

Some endpoints stood up:
/ticket (POST) - Handles creating new tickets, takes numberOfLines parameter to generate amount of lines for ticket.

/ticket (GET) - Retrieves all tickets.

/ticket/{id} (GET) - Gets ticket by ID.

/ticket (PUT) - Adds more lines, takes in numberOfLines and id and if ticket not checked yet it will add number of lines to ticket.

/ticket/status/{id} (PUT) - Retrieves status of ticket by ID, gets sorted list by value and sets ticket checked if not already set.

Included exported Postman requests used to quickly test endpoints.
