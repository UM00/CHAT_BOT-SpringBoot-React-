import React, { useState, useEffect } from 'react';
import axios from 'axios';

function ChatBox({ selectedSender, currentUser }) {
  const [messages, setMessages] = useState([]);
  const [messageText, setMessageText] = useState('');

  // Fetch messages between the selected sender and current user
  useEffect(() => {
    let intervalId;

    if (selectedSender) {
      const fetchMessages = () => {
        axios
          .get('http://localhost:8080/chat/messages', {
            params: {
              user1: currentUser,
              user2: selectedSender,
            },
          })
          .then((response) => setMessages(response.data))
          .catch((error) => console.error('Error fetching messages', error));
      };

      // Initial fetch
      fetchMessages();

      // Poll messages every second
      intervalId = setInterval(fetchMessages, 1000);
    }

    return () => clearInterval(intervalId); // Cleanup
  }, [selectedSender, currentUser]);

  // Handle sending a message
  const handleSendMessage = () => {
    if (messageText.trim()) {
      const time = new Date().toISOString(); // Use ISO format for consistency
      const smscid = 'SomeId';

      axios
        .post('http://localhost:8080/chat/send', null, {
          params: {
            sender: currentUser,
            receiver: selectedSender,
            text: messageText,
            time,
            smscid,
          },
        })
        .then(() => {
          setMessageText(''); // Clear input after sending
        })
        .catch((error) => console.error('Error sending message', error));
    }
  };

  return (
    <div className="chatbox">
      {selectedSender ? (
        <>
          <h3>Chat with {selectedSender}</h3>
          {/* Render Messages */}
          <div className="messages">
            {messages.length > 0 ? (
              messages.map((message, index) => (
                <div key={index} className={message.sender === currentUser ? 'sent' : 'received'}>
                  <div>{message.sender}: {message.text}</div>
                  <div className="time">{message.time}</div>
                </div>
              ))
            ) : (
              <p>No messages yet.</p>
            )}
          </div>
          {/* Input Box */}
          <div className="message-input">
            <textarea
              value={messageText}
              onChange={(e) => setMessageText(e.target.value)}
              placeholder="Type your message"
            />
            <button onClick={handleSendMessage}>Send</button>
          </div>
        </>
      ) : (
        <p>Select a sender to start chatting</p>
      )}
    </div>
  );
}

export default ChatBox;
