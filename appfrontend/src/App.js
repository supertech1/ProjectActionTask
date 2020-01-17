import React from 'react';
import Header from './component/Header';
import ListCointainer from './component/ListContainer';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom'; 

class App extends React.Component {
    render(){
        return (
            <Router>
                <div className="ui raised very padded text container segment red bg">
                    <Header/>
                    <ListCointainer />
                </div>
            </Router>
        )
    }
}

export default App;