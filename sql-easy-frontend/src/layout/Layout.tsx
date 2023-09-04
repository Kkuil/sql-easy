import {LogoutOutlined,} from "@ant-design/icons"
import type {ProSettings} from "@ant-design/pro-components"
import {ProConfigProvider, ProLayout,} from "@ant-design/pro-components"
import {ConfigProvider, Dropdown,} from "antd"
import {useState} from "react"
import defaultProps from "./_defaultProps.tsx"
import {Outlet, useNavigate} from "react-router"

export function Layout() {
	const navigateTo = useNavigate()
	const [settings] = useState<Partial<ProSettings> | undefined>({
		layout: "top",
		splitMenus: true,
	})

	const [pathname, setPathname] = useState("/")
	if (typeof document === "undefined") {
		return <div/>
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
							title: "Kkuil",
							render: (_, dom) => {
								return (
									<Dropdown
										menu={{
											items: [
												{
													key: "logout",
													icon: <LogoutOutlined/>,
													label: "退出登录",
												},
											],
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