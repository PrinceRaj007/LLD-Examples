package com.example.elevator.models.util;

import java.util.ArrayList;
import java.util.List;

import com.example.elevator.interfaces.ElevatorAllocationStrategy;
import com.example.elevator.interfaces.SimpleElevatorAllocationStrategy;
import com.example.elevator.models.Direction;
import com.example.elevator.models.Elevator;

public class ElevatorController {
	List<Elevator> elevators;
	ElevatorAllocationStrategy allocationStrategy;

	public ElevatorController(int size, InputHandler inputHandler) {
		// TODO Auto-generated constructor stub
		elevators = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			elevators.add(new Elevator(i, inputHandler));
		}
		allocationStrategy = new SimpleElevatorAllocationStrategy();
	}

	public void requestForElevators(int floor, Direction dir) {
		Elevator elevator = allocationStrategy.getBestElevator(elevators, floor, dir);
		System.out.println("Assigned Elevator " + elevator.getId() + " to floor " + floor);
		elevator.addPickupRequest(floor, dir);
	}

	public void startElevators() {
		elevators.forEach(Elevator::move);
	}
}
