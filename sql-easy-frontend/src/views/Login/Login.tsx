import {LoginFormPage,} from "@ant-design/pro-components"
import {useImmer} from "use-immer"
import {FieldData} from "rc-field-form/lib/interface"
import {Tabs} from "antd"
import {LoginComp} from "@/views/Login/components/LoginComp.tsx"
import {RegistryComp} from "@/views/Login/components/RegistryComp.tsx"

/**
 *  @description 登录信息类型
 */
type TLoginInfo = {
	username: string
	password: string
	autoLogin: boolean | null
}

/**
 *  @description 注册信息类型
 */
type TRegistryInfo = {
	username: string
	password: string
	confirmedPassword: string
}

/**
 *  @description 登录 / 注册
 */
type TType = {
	login: (changedFields: FieldData[]) => void
	registry: (changedFields: FieldData[]) => void
}

export function Login() {

	/**
	 *  @description 登录 / 注册
	 */
	const [type, setType] = useImmer<keyof TType>("login")

	/**
	 *  @description 登录信息
	 */
	const [loginInfo, setLoginInfo] = useImmer<TLoginInfo>({
		username: "",
		password: "",
		autoLogin: null,
	})

	/**
	 *  @description 注册信息
	 */
	const [registryInfo, setRegistryInfo] = useImmer<TRegistryInfo>({
		username: "",
		password: "",
		confirmedPassword: "",
	})

	const FIELD_CHANGE_MAP: TType = {
		login: (changedFields: FieldData[]) => {
			setLoginInfo((draft) => {
				changedFields.forEach((field: FieldData) => {
					draft[field.name as keyof TLoginInfo] = field.value as never
				})
			})
			console.log(loginInfo)
		},
		registry: (changedFields: FieldData[]) => {
			setRegistryInfo((draft) => {
				changedFields.forEach((field: FieldData) => {
					draft[field.name as keyof TRegistryInfo] = field.value as never
				})
			})
			console.log(registryInfo)
		}
	}

	/**
	 * @description 表单修改
	 * @param changedFields
	 */
	const onFieldsChange = (changedFields: FieldData[]) => {
		FIELD_CHANGE_MAP[type as keyof TType](changedFields)
	}

	/**
	 *  @description 切换登录/注册
	 * @param activeKey
	 */
	const onTabChange = (activeKey: string) => {
		setType(activeKey as keyof TType)
	}

	return (
		<div className="h-screen overflow-hidden">
			<LoginFormPage
				backgroundImageUrl="https://gw.alipayobjects.com/zos/rmsportal/FfdJeJRQWjEeGTpqgBKj.png"
				logo="https://github.githubassets.com/images/modules/logos_page/Octocat.png"
				title="SQL-EASY"
				subTitle="让SQL更简单"
				activityConfig={{
					style: {
						boxShadow: "0px 0px 8px rgba(0, 0, 0, 0.2)",
						color: "#fff",
						borderRadius: 8,
						backgroundColor: "#1677FF",
					},
				}}
				onFieldsChange={onFieldsChange}
			>
				<Tabs
					centered
					activeKey={type}
					onChange={onTabChange}
				>
					<Tabs.TabPane key={"login"} tab={"登录"}/>
					<Tabs.TabPane key={"registry"} tab={"注册"}/>
				</Tabs>
				{
					type === "login" ? <LoginComp/> : <RegistryComp/>
				}
			</LoginFormPage>
		</div>
	)
}
