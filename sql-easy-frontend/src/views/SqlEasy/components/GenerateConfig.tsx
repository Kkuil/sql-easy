import {Button, Checkbox, Collapse, Dropdown, Form, Input, InputNumber, MenuProps, message, Space} from "antd"
import {DownOutlined} from "@ant-design/icons"
import {TDataGenerateConfigInfo, TDataGenerateFieldInfo} from "@/types/core"
import {ItemType as ItemType1} from "antd/es/menu/hooks/useItems"
import {useImmer} from "use-immer"
import {ItemType as ItemType2} from "rc-collapse/es/interface"
import {Draft} from "immer"
import {useEffect} from "react"
import {listMockType} from "@/api/common.ts"
import {CheckboxOptionType, CheckboxValueType} from "antd/es/checkbox/Group"
import {generate} from "@/api/core.ts"
import {store} from "@/store"

interface IFieldParams {
	index: number;
	field: TDataGenerateFieldInfo;
	onFieldValueChange: (index: number, key: keyof TDataGenerateFieldInfo, value: never) => void;
}

/**
 * 字段表单
 */
function FieldForm({index, field, onFieldValueChange}: IFieldParams) {

	/**
	 * 模拟类型列表
	 */
	const [mockDataType, setMockDataType] = useImmer<MenuProps["items"]>([])

	/**
	 * 选中的模拟数据类型
	 */
	const [selectedMockDataType, setSelectedMockDataType] = useImmer<{
		key: string,
		label: string
	}>({
		key: "3170",
		label: "默认"
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
			draft?.splice(0, draft.length, ...result.data.map(item => ({key: item.id, label: item.name})))
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
	const onDropFieldChange: MenuProps["onClick"] = (e) => {
		console.log(mockDataType)
		const type = mockDataType?.filter(item => item?.key == e.key)[0]
		console.log(type)
		setSelectedMockDataType((draft => {
			draft.key = type?.key as string
			draft.label = (type as { label: string })?.label
		}))
		onFieldValueChange(index, "mockDataType", e.key as never)
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

			<Dropdown menu={{items: mockDataType, onClick: onDropFieldChange}} placement="bottom">
				<Button>
					<Space>
						{selectedMockDataType.label}
						<DownOutlined/>
					</Space>
				</Button>
			</Dropdown>
			<Space className="extra-info">
				<div>123</div>
			</Space>
		</>
	)
}

export function GenerateConfig() {
	/**
	 * 字段模板
	 */
	const FIELD_TEMPLATE: TDataGenerateFieldInfo = {
		name: "test",
		type: "",
		defaultValue: "",
		comment: "test",
		onUpdate: false,
		nonNull: false,
		unique: false,
		primary: false,
		autoIncrement: false,
		mockDataType: "",
		extraInfo: "",
	}

	/**
	 * 方言列表
	 */
	const dialectItems: ItemType1[] = [
		{
			key: "MySQL",
			label: <a>MySQL</a>,
		},
	]

	/**
	 * 数据生成配置信息
	 */
	const [generateConfig, setGenerateConfig] = useImmer<TDataGenerateConfigInfo>({
		dialect: "MySQL",
		database: "",
		table: "",
		engine: "",
		comment: "",
		count: 20,
		fields: []
	})

	/**
	 * 字段信息列表
	 */
	const [fieldItems, setFiledItems] = useImmer<ItemType2[]>([])

	/**
	 * 生成数据
	 */
	const generateData = async () => {
		const result = await generate(generateConfig)
		if (!result?.data) {
			return message.error("生成失败")
		}
		message.success("生成成功")
		store.dispatch({
			type: "core/setData",
			payload: result.data
		})
	}

	/**
	 * 值变化
	 * @param field
	 * @param value
	 */
	const onValueChange = (field: keyof TDataGenerateConfigInfo, value: never) => {
		setGenerateConfig((draft) => {
			draft[field] = value
		})
	}

	/**
	 * 字段值变化
	 * @param index 索引
	 * @param key 键
	 * @param value 值
	 */
	const onFieldValueChange = (index: number, key: keyof TDataGenerateFieldInfo, value: never) => {
		console.log(index, key, value)
		setGenerateConfig((draft) => {
			draft.fields[index][key] = value
		})
	}

	/**
	 * 新增字段
	 */
	const addField = (field: TDataGenerateFieldInfo) => {
		if (fieldItems.length > 10) {
			return message.error("建议分库分表")
		}
		setFiledItems((draft) => {
			const fieldConfig: ItemType2 = {
				key: Date.now(),
				label: field.name,
				children: <FieldForm index={fieldItems.length} field={field} onFieldValueChange={onFieldValueChange}/>
			}
			draft.push(fieldConfig as Draft<ItemType2>)
		})
		setGenerateConfig((draft) => {
			draft.fields.push(field)
		})
		console.log(generateConfig.fields)
	}

	/**
	 * 新增通用字段
	 */
	const addCommonField = () => {

	}

	return (
		<>
			<Dropdown menu={{items: dialectItems}} disabled>
				<Button>
					MySQL
					<DownOutlined/>
				</Button>
			</Dropdown>
			<Form
				labelCol={{span: 4}}
				wrapperCol={{span: 14}}
				onFinish={generateData}
				layout="horizontal"
				className="mt-[10px]"
			>
				<Form.Item<TDataGenerateConfigInfo>
					label="库名"
					name="database"
					rules={[{required: true, message: "库名不能为空"}]}
				>
					<Input
						placeholder="请输入库名"
						onChange={(e) => onValueChange("database", e.target.value as never)}
					/>
				</Form.Item>

				<Form.Item<TDataGenerateConfigInfo>
					label="表名"
					name="table"
					rules={[{required: true, message: "表名不能为空"}]}
				>
					<Input
						placeholder="请输入表名"
						onChange={(e) => onValueChange("table", e.target.value as never)}
					/>
				</Form.Item>

				<Form.Item<TDataGenerateConfigInfo>
					label="存储引擎"
					name="engine"
				>
					<Input
						placeholder="请输入存储引擎，默认为InnoDB"
						onChange={(e) => onValueChange("engine", e.target.value as never)}
					/>
				</Form.Item>

				<Form.Item<TDataGenerateConfigInfo>
					label="表注释"
					name="comment"
					rules={[{message: "表注释不能为空"}]}
				>
					<Input
						placeholder="请输入表注释，默认为表名"
						onChange={(e) => onValueChange("comment", e.target.value as never)}
					/>
				</Form.Item>

				<Form.Item<TDataGenerateConfigInfo>
					label="生成"
					name="count"
				>
					<InputNumber
						type="number"
						max={100}
						defaultValue={20}
						onInput={(count) => onValueChange("count", count as never)}
					/>
				</Form.Item>
			</Form>
			{
				fieldItems.length ?
					<Collapse
						items={fieldItems}
					/> : ""
			}
			<Space className="mt-[10px]">
				<Button type="primary" onClick={() => addField(FIELD_TEMPLATE)}>新增字段</Button>
				<Button type="primary" onClick={addCommonField}>新增通用字段</Button>
			</Space>
			<Form.Item className="mt-[10px]">
				<Button type="primary" onClick={generateData}>生成</Button>
			</Form.Item>
		</>
	)
}