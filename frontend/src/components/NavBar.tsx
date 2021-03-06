import React from 'react'
import { Link } from 'react-router-dom'
import '../common/Button.css'
import pitzaLogo from '../assets/svgs/logo.svg'
import './NavBar.css'

export default function NavBar() {
  return (
    <nav className='navbar__container'>
      <Link to='/about' className='btn-nav btn'>o nas</Link>
      <Link to='/contact' className='btn-nav btn'>kontakt</Link>
      <Link to='/order' className='btn-nav btn'>zamów!</Link>
      <img className='navbar__logoImg' alt='pitza and fryty logo' src={pitzaLogo} />
      <Link to='/account' className='btn-nav btn'>konto</Link>
    </nav>
  )
}
