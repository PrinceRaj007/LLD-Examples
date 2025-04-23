package com.example.elevator.interfaces;

import java.util.List;

import com.example.elevator.models.Direction;
import com.example.elevator.models.Elevator;

public interface ElevatorAllocationStrategy {
	public Elevator getBestElevator(List<Elevator> elevators, int floor, Direction dir);
}
