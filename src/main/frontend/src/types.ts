export interface ICard extends ISupplier {
	refreshData: () => void,
	creating?: boolean
}

export interface ISupplier {
	id: number,
	name: string,
	email: string,
	comment: string,
	cnpj: string,
}
