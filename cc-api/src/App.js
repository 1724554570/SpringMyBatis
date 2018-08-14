import React, { Component } from 'react';
// import logo from './logo.svg';
import './styles/base.css';
import './App.css';

import HeaderNavigation from './layout/HeaderNavigation';
import Main from './main/Main';
import FooterContent from './layout/FooterContent';

class App extends Component {
  render() {
    return (
      <div className="AppContent">
        <HeaderNavigation />
        <Main />
        <FooterContent />
        {/* <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p> */}
      </div>
    );
  }
}

export default App;
