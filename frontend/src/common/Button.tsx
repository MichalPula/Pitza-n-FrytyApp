import React from 'react'
import './Button.css'
type ButtonProps = {
  children: React.ReactChild
  variant: "nav" | "primary" | "control"
}

export default function Button(props: ButtonProps) {
  return (
    <button className={`btn btn-${props.variant}`}>
      {props.children}
    </button>
  )
}
