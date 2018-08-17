import React, { Component } from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';

import Index from '../components/indexComponent';
import Create from '../components/createCompoent';
import About from '../components/aboutCompoent';
import Plugin from '../components/pluginCompoent';

// import Utils from '../util/util';

export default class Main extends Component {

    constructor() {
        super();
        window.document.title = "飞扬的青春";
    }

    render() {

        return (
            <div id="body-inner">
                <Router>
                    <Switch>
                        {/*Switch是匹配*/}
                        {/*exact 我们匹配/斜杠时候，就匹配第一个*/}
                        <Route exact path="/" component={Index} />
                        <Route exact path="/plugin" component={Plugin} />
                        <Route exact path="/about" component={About} />
                        <Route exact path="/create" component={Create} />
                    </Switch>
                </Router>
            </div>
        );
    }
}