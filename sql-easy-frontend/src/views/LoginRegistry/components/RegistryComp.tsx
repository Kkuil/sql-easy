import {ProFormText} from "@ant-design/pro-components"
import {LockOutlined, UserOutlined} from "@ant-design/icons"
import {TRegistryInfo} from "@/views/LoginRegistry/LoginRegistry.tsx"

/**
 *  注册组件属性类型
 */
type  TRegistryCompProps = {
	registryInfo: TRegistryInfo
}

export function RegistryComp({registryInfo}: TRegistryCompProps) {
	return (
		<>
			<ProFormText
				name="username"
				fieldProps={{
					size: "large",
					prefix: <UserOutlined className={"prefixIcon"}/>,
				}}
				placeholder="请输入用户名"
				rules={[
					{
						required: true,
						message: "请输入用户名!",
					},
					{
						max: 10,
						message: "用户名不能超过10个字符!"
					}
				]}
			/>
			<ProFormText.Password
				name="password"
				fieldProps={{
					size: "large",
					prefix: <LockOutlined className={"prefixIcon"}/>,
				}}
				placeholder="请输入密码"
				rules={[
					{
						required: true,
						message: "请输入密码！",
					},
					{
						max: 10,
						message: "密码不能超过10个字符!"
					}
				]}
			/>
			<ProFormText.Password
				name="confirmedPassword"
				fieldProps={{
					size: "large",
					prefix: <LockOutlined className={"prefixIcon"}/>,
				}}
				placeholder="请再次输入密码"
				rules={[
					{
						pattern: new RegExp(registryInfo.password),
						required: true,
						message: "两次输入的密码不一致！",
					}
				]}
			/>
		</>
	)
}