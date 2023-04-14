import { useLayoutEffect, useState } from 'react'
import './App.css'
import api from "./api";

function App() {
  const [totalVisitCount, setTotalVisitCount] = useState<number | null>(null);
  const [userVisitCount, setUserVisitCount] = useState<number | null>(null);
  const [data, setData] = useState<any>(null);
  const [hasCleared, setHasCleared] = useState(false);
  const buttonStyle = hasCleared ? {
    pointerEvents: "none",
    textDecoration: "line-through",
  } : {};

  useLayoutEffect(() => {
    if (!totalVisitCount && !userVisitCount) {
    api.fetchData()
      .then((data) => {
        setData(data);
        setTotalVisitCount(data.totalVisitCount);
        setUserVisitCount(data.userVisitCount);
      })
      .catch((error) => console.error(error));
    }
  }, []);

  function handleClearVisitsClick(e: React.MouseEvent<HTMLButtonElement>) {
    e.preventDefault();
    setHasCleared(true);
    api.deleteVisitsByIp();
  }

  return (
    <div className="App">
      <p>{data?.message}</p>
      <p>Total visits: {totalVisitCount}</p>
      <p>Your visits: {userVisitCount}</p>
      <p>Your IP: {data?.userIp}</p>
      <button style={buttonStyle} disabled={hasCleared} onClick={handleClearVisitsClick}>Clear my visit count</button>
      <p>{hasCleared ? "Your visit count has been cleared." : ""}</p>
    </div>
  )
}

export default App
