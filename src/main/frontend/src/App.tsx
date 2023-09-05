import { useState, useEffect } from 'react'
import './App.css'
import Card from './components/Card'

function App() {
  useEffect(() => {
		const supplier = getSupplier()
		console.log(supplier)
  }, [])

  return <>
  	{/* <Card />
  	<Card />
  	<Card /> */}
	Helo wordi
  </>
}

async function getSupplier() {
	const res = await fetch("http://localhost:8080/rest/supplier")
	return await res.json();
}

export default App
