import React, {Component} from "react";
import {Link} from "react-router-dom"
import GetImage from "./image";
import recipesService from "../../../repository/axiosRecipesRepository";
import axios from "../../../custom-axios/axios";
class Recipe extends Component {
    constructor(props) {
        super(props);
        this.state = {
            imageUrl: ""
        }
    }

    componentDidMount() {
        debugger;
        axios.get("/recipes/"+this.props.recipe.recipeId+"/image").then((data)=>{
            this.setState(() => {
                return {
                    "imageUrl": data.data
                }
            })
        });
    }

    componentDidUpdate() {
        axios.get("/recipes/"+this.props.recipe.recipeId+"/image").then((data)=>{
            this.setState(() => {
                return {
                    "imageUrl": data.data
                }
            })
        });
    }

    render() {
        return(
            <div className="col-md-4">
                <div className="card-box">
                    <div className="card-title">
                        <h2>{this.props.recipe.title}</h2>
                    </div>
                    <img className="card-img-top" src={this.state.imageUrl} alt="Card image cap"/>
                    <p><a href={this.props.recipe.recipeUrl}>{this.props.recipe.recipeUrl}</a> </p>
                    <div className="card-link">
                        <div className="form-inline" action="/action_page.php">
                            <Link className="c-link" to={"/recipes/"+this.props.recipe.recipeId+"/details"}>
                                Learn More
                            </Link>
                            <button className="btn btn-success" type="submit" onClick={()=>this.props.onSave(this.props.recipe.recipeId)}>SAVE</button>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}

export default Recipe;