import React, {useEffect, useState} from 'react';

const Uslugi = ({ addToCart }) => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetch('http://localhost:1323/products')
            .then(response => response.json())
            .then(data => setProducts(data))
            .catch(error => console.error('Error fetching products:', error));
    }, []);

    const handleAddToCart = (product) => {
        addToCart(product);
    };

    return (
        <div>
            <h2>Uslugi</h2>
            <ul>
                {products.map(product => (
                    <li>
                        {product.valueOf()}
                        <button onClick={() => handleAddToCart(product)}>Dodaj zamówienie</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Uslugi;