import {ProCard} from "@ant-design/pro-components"
import {GeneratedData} from "@/views/SqlEasy/components/GeneratedData.tsx"
import {GenerateConfig} from "@/views/SqlEasy/components/GenerateConfig.tsx"

export function SqlEasy() {
	return (
		<ProCard split="vertical" className="h-screen">
			<ProCard title="生成数据配置" colSpan="50%">
				<GenerateConfig/>
			</ProCard>
			<ProCard title="生成结果" headerBordered>
				<GeneratedData/>
			</ProCard>
		</ProCard>
	)
}