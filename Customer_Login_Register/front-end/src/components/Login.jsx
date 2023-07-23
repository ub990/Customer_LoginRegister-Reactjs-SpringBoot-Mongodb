import {  useState } from "react";
import { useNavigate } from 'react-router-dom';
import './Style.css';
import axios from "axios";

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [errorMessages, setErrorMessages] = useState({});
    const errors = {
      uname: "Username does not exist",
      pass: "Invalid Password"
    };    
    function renderErrorMessage(name) {
    return name === errorMessages.name && (
      <div className="error">{errorMessages.message}</div>
    );
  }
    async function login(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/api/v1/customer/login", {
            username: username,
            password: password,
            }).then((res) => 
            {
             console.log(res.data);
             
             if (res.data.message === "Username not exist") 
             {
              /* alert("Username not exits");*/
               setErrorMessages({ name: "uname", message: errors.uname });
             } 
             else if(res.data.message === "Login Success")
             { 
                
                navigate('/home');
             } 
              else 
             { 
               /* alert("Incorrect Username and Password not match");*/
                setErrorMessages({ name: "pass", message: errors.pass });
             }
          }, fail => {
           console.error(fail); // Error!
  });
        }
 
         catch (err) {
          alert(err);
        }
      
      }
    return (
      
    <div className="auth-form-container">
      <h2>Login</h2>
      <form className="login-form" onSubmit={login}>
      <div class="form-group">
              <label htmlFor="username">Username</label>
              <input type="username" required class="form-control" id="username" placeholder="Username"

                value={username}
                onChange={(event) => {
                  setUsername(event.target.value);
                } } />
            </div>
            <div class="form-group">
              <label htmlFor="password">password</label>
            <input type="password" required class="form-control" id="password" placeholder="*********"

              value={password}
              onChange={(event) => {
                setPassword(event.target.value);
              } } />
          </div>
          {renderErrorMessage("uname")}
          {renderErrorMessage("pass")}
          <button className="btn" type="submit">Log In</button>
      </form>
      <button className="link-btn" onClick={() => navigate('/register')}>Don't have an account? Register here.</button>
  </div>
      
    );
            
  }
  
  export default Login;
