package com.example.elevator.models.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
	
	public List<Integer> getDestinationFloorRequest(){
		List<Integer> destFloors = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("\tPeople Entering in the Elevator");
		System.out.println("\tEnter the number of people Entered: ");
		int n = scanner.nextInt();
		for(int i=0;i<n;i++) {
			int desFloor = scanner.nextInt();
			destFloors.add(desFloor);
		}
		return destFloors;
	}
}
