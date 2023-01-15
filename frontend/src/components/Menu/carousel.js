import React, {useEffect, useState} from 'react';
import Slider from "react-slick";
import axios from "../../custom-axios/axios";

const Carousel = () => {
    const [images,setImages] = useState([]);

    useEffect(()=>{
        debugger;
        axios.get("/images").then((data)=>{
            setImages(data.data);
        });
    });

    let settings = {
        infinite: true,
        speed: 500,
        arrows:true,
        slidesToShow: 5,
        slidesToScroll: 4,
        autoplay: true,
        autoplaySpeed: 4000,

        responsive: [
            {
                breakpoint: 960,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 2
                }
            }
        ]
    };
    return (
        <div className="container car">
            {images.length===0?(
                <div className="spinner-border" role="status">
                    <span className="sr-only">Loading...</span>
                </div>
            ):(
                <Slider {...settings}>
                    {images.map(current=>(
                        <div>
                            <div className="box">
                                <img src={current} />
                            </div>
                        </div>
                    ))}
                </Slider>
            )}
        </div>
    );
};

export default Carousel;