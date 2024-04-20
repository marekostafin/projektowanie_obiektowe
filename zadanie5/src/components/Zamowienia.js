import {useEffect, useState} from "react";

const Zamowienia = ({ shoppingCartItems }) => {
    return (
        <div>
            <h2>Zamówienia</h2>
            <ul>
                {shoppingCartItems.map(item => (
                    <li>
                        {item.valueOf()}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Zamowienia;