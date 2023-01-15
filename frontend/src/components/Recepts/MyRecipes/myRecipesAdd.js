import React, {Component, useState, useEffect} from "react";
import {useHistory} from 'react-router-dom';

const MyRecipesAdd = (props) => {
    const [title, setTitle] = useState("");
    const [ing, setIng] = useState([{}]);
    const [ins, setIns] = useState([{}]);
    const [valid, setValid] = useState(false);
    const [validT, setValidT] = useState(false);
    const [validIns, setValidIns] = useState(false);
    const [validIng, setValidIng] = useState(false);
    const history = useHistory();

    useEffect(() => {
        if (validT && validIng && validIns) {
            setValid(true);
        }
        else{
            setValid(false);
        }
    });

    const handleNameChange = () => {
        setTitle( document.getElementById("title").value);
        if(document.getElementById("title").value !== "")
            setValidT(true);
        else
            setValidT(false);
    };

    // za ingredients
    const handleIngredientNameChange = idx => evt => {
        const newIngredients = ing.map((shareholder, sidx) => {
            if (idx !== sidx) return shareholder;
            return { ...shareholder, text: evt.target.value };
        });

        setIng(newIngredients);
        if(evt.target.value !== "")
            setValidIng(true);
        else
            setValidIng(false);
    };

    const handleAddIngredient = () => {
        setIng(ing.concat([{}]));
        if(ing.length === 1)
            setValidIng(false);
        else
            setValidIng(true);
    };

    const handleRemoveIngredient = idx => () => {
        setIng(ing.filter((s, sidx) => idx !== sidx));
        if(ing.length === 1)
            setValidIng(false);
        else
            setValidIng(true);
    };

    // za instructions
    const handleInstructionNameChange = idx => evt => {
        const newInstructions = ins.map((instruction, sidx) => {
            if (idx !== sidx) return instruction;
            return { ...instruction, text: evt.target.value };
        });

        setIns(newInstructions);
        if(evt.target.value !== "")
            setValidIns(true);
        else
            setValidIns(false);
    };


    const handleAddInstruction = () => {
        setIns(ins.concat([{}]));
        if(ins.length === 1)
            setValidIns(false);
        else
            setValidIns(true);
    };

    const handleRemoveInstruction = idx => () => {
        setIns(ins.filter((s, sidx) => idx !== sidx));
        if(ins.length === 1)
            setValidIns(false);
        else
            setValidIns(true);
    };

    const onFormSubmit = (event) => {
        event.preventDefault();
        debugger;
        console.log(event);
        const newIngredients = {
            "ingredients": ing
        };
        const newInstructions = {
            "instructions": ins
        };
        const newRecipe = {
            "recipeId" : "12345",
            "title": document.getElementById("title").value,
            "recipeUrl": "",
            "recipePartition": "",
            "ingredients": ing,
            "instructions": ins
        };
        props.onNewRecipeAdded(newIngredients, newInstructions, newRecipe);
        history.push("/my-recipes");
    };

    const onFormSubmitIngredient = (event) => {
        event.preventDefault();
        debugger;
        console.log(event);
        const newIngredients = {
            "ingredients": ing
        };
        props.onNewIngredientAdded(newIngredients);
    };

    return (
        <form className="">
            <h4>MY NEW RECIPE</h4>
            <input
                type="text"
                placeholder="RECIPE TITLE"
                id="title"
                onChange={handleNameChange}
            />
            <tr>
                <td>
                    <h4>INGREDIENTS</h4>
                    {ing.map((ingredient, idx) => (
                        <div className="shareholder">
                            <input
                                type="text"
                                placeholder={`Ingredient name #${idx + 1} `}
                                value={ingredient.name}
                                onChange={handleIngredientNameChange(idx)}
                            />
                            <button
                                type="button"
                                onClick={handleRemoveIngredient(idx)}
                                className="small"
                            >
                                -
                            </button>
                        </div>
                    ))}
                    <button
                        type="button"
                        onClick={handleAddIngredient}
                        className="small"
                    >
                        Add Ingredient
                    </button>
                </td>
                <td>
                    <h4>INSTRUCTIONS</h4>

                    {ins.map((instruction, idx) => (
                        <div className="shareholder">
                            <input
                                type="text"
                                placeholder={`Instruction step #${idx + 1}`}
                                value={instruction.name}
                                onChange={handleInstructionNameChange(idx)}
                            />
                            <button
                                type="button"
                                onClick={handleRemoveInstruction(idx)}
                                className="small"
                            >
                                -
                            </button>
                        </div>
                    ))}
                    <button
                        type="button"
                        onClick={handleAddInstruction}
                        className="small"
                    >
                        Add Instruction
                    </button>
                </td>
            </tr>

            <div className="form-inline" >
                <button className="btn btn-success"
                        type="submit"
                        disabled={!valid}
                        onClick={onFormSubmit}>
                    SUBMIT
                </button>
            </div>
        </form>
    );
};

export default MyRecipesAdd;
