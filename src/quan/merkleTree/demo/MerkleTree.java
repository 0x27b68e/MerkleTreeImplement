package quan.merkleTree.demo;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
	
	private List<String> transactionList;
	private String root = "";
	
	
	public MerkleTree(List<String> transactionList) {
		super();
		this.transactionList = transactionList;
	}
	
	public void createMerkleTree() {
		
		List<String> hashList = convertFromTransactionToHash(transactionList);
		// đệ qui
		while (hashList.size() != 1) {
			hashList = convertFromTransactionToHash(hashList);
		}
		this.root = hashList.get(0);
	}
	
	
	
	
	private List<String> convertFromTransactionToHash(List<String> listTransaction) {
		
		List<String> hashList = new ArrayList<String>();
		int index = 0;
		while (index < listTransaction.size()) {
			//left
			String left = listTransaction.get(index);
			index++;
			
			// right
			String right = listTransaction.get(index);
			// sha hash value
			String hash = sha256Helper(left + right);
			hashList.add(hash);
			index++;
		}
		
		return hashList;
		
	}
	
	
	// get SHA256
	public String sha256Helper(String string) {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] stringToBytes = string.getBytes("UTF-8");
			byte[] hash = md.digest(stringToBytes);
			
			for (int i = 0; i < hash.length; i++) {
				String hexString = Integer.toHexString(0xff & hash[i]);
				if(hexString.length() == 1) {
					stringBuffer.append(0);
				}
				stringBuffer.append(hexString);
			}
			return stringBuffer.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}
	
	
	public List<String> getTransactionList() {
		return transactionList;
	}


	public void setTransactionList(List<String> transactionList) {
		this.transactionList = transactionList;
	}


	public String getRoot() {
		return root;
	}


	public void setRoot(String root) {
		this.root = root;
	}
	
}
