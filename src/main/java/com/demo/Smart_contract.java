package com.demo;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Function;
import org.web3j.protocol.core.DefaultBlockParameterName;

import java.math.BigInteger;
import java.util.Arrays;

public class Smart_contract {

    public void connectToEthereum(String pname, String pid, String md, String ed) throws Exception {
        String INFURA_URL = "https://sepolia.infura.io/v3/YOUR_INFURA_PROJECT_ID"; // Replace with your Infura URL
        String PRIVATE_KEY = "YOUR_WALLET_PRIVATE_KEY"; // Replace with your Ethereum private key
        String CONTRACT_ADDRESS = "YOUR_SMART_CONTRACT_ADDRESS"; // Replace with your smart contract address

        // Initialize Web3j connection
        Web3j web3j = Web3j.build(new HttpService(INFURA_URL));
        Credentials credentials = Credentials.create(PRIVATE_KEY);
        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials);

        try {
            // Get Ethereum Client Version
            Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
            System.out.println("Connected to Ethereum Network: " + web3ClientVersion.getWeb3ClientVersion());

            // Get Wallet Address
            String walletAddress = credentials.getAddress();
            System.out.println("Wallet Address: " + walletAddress);

            // Get Wallet Balance
            BigInteger balance = web3j.ethGetBalance(walletAddress, DefaultBlockParameterName.LATEST)
                    .send().getBalance();
            System.out.println("Balance: " + balance + " Wei");

            // Prepare product details
            String productName = pname;
            String productId = pid;
            String manufacturingDate = md;
            String expirationDate = ed;

            // Prepare the function and encode it
            Function addFunction = new Function(
                "add", // function name
                Arrays.asList(
                    new Utf8String(productName),  // product name
                    new Utf8String(productId),    // product id
                    new Utf8String(manufacturingDate),  // manufacturing date
                    new Utf8String(expirationDate),  // expiration date
                    new Address(walletAddress)    // sender address
                ),
                Arrays.asList() // no output
            );

            // Encode the function call
            String encodedFunction = FunctionEncoder.encode(addFunction);

            // Send the transaction to the smart contract
            Transaction transaction = Transaction.createFunctionCallTransaction(
                    walletAddress, null, BigInteger.ZERO, BigInteger.valueOf(21000), CONTRACT_ADDRESS, BigInteger.ZERO, encodedFunction);

            EthSendTransaction response = transactionManager.sendTransaction(
                    BigInteger.ZERO, BigInteger.valueOf(21000), CONTRACT_ADDRESS, encodedFunction, BigInteger.ZERO);

            // Get transaction receipt
            String transactionHash = response.getTransactionHash();
            System.out.println("Transaction Hash: " + transactionHash);

            // Wait for the transaction to be mined and print the receipt
            TransactionReceipt receipt = web3j.ethGetTransactionReceipt(transactionHash).send().getResult();
            if (receipt != null && receipt.getStatus().equals("0x1")) {
                System.out.println("Transaction successful!");
            } else {
                System.out.println("Transaction failed!");
            }

        } catch (Exception e) {
            System.err.println("Error connecting to Ethereum: " + e.getMessage());
        }
    }
}
