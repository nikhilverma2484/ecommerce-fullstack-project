import React from "react";

function Cart({ cartItems, onCheckout }) {
  const calculateTotal = () => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

  return (
    <div style={{ textAlign: "center", marginTop: "30px" }}>
      <h2>Your Cart</h2>
      {cartItems.length === 0 ? (
        <p>Cart is empty.</p>
      ) : (
        <div>
          {cartItems.map((item, index) => (
            <p key={index}>
              {item.name} - ₹{item.price}
            </p>
          ))}
          <h3>Total: ₹{calculateTotal()}</h3>
          <button onClick={onCheckout}>Checkout</button>
        </div>
      )}
    </div>
  );
}

export default Cart;