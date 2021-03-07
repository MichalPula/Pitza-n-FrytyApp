import React from 'react'
import "./Menu.css"
import TEMP_PIZZA_IMG from "../assets/imgs/pexels-daria-shevtsova-1260968.jpg"
import MenuItem from "./MenuItem"

// waiting for REST
const TEMP = {
  id: 1,
  name: "Strawberriore",
  prices: [19, 26, 34],
  ingredients: ["sos śmietanowy", "brokuł", "świeża bazylia", "truskawki"],
  imgURL: TEMP_PIZZA_IMG,
}

const TEMP2 = {
  id: 2,
  name: "margharita",
  prices: [13, 19, 25],
  ingredients: ["sos pomidorowy"],
  imgURL: TEMP_PIZZA_IMG,
}

export default function Menu() {
  React.useEffect(() => {
    // TODO get pizzas from API
    // using store etc etc
  }, [])
  return (
    <section className="menu__container">
      <MenuItem pizza={TEMP} />
      <MenuItem pizza={TEMP2} />
    </section>
  )
}
