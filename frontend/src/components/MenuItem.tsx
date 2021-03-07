import React from "react"
import Button from "../common/Button"
import plus from "../assets/svgs/plus.svg"

import "./MenuItem.css"
type MenuItemProps = {
  pizza: {
    id: number
    name: string
    prices: Array<number>
    ingredients: Array<string>
    imgURL: string
  }
}

export default function MenuItem(props: MenuItemProps) {
  const { pizza } = props
  return (
    <article className="menuItem__container">
      <h2 className="menuItem__heading">
        {pizza.id}. {pizza.name}
      </h2>
      <table className="menuItem__pricesTable">
        <thead>
          <tr>
            <th scope="col">30cm</th>
            <th scope="col">40cm</th>
            <th scope="col">50cm</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            {pizza.prices.map((price, i) => (
              <td key={price + i}>{price.toFixed(2)}zł</td>
            ))}
          </tr>
        </tbody>
      </table>
      <ul className="menuItem__ingredientsList">
        {pizza.ingredients.map((ing, i) => (
          <li key={ing + i}>{ing}</li>
        ))}
      </ul>
      <div className="menuItem__controls">
        <img src={pizza.imgURL} alt={pizza.name} className="menuItem__image" />
        <Button variant="control">
          <img
            src={plus}
            alt="add to cart button"
            className="menuItem__btnIcon"
          />
        </Button>
      </div>
    </article>
  )
}
