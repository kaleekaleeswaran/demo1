// app.jsx
import React from 'react';
import './App.css';
import StoreProvider from './components/StoreProvider';
import ListOfToDo from './components/ListOfToDo';
import Form from './components/Form';

function App() {
  return (
    <StoreProvider>
      <div className="container m-5 p-2 rounded mx-auto bg-light shadow">
        <div className="row m-1 p-4">
          <div className="col">
            <div className="p-1 h1 text-primary text-center mx-auto display-inline-block">
              <i className="fa fa-check bg-primary text-white rounded p-2"></i>
              <u>My Todo-s</u>
            </div>
          </div>
        </div>
        <Form />
        <ListOfToDo />
      </div>
    </StoreProvider>
  );
}

export default App;
