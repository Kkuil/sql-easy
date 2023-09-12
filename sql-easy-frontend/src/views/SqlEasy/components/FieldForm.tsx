import {TDataGenerateFieldInfo} from "@/types/core"
import {useImmer} from "use-immer"
import {Checkbox, Form, Input, message, Select, Space} from "antd"
import {CheckboxOptionType, CheckboxValueType} from "antd/es/checkbox/Group"
import {useEffect} from "react"
import {listMockType} from "@/api/common.ts"
import {SelectProps} from "rc-select/lib/Select"

interface IFieldParams {
	index: number;
	field: TDataGenerateFieldInfo;
	onFieldValueChange: (index: number, key: keyof TDataGenerateFieldInfo, value: never) => void;
}

interface IMockList {
	value: string
	label: string
}

/**
 * 字段表单
 */
export function FieldForm({index, field, onFieldValueChange}: IFieldParams) {

	/**
	 * 模拟类型列表
	 */
	const [mockDataType, setMockDataType] = useImmer<IMockList[]>([])

	/**
	 * 选中的模拟数据类型
	 */
	const [selectedMockDataType, setSelectedMockDataType] = useImmer<IMockList>({
		value: field.mockDataType,
		label: mockDataType?.find(item => item?.value == field.mockDataType)?.label as string
	})

	/**
	 * 布尔值选项
	 */
	const options: CheckboxOptionType[] = [
		{
			label: "CURRENT_TIMESTAMP",
			value: "onUpdate"
		},
		{
			label: "非空",
			value: "nonNull"
		},
		{
			label: "主键",
			value: "primary"
		},
		{
			label: "唯一",
			value: "unique"
		},
		{
			label: "自增",
			value: "autoIncrement"
		},
	]

	useEffect(() => {
		initMockType().then(() => {
		})
	}, [])

	/**
	 * 初始化模拟数据
	 */
	const initMockType = async () => {
		if (mockDataType?.length) return
		const result = await listMockType()
		if (!result.data) {
			message.error("获取模拟类型失败")
		}
		setMockDataType((draft) => {
			draft?.splice(0, draft.length, ...result.data.map(item => ({value: item.id, label: item.name})))
		})
	}

	/**
	 * 布尔字段更新
	 */
	const onBoolFieldChange = (checkedValue: Array<CheckboxValueType>) => {
		options.forEach((option) => onFieldValueChange(index, option.value as keyof TDataGenerateFieldInfo, checkedValue.includes(option.value) as never))
	}

	/**
	 * 选项更新
	 */
	const onSelectFieldChange: SelectProps["onChange"] = (value) => {
		const type = mockDataType?.filter(item => item?.value == value)[0]
		setSelectedMockDataType((draft => {
			draft.value = type?.value as string
			draft.label = (type as { label: string })?.label
		}))
		onFieldValueChange(index, "mockDataType", value as never)
	}

	return (
		<>
			<Form.Item<TDataGenerateFieldInfo>
				label="字段类型"
				name="type"
				rules={[{required: true, message: "字段类型不能为空"}]}
			>
				<Input
					defaultValue={field.type}
					placeholder="请输入字段类型"
					onChange={(e) => onFieldValueChange(index, "type", e.target.value as never)}
				/>
			</Form.Item>

			<Form.Item<TDataGenerateFieldInfo>
				label="默认值"
				name="defaultValue"
			>
				<Input
					placeholder="请输入默认值"
					defaultValue={field.defaultValue}
					onChange={(e) => onFieldValueChange(index, "defaultValue", e.target.value as never)}
				/>
			</Form.Item>

			<Form.Item<TDataGenerateFieldInfo>
				label="注释"
				name="comment"
			>
				<Input
					placeholder="请输入注释"
					defaultValue={field.comment}
					onChange={(e) => onFieldValueChange(index, "comment", e.target.value as never)}
				/>
			</Form.Item>

			<Checkbox.Group
				options={options}
				defaultValue={[
					field.nonNull ? "nonNull" : "",
					field.primary ? "primary" : "",
					field.autoIncrement ? "autoIncrement" : "",
					field.onUpdate ? "onUpdate" : "",
					field.unique ? "unique" : "",
				]}
				onChange={onBoolFieldChange}
			/>
			<Select
				defaultValue={parseInt(selectedMockDataType.value) ? parseInt(selectedMockDataType.value) : 1001}
				style={{
					width: "120px"
				}}
				onChange={onSelectFieldChange}
				options={mockDataType}
			/>
			<Space className="extra-info">
				额外信息：
				{

				}
			</Space>
		</>
	)
}