# Java Hotel Management System Project

## Project Overview

This Java-based Hotel Management System is designed to streamline the operations of a hotel, offering various functionalities for hotel staff, managers, and administrators. The project includes several modules that handle customer check-ins, room management, employee management, and more, providing an efficient way to manage daily tasks.

## Features

- **Login System**: Separate login interfaces for staff and admins.
- **Room Management**: Manage rooms, including adding new rooms, updating room status, and searching for rooms.
- **Customer Management**: Add new customers, update customer check-out status, and view customer information.
- **Employee Management**: Add and manage employees, including viewing department and manager information.
- **Service Management**: Handle car pickup services for customers.
- **Dashboard**: An overview of the hotel's operations, giving insights to administrators.
- **Admin Features**: Admin functionalities include managing rooms, employees, and overall hotel operations.
  
## Classes

1. **AddDriver**: Manages the addition of new drivers for hotel services.
2. **AddEmployee**: Handles adding new employees to the hotel system.
3. **AddRoom**: Allows for adding new rooms to the hotel database.
4. **Admin**: Contains functionalities specific to admin users, including managing hotel-wide settings.
5. **Checkout**: Manages the process of customer check-out and updating records.
6. **CustomerInfo**: Displays detailed information about all current customers in the hotel.
7. **Dashboard**: Provides an overview of the hotel's operations and key metrics.
8. **Department**: Manages hotel departments and associated staff.
9. **Employee**: Displays and manages employee details and information.
10. **Login (Initial)**: Initial login screen for staff users.
11. **Login2 (for Admin)**: Separate login interface for admin users.
12. **ManagerInfo**: Displays information about hotel managers.
13. **NewCustomer**: Handles the process of checking in new customers and assigning rooms.
14. **PickupCarService**: Manages the car pickup services offered to customers.
15. **Reception**: Main interface for hotel receptionists to manage daily tasks.
16. **Room**: Manages room details, including availability and pricing.
17. **SearchRoom**: Allows users to search for rooms based on criteria like availability and bed type.
18. **Splash**: Splash screen displayed at the start of the application.
19. **UpdateCheck**: Manages updating of check-in and check-out statuses.
20. **UpdateRoom**: Updates room details, such as cleanliness and availability.

## Technologies Used

- **Java**: Core programming language for the project.
- **Swing**: Java library used to create the graphical user interface (GUI).
- **MySQL**: Database used to store and retrieve hotel information (customers, rooms, employees, etc.).
- **JDBC**: Java Database Connectivity (JDBC) for connecting and executing queries on the MySQL database.
- **NetBeans/IntelliJ/Eclipse**: IDEs that can be used to run and debug the project.

## Future Improvements

- **Reporting Module**: Generate reports on hotel performance, customer statistics, and financial summaries.
- **Enhanced Security**: Implement role-based access control for finer-grained permission management.
- **Mobile Integration**: Build a mobile app for hotel staff to manage operations on the go.
