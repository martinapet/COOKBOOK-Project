import React from "react";

const Ingredient = (props) => {
    const all = props.ingredients.map((ingredient, index) => {
        debugger;
        return (
            <li key={index}>
                <th scope="col">{ingredient.ingredientText}</th>
            </li>
        );
    });
    return(
        <ul>
        {all}
        </ul>
    )
};

export default Ingredient;