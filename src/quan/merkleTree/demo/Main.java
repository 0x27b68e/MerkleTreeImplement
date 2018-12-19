package quan.merkleTree.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> transactionList = new ArrayList<String>();
		transactionList.add("Transaction 1");
		transactionList.add("Transaction 2");
		transactionList.add("Transaction 3");
		transactionList.add("Transaction 4");
		
		
		MerkleTree merkleTree = new MerkleTree(transactionList);
		merkleTree.createMerkleTree();
		
		System.out.println(merkleTree.getRoot());
		
	}
}
