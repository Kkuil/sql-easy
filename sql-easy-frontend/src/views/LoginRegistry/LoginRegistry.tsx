import {LoginFormPage,} from "@ant-design/pro-components"
import {useImmer} from "use-immer"
import {FieldData} from "rc-field-form/lib/interface"
import {message, Tabs} from "antd"
import {LoginComp} from "@/views/LoginRegistry/components/LoginComp.tsx"
import {RegistryComp} from "@/views/LoginRegistry/components/RegistryComp.tsx"
import {login, registry} from "@/api/userCommon.ts"
import CryptoUtil from "@/utils/CryptoUtil.ts"
import {useNavigate} from "react-router"
import {TOKEN_KEY_IN_LOCAL_STORAGE} from "@/constant/user.ts"

/**
 *  @description 登录信息类型
 */
export type TLoginInfo = {
	username: string
	password: string
	autoLogin: boolean | null
}

/**
 *  @description 注册信息类型
 */
export type TRegistryInfo = {
	username: string
	password: string
	confirmedPassword: string
}

/**
 *  @description 登录 / 注册
 */
type TMapType = {
	login: (data: never) => void
	registry: (data: never) => void
}

/**
 *  @description 表单配置类型
 */
type TFormConfig = {
	loading: boolean
}

export function LoginRegistry() {

	const navigateTo = useNavigate()

	/**
	 *
	 */
	const [formConfig, setFormConfig] = useImmer<TFormConfig>({
		loading: false
	})

	/**
	 *  @description 登录 / 注册
	 */
	const [type, setType] = useImmer<keyof TMapType>("login")

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

	/**
	 * 字段变化函数map映射
	 */
	const FIELD_CHANGE_MAP: TMapType = {
		login: (changedFields: Record<string, never>) => {
			setLoginInfo((draft) => {
				Object.keys(changedFields).forEach((key: string) => {
					draft[key as keyof TLoginInfo] = changedFields[key]
				})
			})
		},
		registry: (changedFields: Record<string, never>) => {
			setRegistryInfo((draft) => {
				Object.keys(changedFields).forEach((key: string) => {
					draft[key as keyof TRegistryInfo] = changedFields[key]
				})
			})
		}
	}

	/**
	 * 提交信息函数map映射
	 */
	const SUBMIT_MAP: TMapType = {
		login: async (loginInfo: TLoginInfo) => {
			console.log(loginInfo)
			setFormConfig({
				loading: true
			})
			try {
				const result = await login({
					...loginInfo,
					password: CryptoUtil.md5(loginInfo.password)
				})
				if (!result?.data) {
					return message.error(result?.message)
				}
				message.success(result?.message)
				// 保存token
				localStorage.setItem(TOKEN_KEY_IN_LOCAL_STORAGE, result.data)
				navigateTo("/")
			} finally {
				setFormConfig({
					loading: false
				})
			}
		},
		registry: async (registryInfo: TRegistryInfo) => {
			console.log(registryInfo)
			setFormConfig({
				loading: true
			})
			try {
				const result = await registry({
					...registryInfo,
					password: CryptoUtil.md5(registryInfo.password)
				})
				if (!result.data) {
					return message.error(result.message)
				}
				message.success(result.message)
				setType("login")
			} finally {
				setFormConfig({
					loading: false
				})
			}
		}
	}

	/**
	 * 事件监听器
	 */
	const eventListeners = {
		/**
		 * @description 表单修改
		 * @param changedFields
		 */
		onValuesChange: (changedFields: FieldData[]) => {
			FIELD_CHANGE_MAP[type as keyof TMapType](changedFields as never)
		},
		/**
		 *  @description 切换登录/注册
		 * @param activeKey
		 */
		onTabChange: (activeKey: string) => {
			setType(activeKey as keyof TMapType)
		},
		/**
		 * 登录 / 注册
		 * @param formInfo 表单信息
		 */
		onFinish: async (formInfo: never) => {
			SUBMIT_MAP[type as keyof TMapType](formInfo)
		}
	}

	return (
		<div className="h-screen overflow-hidden">
			<LoginFormPage
				backgroundImageUrl="https://gw.alipayobjects.com/zos/rmsportal/FfdJeJRQWjEeGTpqgBKj.png"
				logo="https://github.githubassets.com/images/modules/logos_page/Octocat.png"
				title="SQL-EASY"
				subTitle="让SQL更简单"
				onValuesChange={eventListeners.onValuesChange}
				onFinish={eventListeners.onFinish}
				loading={formConfig.loading}
			>
				<Tabs
					centered
					activeKey={type}
					onChange={eventListeners.onTabChange}
				>
					<Tabs.TabPane key={"login"} tab={"登录"}/>
					<Tabs.TabPane key={"registry"} tab={"注册"}/>
				</Tabs>
				{
					type === "login" ? <LoginComp loginInfo={loginInfo}/> : <RegistryComp registryInfo={registryInfo}/>
				}
			</LoginFormPage>
		</div>
	)
}
