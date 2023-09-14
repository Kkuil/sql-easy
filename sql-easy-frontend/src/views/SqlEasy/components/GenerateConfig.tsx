import {Button, Collapse, Dropdown, Form, Input, InputNumber, message, Space} from "antd"
import {DownOutlined} from "@ant-design/icons"
import {TDataGenerateConfigInfo, TDataGenerateFieldInfo} from "@/types/core"
import {ItemType as ItemType1} from "antd/es/menu/hooks/useItems"
import {useImmer} from "use-immer"
import {ItemType as ItemType2} from "rc-collapse/es/interface"
import {generate} from "@/api/core.ts"
import {store} from "@/store"
import {FieldForm} from "@/views/SqlEasy/components/FieldForm.tsx"
import {Draft} from "immer"

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
	 * 通用字段模板
	 */
	const COMMON_FIELD_TEMPLATE: TDataGenerateFieldInfo[] = [
		{
			name: "id",
			type: "LONG",
			defaultValue: "",
			comment: "唯一id",
			onUpdate: true,
			nonNull: true,
			unique: true,
			primary: true,
			autoIncrement: true,
			mockDataType: "1003",
			extraInfo: "0",
		},
		{
			name: "create_time",
			type: "DATETIME",
			defaultValue: "",
			comment: "创建时间",
			onUpdate: false,
			nonNull: true,
			unique: false,
			primary: false,
			autoIncrement: false,
			mockDataType: "1002",
			extraInfo: "1001",
		},
		{
			name: "update_time",
			type: "DATETIME",
			defaultValue: "CURRENT_TIMESTAMP",
			comment: "更新时间",
			onUpdate: true,
			nonNull: true,
			unique: false,
			primary: false,
			autoIncrement: false,
			mockDataType: "1002",
			extraInfo: "1001",
		}
	]

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
	 * 删除字段
	 * @param index
	 */
	const delField = (index: number) => {
		setGenerateConfig((draft) => {
			draft.fields.splice(index, 1)
		})
		setFiledItems(draft => {
			draft.splice(index, 1)
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
				key: Date.now() + Math.random(),
				label: (
					<>
						<span>{field.name}</span>
						<Button
							type="dashed"
							className="bg-[#ff6542] text-[#fff]"
							onClick={() => delField(fieldItems.length)}
						>删除</Button>
					</>
				),
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
		for (let i = 0; i < COMMON_FIELD_TEMPLATE.length; i++) {
			addField(COMMON_FIELD_TEMPLATE[i])
		}
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