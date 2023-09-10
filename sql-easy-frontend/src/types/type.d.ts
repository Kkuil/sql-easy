// 返回结果类型
export type TResult<DataType> = {
	code: number
	message: string
	data: DataType
}