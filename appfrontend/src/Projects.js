import React from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import "./App.css";

class Projects extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            projects : []
          }
    }

    componentWillMount(){
        axios.get('localhost:8081/project/all')
        .then( (response) => {
          this.setState({
            projects: response.data
          });
          console.log(response);
        } )
        .catch( err => {
          console.log(err);
        })
      }

    render(){

        const { projects } = this.state;
        // [
        //   {id:1, name: "Lawma", description: "Manage waste", completed: false},
        //   {id:1, name: "Pawma", description: "Manage waste", completed: false},
        //   {id:1, name: "Loan", description: "Loan", completed: false},
        // ];
    
        return(

            <div className="app-container">
        
        <header className="app-title p-4 mb-3">
  
          <h1 className="">Project-Action</h1>

        </header>
  
        <main className="container">
          <div className="row mt-4">
            {
  
              projects.map( project => {

                return (
                  <div className="col-sm-12 col-md-4">
                    <div className="card">
                      <div className="card-body">
                        <h5 className="card-title">{project.name}</h5>
                        <div className="card-text">{project.description}</div>
                        
                        <div className="card-text">
                          {
                            project.isCompleted 
                            ? 
                            <span className="badge badge-success badge-sm">Completed</span>
                            :
                            <span className="badge badge-warning badge-sm">Pending</span>  
                          }
                        </div>

                        <hr/>
                        <b>Actions</b>
                        {
                          project.action.length > 0 ?
                            project.action.map( (action, i) => {

                                return(
                                  <p className="card-text" key={action.id}><b>{i+1}:</b> {action.description}</p>
                                );

                            })
                          : null
                        }

                        <Link to={`/project/detail/${project.id}`} className="btn btn-light-blue btn-block">Open</Link>
                      </div>
                    </div>
                  </div>
                );
              
              }) 
  
            }

          </div>
        </main>
  
      </div>
        );
        
    }
}

export default Projects;