
import React, { useState, useEffect } from 'react';

function App() {
  // State variables to hold the input field values
  const [name, setName] = useState('');
  const [type, setType] = useState('');
  const [place, setPlace] = useState('');
  const [warranty, setWarranty] = useState('');
  // Fetching product place holders
  const [products, setProducts] = useState([]);
  const [warrantyExpiredProducts, setWarrantyExpiredProducts] = useState([]);


  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Create an object with the field values
    const data = {
      name,
      type,
      place,
      warranty,
    };

    // Send the POST request
    fetch('/product', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((responseData) => {
        // Handle the response data if needed
        console.log(responseData);
      })
      .catch((error) => {
        // Handle any errors
        console.error(error);
      });

    // Reset the input field values
    setName('');
    setType('');
    setPlace('');
    setWarranty('');
  };

  useEffect(() => {
  }, []);

  // Fetch all the products
  const fetchProducts = () => {
    fetch('/products')
      .then((response) => response.json())
      .then((data) => {
        setProducts(data);
      })
      .catch((error) => {
        console.error('Error fetching products:', error);
      });
  };
  // Fetching Warranty Expired Products
  const fetchWarrantyExpiredProducts = () => {
    fetch('/product/warranty-exp')
      .then((response) => response.json())
      .then((data) => {
        setWarrantyExpiredProducts(data);
      })
      .catch((error) => {
        console.error('Error fetching warranty expired products:', error);
      });
  };

  return (
    <div>
      <h1>Welcome to Product Management</h1>
      <h2>New Product Entry</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
        </label>
        <br/>
        <label>
          Type:
          <input type="text" value={type} onChange={(e) => setType(e.target.value)} />
        </label>
        <br/>
        <label>
          Place:
          <input type="text" value={place} onChange={(e) => setPlace(e.target.value)} />
        </label>
        <br/>
        <label>
          Warranty:
          <input type="text" value={warranty} onChange={(e) => setWarranty(e.target.value)} />
        </label>
        <br/>
        <button style={{ margin: '10px' }} type="submit">Submit</button>
      </form>
      <h2>View Exisiting Products Entry</h2>
      <button style={{ margin: '10px' }} onClick={fetchProducts}>All Products</button>
      <button style={{ margin: '10px' }} onClick={fetchWarrantyExpiredProducts}>Warranty Expired</button>
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Place</th>
            <th>Warranty</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.name}</td>
              <td>{product.type}</td>
              <td>{product.place}</td>
              <td>{product.warranty}</td>
            </tr>
          ))}
        </tbody>
        <tbody>
        {warrantyExpiredProducts.map((product) => (
          <tr key={product.id}>
            <td>{product.name}</td>
            <td>{product.type}</td>
            <td>{product.place}</td>
            <td>{product.warranty}</td>
          </tr>
        ))}
      </tbody>
      </table>
    </div>
  );

}
export default App;