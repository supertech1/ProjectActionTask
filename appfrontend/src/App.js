import React from 'react';

import "./App.css";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Projects from "./Projects";
import ProjectDetail from "./ProjectDetail";


class App extends React.Component{


  render() {
    return (
        <Router>
            <Switch>
                <Route path='/' exact={true} component={Projects}/>
                <Route path='/project/detail/:id' exact={true} component={ProjectDetail}/>
            </Switch>
        </Router>
    )
}
 

}

export default App;