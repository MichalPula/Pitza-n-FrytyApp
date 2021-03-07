import React from 'react'
import { Link } from 'react-router-dom'
import '../common/Button.css'
import pitzaLogo from '../assets/svgs/logo.svg'
import './NavBar.css'

export default function NavBar() {
  return (
    <nav className="navbar__container">
      <Link to="/about" className="btn-nav btn">
        o nas
      </Link>
      <Link to="/contact" className="btn-nav btn">
        kontakt
      </Link>
      <Link to="/order" className="btn-nav btn">
        zamów!
      </Link>
      <Link to="/" className="">
        <object
          data={pitzaLogo}
          aria-label="pitza n fryty logo"
          className="navbar__logoImg"
        ></object>
      </Link>
      <Link to="/account" className="btn-nav btn">
        konto
      </Link>
    </nav>
  )
}
