import React, { Component } from 'react';
import { HashRouter as Router, Route, Switch } from 'react-router-dom';

import Index from '../components/indexComponent';
import Create from '../components/createCompoent';

// import Utils from '../util/util';

export default class Main extends Component {

    render() {
        
        return (
            <div id="body-inner">
                <Router>
                    <Switch>
                        {/*Switch是匹配*/}
                        {/*exact 我们匹配/斜杠时候，就匹配第一个*/}
                        <Route exact path="/" component={Index} />
                        <Route exact path="/create" component={Create} />
                    </Switch>
                </Router>
            </div>
        );
    }
}