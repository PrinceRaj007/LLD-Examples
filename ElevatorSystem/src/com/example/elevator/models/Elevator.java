package com.example.elevator.models;

import java.util.List;
import java.util.TreeSet;

import com.example.elevator.models.util.InputHandler;

public class Elevator {
	int id;
	Direction direction;
	int currentFloor;
	TreeSet<Integer> upDestinationFloorReq;
	TreeSet<Integer> downDestinationFloorReq;
	InputHandler inputHandler;

	public Elevator(int id, InputHandler inputHandler) {
		this.id = id;
		this.inputHandler = inputHandler;
		direction = Direction.IDLE;
		currentFloor = 0;
		upDestinationFloorReq = new TreeSet<Integer>();
		downDestinationFloorReq = new TreeSet<Integer>();
	}

	public void move() {
		
		// Before moving check if direction where we have to move have any req left
		if (direction == Direction.UP && upDestinationFloorReq.isEmpty()) {
			direction = downDestinationFloorReq.isEmpty() ? Direction.IDLE : Direction.DOWN;
		} else if (direction == Direction.DOWN && downDestinationFloorReq.isEmpty()) {
			direction = upDestinationFloorReq.isEmpty() ? Direction.IDLE : Direction.UP;
		}else if (direction == Direction.IDLE) {
            if (!upDestinationFloorReq.isEmpty()) direction = Direction.UP;
            else if (!downDestinationFloorReq.isEmpty()) direction = Direction.DOWN;
        }
		// Now check if direction is UP elevator should go to next floor, if it is DOWN
		// it should to below floor
		if (direction == Direction.UP) {
			currentFloor++;
			System.out.println("Elevator: " + id + " going UP, Current Floor: " + currentFloor);
		} else if (direction == Direction.DOWN) {
			currentFloor--;
			System.out.println("Elevator: " + id + " going DOWN, Current Floor: " + currentFloor);
		}
		// Now check if the elevator has to stop and open it's door at current floor
		// Here we used contains(), we could have also used first() and last() func with
		// up and down list respectively
		if ((direction == Direction.UP && upDestinationFloorReq.contains(currentFloor))
				|| (direction == Direction.DOWN && downDestinationFloorReq.contains(currentFloor))) {
			openDoor();
			// remove the floor from the req List
			removeFloor(currentFloor);
			List<Integer> destFloors = inputHandler.getDestinationFloorRequest();
			destFloors.stream().forEach(this::addDestination);
			closeDoor();
		}

	}

	private void removeFloor(int floor) {
		if (direction == Direction.UP) {
			upDestinationFloorReq.remove(floor);
		} else if (direction == Direction.DOWN) {
			downDestinationFloorReq.remove(floor);
		}
	}

	public void addDestination(int floor) {
		if (floor > currentFloor) {
			upDestinationFloorReq.add(floor);
		} else if (floor < currentFloor) {
			downDestinationFloorReq.add(floor);
		}
	}

	public void openDoor() {
		System.out.println("Elevator Door OPENING at Floor: " + currentFloor);
	}

	public void closeDoor() {
		System.out.println("Elevator Door CLOSING at Floor: " + currentFloor);
	}

	public int getId() {
		return id;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public boolean isAvailableForRequest(int floor, Direction dir) {
		return direction == Direction.IDLE
				|| (dir == Direction.UP && direction == Direction.UP && floor >= currentFloor)
				|| (dir == Direction.DOWN && direction == Direction.DOWN && floor <= currentFloor);
	}
	public void addPickupRequest(int floor, Direction dir) {
		if(dir == Direction.UP) {
			upDestinationFloorReq.add(floor);
		}else if(dir == Direction.DOWN) {
			downDestinationFloorReq.add(floor);
		}
	}
}
