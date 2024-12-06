import React from 'react';

function Sidebar({ senders, setSelectedSender }) {
  return (
    <div className="sidebar">
      <h3>CHATS</h3>
      <ul>
        {senders.map(sender => (
          <li key={sender} onClick={() => setSelectedSender(sender)}>
            {sender}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Sidebar;
