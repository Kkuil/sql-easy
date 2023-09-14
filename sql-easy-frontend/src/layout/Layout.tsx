import {LoginOutlined, LogoutOutlined,} from "@ant-design/icons"
import type {ProSettings} from "@ant-design/pro-components"
import {ProConfigProvider, ProLayout,} from "@ant-design/pro-components"
import {ConfigProvider, Dropdown,} from "antd"
import {useState} from "react"
import defaultProps from "./_defaultProps.tsx"
import {Outlet, useNavigate} from "react-router"
import {RootState, store} from "@/store"
import {TOKEN_KEY_IN_LOCAL_STORAGE} from "@/constant/user.ts"
import {useSelector} from "react-redux"

export function Layout() {
	const navigateTo = useNavigate()
	const {username} = useSelector((state: RootState) => state.user.info)
	const [settings] = useState<Partial<ProSettings> | undefined>({
		layout: "top",
		splitMenus: true,
	})

	const [pathname, setPathname] = useState("/")
	if (typeof document === "undefined") {
		return <div/>
	}

	/**
	 * 退出登录
	 */
	const logout = () => {
		localStorage.removeItem(TOKEN_KEY_IN_LOCAL_STORAGE)
	}

	/**
	 * 去登录
	 */
	const login = () => {
		navigateTo("/login")
	}

	return (
		<div
			id="test-pro-layout"
			style={{
				height: "100vh",
				overflow: "auto",
			}}
		>
			<ProConfigProvider hashed={false}>
				<ConfigProvider
					getTargetContainer={() => {
						return document.getElementById("test-pro-layout") || document.body
					}}
				>
					<ProLayout
						prefixCls="my-prefix"
						bgLayoutImgList={[
							{
								src: "https://img.alicdn.com/imgextra/i2/O1CN01O4etvp1DvpFLKfuWq_!!6000000000279-2-tps-609-606.png",
								left: 85,
								bottom: 100,
								height: "303px",
							},
							{
								src: "https://img.alicdn.com/imgextra/i2/O1CN01O4etvp1DvpFLKfuWq_!!6000000000279-2-tps-609-606.png",
								bottom: -68,
								right: -45,
								height: "303px",
							},
							{
								src: "https://img.alicdn.com/imgextra/i3/O1CN018NxReL1shX85Yz6Cx_!!6000000005798-2-tps-884-496.png",
								bottom: 0,
								left: 0,
								width: "331px",
							},
						]}
						{...defaultProps}
						location={{
							pathname,
						}}
						token={{
							header: {
								colorBgMenuItemSelected: "rgba(0,0,0,0.04)",
							},
						}}
						siderMenuType="group"
						menu={{
							collapsedShowGroupTitle: true,
						}}
						avatarProps={{
							src: "https://gw.alipayobjects.com/zos/antfincdn/efFD%24IOql2/weixintupian_20170331104822.jpg",
							size: "small",
							title: store.getState().user.info.username ? store.getState().user.info.username : "未登录",
							render: (_, dom) => {
								return (
									<Dropdown
										menu={{
											items: [[
												{
													key: "logout",
													icon: <LogoutOutlined/>,
													label: <a onClick={logout}>退出登录</a>,
												},
												{
													key: "login",
													icon: <LoginOutlined/>,
													label: <a onClick={login}>去登录</a>,
												},
											][username ? 0 : 1]],
										}}
									>
										{dom}
									</Dropdown>
								)
							},
						}}
						headerTitleRender={(logo, title, _) => {
							console.log(title)
							const defaultDom = (
								<a>
									{logo}
									<span className="ml-[5px]">sql-easy</span>
								</a>
							)
							if (typeof window === "undefined") return defaultDom
							if (document.body.clientWidth < 1400) {
								return defaultDom
							}
							if (_.isMobile) return defaultDom
							return (
								<>
									{defaultDom}
								</>
							)
						}}
						menuItemRender={(item, dom) => (
							<div
								onClick={() => {
									setPathname(item.path || "/")
									navigateTo(item.path as string)
								}}
							>
								{dom}
							</div>
						)}
						{...settings}
					>
						<Outlet/>
					</ProLayout>
				</ConfigProvider>
			</ProConfigProvider>
		</div>
	)
}