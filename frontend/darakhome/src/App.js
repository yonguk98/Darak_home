import Board from './board/Board';
import Login from './user/Login'
import Write from './board/Write'
import {Routes, Route, Link} from "react-router-dom";
import './css/Board.css';
import './css/Login.css'

function App() {
  return (
    <div className="App">
      <nav>
        <Link to="/board">Board</Link> | <Link to="/user/login">Login</Link> | <Link to="/user/write">Write</Link>
      </nav>
      <Routes>
        <Route path="/board" element={<Board />} />
        <Route path="/user/login" element={<Login />} />
        <Route path="/user/write" element={<Write />} />
      </Routes>
    </div>
  );
}

export default App;
