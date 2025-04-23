package com.example.elevator;

import com.example.elevator.models.Direction;
import com.example.elevator.models.util.ElevatorController;
import com.example.elevator.models.util.InputHandler;

public class ElevatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputHandler inputHandler = new InputHandler();
		ElevatorController controller = new ElevatorController(5, inputHandler);
		controller.requestForElevators(3, Direction.UP);
		controller.requestForElevators(5, Direction.DOWN);
		controller.requestForElevators(8, Direction.UP);
		for(int i=0;i<20;i++) {
			controller.startElevators();
		}
	}

}
