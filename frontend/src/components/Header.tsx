import React from 'react'
import pizzaPhoto from '../assets/imgs/pexels-brett-jordan-825661.jpg'
import NavBar from '../components/NavBar'
import './Header.css'
export default function Header () {

  return (
    <header className="header__container">
      <object
        aria-label="pizza photo header hero"
        data={pizzaPhoto}
        className="header__heroImg"
      ></object>
      <NavBar />
    </header>
  )
}
