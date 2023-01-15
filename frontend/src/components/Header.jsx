import React from "react";
import { Button } from "react-bootstrap";
import { FaList } from "react-icons/fa";

const Header = props => {
  const searchFilter = document.getElementById("search");
  const listPlaces = document.getElementById("list");
  const map = document.getElementById("map-container");
  return (
    <header className="map-header" role="banner" tabIndex="0">
      <Button
        //toggle hiding side menu
        onClick={() => {
          searchFilter.classList.toggle("hide");

          listPlaces.classList.toggle("hide");
          map.classList.toggle("another");
          props.isHidden();
        }}
        aria-label="Toggle Side Menu"
      >
          <FaList/>
      </Button>
      <h1>WE RECOMMEND</h1>
    </header>
  );
};

export default Header;
