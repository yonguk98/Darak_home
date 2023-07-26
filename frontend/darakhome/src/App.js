import Board from './board/Board';
import Login from './user/Login';
import Write from './board/Write';
import Join from './user/Join';
import Home from './home/Home';
import {Routes, Route, Link} from "react-router-dom";
import './css/Board.css';
import './css/Login.css';
import './css/Write.css';
import './css/Home.css';

function App() {
  return (
    <div className="App">
      <nav>
        <Link to="/board">Board</Link> | <Link to="/users/login">Login</Link> | <Link to="/board/write"></Link> <Link to="/users/join"></Link> <Link to="/home">Home</Link>
      </nav>
      <Routes>
        <Route path="/board" element={<Board />} />
        <Route path="/user/login" element={<Login />} />
        <Route path="/board/write" element={<Write />} />
        <Route path="/user/join" element={<Join />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
