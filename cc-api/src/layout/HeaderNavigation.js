import React, { Component } from 'react';
import '../styles/header.css';

class HeaderNavigation extends Component {
    
    render() {
        return (
            <div id="header">
                <div className="header-inner">
                    <div className="logo"><a href="/" title="飞扬的青春"><span>飞扬的青春</span></a></div>
                    <div className="header-nav">
                        <ul>
                            <li className="cur"><a href="" >首页</a></li>
                            <li className=""><a href="" >插件</a></li>
                            <li className=""><a href="" >关于我们</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}

export default HeaderNavigation;
