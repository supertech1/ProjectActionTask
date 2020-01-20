import React from 'react';
import axios from 'axios';


import "./App.css";

class ProjectDetail extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            project : {},
            isLoading: true
          }

          this.id = props.match.params.id;
          this.addAction = this.addAction.bind(this);
    }

    addAction(event){

        event.preventDefault();

        let isc = false;
        if(this.iscompleted.value == "on")
            isc = true;

        let data = {
            description: this.description.value,
            note: this.note.value,
            completed : isc
        }


        axios.post(`http://localhost:8080/action/create/${this.id}`, data)
        .then( (response) => {

            this.fetchProject();
            alert("Added");
        })
        .catch( err => {
            console.log(err);
        } );
    }

    fetchProject(){
        axios.get(`https://vgg-project-action-backend.herokuapp.com/project/view/${this.id}`)
        .then( (response) => {
          this.setState({
            project: response.data,
            isLoading: false
          });
          console.log(response);
        } )
        .catch( err => {
          console.log(err);
        })
    }

    componentWillMount(){
        this.fetchProject();    
    }
    
      

    render(){

        const { project, isLoading } = this.state;
        
    
        return(

            <div className="app-container">
        
                <header className="app-title p-4 mb-3">
        
                {

                    this.state.isLoading == false 
                    ? 
                    <h1>{project.name}</h1>
                    :
                    null
                }
                </header>
    
                <main className="container">
                    <div className="row mt-4">
                        
                            
                            { 
                            
                                this.state.isLoading == false 
                                
                                ? 
                                
                                <div className="col-sm-12 col-md-12">
                                    <div className="card">
                                    <div className="card-body">
                                        <h5 className="card-title">{project.name}</h5>
                                        <div className="card-text">{project.description}</div>
                                        <hr/>
                                        <b>Actions</b>
                                        {
                                            project.action.length > 0 
                                            ?    
                                            project.action.map( (action, i) => {

                                                return(
                                                    <p className="card-text">
                                                        <b>{i+1} </b> 
                                                        
                                                        {
                                                            action.completed 
                                                            ? 
                                                            <span className="badge badge-success badge-sm">Completed</span>
                                                            :
                                                            <span className="badge badge-warning badge-sm">Pending</span>  
                                                        }

                                                        &nbsp;:&nbsp;

                                                        {action.description} ({action.note})
                                                        
                                                    </p>
                                                );

                                            })
                                            :
                                            null
                                        }

                                        <hr/>

                                        <form onSubmit={this.addAction}>
                                            <div className="form-group">
                                                <input className="form-control" type="text" placeholder="description" ref={ description => this.description = description  }/>
                                            </div>
                                            <div className="form-group">
                                                <input className="form-control" type="text" placeholder="note" ref={ note => this.note = note }/>
                                            </div>
                                            <div className="form-check">
                                                <input className="form-check-input" type="checkbox" ref={ iscompleted => this.iscompleted = iscompleted  }/> 
                                                <label className="form-check-label">is Completed</label>
                                            </div>
                                            <p className="text-center">
                                                <button type="submit" className="btn btn-sm btn-warning">Add</button>
                                            </p>
                                        </form>

                                    </div>
                                    </div>
                                </div> 
                                
                                : 
                                
                                <p className="text-center lead display-4 text-light col-sm-12">Waiting for server...</p>
                            
                            }
            );
                        
                        
                        

                    </div>
                </main>
  
            </div>
        );
        
    }
}

export default ProjectDetail;