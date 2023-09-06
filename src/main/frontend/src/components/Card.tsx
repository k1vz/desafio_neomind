import { useState } from "react";
import { addSupplier, deleteSupplier, updateSupplier } from "../services";
import { ICard } from "../types";

export const Card = ({ id, name, email, comment, cnpj, refreshData, creating = false }: ICard) => {
	const [editing, setEditing] = useState(creating);
	const [currentName, setCurrentName] = useState(name);
	const [currentEmail, setCurrentEmail] = useState(email);
	const [currentComment, setCurrentComment] = useState(comment);
	const [currentCnpj, setCurrentCnpj] = useState(cnpj);

	const handleDelete = () => {
		deleteSupplier(id).finally(() => refreshData());
	};

	const handleUpdate = () => {
		updateSupplier({
			id,
			name: currentName,
			email: currentEmail,
			comment: currentComment,
			cnpj: currentCnpj
		}).finally(() => {
			refreshData();
			setEditing(false);
		});
	};

	const handleAdd = () => {
		addSupplier({
			name: currentName,
			email: currentEmail,
			comment: currentComment,
			cnpj: currentCnpj
		})
			.finally(() => {
				refreshData();
			});
	};

	return (
		<div className="card m-5" style={{ maxWidth: "24rem", minWidth: "24rem", borderColor: "#1F313D" }}>
			<div className="card-header bg-transparent " style={{ borderColor: "#1F313D" }}>
				CNPJ: {!editing ? <span>{cnpj}</span> : <input
					value={currentCnpj}
					onChange={e => setCurrentCnpj(e.target.value)}
					type="number"
					className="form-control"
					placeholder="Enter CNPJ"
				/>}
			</div>
			<div className="card-body text-success">
				<h5 className="card-title">
					Name: {!editing ? <span>{name}</span> : <input
						value={currentName}
						onChange={e => setCurrentName(e.target.value)}
						type="text"
						className="form-control"
						placeholder="Enter name"
					/>}
				</h5>
				<p className="card-text">
					Email: {!editing ? <span>{email}</span> : <input
						value={currentEmail}
						onChange={e => setCurrentEmail(e.target.value)}
						type="email"
						className="form-control"
						placeholder="Enter email"
					/>}
				</p>
				<p className="card-text">
					Comment: {!editing ? <span>{comment}</span> : <input
						value={currentComment}
						onChange={e => setCurrentComment(e.target.value)}
						type="text"
						className="form-control"
						placeholder="Enter comment"
					/>}
				</p>
			</div>
			<div className="card-footer border-top p-2 d-flex justify-content-around">
				{editing ? (
					<button
						type="button"
						className="btn btn-success p-2"
						onClick={() => creating ? handleAdd() : handleUpdate()}
					>
						Execute
					</button>
				) : null}
				{!creating ? (
					<button
						type="button"
						className="btn btn-info p-2"
						data-dismiss="modal"
						onClick={() => editing ? setEditing(false) : setEditing(true)}
					>
						{editing ? "Cancel" : "Update"}
					</button>
				) : null}
				{!creating ? (
					<button
						type="button"
						className="btn btn-danger p-2"
						data-dismiss="modal"
						onClick={handleDelete}
					>
						Delete
					</button>
				) : null}
			</div>
		</div>
	)
}