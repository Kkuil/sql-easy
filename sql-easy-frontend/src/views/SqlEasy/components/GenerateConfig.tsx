import {Button, Checkbox, Collapse, Dropdown, Form, Input, InputNumber, MenuProps, message, Space} from "antd"
import {DownOutlined, UserOutlined} from "@ant-design/icons"
import {TDataGenerateConfigInfo, TDataGenerateFieldInfo} from "@/types/core"
import {ItemType as ItemType1} from "antd/es/menu/hooks/useItems"
import {useImmer} from "use-immer"
import {ItemType as ItemType2} from "rc-collapse/es/interface"
import {Draft} from "immer"

interface IFieldParams {
	index: number;
	field: TDataGenerateFieldInfo;
	onFieldValueChange: (index: number, key: keyof TDataGenerateFieldInfo, value: never) => void;
}

/**
 * 字段表单
 */
function FieldForm({index, field, onFieldValueChange}: IFieldParams) {

	const items: MenuProps["items"] = [
		{
			label: "1st menu item",
			key: "1",
			icon: <UserOutlined/>,
		},
		{
			label: "2nd menu item",
			key: "2",
			icon: <UserOutlined/>,
		},
		{
			label: "3rd menu item",
			key: "3",
			icon: <UserOutlined/>,
			danger: true,
		},
		{
			label: "4rd menu item",
			key: "4",
			icon: <UserOutlined/>,
			danger: true,
			disabled: true,
		},
	]

	return (
		<>
			<Form.Item<TDataGenerateFieldInfo>
				label="字段类型"
				name="type"
				rules={[{required: true, message: "字段类型不能为空"}]}
			>
				<Input
					defaultValue={field.type}
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

			<Form.Item<TDataGenerateFieldInfo>
				label="同步更新"
				name="onUpdate"
			>
				<Input
					placeholder="请输入字段更新动作"
					defaultValue={field.onUpdate + ""}
					onChange={(e) => onFieldValueChange(index, "onUpdate", e.target.value as never)}
				/>
			</Form.Item>

			<Checkbox.Group
				options={[
					{
						label: "非空",
						value: "notNull"
					},
					{
						label: "主键",
						value: "primary"
					},
					{
						label: "自增",
						value: "autoIncrement"
					},
				]}
				defaultValue={[field.nonNull ? "notNull" : "", field.primary ? "primary" : "", field.autoIncrement ? "autoIncrement" : ""]}
				onChange={(field) => console.log(field)}
			/>

			<Form.Item<TDataGenerateFieldInfo>
				label="模拟类型"
				name="mockDataType"
			>
				<Dropdown menu={{items}}>
					<Button>
						<Space>
							Button
							<DownOutlined/>
						</Space>
					</Button>
				</Dropdown>
				<Space className="extra-info">
					<div>123</div>
				</Space>
			</Form.Item>
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
	const generate = () => {
		console.log(generateConfig)
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
				onFinish={generate}
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
					label="表注释"
					name="comment"
					rules={[{message: "表注释不能为空"}]}
				>
					<Input
						placeholder="请输入表注释"
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
				<Button type="primary" onClick={generate}>生成</Button>
			</Form.Item>
		</>
	)
}