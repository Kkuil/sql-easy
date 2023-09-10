import {ProCard} from "@ant-design/pro-components"
import {Button, Dropdown, Form, Input, InputNumber} from "antd"
import {ItemType} from "antd/es/menu/hooks/useItems"
import {DownOutlined} from "@ant-design/icons"
import {TDataGenerateConfigInfo} from "@/types/core"
import {useImmer} from "use-immer"

export function SqlEasy() {

	const [generateConfig, setGenerateConfig] = useImmer<TDataGenerateConfigInfo>({
		dialect: "",
		database: "",
		table: "",
		engine: "",
		comment: "",
		count: "string",
		fields: []
	})

	const items: ItemType[] = [
		{
			key: "MySQL",
			label: <a>MySQL</a>,
		},
	]

	/**
	 * 生成数据
	 */
	const generate = () => {
		console.log(generateConfig)
	}

	const onValueChange = (field: keyof TDataGenerateConfigInfo, value: never) => {
		setGenerateConfig((draft) => {
			draft[field] = value
		})
	}

	return (
		<ProCard split="vertical" className="h-screen">
			<ProCard title="生成数据配置" colSpan="50%" className="border-b-[1px]">
				<Dropdown menu={{items}} disabled>
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

					<Form.Item>
						<Button type="primary" onClick={generate}>生成</Button>
					</Form.Item>
				</Form>
			</ProCard>
			<ProCard title="生成结果" headerBordered>
				<div style={{height: 360}}>右侧内容</div>
			</ProCard>
		</ProCard>
	)
}