import React from "react";
import {Link} from "react-router-dom";
import {useHistory} from 'react-router-dom';

const Header = (props) => {
    const history = useHistory();

    const onSearch = (e)=>{
        debugger;
        e.preventDefault();
        props.onSearch(document.getElementById("searchTerm").value);
        document.getElementById("searchTerm").value = "";
        history.push("/recipes/search");
    };

    return(
        <body>
        <title>My CookBook</title>
        <header>
            <nav className="element navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <Link className="navbar-brand" to={"/"}>HOME</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"/>
                </button>
                <div className="element collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className=" nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                <span>CATEGORIES</span>
                            </a>
                            <div className="dropdown-menu">
                                <Link className="dropdown-item" to={"/recipes"}>ALL RECIPES</Link>
                                <Link className="dropdown-item" to={"/recipes/salty"}>SALTY</Link>
                                <Link className="dropdown-item" to={"/recipes/sweet"}>SWEET</Link>
                                <Link className="dropdown-item" to={"/recipes/fit"}>FIT</Link>
                            </div>
                        </li>
                        <li className="each nav-item ">
                            <Link className="nav-link" to={"/my-recipes"}><span>MY RECIPES</span></Link>
                        </li>
                        <li className="each nav-item ">
                            <Link className="nav-link" to={"/recipes/find"}><span>FIND RESTAURANTS</span></Link>
                        </li>
                        <li className="each">
                            <div className="form-inline" action="/action_page.php">
                                <input className="form-control mr-sm-2" id="searchTerm" name={"searchTerm"} type="text" placeholder="SEARCH RECIPE"/>
                                    <button className="btn btn-success" type="submit" onClick={onSearch}><span>SEARCH</span></button>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        </body>
    )
};

export default Header;