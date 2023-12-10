Readme








GROUP MEMBERS _
1. Grishma Bellani -2022189
2. Shubham Kumar Dwivedi -2022494


The StickHeroGame project was made using javaFx and java language.
In this The increase StickLength is done by pressing on the touchpad/mouse continuously for the instant of time.


The character flip method to collect cherries is done by pressing “F” key of the keyboard.

Any button the screen works by pressing on the mouse/touchpad and releasing.

The buttons made are-
1.play button on the Start screen
2.Revive button on GameOverScreen
3.Replay button on the GameOverScreen
4.Revive Button on the GamesOverScreen.


We Have made 3 Fxml files-
1.StartScreen
2.GameScreen
3.GameOverSCreen



The Various Design Patterns are used-


Singleton Pattern:


The Player class has a private static instance of itself, and a public static method (getInstance()) to get that instance. This ensures that only one instance of Player can exist



Strategy Pattern:
The Revivable interface and the ReviveFeature class use the strategy pattern. The ReviveFeature class encapsulates the algorithm for reviving the character, and different strategies for revival can be implemented by other classes that implement the Revivable interface.
Observer Pattern:
The methods like switchToStartScreen, switchToGameScreen, and switchToGameOverScreen can be considered as events that notify observers (other parts of the application) about state changes.
The StickHeroController class interacts with an external score list (List<Integer> scoreList) which can be considered an observation mechanism.
Example: The StickHeroController class implements a scoring mechanism (updateScore(int score)) and notifies observers (possibly a UI) of the changes.
State Pattern:
The variable characterFlippedUp and the methods flipCharacterDown and flipCharacterUp suggest a simple state pattern where the character's state (flipped up or down) is managed.
Factory Method Pattern:
The method generateCherries can be seen as a factory method for creating cherry objects. The Cherry class, or an interface implemented by it, represents the product created by this factory.
Command Pattern:
The method cartoon turn act as commands triggered by user input. The commands are encapsulated and can be executed, providing a level of abstraction.

The increasing stickPressed and increasing stickReleased methods may represent a form of command pattern where different events trigger actions.
Composite Pattern:
The Group class creates a group of rectangles (G1). The composite pattern allows for treating individual objects and compositions of objects uniformly.
Template Method Pattern:
The methods like generatePillars can be seen as template methods. They define the skeleton of the algorithm, allowing subclasses (Rectangle objects) to alter specific algorithm steps without changing its structure. These are just high-level observations, and the actual design patterns might vary based on the complete context and interactions within the application.
Also, it used soo many patterns that can’t be explained explicitly.













Classes:
. Player: Represents the game player, managing player state and actions.

Cherry: Defines the cherry object in the game, including its position and visibility.

ReviveFeature: Implements the revival mechanism for the player.

StickHeroController: Controls the game logic, player actions, and transitions between game screens.

StickHeroEngine: Manages the core game engine, updating game states and handling game mechanics.

StartScreen: Displays the initial screen with options to start or view tutorials.

GameScreen: Represents the main game screen, handling gameplay elements.

GameOverScreen:  Displays the game-over screen with the player's score.

JUnit Test Cases:
PlayerTest: Tests functionalities and behaviours of the Player class.

StickHeroControllerTest: Tests the game logic and controller functionalities.

StickHeroControllerTest1: Another set of tests for the StickHeroController class, likely covering additional scenarios or edge cases.



Used files to store the game scores.

GitHub Repository Link: 
GitHub Link



