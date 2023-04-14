import { useLayoutEffect, useState } from 'react'
import './App.css'
import api from "./api";

function App() {
  const [totalVisitCount, setTotalVisitCount] = useState<number | null>(null);
  const [userVisitCount, setUserVisitCount] = useState<number | null>(null);
  const [accountId, setAccountId] = useState('account_1');
  const [data, setData] = useState<any>(null);
  const [hasCleared, setHasCleared] = useState(false);
  const buttonStyle = hasCleared ? {
    pointerEvents: "none",
    textDecoration: "line-through",
  } : {};

  function handleAccountChange(event) {
    setAccountId(event.target.value);
  };

  function handleClearVisitsClick(e: React.MouseEvent<HTMLButtonElement>) {
    e.preventDefault();
    setHasCleared(true);
    api.deleteVisitsByAccountId(accountId);
  }

  function handleSubmitVisit() {
    api.submitVisit(accountId)
      .then((data) => {
        setData(data);
        setTotalVisitCount(data.totalVisitCount);
        setUserVisitCount(data.userVisitCount);
      })
      .catch((error) => console.error(error));
  };


  return (
    <div className="App">
      <form>
        <label htmlFor="account1">Account 1</label>
        <input
          type="radio"
          id="account1"
          name="account"
          value="account_1"
          checked={accountId === 'account_1'}
          onChange={handleAccountChange}
        />
        <label htmlFor="account2">Account 2</label>
        <input
          type="radio"
          id="account2"
          name="account"
          value="account_2"
          checked={accountId === 'account_2'}
          onChange={handleAccountChange}
        />
        <label htmlFor="account3">Account 3</label>
        <input
          type="radio"
          id="account3"
          name="account"
          value="account_3"
          checked={accountId === 'account_3'}
          onChange={handleAccountChange}
        />
        <button id="submitVisit" type="button" onClick={handleSubmitVisit}>
          Submit Visit
        </button>
      </form>
      <p>Total visits: {totalVisitCount}</p>
      <p>Your visits: {userVisitCount}</p>
      <button style={buttonStyle} disabled={hasCleared} onClick={handleClearVisitsClick}>Clear my visit count</button>
      <p>{hasCleared ? "Your visit count has been cleared." : ""}</p>
    </div>
  )
}

export default App
