import React, { useState } from "react";
import Login from "./components/Login";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [cartItems, setCartItems] = useState([]);

  const handleLoginSuccess = () => {
    setIsLoggedIn(true);
  };

  const handleAddToCart = (product) => {
    setCartItems([...cartItems, product]);
  };

  const handleCheckout = () => {
    alert("Order placed successfully! Total: ₹" + cartItems.reduce((t, i) => t + i.price, 0));
    setCartItems([]);
  };

  return (
    <div className="App">
      {!isLoggedIn ? (
        <Login onLoginSuccess={handleLoginSuccess} />
      ) : (
        <div>
          <ProductList onAddToCart={handleAddToCart} />
          <Cart cartItems={cartItems} onCheckout={handleCheckout} />
        </div>
      )}
    </div>
  );
}

export default App;