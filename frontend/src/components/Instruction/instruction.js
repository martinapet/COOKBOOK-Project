import React from "react";

const Instruction = (props) => {
    const all = props.instructions.map((instruction, index) => {
        //debugger;
        return (
            <li key={index}>
                <th scope="col">{instruction.instructionText}</th>
            </li>
        );
    });
    return(
        <ul>
        {all}
        </ul>
    )
};

export default Instruction;