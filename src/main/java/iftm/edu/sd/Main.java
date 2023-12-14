package iftm.edu.sd;

import iftm.edu.sd.architecture.Block;
import iftm.edu.sd.architecture.Blockchain;
import iftm.edu.sd.entities.Transaction;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        // mock transações
        Transaction transaction1 = new Transaction("Alice", "Bob", 10.0);
        blockchain.addTransaction(transaction1);

        Transaction transaction2 = new Transaction("Bob", "Charlie", 5.0);
        blockchain.addTransaction(transaction2);

        // Adicionando um bloco contendo as transações
        blockchain.addBlock(new Block(blockchain.getChain().size(), new Date().getTime(), blockchain.getCurrentTransactions(), blockchain.getChain().get(blockchain.getChain().size() - 1).getHash()));

        // Imprimindo a blockchain
        blockchain.printBlockchain();
    }
}