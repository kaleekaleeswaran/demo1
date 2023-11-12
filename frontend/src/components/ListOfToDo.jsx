// ListOfToDo.jsx
import React, { useContext, useEffect } from 'react';
import { Store } from './StoreProvider';

const ListOfToDo = () => {
  const { state, dispatch } = useContext(Store);

  useEffect(() => {
    let listOfNote = fetchAllNotes().then((notes) => {
      let action = {
        type: 'get-notes',
        payload: notes,
      };
      dispatch(action);
    });
  }, []);

  const fetchAllNotes = async () => {
    let response = await fetch('http://localhost:8081/api/get/notes');
    let data = await response.json();
    return data;
  };

  const onCheckbox = async (event, note) => {
    const checked = event.currentTarget.checked;

    let noteWithCheckboxInformation = { ...note, done: checked };

    let noteUpdatedPromise = await fetch(`http://localhost:8081/api/update/note`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(noteWithCheckboxInformation),
    });
    let noteUpdated = await noteUpdatedPromise.json();
    dispatch({
      type: 'update-note',
      payload: noteUpdated,
    });
  };

  const onDelete = async (note) => {
    let response = await fetch(`http://localhost:8081/api/delete/note/${note.id}`, {
      method: 'DELETE',
    });
    if (response.status === 200) {
      dispatch({
        type: 'remove-note',
        payload: note,
      });
    }
  };

  return (
    <div className="row mx-1 px-5 pb-3 w-80">
      <div className="col mx-auto">
        <h1>actions to be done</h1>
        <ul>
          {state.listOfNotes.map((note) => (
            <li style={note.done ? { textDecoration: 'line-through' } : {}} key={note.id}>
              {note.title}<br />
              {note.message}<br />
              <input onChange={(event) => onCheckbox(event, note)} type="checkbox" checked={note.done} />
              <button onClick={() => onDelete(note)}>Delete</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default ListOfToDo;
