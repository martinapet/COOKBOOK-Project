import React, {useEffect} from "react";
import {Link} from "react-router-dom";
import SavedRecipe from "./savedRecipe";
import Recipe from "../AllRecipes/recipe";
const MyRecipes = (props) => {

    let savedRecipes = props.saved.map((recipe, index) => {
        debugger;
        return (
            <SavedRecipe id={recipe.id} recipe={recipe} key={index} onDelete={props.onDelete}/>
        );
    });

    let myRecipes = props.my.map((recipe, index) => {
        debugger;
        let ingredients = recipe.ingredients.map((ing, index) => {
            debugger;
            return (
                <li>{ing.text}<br/></li>
            );
        });
        let instructions = recipe.instructions.map((ins, index) => {
            debugger;
            return (
                <li>{ins.text}<br/></li>
            );
        });
        return (
            <div className="col-md-4">
                <div className="card-box">
                    <div className="card-title">
                        <h2>{recipe.title}</h2>
                        <h4>Ingredients</h4>
                        <ul>{ingredients}</ul>

                        <h4>Instructions</h4>
                        <ul>{instructions}</ul>
                    </div>
                    <div className="card-link">
                        <div className="form-inline" action="/action_page.php">
                            <button className="btn btn-success" type="submit" onClick={()=>props.onDeleteMy(recipe.recipeId)}
                            >DELETE</button>

                        </div>
                    </div>
                </div>
            </div>

        );
    });

    useEffect(() => {
         saved();
    },);

    function saved() {
        savedRecipes = props.saved.map((recipe, index) => {
            debugger;
            return (
                <SavedRecipe id={recipe.id} recipe={recipe} key={index} onDelete={props.onDelete}/>
            );
        });
        myRecipes = props.my.map((recipe, index) => {
            debugger;
            let ingredients = recipe.ingredients.map((ing, index) => {
                debugger;
                return (
                    <p>{ing.text}</p>
                );
            });
            return (
                <div>
                    <p>{recipe.title} </p>
                    {ingredients}
                </div>

            );
        });
    }

    function result1() {
        if(props.saved.toString().length > 0) {
            return <span className="saved-text" >SAVED RECIPES</span>
        }
    }

    function result2() {
        if(props.my.toString().length > 0) {
            return <span className="saved-text" >MY RECIPES</span>
        }
    }

    return(
        <div>
            <div className="btn-body">
                <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"/>
                <div className="btn-body-div type-1">
                    <div className="btn-body-div-div">
                        <Link className="btn btn-1" to={"/recipes/new"}>
                            <span className="txt">ADD RECIPE</span>
                            <span className="round"><i className="fa fa-chevron-right"></i></span>
                        </Link>
                    </div>
                </div>
            </div>

            <div className="table" >
                <div className="saved">
                    {result1()}
                    <div className="container">
                        <div className="row">
                            {savedRecipes}
                        </div>
                    </div>
                </div>

                <div className=" ">
                    {result2()}
                    <div className="container">
                        <div className="row">
                            {myRecipes}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

};

export default MyRecipes;