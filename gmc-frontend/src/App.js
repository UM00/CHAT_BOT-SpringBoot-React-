import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Sidebar from './Sidebar';
import ChatBox from './ChatBox';
import './App.css';

function App() {
  const [senders, setSenders] = useState([]);
  const [selectedSender, setSelectedSender] = useState(null);
  const [currentUser] = useState("currentUser");

  useEffect(() => {
    const intervalId = setInterval(() => {
      axios.get('http://localhost:8080/chat/senders')
        .then(response => setSenders(response.data))
        .catch(error => console.error("Error fetching senders", error));
    }, 1000);
    return () => clearInterval(intervalId);
  }, []);  

  return (
    <div className="app">
      <Sidebar senders={senders} setSelectedSender={setSelectedSender} />
      <ChatBox selectedSender={selectedSender} currentUser={currentUser} />
    </div>
  );
}

export default App;
