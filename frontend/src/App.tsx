import { useLayoutEffect, useState } from 'react'
import './App.css'
import { fetchData } from "./api";

function App() {
  const [totalVisitCount, setTotalVisitCount] = useState<number | null>(null);
  const [userVisitCount, setUserVisitCount] = useState<number | null>(null);
  const [data, setData] = useState<any>(null);

  useLayoutEffect(() => {
    if (!totalVisitCount && !userVisitCount) {
    fetchData()
      .then((data) => {
          setData(data);
        setTotalVisitCount(data.totalVisitCount);
        setUserVisitCount(data.userVisitCount);
      })
      .catch((error) => console.error(error));
    }
  }, []);

  return (
    <div className="App">
      <p>{data?.message}</p>
      <p>Total visits: {totalVisitCount}</p>
      <p>Your visits: {userVisitCount}</p>
      <p>Your IP: {data?.userIp}</p>
    </div>
  )
}

export default App
