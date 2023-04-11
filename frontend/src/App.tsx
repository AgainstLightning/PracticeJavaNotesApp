import { useEffect } from 'react'
import './App.css'
import {fetchData} from "./api";

function App() {
    useEffect(() => {
        fetchData()
            .then((data) => console.log(data))
            .catch((error) => console.error(error))
    }, []);

  return (
    <div className="App">

    </div>
  )
}

export default App
