package Ponavljanje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPostiitons= new ArrayList<Integer>();
	static ArrayList<Integer> cpuPostiitons= new ArrayList<Integer>();

	public static void main(String[] args) {
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, 
				{ '-', '+', '-', '+', '-' }, 
				{ ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, 
				{ ' ', '|', ' ', '|', ' ' } };

		printGameBoard(gameBoard);
//
//		for (char [] row : gameBoard) {
//			for (char c : row) {
//				System.out.print(c);
//			}
//			System.out.println();
		// ovo moeže u metodi

		
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement(1-9)");
			int playerPos = scan.nextInt();
			while(playerPostiitons.contains(playerPos) || cpuPostiitons.contains(playerPostiitons)){
				System.out.println("Positions taken!Enter Correct Positions");
				playerPos=scan.nextInt();
			}
			

			// ovo u metodu
//		switch(pos) {
//		case 1:
//			gameBoard [0] [0]= 'X';
//			break;
//		case 2:
//			gameBoard [0] [2]= 'X';
//			break;
//		case 3:
//			gameBoard [0] [4]= 'X';
//			break;
//		case 4:
//			gameBoard [2] [0]= 'X';
//			break;
//		case 5:
//			gameBoard [2] [2]= 'X';
//			break;
//		case 6:
//			gameBoard [2] [4]= 'X';
//			break;
//		case 7:
//			gameBoard [4] [0]= 'X';
//			break;
//		case 8:
//			gameBoard [4] [2]= 'X';
//			break;
//		case 9:
//			gameBoard [4] [4]= 'X';
//			break;
//		
//		}

			placePiece(gameBoard, playerPos, "player");
			String result=checkWinnger();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}

			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while(playerPostiitons.contains(cpuPos) || cpuPostiitons.contains(cpuPos)){
				cpuPos = rand.nextInt(9) + 1;
				
			}
			placePiece(gameBoard, cpuPos, "cpu");
			printGameBoard(gameBoard);
			
			result=checkWinnger();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
		}

	}

	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();

		}

	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPostiitons.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPostiitons.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;

		}

	}
	
	public static String checkWinnger() {
		
		List topRow=Arrays.asList(1,2,3);
		List middleRow=Arrays.asList(4,5,6);
		List bottomRow=Arrays.asList(7,8,9);
		List leftCol=Arrays.asList(1,4,7);
		List middleCol=Arrays.asList(2,5,8);
		List rightCol=Arrays.asList(3,6,9);
		List cross1=Arrays.asList(1,5,9);
		List cross2=Arrays.asList(7,5,3);
		
		List<List> winning= new ArrayList<List>();
		winning.add(topRow);
		winning.add(middleRow);
		winning.add(bottomRow);
		winning.add(leftCol);
		winning.add(middleCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l : winning) {
			if(playerPostiitons.containsAll(l)) {
				return "Congrats you win";
			}else if (cpuPostiitons.containsAll(l)) {
				return "cpu Wins";
			} else if(playerPostiitons.size() + cpuPostiitons.size() == 9)
				return "CAT";
			}
		
		return "";
		
	}
}
