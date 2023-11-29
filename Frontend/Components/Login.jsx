import React, { useState } from "react";
import axios from "axios";


const Login = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
  
    const sendLoginRequest = async (event) => {
      event.preventDefault();
  
      try {
        const response = await axios.post("http://localhost:3000/login", {
          username: username,
          password: password,
        });
  
        // Handle the response from the server
        console.log("Login successful:", response.data);
      } catch (error) {
        // Handle error, e.g., display an error message to the user
        console.error("Login failed:", error.message);
      }
    };

    return (
        <>
        <form onSubmit={sendLoginRequest} method="post" className="col-5">
            <div className="mb-3">
                <label className="form-label">User Name</label>
                <input type="text" className="form-control input" value={username} onChange={(e) => setUsername(e.target.value)}/>
            </div>
            <div className="mb-3">
                <label className="form-label">Password</label>
                <input type="password" className="form-control input" size="20" id="exampleInputPassword1 value={password} onChange={(e) => setPassword(e.target.value)}"/>
            </div>
            <button type="submit" className="btn btn-primary btn-success" value="login">Submit</button>
        </form>
        </>
    );
};

export default Login