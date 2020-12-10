import React from "react";

import List from "./components/List";
import listMovies from "movies.json";
import './App.css';

export default class App extends React.Component {
    state = {
      favItems: [],
    };

    handleItemClick = (item) => {
        const newItems = [ ...this.state.favItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if (targetInd < 0) newItems.push(newItem);
        // else newItems.splice(targetInd, 1);
        this.setState({ favItems: newItems });
    };

    deleteList (listMovies) {
        const list = [ ...this.state.favItems];
        if (listMovies > 0) this.setState({ list: list.filter(list => list != listMovies)});
    };

    checkList() {
        const { favItems } = this.state;
        if (favItems == null) return ("Belum ada item yang dipilih");
    }

    isFavItems = () => this.state.favItems;

    toogleSwitch = events => {
      favorite = isFunction(favorite) ? favorite() : favorite;
      this.setState({ favorite: !this.isFavItems});
    }

    render() {
        const { favItems } = this.state;

        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
                <p className="text-center text-secondary text-sm font-italic">
                    (This is a <strong>class-based</strong> application)
                </p>
                <div className="container pt-3">
                    <div className="row">
                        <div className="col-md">
                          <label className="switch">
                            <input onItemClick={this.toogleSwitch} />
                            <span className="slider round"></span>
                          </label>
                        </div>
                        <div className="col-sm">
                            <List
                                title="List Movies"
                                items={listMovies}
                                onItemClick={() => {}}
                            />
                        </div>
                        <div className="col-sm">
                            <List
                                className="List"
                                title="My Favorites"
                                items={favItems.checkList()}
                                onItemClick={this.handleItemClick}
                            />
                            <button
                              type="button"
                              className="list-group-item list-group-item-action flex-column align-items-start w-100 mb-3"
                              onClick={this.deleteList("List")}
                            >Delete</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
