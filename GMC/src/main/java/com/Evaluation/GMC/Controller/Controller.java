//package com.Evaluation.GMC.Controller;
//
//import ch.qos.logback.core.net.SyslogOutputStream;
//import com.Evaluation.GMC.Model.Model;
//import com.Evaluation.GMC.Service.Service;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/chat")
//public class Controller {
//    private final Service service;
//
//    public Controller(Service service) {
//        this.service = service;
//    }
//
//
//    // Endpoint to send a message
//    @PostMapping("/send")
//    public String sendMessage(
//            @RequestParam String sender,
//            @RequestParam String receiver,
//            @RequestParam String text,
//            @RequestParam String time,
//            @RequestParam String smscid) {
//        Model message = new Model();
//        message.setSender(sender);
//        message.setReciever(receiver);
//        message.setText(text);
//        message.setTime(time);
//        message.setSmcid(smscid);
//
//        service.saveMessage(message);
//        return "Message sent successfully";
//    }
//
////    @GetMapping("/messages")
////    public List<Model> getMessages(
////            @RequestParam String sender,
////            @RequestParam String receiver) {
////        return service.getMessages(sender, receiver);
////    }
//    //==============================
//    @GetMapping("/messages")
//    public List<Model> getMessages(
//            @RequestParam String sender,
//            @RequestParam String receiver) {
//        System.out.println("sender"+sender);
//        System.out.println("reciever"+receiver);
//        List<Model> messages = service.getMessages(sender, receiver);
//        System.out.println("Fetched messages: " + messages);  // Debugging the response
//        return messages;
//    }
//

////    @GetMapping("/messages")
////    public List<Model> getMessages(
////            @RequestParam String sender,
////            @RequestParam String receiver) {
////        return service.getMessagesBetweenUsers(sender, receiver);
////    }
//
//    // Endpoint to get all senders (for the left sidebar)
//    @GetMapping("/senders")
//    public List<String> getSenders() {
//        return service.getSenders();
//    }
//}




package com.Evaluation.GMC.Controller;

import com.Evaluation.GMC.Model.Model;
import com.Evaluation.GMC.Service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/send")
    public String sendMessage(
            @RequestParam String sender,
            @RequestParam String receiver,
            @RequestParam String text,
            @RequestParam String time,
            @RequestParam String smscid) {
        Model message = new Model();
        message.setSender(sender);
        message.setReciever(receiver);
        message.setText(text);
        message.setTime(time);
        message.setSmcid(smscid);
        service.saveMessage(message);
        return "Message sent successfully";
    }

    @GetMapping("/messages")
    public List<Model> getMessages(
            @RequestParam String user1,
            @RequestParam String user2) {
        return service.getMessagesBetweenUsers(user1, user2);
    }


    @GetMapping("/senders")
    public List<String> getSenders() {
        return service.getSenders();
    }
}
