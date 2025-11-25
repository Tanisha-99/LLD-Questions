package models;

public class ElevatorRequest {
    private RequestSource source;
    private Direction direction; // for external requests
    private int floor; // for internal requests

    public ElevatorRequest(RequestSource requestSource, Direction direction, int floor) {
        this.direction = direction;
        this.source = requestSource;
        this.floor = floor;
    }

    public ElevatorRequest(int floor) {
        this.floor = floor;
        this.source = RequestSource.INTERNAL;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public RequestSource getSource() {
        return source;
    }

    public void setSource(RequestSource source) {
        this.source = source;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isInternalRequest() {
        return source == RequestSource.INTERNAL;
    }

}
