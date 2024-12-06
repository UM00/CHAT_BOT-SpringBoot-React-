//package com.Evaluation.GMC.Repository;
//
//import com.Evaluation.GMC.Model.Model;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.List;
//
//@org.springframework.stereotype.Repository
//public interface Repository extends JpaRepository<Model, Long> {
//
//    @Query("SELECT m FROM Model m WHERE m.sender = :sender AND m.receiver = :receiver")
//    List<Model> findMessages(@Param("sender") String sender, @Param("receiver") String receiver);
//
//    // Method to fetch messages by sender and receiver
////    List<Model> findBySenderAndReciever(String sender, String reciever);
//
//    // Custom query to get distinct senders
//    @Query("SELECT DISTINCT m.sender FROM Model m")
//    List<String> findDistinctSenders();
//}



package com.Evaluation.GMC.Repository;

import com.Evaluation.GMC.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model, Long> {

    @Query("SELECT m FROM Model m WHERE (m.sender = :user1 AND m.receiver = :user2) OR (m.sender = :user2 AND m.receiver = :user1) ORDER BY m.id ASC")
    List<Model> findMessagesBetweenUsers(@Param("user1") String user1, @Param("user2") String user2);


    @Query("SELECT DISTINCT m.sender FROM Model m")
    List<String> findDistinctSenders();
}
