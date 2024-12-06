

 
 
Project Description: Chat Application
In this project, I have implemented a functional chat application where users can exchange messages in a conversational format. Below is a summary of the work you accomplished:
1.	Backend Setup:
o	Built a REST API using Spring Boot to manage chat messages between users.
o	Created a Model class to represent chat messages, including fields like sender, receiver, text, timestamp, and an ID.
o	Designed a Repository using Spring Data JPA, with custom queries to:
	Fetch messages between two users, considering bidirectional communication.
	Retrieve a list of distinct senders for the sidebar.
o	Developed a Service layer to handle the business logic of saving and retrieving messages.
o	Implemented a Controller with endpoints to:
	Send a message (/chat/send).
	Retrieve messages between two users (/chat/messages).
	Fetch distinct senders (/chat/senders).
2.	Frontend Development:
o	Built the frontend using React, with components for the sidebar and chatbox.
o	Created a Sidebar component to display the list of distinct senders and allow selecting a conversation.
o	Designed the ChatBox component to display the conversation between the selected sender and the current user:
	Used useEffect with polling to periodically fetch messages.
	Displayed messages in a conversational format, distinguishing between messages sent by the current user and the other user.
o	Added input functionality to send new messages, which update the chat in real time.
3.	Real-Time Features:
o	Implemented polling using setInterval to fetch new messages every second, ensuring the chat stays updated dynamically.
o	Ensured that messages sent by the current user are also reflected instantly in the chatbox.
4.	Message Logic:
o	Handled bidirectional communication:
	Ensured that messages sent or received between two users are displayed in the same chat window.
	Allowed the current user to switch between senders and view the complete conversation history for each.
5.	User Experience:
o	Displayed timestamps for each message to maintain the conversational context.
o	Differentiated between sent and received messages visually using CSS classes (sent and received).
________________________________________
Key Functionalities:
•	Chat between two users (sender and receiver) with a complete history displayed in a single chatbox.
•	Dynamic list of active senders in the sidebar.
•	Real-time updates with seamless message sending and fetching.
•	REST API integration between the backend and frontend.
________________________________________
Technical Stack:
•	Backend: Spring Boot, Hibernate/JPA
•	Frontend: React (with Axios for API calls)
•	Database: JPA (SQL backend, H2)

