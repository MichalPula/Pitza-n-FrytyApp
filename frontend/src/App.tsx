import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import { RecoilRoot } from 'recoil'
import LandingPage from './views/LandingPage';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <RecoilRoot>
          <Route path='/' exact component={LandingPage} />
        </RecoilRoot>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
