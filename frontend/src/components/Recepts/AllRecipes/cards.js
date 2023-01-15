import React, {useEffect} from 'react';
import Recipe from "./recipe";

const Posts = ({ posts, loading, onSave, onDelete }) => {

    function result() {
        if(loading) {
            return <h2>Loading...</h2>;
        }
        else {
            return <div className="row">
                {posts.map((recipe, index) => {
                    return (
                        <Recipe id={recipe.id} recipe={recipe} key={index} onSave={onSave} onDelete={onDelete}/>
                    );
                })}
            </div>
        }
    }

    return (
        <div>
            {result()}
        </div>
    );
};

export default Posts;