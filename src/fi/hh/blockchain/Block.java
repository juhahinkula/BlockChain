package fi.hh.blockchain;

import java.util.Calendar;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class Block {
	private String hash, previousBlockHash, data;
	private long blockTimeStamp;
	
	public Block(String previousBlockHash, String data) {
		super();

		this.previousBlockHash = previousBlockHash;
		this.data = data;

		Calendar date = Calendar.getInstance();
		this.blockTimeStamp = date.getTimeInMillis();
		
		this.hash = this.calculateBlockHash(data + Long.toString(this.blockTimeStamp) + previousBlockHash);
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPreviousBlockHash() {
		return previousBlockHash;
	}

	public void setPreviousBlockHash(String previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	// Calculate Hash for the block
	// Using Google Guava library v 19.0
	private String calculateBlockHash(String blockContent) {
		HashFunction hf = Hashing.sha256();		
		HashCode hc = hf.hashString(blockContent, Charsets.UTF_8);
		return hc.toString();		
	}

	@Override
	public String toString() {
		return "Block [hash=" + hash + ", previousBlockHash=" + previousBlockHash + ", data=" + data
				+ ", blockTimeStamp=" + blockTimeStamp + "]";
	}
	
	
}
