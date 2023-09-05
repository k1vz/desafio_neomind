interface iCard {
	name: string,
	email: string,
	comment: string,
	cnpj: string
}

function Card({name, email, comment, cnpj}: iCard) {
  return (
    <>
      <div>
	  	<div className="card border-success mb-3" style={{maxWidth: "18rem"}}>
			<div className="card-header bg-transparent border-success">CNPJ: <span>{cnpj}</span></div>
			<div className="card-body text-success">
				<h5 className="card-title">Nome: <span>{name}</span></h5>
				<p className="card-text">Email: <span>{email}</span></p>
				<p className="card-text">Commentss: <span>{comment}</span></p>
			</div>
			<div className="modal-footer border-top p-2 d-flex justify-content-around">
				<button type="button" className="btn btn-success p-2">Execute</button>
				<button type="button" className="btn btn-warning p-2" data-dismiss="modal">Update</button>
				<button type="button" className="btn btn-danger p-2" data-dismiss="modal">Delete</button>
			</div>
		</div>
		
      </div>
    </>
  )
}

export default Card
