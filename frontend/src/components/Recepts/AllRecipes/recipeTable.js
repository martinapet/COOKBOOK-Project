import React, {useState, useEffect} from "react";
import Pagination from "./pagination";
import Posts from "./cards";
import axios from "../../../custom-axios/axios";

const GetRecipes = (props) => {
    const [posts, setPosts] = useState([]);
    const [loading, setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [postsPerPage] = useState(9);

    useEffect(() => {
        const fetchPosts = async () => {
            setLoading(true);
            let res;
            if(props.category === "all")
                res = await axios.get("/recipes");
            if(props.category === "salty")
                res = await axios.get("/recipes/salty");
            if(props.category === "sweet")
                res = await axios.get("/recipes/sweet");
            if(props.category === "fit")
                res = await axios.get("/recipes/fit");
            setPosts(res.data.content);
            setLoading(false);
        };

        fetchPosts();

    }, []);

    // Get current posts
    const indexOfLastPost = currentPage * postsPerPage;
    const indexOfFirstPost = indexOfLastPost - postsPerPage;
    const currentPosts = posts.slice(indexOfFirstPost, indexOfLastPost);

    // Change page
    const paginate = pageNumber => setCurrentPage(pageNumber);


    return(
        <div className="table">
            <div className="container mt-3">
                <Posts posts={currentPosts} loading={loading} onSave={props.onSave} onDelete={props.onDelete}/>
                <Pagination
                    postsPerPage={postsPerPage}
                    totalPosts={posts.length}
                    paginate={paginate}
                />
            </div>

        </div>
    );
};

export default GetRecipes;