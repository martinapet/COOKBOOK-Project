import React, {useEffect, useState} from "react";
import {Link, useParams} from 'react-router-dom';
import axios from '../../../custom-axios/axios'
import Ingredient from "../../Ingredients/ingredient";
import Instruction from "../../Instruction/instruction";

const GetImage = (props) => {
    const [img, setImg] = useState("");
    const {recipeId} = props.recipeId;

    useEffect(() => {
        debugger;
        axios.get("/recipes/"+recipeId+"/image").then((data)=>{
            setImg(data.data);
        });
    });

    return (
        <div>
            <img className="card-img-top" src={img} alt="Card image cap"/>
        </div>
    )
};

export default GetImage;