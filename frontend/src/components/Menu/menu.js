import React from "react";
import Carousel from "./carousel";

const Menu = (props) => {
    return(
        <div >
            <div className="div-menu">
            <p className="title">MY COOKBOOK</p>
            <p className="quote">"WE ARE WHAT WE EAT"</p>
        </div>
            <Carousel/>

        </div>
    )
};

export default Menu;