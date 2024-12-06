//package com.Evaluation.GMC.Service;
//
//import com.Evaluation.GMC.Model.Model;
//import com.Evaluation.GMC.Repository.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@org.springframework.stereotype.Service
//public class Service {
//    private final Repository repository;
//
//    public Service(Repository repository) {
//        this.repository = repository;
//    }
//
//    // Save a message in the database
//    @Transactional
//    public void saveMessage(Model message) {
//        try {
//            repository.save(message);
//            System.out.println("Message saved successfully: " + message);
//        } catch (Exception e) {
//            System.err.println("Error saving message: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//    // Fetch messages between sender and receiver
//    public List<Model> getMessages(String sender, String receiver) {
//        System.out.println("Fetching messages for sender: " + sender + " and receiver: " + receiver);
//        List<Model> messages = repository.findMessages(sender, receiver);
//        System.out.println("Messages fetched: " + messages);
//        return messages;
//    }
//
//    // Get list of distinct senders
//    public List<String> getSenders() {
//        return repository.findDistinctSenders();
//    }
//}


package com.Evaluation.GMC.Service;

import com.Evaluation.GMC.Model.Model;
import com.Evaluation.GMC.Repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveMessage(Model message) {
        repository.save(message);
    }

    public List<Model> getMessagesBetweenUsers(String user1, String user2) {
        return repository.findMessagesBetweenUsers(user1, user2);
    }


    public List<String> getSenders() {
        return repository.findDistinctSenders();
    }
}
