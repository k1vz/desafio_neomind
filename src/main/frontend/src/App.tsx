import { useState, useEffect } from 'react'
import './App.css'
import { Card} from './components/Card'
import { ICard } from './types';
import { getSupplier } from './services';
import LogoNeomind from './assets/logo-neomind-large.svg';

function App() {
	const [data, setData] = useState<ICard[]>();
	useEffect(() => {
		refreshData();
	}, [])
	const refreshData = () => getSupplier().then(res => setData(res))

	return (
		<>
			<header className="p-5 header">
				<img src={LogoNeomind} />
			</header>
			<div className="d-flex m-3 flex-wrap">
				{data?.map(data => 
					<Card 
						key={data.id}
						id={data.id}
						name={data.name}
						email={data.email}
						comment={data.comment}
						cnpj={data.cnpj}
						refreshData={refreshData}
					/>
				)}
				<Card 
						id={0}
						name={""}
						email={""}
						comment={""}
						cnpj={""}
						refreshData={refreshData}
						creating={true}
					/>
			</div>
		</>
  )}

export default App
