import { useEffect, useState } from 'react'
import './App.css'
import ProductsList from './assets/ProductsList';
import CategoryFilter from './assets/CategoryFilter';
// import Navbar from './assets/Navbar';


function App() {
  const [products, setProducts] = useState([]);
  const [category, setCategory] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(()=>{
    fetch('http://localhost:8081/api/products')
    .then(response => response.json())
    .then(data => setProducts(data));

    fetch('http://localhost:8081/api/categories')
    .then(response => response.json())
    .then(data => setCategory(data));
  }, []);

  const handleSearchChange =(e)=>{
    setSearchTerm(e.target.value);
  }

  const handleSortChange = (e) =>{
    setSortOrder(e.target.value);
  }

  const handleCategorySelect = (categoryId) =>{
    setSelectedCategory(categoryId ? Number(categoryId):null);
  }
  console.log("filteredProducts");
  
  const filteredProducts = products
              .filter(product => {
                return(
                 (selectedCategory ? product.categoryId === selectedCategory : true)
                  // console.log("true or false = ", product.categoryId)
                  &&
                  product.name.toLowerCase().includes(searchTerm.toLowerCase())
                )
              })
              .sort((a, b) => {
                if(sortOrder === "asc"){
                  return a.price - b.price;
                } else {
                  return b.price - a.price;
                }
              });
            
  console.log(filteredProducts);
  return (
    <div className='container'>
      {/* <Navbar handleSearchChange={handleSearchChange} categories={category} onSelect={handleCategorySelect}/> */}
      {/* Navbar starting */}
      <nav className="navbar fixed-top navbar-expand-lg bg-dark navbar-dark">
  <div className="container-fluid">
    <a className="navbar-brand" href="/">Product Catalog</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav align-items-center me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li className="nav-item dropdown">
        <a class="nav-link dropdown-toggle d-flex align-items-center" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <CategoryFilter categories={category} onSelect={handleCategorySelect}/>
          </a>
        </li>
        <li className="nav-item dropdown">
        <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort by Price: Low to High</option>
            <option value="dec">Sort by Price: High to Low</option>
          </select>
        </li>
      </ul>
      <form className="d-flex" role="search">
        <input className="form-control me-2" 
        type="text" 
        placeholder="Search for products" 
        aria-label="Search" 
        onChange={handleSearchChange}
        />
      </form>
    </div>
  </div>
</nav>
{/* nav bar ending */}
      {/* <h1 className='my-4'>Product Catalog</h1>
      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <p><CategoryFilter categories={category} onSelect={handleCategorySelect}/></p>
        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input type='text' 
          className='form-control' 
          placeholder='Search for products'
          onChange={handleSearchChange}/>
        </div>
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Sort by Price: Low to High</option>
            <option value="dec">Sort by Price: High to Low</option>
          </select>
        </div>
      </div> */}
      <div className='container' style={{ marginTop: "80px" }}>
      {filteredProducts.length>0 ? (
        // display products
        // console.log("products:", products)
         <ProductsList products={filteredProducts}/>
      ) : (
        <p>No products found</p>
      )}
      </div>
    </div>
  )
}

export default App
