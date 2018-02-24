package fi.hh.blockchain;

public class BlockChainApp {

	public static void main(String[] args) {
		Block b1 = new Block("first", "This is the first block");
		Block b2 = new Block(b1.getHash(), "This is the second block");
		Block b3 = new Block(b2.getHash(), "This is the third block");
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());
	}

}
