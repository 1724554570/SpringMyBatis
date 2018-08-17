import React, { Component } from 'react';
import { HashRouter as Router, NavLink } from 'react-router-dom';
import '../styles/header.css';

class HeaderNavigation extends Component {

    render() {
        return (
            <div id="header">
                <div className="header-inner">
                    <div className="logo"><a href="/" title="飞扬的青春"><span>飞扬的青春</span></a></div>
                    <Router>
                        <div className="header-nav">
                            <NavLink exact className="nav-a" activeClassName="cur" to="/">首页</NavLink>
                            <NavLink className="nav-a" activeClassName="cur" to="/plugin">插件</NavLink>
                            <NavLink className="nav-a" activeClassName="cur" to="/about">关于我们</NavLink>
                            {/* <ul> */}
                            {/* <li><Link to="/">首页</Link></li> */}
                            {/* <li><Link to="/plugin">插件</Link></li> */}
                            {/* <li><Link to="/about">关于我们</Link></li> */}
                            {/* <li className="cur"><a href="" >首页</a></li> */}
                            {/* <li className=""><a href="" >插件</a></li> */}
                            {/* <li className=""><a href="" >关于我们</a></li> */}
                            {/* </ul> */}
                        </div>
                    </Router>
                </div>
            </div>
        );
    }
}

export default HeaderNavigation;
