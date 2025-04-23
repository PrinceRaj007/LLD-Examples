package com.example.elevator.interfaces;

import java.util.Comparator;
import java.util.List;

import com.example.elevator.models.Direction;
import com.example.elevator.models.Elevator;

public class SimpleElevatorAllocationStrategy implements ElevatorAllocationStrategy{

	@Override
	public Elevator getBestElevator(List<Elevator> elevators, int floor, Direction dir) {
		Elevator best = elevators.stream().filter(e->e.isAvailableForRequest(floor, dir))
				.min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor)))
                .orElse(null); 
		return best==null ? elevators.get(0) : best;
	}
}
