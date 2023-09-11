// 生成数据配置
export type TDataGenerateConfigInfo = {
	dialect: string
	database: string
	table: string
	engine?: string
	comment?: string
	count: number
	fields: TDataGenerateFieldInfo[]
}

// 生成数据结果
export type TDataGenerateResult = {
	createTableSql: string
	insertSql: string
	jsonCode: string
	javaCode: string
	typescriptCode: string
	excel: string
}

// 字段配置
export type TDataGenerateFieldInfo = {
	name: string
	type: string
	defaultValue: string
	comment: string
	onUpdate: boolean
	nonNull: boolean
	unique: boolean
	primary: boolean
	autoIncrement: boolean
	mockDataType: string
	extraInfo: string
}