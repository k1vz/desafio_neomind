import { ISupplier } from "./types";

export async function getSupplier() {
	const res = await fetch("http://localhost:8080/rest/supplier/")
	return await res.json();
}

export async function getSupplierById(id: number) {
	const res = await fetch("http://localhost:8080/rest/supplier/" + id)
	return await res.json();
}

export async function addSupplier(supplier: Omit<ISupplier, "id">) {
	try {
		const res = await fetch("http://localhost:8080/rest/supplier/", {
			method: "POST",
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify({
				...supplier
			})
		})
		const errorMessage = await res.json();
		if (res.status === 422) {
			switch (errorMessage.error) {
				case "SupplierDTO email isn't valid!": {
					alert("Email is not valid");
					break;
				}
				case "SupplierDTO CNPJ isn't valid!": {
					alert("CNPJ is not valid");
					break;
				}
				case "SupplierDTO already exists!": {
					alert("Supplier already exists (CNPJ)");
					break;
				}
				case "SupplierDTO not found!": {
					alert("Supplier not found");
					break;
				}
			}
		}
	} catch (e) {
		alert("API isn't responding")
	}
}

export async function updateSupplier(supplier: ISupplier) {
	await fetch("http://localhost:8080/rest/supplier/", {
		method: "PUT",
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({
			...supplier
		})
	})
}

export async function deleteSupplier(id: number) {
	await fetch("http://localhost:8080/rest/supplier/" + id, {
		method: "DELETE"
	})
}