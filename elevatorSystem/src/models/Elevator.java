package models;

import observer.ElevatorObserver;
import state.ElevatorState;
import state.IdleState;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator implements Runnable{
    private int id;
    private int capacity; // dont include
    private AtomicInteger currentFloor;
    private Direction direction;
    private final TreeSet<Integer> upRequests;

    private final TreeSet<Integer> downRequests;
    private List<ElevatorObserver> observers;
    private ElevatorState state;
    private volatile boolean isRunning = true;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity; // dont include
        this.currentFloor = new AtomicInteger(0);
        this.direction = Direction.IDLE;
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a,b) -> b - a);
        this.state = new IdleState();
        this.observers = new LinkedList<>();
    }

    public void run() {
        while(isRunning) {
            move();
            try {
                Thread.sleep(1000);

            }catch(Exception e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }

    public void move() {
        state.move(this);
    }

    public void addRequest(ElevatorRequest request) {
        System.out.println("Elevator " + id + " processing requests");
        state.addRequest(this,request);
    }

    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer) {
        observers.remove(observer);
    }

    private void notifyStateChange(ElevatorState state) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorStateChange(this, state);
        }
    }

    private void notifyFloorChange(int floor) {
        for (ElevatorObserver observer : observers) {
            observer.onElevatorFloorChange(this, floor);
        }
    }

    public TreeSet<Integer> getDownRequests() {
        return downRequests;
    }

    public TreeSet<Integer> getUpRequests() {
        return upRequests;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor.get();
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = new AtomicInteger(currentFloor);
        notifyFloorChange(this.currentFloor.get());
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyStateChange(state);
    }

    public void stopElevator() {
        this.isRunning = false;
    }
}
