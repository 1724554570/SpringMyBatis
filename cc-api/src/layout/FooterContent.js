import React, { Component } from 'react';
import '../styles/header.css';

class FooterContent extends Component {

    render() {
        return (
            <div id="footer">
                <div className="footer-inner">
                    <div className="copyright">
                        <p>
                            <span>Copyright © 2018</span>
                            <span>
                                <a
                                    href="http://www.miitbeian.gov.cn/"
                                //  target="_blank"
                                >粤ICP备18046099号</a>
                            </span>
                        </p>
                    </div>
                </div>
            </div>
        );
    }
}

export default FooterContent;
