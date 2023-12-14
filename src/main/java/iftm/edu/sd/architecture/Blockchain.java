package iftm.edu.sd.architecture;

import iftm.edu.sd.entities.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {

    private ArrayList<Block> chain;
    private ArrayList<Transaction> currentTransactions;

    public Blockchain() {
        this.chain = new ArrayList<>();
        this.currentTransactions = new ArrayList<>();
        // Adicionando o bloco inicial (genesis block)
        addBlock(new Block(0, new Date().getTime(), currentTransactions, "0"));
    }

    public void addTransaction(Transaction transaction) {
        currentTransactions.add(transaction);
    }

    public void addBlock(Block block) {
        block = mineBlock(block);
        chain.add(block);
        currentTransactions = new ArrayList<>();
    }

    private Block mineBlock(Block block) {
        while (!block.getHash().substring(0, 4).equals("0000")) {
            block = new Block(block.getIndex(), block.getTimestamp(), block.getTransactions(), block.getPreviousHash() + 1);
        }
        System.out.println("Bloco minerado: " + block.getHash());
        return block;
    }

    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println("Index: " + block.getIndex());
            System.out.println("Timestamp: " + block.getTimestamp());
            System.out.println("Transactions: \n") ;
            for (Transaction t : block.getTransactions()) {
                System.out.println(t.toString());
            }
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println();
        }
    }

    public ArrayList<Block> getChain() {
        return chain;
    }

    public void setChain(ArrayList<Block> chain) {
        this.chain = chain;
    }

    public ArrayList<Transaction> getCurrentTransactions() {
        return currentTransactions;
    }

    public void setCurrentTransactions(ArrayList<Transaction> currentTransactions) {
        this.currentTransactions = currentTransactions;
    }
}
