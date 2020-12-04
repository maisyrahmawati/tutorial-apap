import React from "react";

import List from "./components/List";
import listMovies from "movies.json";
import './App.css';

export default class App extends React.Component {
  render() {
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={()=>{}}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
