# AutomateTicketBooking

Feature: Book Ticket

  I want to book a ticket in BlazeDemo

  Scenario: Book Ticket from Philadelphia to Rome

    Given I Open URL "https://blazedemo.com/index.php" and launch driver

    When I search ticket from "Philadelphia" to "Rome" Depart

    Choose the flight with lowest price

    Filling the booking form and submitting it
    
    Validating the final message
    
    Then I close driver
