package com.Evaluation.GMC.Model;

import jakarta.persistence.*;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Sender")
    private String sender;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "Text")
    private String text;
    @Column(name = "Time")
    private String time;
    @Column(name = "smcid")
    private String smcid;

    // Getters and setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReciever(String receiver) {
        this.receiver = receiver;
    }

    public String getReciever() {
        return receiver;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSmcid() {
        return smcid;
    }

    public void setSmcid(String smcid) {
        this.smcid = smcid;
    }
}
