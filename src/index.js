import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom'

import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import './index.css';
import Create from './create/Create';
import Search from './search/Search';
import Demo from './demo/Demo';

import Navbar from './CustNav.jsx';

ReactDOM.render(
  <Router >
    <Navbar />
    <Routes>
      <Route exact path="/" element={<App />} />
      <Route exact path="/create" element={<Create />} />
      <Route exact path="/search" element={<Search />} />
      <Route exact path="/demo" element={<Demo />} />
    </Routes>
  </Router>,
  document.getElementById('root')
);


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
