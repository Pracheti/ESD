import React from "react";

const Login = () => {
    function sendLoginRequest (){
        console.log("Sending request");
    }

    return (
        <>
            <div>
                <label htmlFor="username">Username</label>
                <input type="text" id="username" />
            </div>
            <div>
                <label htmlFor="Password">Password</label>
                <input type="password" id="password" />
            </div>
            <div>
                <button id="submit" type="button" onClick={() => sendLoginRequest()} > Login </button>
            </div>
        </>
    );
};

export default Login