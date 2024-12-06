import React from 'react';

function Message({ message, currentUser }) {
  return (
    <div className={message.sender === currentUser ? 'sent' : 'received'}>
      <div>{message.sender}: {message.text}</div>
      <div className="time">{message.time}</div>
    </div>
  );
}

export default Message;
