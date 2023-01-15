import React, {useEffect, useState} from "react";
import {Link, useParams} from 'react-router-dom';
import axios from '../../../custom-axios/axios'
import Ingredient from "../../Ingredients/ingredient";
import Instruction from "../../Instruction/instruction";

const GetDetails = (props) => {
    const [recipe, setRecipe] = useState({});
    const [ing, setIng] = useState([]);
    const [ins, setIns] = useState([]);
    const {recipeId} = useParams();

    useEffect(() => {
        axios.get("/recipes/"+recipeId).then((data)=>{
            setRecipe(data.data);
        });
    },);

    useEffect(() => {
        axios.get("/recipes/"+recipeId+"/ingredients").then((data)=>{
            setIng(data.data);
        });
    },);

    useEffect(() => {
        axios.get("/recipes/"+recipeId+"/instructions").then((data)=>{
            setIns(data.data);
        });
    },);

    return (
        <div className="table">
            <div className="container">
                <div className="row">
                    <div className="col-md-4">
                        <div className="card-box" style={{ width: '600px' }}>
                            <div className="card-title">
                                <h2>{recipe.title}</h2>
                            </div>
                            <table className="details">
                                <tbody>
                                    <h5>INGREDIENTS</h5>
                                    <Ingredient ingredients={ing}/>
                                    <h5>INSTRUCTIONS</h5>
                                    <Instruction instructions={ins}/>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default GetDetails;