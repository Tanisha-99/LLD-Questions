package utilityClasses;

import java.util.*;

public class Snake {
    /*
    to store positions of snake body used deque because
    1. if encountered a food, length is to be increased so we can simply insert at front
    2. if didn't encountered a food item, we need to move the entire body by 1 place so we can insert at front and remove one from rear.

    So all operations - eating, moving can be done in O(1)
     */

    private Deque<Position> body;

    // for checking collision with itself in O(1)
    private Map<Position, Boolean> positionMap;

    public Snake() {
        /*
        using ArrayDeque and not LinkedList because
        1. dont need random access LinkedLis do support random access by iteration but here it is not needed
        2. Linkedlist stores the node object and 2 pointers per node - prev and next while array deque stores just the data array hence it is more memory efficient
        3. Array deque dynamically resizes itself but never stores null, linkedlist would allow that but it is not needed here
        4. arraydeque is more cache friendly
         */

        this.body = new ArrayDeque<>();
        this.positionMap = new HashMap<>();

        Position initialPosition = new Position(0, 0);
        this.body.offerFirst(initialPosition);
        this.positionMap.put(initialPosition, true);
    }

    public Deque<Position> getBody() {
        return body;
    }

    public Map<Position, Boolean> getPositionMap() {
        return positionMap;
    }
}
