import axios from '../custom-axios/axios'
import qs from 'qs'

const RecipesService = {
    fetchRecipes: ()=> {
        return axios.get("/recipes");
    },
    fetchSalty: ()=> {
        return axios.get("/recipes/salty");
    },
    fetchSweet: ()=> {
        return axios.get("/recipes/sweet");
    },
    fetchFit: ()=> {
        return axios.get("/recipes/fit");
    },
    addRecipe: (recipe) => {
        const data = {
            ...recipe
        };
        const formParams = qs.stringify(data);
        return axios.post("/recipes", formParams, {
            headers:{
                'recipeId': data.recipeId,
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
    },
    addIngredients: (recipe) => {
        const data = {
            ...recipe
        };
        const formParams = qs.stringify(data);
        return axios.post("/ingredients", formParams, {

        })
    },
    addInstructions: (recipe) => {
        const data = {
            ...recipe
        };
        const formParams = qs.stringify(data);
        return axios.post("/instructions", formParams, {

        })
    },
    searchTitle: (searchTerm) => {
        return axios.get(`/recipes?title=${searchTerm}`);
    }
};

export default RecipesService;