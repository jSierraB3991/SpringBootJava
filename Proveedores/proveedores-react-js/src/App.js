import React from 'react';
import logo from './logo.svg';
import './App.css';
import MysProviderList from './Components/MysProviderList'

function App() {
  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col col-md-3 offset-md-4">
          <img src={logo} className="App-logo text-center" alt="logo" />
        </div>
        <div className="col col-md-12">
          <MysProviderList></MysProviderList>
        </div>
      </div>
    </div>
  );
}

export default App;
