//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to snake and food game !");


    }
}

/*
1. Snake moves in a grid based environment of specific width and height
2. player controls the snake movement direction
3. snake grows when it eats the food
4. Game ends when it collides with wall or itself
5. supports food placement and consumption mechanisms - different types of food items
6. Tracks the game score


Entities

1. food item
2. game board
3. board interface
4. player
5. snake
6. position


Patterns

1. Strategy pattern for snake movement
2. Factory pattern for food creation and placement (normal, poisonous, special)
3. Observer design pattern for score updates
 */