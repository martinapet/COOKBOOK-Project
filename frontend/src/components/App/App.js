import React, {Component} from "react";
import {BrowserRouter as Router, Route} from 'react-router-dom'
import Header from "../Header/header";
import Menu from "../Menu/menu";
import MyRecipes from "../Recepts/MyRecipes/MyRecipes";
import MyRecipesAdd from "../Recepts/MyRecipes/myRecipesAdd";
import GetRecipes from "../Recepts/AllRecipes/recipeTable";
import GetDetails from "../Recepts/AllRecipes/recipeDetails";
import {loadRecipes} from "../repository/recipesRepository";
import recipesService from "../../repository/axiosRecipesRepository";
import Search from "../Recepts/AllRecipes/search";
import NewMap from "../../NewMap";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            recipes: [],
            search: [],
            saved: [],
            my: [],
            sweet: [],
            salty: [],
            fit: []
        }
    }

    componentDidMount() {
        this.loadRecipes();
    }

    // componentDidUpdate() {
    //     this.loadRecipes();
    // }


    loadRecipes = () => {
        recipesService.fetchRecipes().then(response=>{
            this.setState((prevState) => {
                return {
                    "recipes": response.data.content
                }
            })
        });
        recipesService.fetchSalty().then(response=>{
            this.setState((prevState) => {
                return {
                    "salty": response.data.content
                }
            })
        });
        recipesService.fetchSweet().then(response=>{
            this.setState((prevState) => {
                return {
                    "sweet": response.data.content
                }
            })
        });
        recipesService.fetchFit().then(response=>{
            this.setState((prevState) => {
                return {
                    "fit": response.data.content
                }
            })
        });
    };

    createRecipe = (newIngredients, newInstructions, newRecipe) => {
        debugger;
        let ingredients = [];
        let instructions = [];
        recipesService.addIngredients(newIngredients).then((response)=>{
            ingredients = response.data;
        });
        recipesService.addInstructions(newIngredients).then((response)=>{
            instructions = response.data;
        });
        //newRecipe.ingredients = ingredients;
        //newRecipe.instructions = instructions;
        this.setState((prevState) => {
            debugger;
            const newRef = [...prevState.my, newRecipe ];
            return {
                "my": newRef
            }
        });
    };

    createIngredient = (newRecipe) => {
        debugger;
        recipesService.addIngredient(newRecipe);
    };

    saveRecipe = (recipeId) => {
        if(this.hasSaved(recipeId)) return;
        this.setState((state) => {
            debugger;
            let recipe = [];
            state.recipes.map((item)=>{
                if(item.recipeId === recipeId) {
                    recipe = item;
                }
            });
            const savedRecipes = [...state.saved, recipe ];
            return {
                "saved" : savedRecipes
            }
        })
    };

    hasSaved = (recipeId) => {
        let flag;
        this.state.saved.map((item)=>{
            if(item.recipeId === recipeId) {
                flag = true;
            }
        });
        if(flag) return true;
        else return false;
    };

    deleteSaved = (recipeId) => {
        this.setState((state) => {
            debugger;
            const savedRecipes = state.saved.filter((i) => {
                return i.recipeId !== recipeId;
            });
            return {"saved" : savedRecipes}
        })
    };

    deleteMy = (recipeId) => {
        this.setState((state) => {
            debugger;
            const savedRecipes = state.my.filter((i) => {
                return i.recipeId !== recipeId;
            });
            return {"my" : savedRecipes}
        })
    };

    searchData = (searchTerm) => {
        recipesService.searchTitle(searchTerm).then((response)=>{
            this.setState((prevState) => {
                return {
                    "search": response.data.content
                }
            })
        });
    };

    render() {
        return(
            <Router>
                <Header onSearch={this.searchData}/>
                <main>
                    <Route path={"/"} exact render={()=>
                        <Menu/>}>
                    </Route>
                    <Route path={"/recipes"} exact render={()=>
                        <GetRecipes category="all" onSave={this.saveRecipe}/>}>
                    </Route>
                    <Route path={"/recipes/search"} exact render={()=>
                        <Search recipes={this.state.search} onSave={this.saveRecipe}/>}>
                    </Route>
                    <Route path={"/recipes/salty"} exact render={()=>
                        <GetRecipes category="salty" recipes={this.state.salty} onSave={this.saveRecipe}/>}>
                    </Route>
                    <Route path={"/recipes/sweet"} exact render={()=>
                        <GetRecipes category="sweet" recipes={this.state.sweet} onSave={this.saveRecipe}/>}>
                    </Route>
                    <Route path={"/recipes/fit"} exact render={()=>
                        <GetRecipes category="fit" recipes={this.state.fit} onSave={this.saveRecipe}/>}>
                    </Route>
                    <Route path={"/my-recipes"} exact render={()=>
                        <MyRecipes saved={this.state.saved} my={this.state.my} onDelete={this.deleteSaved} onDeleteMy={this.deleteMy}/>}>
                    </Route>
                    <Route path={"/recipes/new"} exact render={()=>
                        <MyRecipesAdd onNewRecipeAdded={this.createRecipe} onNewIngredientAdded={this.createIngredient}/>}>
                    </Route>
                    <Route path="/recipes/:recipeId/details" render={()=>
                        <GetDetails/>}>
                    </Route>
                    <Route path="/recipes/find" render={()=>
                        <NewMap/>}>
                    </Route>
                </main>
            </Router>
        )
    }
}

export default App;