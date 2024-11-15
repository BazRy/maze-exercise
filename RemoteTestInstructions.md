﻿# Maze Test - V4

When returning the completed test, could you please complete it in **Java 21** and send it as a zip file; we are unable to access various links on our systems.
If using Maven, run an 'mvn clean' prior to packaging it, or ensure that your submission does not contain any .sh, .bat, .class or other files that could otherwise
be blocked.

Please **do not publish your submission** to Github or any other public repository, this test is proprietary and should not be made public.
We are aware that there are a number of solutions to this test available on the Internet, copied submissions will be identified and immediately disqualified.
By submitting your solution to us you assert that it is wholly your original work and not a copy.

We recognize that you may have questions about these requirements. For the purpose of this test, please make an assumption about the answer and note your assumptions in a readme.txt submitted with your solution. You should be ready to explain any assumptions and technical choices you have made during later interview stages.

There is no stated time limit but allow at least half a day. The important thing is to arrive at a solution that you are satisfied with and comfortable discussing with others.

The code must be representative of what you would produce “on the job”, by that we mean the code must be clear, maintainable, bug free and efficient.

The zipped project is for IntelliJ and uses Maven; you should feel free to use any other tools you are more comfortable with.
There are four classes in it and you should feel free to change these in any way you see fit, including deleting them and starting again.

The test is based on exploring any arbitrary maze (one is provided).


## User Story 1

As a world famous explorer of Mazes I would like a maze to exist
So that I can explore it

### Acceptance Criteria

1. A Maze (as defined in Maze1.txt) consists of walls 'X', empty spaces ' ', one and only one start location 'S', and at least one exit location 'E' 
2. After a maze has been created the number of walls, empty spaces and exit locations should be available to me 
3. After a maze has been created I should be able to put in a co-ordinate and know what exists at that location


## User Story 2

As a world famous explorer of Mazes I would like to exist in a maze and be able to navigate it
So that I can explore it

### Acceptance Criteria

1. Given a maze the explorer should be able to drop in to the Start location (facing north)
2. An explorer on a maze must be able to move forward 
3. An explorer on a maze must be able to only turn left or right (changing direction the explorer is facing)
4. An explorer on a maze must be able to declare what is in front of them 
5. An explorer on a maze must be able to declare all movement options from their given location 
6. An explorer on a maze must be able to declare the number of times they have moved forward so far 
7. An explorer on a maze must be able to report a record of where they have been in an understandable fashion


**Note:** We are looking for Explorer solutions that demonstrate they have successfully implemented the above Acceptance criteria.
Please do not submit a fully autonomous maze solving Explorer implementation.
