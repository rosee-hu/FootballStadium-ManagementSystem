# 🎟️ CIS 321 – Ticket Booking System

## Project Overview
A user-friendly stadium ticket booking system designed to improve customer service and reduce wait times. The system allows users to book tickets, reserve services (e.g., parking, food), and manage match-related data. Admins have full control over ticket and service management.

## System Features
- Admin and user roles
- Ticket booking and cancellation
- Match and stadium information
- Add-on services (e.g., snacks, parking)
- Payment integration

## Database Entities
- **User**: personal details and login
- **Admin**: admin credentials
- **Tickets**: ticket details and seat type
- **Match**: teams, date, time
- **Stadium**: name, city, capacity
- **Services**: food and drink options
- **Payment**: card and price details

## Key Relationships
- One user/admin can manage multiple tickets
- Each ticket is linked to a payment and match
- Matches are hosted in stadiums
- Tickets can include optional services
