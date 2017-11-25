# [CSE3063: First Project: Monopoly Game in Java](https://github.com/muhammeddkilicc/cse3063f17p1_mkilic_obayraktar_masakalli "CSE3063 Java Project")
Repository Name: cse3063f17p1_mkilic_obayraktar_masakalli

### Contributors

__*[Mehmet Ali Sakallı](https://github.com/mehmetalisakalli)-150114080*__ :sparkles:

__*[Muhammed Kılıç](https://github.com/muhammeddkilicc/)-150115048*__ :octocat:

__*[Onur Bayraktar](https://github.com/onurbayraktar)-150114079*__ :rocket:



### Iteration 3 To Do List
##### Due Date : Sun, November 26, 14:00
- [x] All trace of activity should be printed to the screen and to a text file named monopoly-output.txt simultaneously. One of these monopoly-output.txt files from your runs must be loaded to GitHub. 
- [x] Lots
- [x] Railroads
- [x] Utility Squares
- [x] Players who land on these squares may buy them
- [x] If the square is owned by the player that landed on it, nothing happens
- [x] If the square is owned by a player other than the one that landed on it, the player that landed on the square must pay its owner rent
- [x] There are NO colors or names for the Lots. You will use square numbers from 1 to 40 e.g. "Square2", "Square4" as names when you are printing messages to the screen. The position of these Lot squares, their price, and their rent will be read from a comma separated text file. An example of such file is given as a attachment.
- [x] There are two Utility Squares at positions 13 and 29, named as "ElectricUtility" and "WaterUtility". The price for a utility square is 150. We simplify the the "rent" rules for these, a player who lands on these squares will pay the owner 10 times the roll of a dice.
- [x] There are four railroad squares at positions 6,16,26,and 36 named as "RailRoad1",  "RailRoad2", "RailRoad3", "RailRoad4". The price for a railroad square is 200. A player who lands on these squares will pay the owner 5 times the roll of a dice plus 25.
- [x] Jail (Square 11) and go to jail (Square 31) squares are as in the 2nd iteration implementations.
- [x] Income tax (Square 5) and Luxury Tax (Square 39) are as in the 2nd iteration implementations. 
- [x]  A simulated player decide to buy a property randomly. When a player lands on a  property square (lot, utility, or railroad square), first checks if the square is owned. If not, rolls a dice. If the dice value is larger than 4 and if the player has enough cash, it buys the square. 
- [x]  END OF GAME: A player go to bankrupt if it can not pay a rent or tax. A player to go bankrupt retires from the game. The simulation ends when a single player left in the game.
- [x] The number of players and initial cash of the players (same for all players) should be taken from the user from the command line. 

### Iteration 2 To Do List
##### Due Date : Thu, November 9, 14:00
- [x] Go square,Jail square,Free Parking square,Income Tax square,Luxury Tax square,


 ### Iteration 1 To Do List
 ##### Due Date : Thu, October 26, 14:00

- [x] Requirement Analysis Document (CSE3063F17P1_RAD_mkilic_obayraktar_masakalli_iteration1.pdf)
- [x] Domain Model as an partial UML class diagram (CSE3063F17P1_DOMAINMODEL_mkilic_obayraktar_masakalli_iteration1.pdf)
- [x] UML class diagram (CSE3063F17P1_DCD_mkilic_obayraktar_masakalli_iteration1.pdf)
- [x] UML Sequence Diagram(s) (CSE3063F17P1_DSD_mkilic_obayraktar_masakalli_iteration1.pdf)
- [x] Java Code


## [Issues](https://github.com/muhammeddkilicc/cse3063f17p1_mkilic_obayraktar_masakalli/issues)

## Sample Code Block

``` java
// this is a sample java code
public Main{
 public static void main(String args[]){
  System.out.println("Hello Object Oriented");
 }
}
```
