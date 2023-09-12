// 返回结果类型
export type TResult<DataType> = {
	code: number
	message: string
	data: DataType
}

// 列表结果
export type TListResult = {
	id: string
	name: string
}