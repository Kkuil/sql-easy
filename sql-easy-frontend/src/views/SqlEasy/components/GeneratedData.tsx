import {Empty, Tabs, TabsProps} from "antd"
import CodeMirror from "@uiw/react-codemirror"
import {javascript} from "@codemirror/lang-javascript"
import {sql} from "@codemirror/lang-sql"
import {json} from "@codemirror/lang-json"
import {java} from "@codemirror/lang-java"
import {RootState} from "@/store"
import {useSelector} from "react-redux"

export function GeneratedData() {

	const {data} = useSelector((state: RootState) => state.core)

	const onChange = (key: string) => {
		console.log(key)
	}

	const items: TabsProps["items"] = [
		{
			key: "createSql",
			label: "建表语句",
			children: <CodeMirror
				value={data.createTableSql}
				width="650px"
				height="550px"
				extensions={[sql()]}
				theme={"dark"}
				onChange={onChange}
			/>,
		},
		{
			key: "insertSql",
			label: "插入模拟数据",
			children: <CodeMirror
				value={data.insertSql}
				width="650px"
				height="550px"
				theme={"dark"}
				extensions={[sql()]}
				onChange={onChange}
			/>,
		},
		{
			key: "json",
			label: "JSON代码",
			children: <CodeMirror
				value={data.jsonCode}
				width="650px"
				height="550px"
				theme={"dark"}
				extensions={[json()]}
				onChange={onChange}
			/>,
		},
		{
			key: "java",
			label: "Java代码",
			children: <CodeMirror
				value={data.javaCode}
				width="650px"
				height="550px"
				theme={"dark"}
				extensions={[java()]}
				onChange={onChange}
			/>,
		},
		{
			key: "frontend",
			label: "前端代码",
			children: <CodeMirror
				value={data.typescriptCode}
				width="650px"
				height="550px"
				theme={"dark"}
				extensions={[javascript({jsx: true})]}
				onChange={onChange}
			/>,
		},
		{
			key: "excel",
			label: "excel文件",
			children: <a href={data.excel}>{data.excel}</a>,
		},
	]

	return (
		<>
			{
				data.excel ?
					<Tabs defaultActiveKey="1" items={items} onChange={onChange}/> :
					<Empty description="请先生成数据"/>
			}
		</>
	)
}