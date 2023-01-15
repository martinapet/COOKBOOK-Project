import React, {useEffect} from 'react';
import {Link} from "react-router-dom";
import axios from "../../../custom-axios/axios";

const Pagination = ({ postsPerPage, totalPosts, paginate }) => {
    const pageNumbers = [];

    const function2 =  () => {
        window.scrollTo(0, 0);
    };

    for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i++) {
        pageNumbers.push(i);
    }

    return (
        <nav className="pag">
            <ul className='pagination'>
                {pageNumbers.map(number => (
                    <li key={number} className='page-item'>
                        <Link onClick={() => {paginate(number); function2();}} to={"/recipes"} className='page-link'>
                            {number}
                        </Link>
                    </li>
                ))}
            </ul>
        </nav>
    );
};

export default Pagination;