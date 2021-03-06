import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import { RecoilRoot } from 'recoil'
import 'normalize.css';
import './App.css'
import routes from './routes';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <RecoilRoot>
          {routes.map((route, i) => (
            <Route
              path={route.path}
              exact={route.exact}
              component={route.component}
              key={i}
            />
          ))}
        </RecoilRoot>
      </Switch>
    </BrowserRouter>
  )
}

export default App
