import React, {useState, useEffect, useCallback} from "react";
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'

const UserProfiles = () => {

    const [userProfiles, setUserProfiles] = useState([]);

    const fetchUserProfiles = () => {
      axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
        console.log(res);
        setUserProfiles(res.data);
      });
    }

    useEffect( () => {
      fetchUserProfiles();
    }, []);

    return userProfiles.map((userProfile, index) => {

      return (
        <div key={index}>
            <br />
            <br />
            <h1>{userProfile.userName}</h1>
            <p>{userProfile.userProfileId}</p>
            <MyDropzone />
            <br />
        </div>
      )
    })
}

function MyDropzone() {
  const onDrop = useCallback(acceptedFiles => {
    const files = acceptedFiles[0];
    console.log(files);
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the image here ...</p> :
          <p>Drag 'n' drop some profile image here, or click to select pofile image</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
        <UserProfiles/>
    </div>
  );
}

export default App;
