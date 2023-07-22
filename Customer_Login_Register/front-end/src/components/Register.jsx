import {  useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
import './Style.css';
function Register() {
  
    const navigate = useNavigate();
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    
    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:8080/api/v1/customer/save", {
          firstName: firstName,
          lastName: lastName,
          email: email,
          phone: phone,
          username: username,
          password: password,
          }).then((res) => {
          alert(res.data + " Registation Successfully");
          navigate('/');
          }, fail => {
            console.error(fail); // Error!
            
   });
        } catch (err) {
          alert(err);
        }
      }
  
    return (
      <div className="auth-form-container">
      <h2>Customer Registration</h2>
  <form className="register-form" onSubmit={save}>
  <div class="form-group">
          <label>Customer First name</label>
          <input type="text"  class="form-control" id="firstName" placeholder="Enter First Name" required
          
          value={firstName}
          onChange={(event) => {
            setFirstName(event.target.value);
          }}
          />
        </div>
        <div class="form-group">
          <label>Customer Last name</label>
          <input type="text"  class="form-control" id="lastName" placeholder="Enter Last Name" required
          
          value={lastName}
          onChange={(event) => {
            setLastName(event.target.value);
          }}
          />
        </div>
        <div class="form-group">
          <label>Email</label>
          <input type="email"  class="form-control" id="email" placeholder="Enter Email" required
          
          value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
          
          />
 
        </div>
        <div class="form-group">
          <label>Phone No</label>
          <input type="number"  class="form-control" id="phone" placeholder="Mobile No" required
          
          value={phone}
          onChange={(event) => {
            setPhone(event.target.value);
          }}
          />
        </div>
        <div class="form-group">
          <label>Username</label>
          <input type="text"  class="form-control" id="username" placeholder="Username" required
          
          value={username}
          onChange={(event) => {
            setUsername(event.target.value);
          }}
          />
        </div>

    

        <div class="form-group">
            <label>Password</label>
            <input type="password"  class="form-control" id="password" placeholder="**********" required
            
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            
            />
          </div>
      <button className="btn" type="submit">Register</button>
  </form>
  <button className="link-btn" onClick={() => navigate('/')}>Already have an account? Login here.</button>
</div>


   
    );
  }
  
  export default Register;