# AutomateTicketBooking

Feature: Book Ticket

  I want to book a ticket in SpiceJet

  Scenario: Book Ticket from Delhi to Kolkata

    Given I Open URL "https://www.spicejet.com/" and launch driver

    When I search ticket from "Delhi" to "Kolkata" Depart on "28-June-2025" return on "29-June-2025"

    Then I close driver
