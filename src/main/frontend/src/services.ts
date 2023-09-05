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
	await fetch("http://localhost:8080/rest/supplier/", {
		method: "POST",
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({
			...supplier
		})
	})
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