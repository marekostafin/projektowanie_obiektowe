import './App.css';
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Link, Route, Routes } from "react-router-dom";
import Uslugi from './components/Uslugi';
import Platnosci from './components/Platnosci';
import Zamowienia from './components/Zamowienia';



function App() {
    const [cartItems, setCartItems] = useState([]);

    const addToCart = (product) => {
        setCartItems([...cartItems, product]);
    };

    return (
        <Router>
            <div>
                <nav>
                    <Link to="/uslugi">Usługi</Link>
                    <br/>
                    <Link to="/platnosci">Płatności</Link>
                    <br/>
                    <Link to="/zamowienia">Koszyk</Link>
                </nav>
                <Routes>
                    <Route path="/produkty" element={<Uslugi addToCart={addToCart} />} />
                    <Route path="/platnosci" element={<Platnosci/>} />
                    <Route path="/zamowienia" element={<Zamowienia shoppingCartItems={cartItems}/>} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
