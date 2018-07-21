import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import Header from './Header';
import Main from './Main';
import Write from './Write';
import About from './About';

class App extends Component {
  render() {
    return (
      <div>   
        <div id="container"></div>
        <Header />
        <Route exact path='/' component={Main} />
        <Route path='/write' component={Write} />
        <Route path='/about' component={About} /> 
      </div>
    );
  }
}

export default App;
