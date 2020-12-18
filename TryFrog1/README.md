# Key Changes

_This project was refactored in a manner that enhances object-oriented key principles and code maintainability._

- Ensured encapsulation in all classes by making variables either protected or private and making setters and getters for needed ones.

- Applied Single responsibility by breaking down large classes and methods into more meaningful and concise ones, e.g., in Player.class (formerly known as Animal.class) the handling of events such as death, out of bounds and restoration were separated from act method into individual methods.—created addimage methods into animating classes to add specific images to the animation—separated setting the score from the GameStage class into the digit class, which is responsible for setting all digit related attributes.

- Improved Inheritance and Polymorphism by grouping similar classes and making them inherit from a base class, but also maintaining individual methods. For Example, Floatable: a group of classes that float on water and can carry a player, e.g., Crocodile, Log, Turtle, and Wet Turtle. which also significantly reduces intersection checking calls in Player class.

- Cleaned up the start method and moved all game components into GameStage (formerly known as Mystage).

- Applied an MVC pattern by creating models, views and controllers for classes such as the round timer. Distributed all the classes that hold the functionality of the program into the model package, the views, such as the scene manager into the view, and classes connecting the game visuals and functionality into the controller package. Additionally, organised the classes inside these packages into more informative ones.

- Modified boundaries, sizes and alignments of all actors in a more accurate manner for an enhanced user experience. For Example, the amount of movement of player, sizes of cars(formerly known as obstacle) and edited some images.

- Used a Maven build file to make building the project and any consequent elements more manageable. Created a Maven wrapper for the project, which makes it easily runnable on any platform without the need for hard coding any runtime arguments or dependencies.

# Additions

_When adding to the base project I ensured to follow the classic Frogger game, but not entirely for the sake of creativity_

- Added ten levels to the game through GenerateNewLevel method. Difficulty increases as the player advances in levels.

- Added four lives for player. The game ends when the player runs out of lives.

- Added a round timer; it resets if the player dies or reaches a swamp and rewards the player 10 points for every second left at the end of every level.

- Added new actors into the game: Bonus ones, such as lady frog and flies, and enemies such as crocodiles and snakes.

- Added a main menu, info and game over scene.

- Added a permanent high scores file, which stores a list of high scores that can be manipulated and extracted to show the highest score during the game and the leader board list at the end scene.

- Added an individuality feature, where at the start of each game the user can enter their name and compete for the leader board
