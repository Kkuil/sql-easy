// 生成数据配置
export type TDataGenerateConfigInfo = {
	dialect: string
	database: string
	table: string
	engine?: string
	comment?: string
	count: string
	fields: TDataGenerateFieldInfo[]
}

// 字段配置
export type TDataGenerateFieldInfo = {
	name: string
	type: string
	defaultValue: string
	comment: string
	onUpdate: string
	nonNull: string
	unique: string
	primary: string
	autoIncrement: string
	mockDataType: string
	extraInfo: string
}