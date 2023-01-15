import React, {useState} from "react";
import Recipe from "./recipe";

const search = (props) => {
    const recipesAll = props.recipes.map((recipe, index) => {
        debugger;
        return (
            <Recipe id={recipe.id} recipe={recipe} key={index} onSave={props.onSave} onDelete={props.onDelete} colClass={"col-md-6 mt-2 col-sm-12"}/>
        );
    });

    return(
        <div className="table">
            {result()}
        </div>
    );



    function result() {
        return (
            <div className="container">
                <div className="row">
                    {recipesAll}
                </div>
            </div>
        )
    }
};

export default search;