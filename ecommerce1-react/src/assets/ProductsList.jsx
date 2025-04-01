import React from 'react'

export default function ProductsList({products}) {
  return (
    // console.log("products:", products)
    <div className="row">
        
  {products?.map((element) => (
     <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={element.id}>
      <div className="card" style={{ width: "18rem" }}>
        <img 
          src={element.imageUrl || "https://placehold.co/600x400"} 
          className="card-img-top" 
          alt={element.name} 
        />
        <div className="card-body">
          <h5 className="card-title">{element.name}</h5>
          <p className="card-text">{element.description}</p>
          <p className="card-text"><strong>${element.price}</strong></p>
        </div>
      </div>
    </div>
  ))}
</div>

  )
}
