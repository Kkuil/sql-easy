import {ProFormCheckbox, ProFormText} from "@ant-design/pro-components"
import {LockOutlined, UserOutlined} from "@ant-design/icons"

export function LoginComp() {
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
			<div
				style={{
					marginBlockEnd: 24,
				}}
			>
				<ProFormCheckbox noStyle name="autoLogin">
					自动登录
				</ProFormCheckbox>
			</div>
		</>
	)
}