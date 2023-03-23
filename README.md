# emailapp

This code is a Java program for a simple email application. 
It allows a user to create an email account with a randomly generated password,
select a user, and perform actions such as changing the password,
setting the mailbox capacity, and setting an alternate email address.

The program consists of a Main class and a User class. The User class defines the properties
and behaviors of a user, while the Main class contains the main method and the user interface (UI) logic.

The Main class uses a userManager object to manage a list of users. The UI logic is implemented using a switch statement,
which accepts user input and performs the appropriate action based on the command entered.

The newEmail() method creates a new email address for a user based on their first name, last name, and department. 
The newPassword() method generates a random password for a user. 
The changePassword() method allows the user to change their password. 
The mailboxCapacity() method allows the user to set the mailbox capacity. 
The setAlterEmail() method allows the user to set an alternate email address. 
The isEmailValid() method validates whether an email address is in the correct format.

The program also contains the commands.txt file, which stores information about the commands available in the program.
This information can be obtained in the application by typing "commands".
