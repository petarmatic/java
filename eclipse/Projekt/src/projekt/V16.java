package projekt;

import java.util.Stack;

public class V16 {

	public static void main(String[] args) {
		int[] in2 = { 8, 8, 5, 7, 9, 8, 7, 4, 8 };
		// String in2 = "([)()]";
		int result = solution(in2);
		System.out.println(result);

	}
	
	 public static int solution(int[] H) {
		Block currentBlock = new Block(0, H[0]);
		Stack blockStack = new Stack();

		blockStack.add(currentBlock);
		int blocksRequired = 1;
		
		for (int i = 1; i < H.length; i++) {
			Block topStackBlock = (Block) blockStack.peek(); // remove any stack blocks that are taller than current
			// block
			while (topStackBlock.upperHeight > H[i]) {
				blockStack.pop();
				if (!blockStack.isEmpty()) {
					topStackBlock = (Block) blockStack.peek();
				} else {
					break;
				}
			}
			if (blockStack.isEmpty()) {
				blockStack.push(new Block(0, H[i]));
				blocksRequired++;
			}
			else if ( ((Block)blockStack.peek()).upperHeight - H[i] == 0) {
				continue;
			}
			else {
				topStackBlock = (Block) blockStack.peek();
				blockStack.push(new Block(topStackBlock.upperHeight, H[i]));
				blocksRequired++;
			}
		}
		
		 
		 return blocksRequired;
	 }
}
	 
	  class Block {
			int lowerHeight;
			int upperHeight;

			Block(int pLowerHeight, int pUpperHeight) {
				lowerHeight = pLowerHeight;
				upperHeight = pUpperHeight;
			}
	 

}
