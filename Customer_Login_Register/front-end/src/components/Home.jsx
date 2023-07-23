import { useNavigate } from 'react-router-dom';
function Home() {
  const navigate = useNavigate();
    return (
      <div>
       <h1>Home</h1>
       <button className="btn" type="submit" onClick={() => navigate('/')}>Logout</button>
      </div>
    );
  }
  export default Home;