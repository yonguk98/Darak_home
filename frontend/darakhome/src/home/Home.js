import React, { useState } from "react";
import { Link } from "react-router-dom";
import { CSSTransition  } from 'react-transition-group';
import { FaHome } from "react-icons/fa";
import { RiArrowDropDownFill, RiArrowDropUpFill } from "react-icons/ri"
import { BsFillPersonFill } from "react-icons/bs";

function Home() {
    
    const [ isOpen1, setIsOpen1 ] = useState(false);
    const [ isOpen2, setIsOpen2 ] = useState(false);

    const toggleDropdown1 = () => {
        setIsOpen1(!isOpen1);
    };

    const toggleDropdown2 = () => {
        setIsOpen2(!isOpen2);
    }

    return(
        <div>
            <nav className="home">
                <div className="home-nav">
                    <FaHome size="24" color="#d49466" />
                    <div className="home-name">다락방</div>
                </div>
                <ul>
                    <li>공지사항</li>
                    <li>
                        게시판<button onClick={toggleDropdown1}>
                            {isOpen1 ? <RiArrowDropUpFill size="20" color="#d49466" /> : <RiArrowDropDownFill size="20" color="#d49466" />}
                        </button>
                        <CSSTransition
                            in={isOpen1}
                            timeout={300}
                            className="menu"
                            unmountOnExit
                        >
                            <ul>
                                <li><Link to="/board">자유게시판</Link></li>
                                <li><Link to="/board">게임게시판</Link></li>
                                <li><Link to="/board">사진게시판</Link></li>
                            </ul>
                        </CSSTransition>
                    </li>
                    <li>
                        자료실<button onClick={toggleDropdown2}>{isOpen2 ? <RiArrowDropUpFill size="20" color="#d49466" /> : <RiArrowDropDownFill size="20" color="#d49466" />}</button>
                        <CSSTransition
                            in={isOpen2}
                            timeout={300}
                            className="menu"
                            unmountOnExit
                        >
                            <ul>
                                <li>시험자료</li>
                                <li>강의평</li>
                            </ul>
                        </CSSTransition>
                    </li>
                    <li>동아리소개</li>
                </ul>
                <ul className="home-links">
                    <li><BsFillPersonFill size="24" color="d49466" /></li>
                </ul>
            </nav>
        </div>
    );
}

export default Home;